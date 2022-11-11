package com.example.team14;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.team14.contacts.ContactActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView5);
        Date currentTime = Calendar.getInstance().getTime();
        textView.setText(currentTime.toString());
    }

    @Override
    protected void onResume() {
        Date currentTime = Calendar.getInstance().getTime();
        textView.setText(currentTime.toString());
        super.onResume();
    }

    public void broadcastListener(View view) {
        Intent intent = new Intent(this, BroadcastActivity.class);
        startActivity(intent);
    }

    public void gotoContacts(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }

    public void toService(View view) {
        Intent intent = new Intent(this, ServiceActivity.class);
        startActivity(intent);
    }
}
