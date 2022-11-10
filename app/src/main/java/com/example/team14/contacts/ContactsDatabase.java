package com.example.team14.contacts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactsDatabase extends SQLiteOpenHelper {
    public static final String DB_NAME = "Project1";
    //Constants for table and columns
    public static final String TABLE = "contacts";
    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String MAIL = "mail";
    private static final String CREATE_TABLE_TUTORIALS = "create table " + TABLE +
            " (" + ID + " integer primary key autoincrement, " + NAME
            + " text, " + PHONE + " text, " + MAIL + " text );";
    private static final String DB_SCHEMA = CREATE_TABLE_TUTORIALS;
    public static final String[] ALL_COLUMNS =
            {ID, NAME, PHONE, MAIL};

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_SCHEMA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("Project1 database", "Upgrading database. Existing contents will be lost. ["
                + oldVersion + "]->[" + newVersion + "]");
        db.execSQL("DROP TABLE IF EXISTS " + "contacts");
        onCreate(db);
    }
    public ContactsDatabase(Context context) {
        super(context, DB_NAME, null, 1);
    }
}