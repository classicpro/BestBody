package com.example.admin.bestbody;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MyTrainingActivity extends AppCompatActivity {

    SQLiteDatabase db;
    DatabaseHelper databaseHelper;
    Cursor userCursor;
    ListView userList;
    SimpleCursorAdapter userAdapter;

    final int MENU_COLOR_RED = 1;
    String nameTemp = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_training);


        userList = (ListView)findViewById(R.id.list1);
        registerForContextMenu(userList);

        Intent intent = getIntent();
        String fName = intent.getStringExtra("fname");

        databaseHelper = new DatabaseHelper(getApplicationContext());
    }
    @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = databaseHelper.getReadableDatabase();

        //получаем данные из бд в виде курсора

        userCursor =  db.query("users" , new String[] {"_id","name", "article"}, "id_ismy = ?",new String[] {nameTemp}, null,null,null);
        // определяем, какие столбцы из курсора будут выводиться в ListView
        String[] headers = new String[] {DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_ARTICLE};
        // создаем адаптер, передаем в него курсор
        userAdapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item,
                userCursor, headers, new int[]{android.R.id.text1, android.R.id.text2}, 0);

        userList.setAdapter(userAdapter);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        userCursor.close();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.list1:
                menu.add(0, MENU_COLOR_RED, 0, "Red");
                break;

        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // создаем объект для данных
        ContentValues cv = new ContentValues();
        String isMy = "0";
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            // пункты меню для tvColor
            case MENU_COLOR_RED:
                // подготовим значения для обновления

                cv.put("id_ismy", isMy);
                // обновляем по id
                //int updCount = db.update("users", cv, "_id = ?",
                      //  new String[] { userCursor. });
                break;
        }
        return super.onContextItemSelected(item);
    }
}
