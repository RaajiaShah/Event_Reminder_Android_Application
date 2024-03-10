package com.example.event_reminder;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;


public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "formdb";


    private static final int DB_VERSION = 1;


    private static final String TABLE_NAME = "eventreminder";


    private static final String ID_COL = "id";


    private static final String NAME_COL = "name";


    private static final String Date_COL = "date";


    private static final String Time_COL = "time";


    private static final String Contact_COL1 = "number1";

    private static final String Contact_COL2 = "number2";


    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + Date_COL + " TEXT,"
                + Time_COL + " TEXT,"
                + Contact_COL1 + " TEXT,"
                + Contact_COL2 + " TEXT)";


        db.execSQL(query);
    }




    public void addNewEvent(String eventName, String eventDate, String eventTime, String eventNumber1, String eventNumber2) {


        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();


        values.put(NAME_COL, eventName);
        values.put(Date_COL, eventDate);
        values.put(Time_COL, eventTime);
        values.put(Contact_COL1, eventNumber1);
        values.put(Contact_COL2, eventNumber2);


        db.insert(TABLE_NAME , null, values);


        db.close();
    }

    public ArrayList<eventModal> readEvents() {

        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursorEvent = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);


        ArrayList<eventModal> eventModalArrayList = new ArrayList<>();


        if (cursorEvent.moveToFirst()) {
            do {

                eventModalArrayList.add(new eventModal(cursorEvent.getString(1),
                        cursorEvent.getString(4),

                        cursorEvent.getString(2),
                        cursorEvent.getString(3),
                        cursorEvent.getString(5)));
            } while (cursorEvent.moveToNext());

        }

        cursorEvent.close();
        return eventModalArrayList;
    }

    public void updateEvent(String originalEventName, String eventName, String eventDate,
                            String eventTime, String eventNumber1, String eventNumber2) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(NAME_COL, eventName);
        values.put(Date_COL, eventDate);
        values.put(Time_COL, eventTime);
        values.put(Contact_COL1, eventNumber1);
        values.put(Contact_COL2, eventNumber2);


        db.update(TABLE_NAME, values, "name=?", new String[]{originalEventName});
        db.close();
    }


    public void deleteEvent(String eventName) {


        SQLiteDatabase db = this.getWritableDatabase();


        db.delete(TABLE_NAME, "name=?", new String[]{eventName});
        db.close();
    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}




