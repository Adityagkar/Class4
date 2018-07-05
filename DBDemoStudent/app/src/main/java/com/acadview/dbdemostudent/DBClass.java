package com.acadview.dbdemostudent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aditya on 6/19/2018.
 */

public class DBClass extends SQLiteOpenHelper {

    public DBClass(Context context) {
        super(context, "USERDB2", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //for table creation
        sqLiteDatabase.execSQL("CREATE TABLE USER (Name text, Password text, Number text, Type text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // if table exists , so drop that and if the table USER doesn't exist , Create new table or after dropping create new table
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USER");
        onCreate(sqLiteDatabase);
     }



     void addData(String name,String password,String number,String type) {
         SQLiteDatabase sqLiteDatabase = getWritableDatabase();

         ContentValues contentValues = new ContentValues();
         contentValues.put("Name", name);
         contentValues.put("Password", password);
         contentValues.put("Number", number);
         contentValues.put("Type", type);

         sqLiteDatabase.insert("USER", null, contentValues);
     }
     //SELECT ROW FROM TABLE WHERE ROW_ID IS LIKE

    Cursor getData() { //showData()

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        //SELECT * FROM TABLE
        Cursor cursor = sqLiteDatabase.query("USER",null,null,null,null,null,null);

         return cursor;

    }

    void onUpdate(String name,String password_old,String password_new){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Password", password_new);
        String arr[]={name,password_old};

        sqLiteDatabase.update("USER",contentValues,"Name = ? AND Password = ?",arr);
    }

    void onDelete(String name){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String arr[]= {name};
        sqLiteDatabase.delete("USER","Name = ?",arr);
    }

//    void onDelete(String name){
//         SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//
//         // DELETE FROM USER WHERE Name = "name" AND Password="xyz";
//        String arr[]={" "};
//        arr[0]=name;
//       sqLiteDatabase.delete("USER","Name=?",arr);
//    }


//    void onUpdate(String name,String oldpassword,String newpassword){
//        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("Name",name);
//        contentValues.put("Password",newpassword);
//        //UPDATE USER WHERE NAame = "name" and PAssword ="oldpassword"
//
//
//        String arr[]={" "," "};
//        arr[0]=name;
//        arr[1]= oldpassword;
//        sqLiteDatabase.update("USER",contentValues,"Name=? AND Password=?",arr);
//        // UPDATE USER WHERE NAME = TEST AND PASSWORD = 123456;
//    }

//    void deleteData(String name){
//         SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//         String arr[]={""};
//         arr[0]=name;
//         sqLiteDatabase.delete("USER","Name=?",arr);
//    }
//
//    void updateData(String name,String password,String newpassword){
//        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//        String ar[]={" "," "};
//        ar[0]=name;
//        ar[1]=password;
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("Name",name);
//        contentValues.put("Password",newpassword);
//
//        sqLiteDatabase.update("USER",contentValues,"Name=? AND Password=?",ar);
//    }

}

