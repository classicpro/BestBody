package com.example.admin.bestbody;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TrainingActivity extends AppCompatActivity implements View.OnClickListener {

    final int MENU_COLOR_RED = 1;

    Button btn1,btnFitnes,BtnMass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        btn1 = (Button) findViewById(R.id.button5);
        btn1.setOnClickListener(this);
        btnFitnes = (Button) findViewById(R.id.button6);
        btnFitnes.setOnClickListener(this);
        BtnMass = (Button) findViewById(R.id.button7);
        BtnMass.setOnClickListener(this);
        registerForContextMenu(btn1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.button6:
                menu.add(0, MENU_COLOR_RED, 0, "Red");
                break;

        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            // пункты меню для tvColor
            case MENU_COLOR_RED:
                btn1.setTextColor(Color.RED);
                btn1.setText("Text color = red");
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View v) {
      //  String name = "1";
      //  String nameFit = "2";
      //  String addMass = "3";
        // по id определеяем кнопку, вызвавшую этот обработчик
        switch (v.getId()) {
            case R.id.button7:
                Intent intent = new Intent(this, Main2Activity.class);
                //intent.putExtra("fname", name);
                startActivity(intent);
                break;
            case R.id.button6:
                Intent intentFitnes = new Intent(this, Main2Activity.class);
                //intentFitnes.putExtra("fname", nameFit);
                startActivity(intentFitnes);
                break;
            case R.id.button5:
                Intent intentMass = new Intent(this, Main2Activity.class);
                //intentMass.putExtra("fname", addMass);
                startActivity(intentMass);
                break;

        }
    }
}

