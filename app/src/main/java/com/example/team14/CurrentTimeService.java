package com.example.team14;

import android.app.Service;
import android.content.Intent;
import java.util.Calendar;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import java.util.Random;
import java.util.logging.Logger;

public class CurrentTimeService extends Service {
    private final IBinder mBinder = new LocalBinder();
    private final Random mGenerator = new Random();
    private HandlerThread mHandlerThread;
    private Handler mHandler;
    public class LocalBinder extends Binder {
        CurrentTimeService getService() {
            // Return this instance of LocalService so clients can call public methods
            return CurrentTimeService.this;
        }
    }
    public CurrentTimeService() {
    }

    private boolean running;
    @Override
    public void onDestroy()
    {
        running = false;
        //super.onDestroy();
    }

    @Override
    public boolean stopService(Intent name) {
        mHandlerThread.interrupt();
        running = false;
        return super.stopService(name);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mHandlerThread = new HandlerThread("LocalServiceThread");
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper());
        running = true;
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                while(running){
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            Calendar calendar = Calendar.getInstance();
                            int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
                            int minOfDay = calendar.get(Calendar.MINUTE);
                            String data = new String(hourOfDay + ":" + minOfDay);
                            Logger.getAnonymousLogger().info("Updating time: " + data);
                            ServiceActivity.updateTimeOnService(data);
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                    }
                }
            }
        })
        ;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }
}
