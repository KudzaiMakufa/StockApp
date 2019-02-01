package com.kudzai.stockapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mitch on 2016-05-13.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Butchery.db";
    public static final String TABLE_NAME = "products";
    public static final String COL1 = "ID";
    public static final String COL2 = "DATE";
    public static final String COL3 = "ITEM";
    public static final String COL4 = "OPENING";
    public static final String COL5 = "PURCHASES";
    public static final String COL6 = "TRANSFERS";
    public static final String COL7 = "CLOSING";
    public static final String COL8 = "ADDIT_INFO";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " DATE TEXT, ITEM TEXT, OPENING TEXT ,PURCHASES TEXT,TRANSFERS TEXT,CLOSING TEXT,ADDIT_INFO TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String date, String item, String opening,String purchases,String transfers,String closing,String addit_info) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, date);
        contentValues.put(COL3, item);
        contentValues.put(COL4, opening);
        contentValues.put(COL5, purchases);
        contentValues.put(COL6, transfers);
        contentValues.put(COL7, closing);
        contentValues.put(COL8, addit_info);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if data as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //query for 1 week repeats
    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }
}
