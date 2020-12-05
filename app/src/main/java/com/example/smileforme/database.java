package com.example.smileforme;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.TextView;

import java.util.jar.Attributes;

public class database extends SQLiteOpenHelper {
    public database(Context Context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(Context,"smile_for_me",factory,version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("Create table admindata(id integer primary key autoincrement, username text, password text)");
        sqLiteDatabase.execSQL("Create table recipientdata(id integer primary key autoincrement, name text, DOB text, Gender text, Email text, Contact_No text, Password text, BPL_No text,status int) ");
        sqLiteDatabase.execSQL("Create table donordata(id integer primary key autoincrement, name text, DOB text, Gender text, Email text, Contact_No text, Password text)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int ver, int ver2)
    {
        sqLiteDatabase.execSQL("drop table admindata");
        onCreate(sqLiteDatabase);
        sqLiteDatabase.execSQL("drop table recipientdata");
        onCreate(sqLiteDatabase);
        sqLiteDatabase.execSQL("drop table donordata");
        onCreate(sqLiteDatabase);
    }
    public void insertintoadmin(String username, String password)
    {
        this.getWritableDatabase().execSQL("insert into admindata(username,password) values('"+username+"','"+password+"')");

    }

    public void insertintorecipient(String name, String DOB, String Gender, String Email, String Contact_No, String Password, String BPL_No)
    {
        this.getWritableDatabase().execSQL("insert into recipientdata(name,DOB,Gender,Email,Contact_No,Password,BPL_No,Status) values('"+name+"','"+DOB+"','"+Gender+"','"+Email+"','"+Contact_No+"','"+Password+"','"+BPL_No+"','"+0+"')");

    }
    public void acceptrecipient(String BPL)
    {
        this.getWritableDatabase().execSQL("update recipientdata set status=1 where BPL_No='"+BPL+"'");
    }
    public void declinerecipient(String BPL)
    {
        this.getWritableDatabase().execSQL("update recipientdata set status=0 where BPL_No='"+BPL+"'");
    }
    public void viewrecipientreq(TextView tv)
    {
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from recipientdata where status=0",null);
        while(cursor.moveToNext())
        {
            tv.append("Name=");
            tv.append(cursor.getString(1));
            tv.append(", BPL=");

            tv.append(cursor.getString(7));

            tv.append("\n");
        }

    }



    public void insertintodonor(String name, String DOB, String Gender, String Email, String Contact_No, String Password)
    {
        this.getWritableDatabase().execSQL("insert into donordata(name,DOB,Gender,Email,Contact_No,Password) values('"+name+"','"+DOB+"','"+Gender+"','"+Email+"','"+Contact_No+"','"+Password+"')");
    }


    public int adselect(String username, String password)
    {
       int flag=0;
       Cursor cursor=this.getReadableDatabase().rawQuery("select * from admindata",null);
       while(cursor.moveToNext())
       {
           flag=1;
       }
       return  flag;

    }
    public int recselect( String Email, String Password)
    {
        int f=0;//recipientdata
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from recipientdata where Email='"+Email+"' AND Password='"+Password+"'",null);
        while(cursor.moveToNext())
        {
            f=1;
        }
        return f;
    }
    public int donselect(String Email, String Password)
    {
        int f=0;
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from donordata where Email='"+Email+"' AND Password='"+Password+"'",null);
         while (cursor.moveToNext())
         {
             f=1;
         }
         return f;
    }



}

