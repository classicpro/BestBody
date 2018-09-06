package com.example.admin.bestbody;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 23.05.2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "userstore4.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "users"; // название таблицы в бд
    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ARTICLE = "article";
    public static final String COLUMN_IDART = "id_art";
    public static final String COLUMN_ISMY = "id_ismy";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db1) {

        db1.execSQL("CREATE TABLE users (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
                + " TEXT, " + COLUMN_IDART
                + " TEXT, " + COLUMN_ISMY
                + " TEXT, " + COLUMN_ARTICLE + " TEXT);");
        // добавление начальных данных
        db1.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_NAME
                + ", " + COLUMN_IDART
                + ", " + COLUMN_ISMY
                + ", " + COLUMN_ARTICLE  + ") VALUES ('Тренировка Арнольда Шварценеггера','1' ,'1', 'Жим штанги лежа подхода по 10 повторений');");
        db1.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_NAME
                + ", " + COLUMN_IDART
                + ", " + COLUMN_ISMY
                + ", " + COLUMN_ARTICLE  + ") VALUES ('Тренировка Арнольда неггера','1' ,'0', 'Жим штанги лежа 5x5');");
        //2-id
        db1.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_NAME
                + ", " + COLUMN_IDART
                + ", " + COLUMN_ISMY
                + ", " + COLUMN_ARTICLE  + ") VALUES ('Fitnes Арнольда Шварценеггера','2' ,'0', 'Жим лежа 10 подхода по 10 повторений');");
        db1.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_NAME
                + ", " + COLUMN_IDART
                + ", " + COLUMN_ISMY
                + ", " + COLUMN_ARTICLE  + ") VALUES ('Fitnes неггера','2' ,'0', 'Жим штанги лежа 25x10');");
        //3-id
        db1.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_NAME
                + ", " + COLUMN_IDART
                + ", " + COLUMN_ISMY
                + ", " + COLUMN_ARTICLE  + ") VALUES ('Add mass Арнольда Шварценеггера','3' ,'0', 'Жим лежа 10 подхода по 10 повторений');");
        db1.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_NAME
                + ", " + COLUMN_IDART
                + ", " + COLUMN_ISMY
                + ", " + COLUMN_ARTICLE  + ") VALUES ('Add mas method Arnolda','3' ,'1', 'Жим штанги лежа 2x2');");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db1, int oldVersion,  int newVersion) {
        db1.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db1);
    }
}
