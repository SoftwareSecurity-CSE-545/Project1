package com.example.team14;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.logging.Logger;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        Logger.getAnonymousLogger().info("Broadcast: In Receiver");
        Toast.makeText(context, "Intent Detected.", Toast.LENGTH_LONG).show();
    }
}