package com.example.logindesign;

/**
 * Created by Sushmitha on 17-01-2016.
 */
import java.util.HashMap;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class LoginDataBaseAdapter {

    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 4;
    public static final int NAME_COLUMN = 6;

    static final String DATABASE_CREATE = "create table "+" LOGIN2 "+
            "( " +"ID integer primary key autoincrement,"+ "Firstname text,"+"Lastname text,"+ "Email text,"+"Username text,"+"password text"+") ";

    public  SQLiteDatabase db;
    private final Context context;
    private DataBaseHelper dbHelper;

    public  LoginDataBaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    public  LoginDataBaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry(String Firstname1,String Lastname1,String email1,String username1,String password1)
    {
        ContentValues newValues = new ContentValues();
        newValues.put("Firstname", Firstname1);
        newValues.put("Lastname",Lastname1);
        newValues.put("Email",email1);
        newValues.put("Username",username1);
        newValues.put("password", password1);

        db.insert("LOGIN2", null, newValues);

    }

    public int deleteEntry(String password)
    {
        String where="PASSWORD=?";
        int numberOFEntriesDeleted= db.delete("LOGIN2", where, new String[]{password}) ;
        return numberOFEntriesDeleted;
    }

    public String getSinlgeEntry(String password)
    {
        Cursor cursor=db.query("LOGIN2", null, " PASSWORD=?", new String[]{password}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String repassword= cursor.getString(cursor.getColumnIndex("REPASSWORD"));
        cursor.close();
        return repassword;
    }

    public String getAllTags(String a) {


        Cursor c = db.rawQuery("SELECT * FROM " + "LOGIN2" + " where SECURITYHINT = '" +a + "'" , null);
        String str = null;
        if (c.moveToFirst()) {
            do {
                str = c.getString(c.getColumnIndex("PASSWORD"));
            } while (c.moveToNext());
        }
        return str;
    }


    public void  updateEntry(String password,String repassword)
    {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("PASSWORD", password);
        updatedValues.put("REPASSWORD",repassword);
        updatedValues.put("SECURITYHINT",repassword);

        String where="USERNAME = ?";
        db.update("LOGIN2",updatedValues, where, new String[]{password});
    }



    public HashMap<String, String> getAnimalInfo(String id) {
        HashMap<String, String> wordList = new HashMap<String, String>();
        String selectQuery = "SELECT * FROM LOGIN2 where SECURITYHINT='"+id+"'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                wordList.put("PASSWORD", cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return wordList;
    }
}
