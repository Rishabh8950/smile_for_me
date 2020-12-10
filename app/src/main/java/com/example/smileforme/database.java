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
    private static final String DATABASE_NAME = "smile_for_me.db";
    private static final int VERSION_NUM = 1;
   public database(Context Context)
    {
        super(Context,DATABASE_NAME,null,VERSION_NUM);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)//all tables admin,recipient,donor,ngo,item created
    {
        sqLiteDatabase.execSQL("Create table admindata(id integer primary key autoincrement, username text, password text)");
        sqLiteDatabase.execSQL("Create table recipientdata(id integer primary key autoincrement, name text, DOB text, Gender text, Email text, Contact_No text, Password text, BPL_No text,status int) ");
        sqLiteDatabase.execSQL("Create table donordata(id integer primary key autoincrement, name text, DOB text, Gender text, Email text, Contact_No text, Password text)");

        sqLiteDatabase.execSQL("Create table ngodata(id integer primary key autoincrement, name text, ngoid text, email text, mobile text, password text, ngodetails text, status int ) ");
        sqLiteDatabase.execSQL("Create table itemsdata(id integer primary key autoincrement, itemtype text, itemdetails text, mobile text, noofitems int, BPL int) ");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int ver, int ver2)//updation part for all tables
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
    //------------------------------Admin Operations-----------------------------------------------------------------
    public void insertintoadmin(String username, String password)//linked with newjunioradmin activity(addition of new admin)
    {
        this.getWritableDatabase().execSQL("insert into admindata(username,password) values('"+username+"','"+password+"')");
    }
    public int adselect(String username, String password)//login access to new admin
    {
        int flag=0;
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from admindata",null);
        while(cursor.moveToNext())
        {
            flag=1;
        }
        cursor.close();//change
        return  flag;

    }
    //------------------------------Upload item Operations-----------------------------------------------------------------
    public void insertintoitems(String itemtype,String itemdetails,String mobile, int noofitems)//linked with uploaditem to insert values
    {
        this.getWritableDatabase().execSQL("insert into itemsdata(itemtype,itemdetails,mobile,noofitems,BPL) values('"+itemtype+"','"+itemdetails+"','"+mobile+"','"+noofitems+"','"+0+"')");
    }
    public void acceptitem(String BPL)//recipient accepting item by using bpl and entering itemid (Items activity)
    {
        this.getWritableDatabase().execSQL("update itemsdata set BPL='"+BPL+"' where ID='"+ID+"'");
    }
    //public void viewselecteditem(TextView tv,String BPL)
    public void viewselecteditem(TextView tv,String BPL)//view accepted item (by recipient) items activity
    {
        this.getReadableDatabase().execSQL("select * from itemsdata where BPL='"+BPL+"'");
        //this.getReadableDatabase().execSQL("select * from itemsdata where BPL='"+BPL+"'");
    }
    public void viewallitems(TextView tv)//view all uploaded items
    {
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from itemsdata where BPL='"+0+"'",null);
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
        cursor.close();//change

    }
    //------------------------------Recipient Operations-----------------------------------------------------------------
    public void insertintorecipient(String name, String DOB, String Gender, String Email, String Contact_No, String Password, String BPL_No)//recipientsignup(insertion of values)
    {
        this.getWritableDatabase().execSQL("insert into recipientdata(name,DOB,Gender,Email,Contact_No,Password,BPL_No,Status) values('"+name+"','"+DOB+"','"+Gender+"','"+Email+"','"+Contact_No+"','"+Password+"','"+BPL_No+"','"+0+"')");
    }
    public void acceptrecipient(String BPL)//login permission for new recipient
    {
        this.getWritableDatabase().execSQL("update recipientdata set status=1 where BPL_No='"+BPL+"'");
    }
    public void declinerecipient(String BPL)//decline recipient request
    {
        this.getWritableDatabase().execSQL("delete from recipientdata where BPL_No='"+BPL+"'");
    }
    public int recselect( String Email, String Password)//login access to recipient
    {
        int f=0;//recipientdata
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from recipientdata where Email='"+Email+"' AND Password='"+Password+"'",null);
        while(cursor.moveToNext())
        {
            f=1;
        }
        cursor.close();//change
        return f;
    }
    public void viewrecipientreq(TextView tv)//view all recipient requests
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
        cursor.close();//change

    }
    //------------------------------NGO Operations-----------------------------------------------------------------
    public void insertintongo(String name, String ngoid, String email, String mobile, String password, String ngodetails)//insertion of values in ngodata
    {
        this.getWritableDatabase().execSQL("insert into ngodata(name,ngoid,email,mobile,password,ngodetails,status) values('"+name+"','"+ngoid+"','"+email+"','"+mobile+"','"+password+"','"+ngodetails+"','"+0+"')");
    }
    public void acceptngo(String ngoid)//give permission to ngo
    {
        this.getWritableDatabase().execSQL("update ngodata set status=1 where ngoid='"+ngoid+"'");
    }
    public void declinengo(String ngoid)//decline ngo request
    {
        this.getWritableDatabase().execSQL("delete from ngodata where ngoid='"+ngoid+"'");
    }
    public void viewngoreq(TextView tv)//view all ngo requests for admin approval
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
        cursor.close();//change
    }
    public void viewngolist(TextView tv)//list to view all ngos that got permission
    {
//        String query = "Select * from ngodata where status=1";
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor =null;
//        if(db != null)
//            cursor = db.rawQuery(query,null);
//        return cursor;
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from ngodata where status=1",null);
        while(cursor.moveToNext())
        {
            tv.append(cursor.getString(0));
            tv.append(") ");
            tv.append("Name=");
            tv.append(cursor.getString(1));
            tv.append(", Type=");
            tv.append(cursor.getString(6));
            tv.append("\n");
            tv.append("ID=");
            tv.append(cursor.getString(2));
            tv.append("\n");
        }
        cursor.close();//change
    }
    public int ngocontactvalidation(String mobile)//ngo validation at the time of donation
    {
        int f=0;
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from ngodata where mobile='"+mobile+"' AND status='"+1+"'",null);
        while(cursor.moveToNext())
        {
            f=1;
        }
        cursor.close();//change
        return f;

    }
    public int ngoselect(String email, String password)//login access to ngo
    {
        int f=0;
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from ngodata where email='"+email+"' AND password='"+password+"'",null);
        while(cursor.moveToNext())
        {
            f=1;
        }
        cursor.close();//change
        return f;
    }
    public int ngosregistertocheckid(String ngoid)
    {
        int f=0;
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from ngodata where ngoid='"+ngoid+"'",null);
        while(cursor.moveToNext())
        {
            f=1;
        }
        cursor.close();//change
        return f;

    }
    //------------------------------Donor Operations-----------------------------------------------------------------
    public void insertintodonor(String name, String DOB, String Gender, String Email, String Contact_No, String Password)//insert values in donor table
    {
        this.getWritableDatabase().execSQL("insert into donordata(name,DOB,Gender,Email,Contact_No,Password) values('"+name+"','"+DOB+"','"+Gender+"','"+Email+"','"+Contact_No+"','"+Password+"')");
    }
    public int donselect(String Email, String Password)//login access to donor
    {
        int f=0;
        Cursor cursor=this.getReadableDatabase().rawQuery("select * from donordata where Email='"+Email+"' AND Password='"+Password+"'",null);
         while (cursor.moveToNext())
         {
             f=1;
         }
         cursor.close();//change
         return f;
    }



}

