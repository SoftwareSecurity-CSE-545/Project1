package com.example.team14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
    }


    public void broadcast(View view) {
        String msg = ((EditText) findViewById(R.id.broadcast_msg)).getText().toString();
        String finalMsg = msg.isEmpty()? Calendar.getInstance().getTime().toString() : msg + "\n" + Calendar.getInstance().getTime();
        Intent intent = new Intent();
        intent.setAction("com.example.homework");
        intent.setPackage("com.example.team14");
        intent.putExtra("message", finalMsg);
        sendBroadcast(intent);
    }
}