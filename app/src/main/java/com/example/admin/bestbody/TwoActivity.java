package com.example.admin.bestbody;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TwoActivity extends Activity implements View.OnClickListener{

    String[] data = {"Мужчина", "Женщина"};
    int positionSpi =0;

    Button btnCalcul;
    EditText eMass, eHeight, eAge;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        eMass = (EditText) findViewById(R.id.editText2);
        eHeight = (EditText) findViewById(R.id.editText);
        eAge = (EditText) findViewById(R.id.editText5);

        tvResult = (TextView) findViewById(R.id.textView8);

        btnCalcul = (Button) findViewById(R.id.button8);
        btnCalcul.setOnClickListener(this);

        // адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        spinner.setAdapter(adapter);
        // заголовок
        spinner.setPrompt("Title");
        // выделяем элемент
        spinner.setSelection(0);
        // устанавливаем обработчик нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                positionSpi = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button8:
                roschet();
                break;
        }

    }

    private void roschet() {
        if (eMass.getText().toString().equals(""))
            eMass.setText("" + 1);
        if (eHeight.getText().toString().equals(""))
            eHeight.setText("" + 1);
        if (eAge.getText().toString().equals(""))
            eAge.setText("" + 1);


        double t1Mass = Integer.parseInt(eMass.getText().toString());
        double t2Height = Integer.parseInt(eHeight.getText().toString());
        double t3Age = Integer.parseInt(eAge.getText().toString());

        double l;
        double tPow = Math.pow(t2Height/100 , 2);
        l = t1Mass/(tPow);
        switch (positionSpi){
            case 0:
                if(l<20) {
                    tvResult.setText("Ваш ИМТ:" + l + "- это означает Недовес");
                }
                if(l >= 20 && l <= 25) {
                    tvResult.setText("Ваш ИМТ:" + l + "- это означает Нормальный Вес");
                }
                if(l > 25 && l <= 30) {
                    tvResult.setText("Ваш ИМТ:" + l + "- это означает Избыточный Вес");
                }
                if(l > 30 && l <= 40) {
                    tvResult.setText("Ваш ИМТ:" + l + "- это означает Ожирение");
                }
                if(l >40) {
                    tvResult.setText("Ваш ИМТ:" + l + "- это означает Сильное Ожирение");
                }
                break;
            case 1:
                if(l<19) {
                    tvResult.setText("Ваш ИМТ:" + l + "- это означает Недовес");
                }
                if(l >= 19 && l <= 24) {
                    tvResult.setText("Ваш ИМТ:" + l + "- это означает Нормальный Вес");
                }
                if(l > 24 && l <= 30) {
                    tvResult.setText("Ваш ИМТ:" + l + "- это означает Избыточный Вес");
                }
                if(l > 30 && l <= 40) {
                    tvResult.setText("Ваш ИМТ:" + l + "- это означает Ожирение");
                }
                if(l >40) {
                    tvResult.setText("Ваш ИМТ:" + l + "- это означает Сильное Ожирение");
                }
                break;
            default:
                tvResult.setText("Не табл. знач.");
                break;
        }
        /*l = (t1*0.03)+(t2*0.4);
        tv.setText("Кол. воды = "+(int)Math.round(l) + " Литра");*/
    }
}
