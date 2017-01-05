package com.callmebear.financerecorder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
 * Created by Call Me Bear on 2016/5/14.
 */
public class RecordersDB extends SQLiteOpenHelper {

    public static final String TABLE_NAME="recorders";
    public static final String ID="_id";
    public static final String VALUE="value";
    public static final String MATTER="matter";
    public static final String TIME="time";

    public RecordersDB(Context context)
    {
        super(context,"recorders",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +VALUE+" TEXT NOT NULL,"
                +MATTER+" TEXT NOT NULL,"
                +TIME+" TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {

    }
}
