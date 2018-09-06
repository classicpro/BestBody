package com.example.admin.bestbody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTraining, btnCalc, btnFam,btnMyTr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTraining = (Button) findViewById(R.id.button2);
        btnTraining.setOnClickListener(this);
        btnCalc = (Button) findViewById(R.id.button3);
        btnCalc.setOnClickListener(this);
        btnFam = (Button) findViewById(R.id.button4);
        btnFam.setOnClickListener(this);
        btnMyTr = (Button) findViewById(R.id.button);
        btnMyTr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // по id определеяем кнопку, вызвавшую этот обработчик
        switch (v.getId()) {
            case R.id.button2:
                Intent intent = new Intent(this, TrainingActivity.class);
                startActivity(intent);

                break;
            case R.id.button3:
                Intent intent3 = new Intent(this, Calc.class);
                startActivity(intent3);


                break;
            case R.id.button:
                Intent intent1 = new Intent(this, MyTrainingActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
