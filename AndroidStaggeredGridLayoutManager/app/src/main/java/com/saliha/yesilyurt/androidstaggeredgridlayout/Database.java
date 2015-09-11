package com.saliha.yesilyurt.androidstaggeredgridlayout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Casper on 11.9.2015.
 */
//favoriler ve haberler ayrı database de olacak.
public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Empatik.db";
    public static final String TABLE_NAME = "haberler";
    public static final String COLUMN_ID ="id";
    public static final String COLUMN_KAYDEDILENLER = "kaydedilenler";
    public static final String COLUMN_FAVORILER = "favoriler";
   /* public static final String SQL_CREATE_QUERY = ("CREATE TABLE "+TABLE_NAME+" ("+COLUMN_ID+
            " INTEGER PRIMARY KEY,"+COLUMN_KAYDEDILENLER+" TEXT,"+COLUMN_FAVORILER+" TEXT");*/
   public static final int DATABASE_VERSION = 1;

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table haberler(id integer primary key, kaydedilenler text, favoriler text");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS haberler");
        onCreate(db);
    }


}
