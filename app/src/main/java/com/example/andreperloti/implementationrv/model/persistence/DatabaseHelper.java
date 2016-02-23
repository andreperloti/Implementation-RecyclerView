package com.example.andreperloti.implementationrv.model.persistence;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.andreperloti.implementationrv.util.ApplicationUtil;

/**
 * Created by andre.perloti on 19/02/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "appLista";
    private static final int DATABASE_VERSION = 1;

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance() {
        return new DatabaseHelper(ApplicationUtil.getContext());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CarContract.getCreateTableScript());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
