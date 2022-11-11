package com.example.team14;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import java.util.logging.Logger;

public class ServiceActivity extends AppCompatActivity {

    Intent intent;
    static TextView timeServiceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ServiceActivity.timeServiceTextView = findViewById(R.id.TimeServiceTextView);
    }

    public static void updateTimeOnService(String data) {
        ServiceActivity.timeServiceTextView.setText(data);
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void onStartService(View view) {
        Logger.getAnonymousLogger().info("ServiceActivity: onStart");
        intent = new Intent(this, CurrentTimeService.class);
        if (view.getStateDescription().equals("ON")) {
            startService(intent);
        }
        else {
            stopService(intent);
        }
    }

    @Override
    public void onBackPressed() {
        stopService(intent);
        finish();
        super.onBackPressed();
    }
}
