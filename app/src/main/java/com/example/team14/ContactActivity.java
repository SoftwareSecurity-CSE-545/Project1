package com.example.team14;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import java.util.ArrayList;
import java.util.Random;

public class ContactActivity extends AppCompatActivity {

    EditText mName;
    EditText mPhone;
    EditText mId;
//    TextView mDBView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        mName = (EditText) findViewById(R.id.contact_name);
        mPhone = (EditText) findViewById(R.id.contact_phone);
        mId = (EditText) findViewById(R.id.contact_id);
        onShow(null);
//        mDBView = (TextView) findViewById(R.id.contacts_list);
    }

    public void onInsert(View view) {
        ContentValues values  = new ContentValues();
        values.put(ContactsDatabase.ID,new Random().nextInt(100));
        values.put(ContactsDatabase.NAME,mName.getText().toString());
        values.put(ContactsDatabase.PHONE,mPhone.getText().toString());
        values.put(ContactsDatabase.MAIL,mId.getText().toString());

        getApplicationContext().getContentResolver().insert(ContactsContentProvider.CONTENT_URI,values);
        Toast.makeText(this,"Contact added successfully",Toast.LENGTH_SHORT).show();
        onShow(view);
    }
    public void onReset(View view) {
        int delcount = getContentResolver().delete(ContactsContentProvider.CONTENT_URI,null,null);
        Toast.makeText(this, "Deleted all contacts",Toast.LENGTH_SHORT).show();
        onShow(view);
    }
    public void onShow(View view) {
        Uri uri = ContactsContentProvider.CONTENT_URI;
        Cursor cursor = this.getContentResolver().query(uri,null,null,null,null);
        StringBuilder sb = new StringBuilder();
        final ArrayList<ContactItem> arrayList = new ArrayList<ContactItem>();
        while (cursor.moveToNext()){
            sb.append(cursor.getString(0) + ",");
            sb.append(cursor.getString(1) + ",");
            sb.append(cursor.getString(2) + ",");
            sb.append(cursor.getString(3) + ",");
            sb.append("\n");
            arrayList.add(new ContactItem(cursor.getString(1), cursor.getString(3), cursor.getString(2) ));
        }
//        mDBView.setText(sb.toString());
        ContactItemAdapter contactAdapter = new ContactItemAdapter(this, arrayList);
        ListView contactListView = findViewById(R.id.contact_list);
        contactListView.setAdapter(contactAdapter);
        if(arrayList.size() == 0) {
            findViewById(R.id.empty_alert).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.empty_alert).setVisibility(View.INVISIBLE);
        }
    }
}

