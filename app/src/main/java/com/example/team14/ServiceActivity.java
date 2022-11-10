package com.example.team14;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Build;
import android.view.View;

import java.util.logging.Logger;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void onStartService(View view) {
        Intent intent = new Intent(this, CurrentTimeService.class);
        if (view.getStateDescription().equals("ON")) {
            startService(intent);
        }
        else {
            stopService(intent);
            finish();
        }
    }
}
