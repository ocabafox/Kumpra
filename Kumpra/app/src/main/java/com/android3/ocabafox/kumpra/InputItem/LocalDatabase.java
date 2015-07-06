package com.android3.ocabafox.kumpra.InputItem;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ocabafox on 7/6/2015.
 */
public class LocalDatabase {

    DBHelper dbHelper;
    public Context context;
    public SQLiteDatabase dB;

    public LocalDatabase(Context context){
        this.context = context;
        dbHelper = new DBHelper(context);
    }

    public LocalDatabase opendB() {
        dB = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public long insert(String getInput) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.INPUT, getInput);
        return dB.insert(DBHelper.TABLENAME, null, contentValues);
    }


    static class DBHelper extends SQLiteOpenHelper{

        private static final String DATABASE_NAME = "db";
        private static final int DATABASE_VERSION = 1;
        private static final String TABLENAME = "Input";

        private static final String UID = "_id";
        private static final String INPUT = "myInput";

        private static final String CREATE_TABLE = "CREATE TABLE " + TABLENAME
                + "(" + UID + " INTEGER(12) NOT NULL, " + INPUT
                + " VARCHAR(255) NOT NULL);";

        private static final String DROP_TABLE = "DROP TABLE IF EXISTS "
                + TABLENAME;
        Context context;


        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
    }
}
