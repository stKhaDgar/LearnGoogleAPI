package com.example.stmak.learngoogleapi.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.android.gms.location.places.Place;

public class PlaceDbHelper extends SQLiteOpenHelper{

    // The database name
    private static final String DATABASE_NAME = "location.db";

    // If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 1;

    // Constructor
    public PlaceDbHelper(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create a table to hold the places data
        final String SQL_CREATE_PLACES_TABLE = "CREATE TABLE " + PlaceContract.PlaceEntry.TABLE_NAME + " (" +
                PlaceContract.PlaceEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                PlaceContract.PlaceEntry.COLUMN_PLACE_ID + " TEXT NOT NULL, " +
                "UNIQUE (" + PlaceContract.PlaceEntry.COLUMN_PLACE_ID + ") ON CONFLICT REPLACE" +
                "); ";

        db.execSQL(SQL_CREATE_PLACES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PlaceContract.PlaceEntry.TABLE_NAME);
        onCreate(db);
    }
}
