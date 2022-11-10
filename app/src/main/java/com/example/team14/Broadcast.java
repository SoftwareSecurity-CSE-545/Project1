package com.example.team14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * •  Create a broadcast receiver that listen to an customized action. You may use any
 * string for your action, such as “com.example.homework”
 * •  When the intent is received, the receiver will show the current time and message
 * embedded in the intent
 * •  You may use a text view to show the message or a toast text
 * •  Create the UI to send the broadcast intent and show the message sent to the
 * receiver
 */

public class Broadcast extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast2);
    }

    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Intent Detected.", Toast.LENGTH_LONG).show();
        }
    }
}
