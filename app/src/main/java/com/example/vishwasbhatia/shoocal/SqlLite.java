package com.example.vishwasbhatia.shoocal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlLite extends SQLiteOpenHelper {
    public static final String  Database_name="Restaurant.db";
    public static final String Column_2="First_Name";
    public static final String Column_3="Last_Name";
    public static final String Column_4="Phone";
    public static final String Column_5="Address";
    public static final String Column_6="Restaurant_Name";
    public static final String Column_7="Request_By";
    public static final String Table_NAME="Restaurant";

    public SqlLite(Context context) {
        super(context,Database_name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_NAME +" (SNO INTEGER PRIMARY KEY AUTOINCREMENT,First_Name TEXT,Last_Name TEXT,Phone TEXT,Address TEXT,Restaurant_Name TEXT,Request_By TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_NAME);
        onCreate(db);
    }

    public boolean insertdata(String firstname,String surname,String phone,String add,String restname,String reqby)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Column_2,firstname);
        contentValues.put(Column_3,surname);
        contentValues.put(Column_4,phone);
        contentValues.put(Column_5,add);
        contentValues.put(Column_6,restname);
        contentValues.put(Column_7,reqby);
        int result= (int) db.insert(Table_NAME,null,contentValues);
        if(result==-1)
        {return false;}
        else
        {return true;}
    }

//    public Cursor getdata()
//    { SQLiteDatabase db=this.getWritableDatabase();
//        Cursor cursor=db.rawQuery("select * from "+Table_NAME,null);
//        return cursor;
//    }
}
