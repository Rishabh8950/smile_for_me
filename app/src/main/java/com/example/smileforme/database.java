package com.example.smileforme;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.TextView;

import java.util.jar.Attributes;

import static android.os.Build.ID;

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

        sqLiteDatabase.execSQL("Create table ngodata(id integer primary key autoincrement, name text, ngoid text, email text, mobile text, password text, ngodetails text, status int ) ");
        sqLiteDatabase.execSQL("Create table itemsdata(id integer primary key autoincrement, itemtype text, itemdetails text, mobile text, BPL int) ");
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
        sqLiteDatabase.execSQL("drop table ngodata");
        onCreate(sqLiteDatabase);
        sqLiteDatabase.execSQL("drop table itemsdata");
        onCreate(sqLiteDatabase);
    }
    public void insertintoadmin(String username, String password)
    {
        this.getWritableDatabase().execSQL("insert into admindata(username,password) values('"+username+"','"+password+"')");

    }
    public void insertintoitems(String itemtype,String itemdetails,String mobile)
    {
        this.getWritableDatabase().execSQL("insert into itemsdata(itemtype,itemdetails,mobile,BPL) values('"+itemtype+"','"+itemdetails+"','"+mobile+"','0')");
    }

    public void insertintorecipient(String name, String DOB, String Gender, String Email, String Contact_No, String Password, String BPL_No)
    {
        this.getWritableDatabase().execSQL("insert into recipientdata(name,DOB,Gender,Email,Contact_No,Password,BPL_No,Status) values('"+name+"','"+DOB+"','"+Gender+"','"+Email+"','"+Contact_No+"','"+Password+"','"+BPL_No+"','"+0+"')");

    }
    public void insertintongo(String name, String ngoid, String email, String mobile, String password, String ngodetails)
    {
        this.getWritableDatabase().execSQL("insert into ngodata(name,ngoid,email,mobile,password,ngodetails,status) values('"+name+"','"+ngoid+"','"+email+"','"+mobile+"','"+password+"','"+ngodetails+"','"+0+"')");
    }

    public void acceptrecipient(String BPL)
    {
        this.getWritableDatabase().execSQL("update recipientdata set status=1 where BPL_No='"+BPL+"'");
    }


    public void declinerecipient(String BPL)
    {
        this.getWritableDatabase().execSQL("update recipientdata set status=0 where BPL_No='"+BPL+"'");
    }

    public void acceptitem(String BPL)
    {
        this.getWritableDatabase().execSQL("update itemsdata set BPL='"+BPL+"' where ID='"+ID+"'");
    }
    public void viewselecteditem(TextView tv,String BPL)
    {
        this.getReadableDatabase().execSQL("select * from itemsdata where BPL='"+BPL+"'",null);
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


    public void viewallitems(TextView tv)
    {
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from itemdata where BPL=0",null);
        while(cursor.moveToNext())
        {
            tv.append("Id=");
            tv.append(cursor.getString(0));
            tv.append(", Item=");
            tv.append(cursor.getString(1));
            tv.append("\n");
            tv.append("Details=");
            tv.append(cursor.getString(2));
            tv.append("\n");

        }

    }

    public void acceptngo(String ngoid)
    {
        this.getWritableDatabase().execSQL("update ngodata set status=1 where ngoid='"+ngoid+"'");
    }

    public void declinengo(String ngoid)
    {
        this.getWritableDatabase().execSQL("update ngodata set status=0 where ngoid='"+ngoid+"'");
    }



    public void viewngoreq(TextView tv)
    {
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from ngodata where status=0",null);
        while(cursor.moveToNext())
        {
            tv.append("Name=");
            tv.append(cursor.getString(1));
            tv.append(", NGO-ID=");
            tv.append(cursor.getString(2));
            tv.append("\n");



        }
    }

    public void viewngolist(TextView tv)
    {
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from ngodata where status=1",null);
        while(cursor.moveToNext())
        {
            tv.append(cursor.getString(0));
            tv.append(" ");
            tv.append("Name=");
            tv.append(cursor.getString(1));
            tv.append(", Type=");
            tv.append(cursor.getString(6));
            tv.append("\n");
            tv.append("Number=");

            tv.append(cursor.getString(4));


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

    public int ngoselect(String email, String password)
    {
        int f=0;
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from ngodata where email='"+email+"' AND password='"+password+"'",null);
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
    public int ngocontactvalidation(String mobile)
    {
        int f=0;
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from ngodata where mobile='"+mobile+"' AND status='"+1+"'",null);
        while(cursor.moveToNext())
        {
            f=1;
        }
        return f;

    }


}

