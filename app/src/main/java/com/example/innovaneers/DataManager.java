package com.example.innovaneers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private DBHelper dbHelper;

    public DataManager(Context context) {
        dbHelper = new DBHelper(context);
    }

    public long insertData(String spinnerValue, String dateValue, String description) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_SPINNER_VALUE, spinnerValue);
        values.put(DBHelper.COLUMN_DATE_VALUE, dateValue);
        values.put(DBHelper.COLUMN_DESCRIPTION, description);
        long id = db.insert(DBHelper.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public List<DataModel> getAllData() {
        List<DataModel> dataList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_ID));
                String spinnerValue = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_SPINNER_VALUE));
                String dateValue = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DATE_VALUE));
                String description = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DESCRIPTION));
                dataList.add(new DataModel(id, spinnerValue, dateValue, description));
            } while (cursor.moveToNext());
            cursor.close();
        }
        db.close();
        return dataList;
    }
}
