package com.example.flowerstore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Databasehandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "use";

    private static final String TABLE_USERS= "users";

    private static final String KEY_EMAIL = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone_number";
    private static final String KEY_PASS="password";

    public Databasehandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void onCreate(SQLiteDatabase db) {
//        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "(" +
//        KEY_EMAIL + "INTEGER PRIMARY KEY," + KEY_NAME + "TEXT, " + KEY_PHONE + "TEXT" + ")";
//        db.execSQL(CREATE_CONTACTS_TABLE);

        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USERS + "(" +
                KEY_EMAIL + " TEXT PRIMARY KEY,"+ KEY_PASS +" TEXT," + KEY_NAME + " TEXT, " + KEY_PHONE + " TEXT" + ")";
        db.execSQL(CREATE_USER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_USERS);
            onCreate(db);
        }


    long addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PHONE, contact.getPhoneNumber());
values.put(KEY_PASS,contact.getPassword());
values.put(KEY_EMAIL,contact.getEmail());
        long trrue=db.insert(TABLE_USERS, null, values);
        db.close();
        return trrue;

    }

    Contact getContact(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USERS, new String[]{KEY_EMAIL,
                        KEY_NAME, KEY_PHONE, KEY_PASS}, "id=?",
                new String[]{id}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(cursor.getString(0),
                cursor.getString(1), cursor.getString(2),cursor.getString(3));
        return contact;
    }


    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_USERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setEmail(cursor.getString(0));
                contact.set_name(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        return contactList;
    }


    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PHONE, contact.getPhoneNumber());


        return db.update(TABLE_USERS, values, KEY_EMAIL + " = ?",
                new String[]{String.valueOf(contact.getEmail())});
    }


    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_EMAIL + " = ?",
                new String[]{String.valueOf(contact.getEmail())});
        db.close();
    }


    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }
}
