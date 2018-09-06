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
import android.widget.Toast;

public class OneActivity extends Activity implements View.OnClickListener{

    String[] data = {"Мужчина", "Женщина"};
    int positionSpi =0;

    Button btnCalc;
    EditText mass, hourAct;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        mass = (EditText) findViewById(R.id.editText3);
        hourAct = (EditText) findViewById(R.id.editText4);

        tv = (TextView) findViewById(R.id.textView2);

        btnCalc = (Button) findViewById(R.id.button10);
        btnCalc.setOnClickListener(this);

        // адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
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
            case R.id.button10:
                roschet();
                break;
        }

    }

    private void roschet() {
        if (mass.getText().toString().equals(""))
            mass.setText("" + 1);
        if (hourAct.getText().toString().equals(""))
            hourAct.setText("" + 1);
        double t1 = Integer.parseInt(mass.getText().toString());
        double t2 = Integer.parseInt(hourAct.getText().toString());
        double l;
        switch (positionSpi){
            case 0:
                l = (t1*0.04)+(t2*0.6);
                tv.setText("Кол. воды = "+(int)Math.round(l) + " Литра");
                break;
            case 1:
                l = (t1*0.03)+(t2*0.4);
                tv.setText("Кол. воды = "+(int)Math.round(l) + " Литра");
                break;
            default:
                tv.setText("Не табл. знач.");
                break;
        }
        /*l = (t1*0.03)+(t2*0.4);
        tv.setText("Кол. воды = "+(int)Math.round(l) + " Литра");*/
    }
}
