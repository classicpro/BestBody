package com.example.admin.bestbody;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;



public class Calc extends TabActivity {
    final String TABS_TAG_1 = "Tag 1";
    final String TABS_TAG_2 = "Tag 2";

    EditText visotaSP;
    EditText vidstanDoGarmat;

    TextView result1;

    Button obch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);


        // получаем TabHost
        TabHost tabHost = getTabHost();

        // инициализация была выполнена в getTabHost
        // метод setup вызывать не нужно

        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator("Вкладка 1");
        tabSpec.setContent(new Intent(this, OneActivity.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("Вкладка 2");
        tabSpec.setContent(new Intent(this, TwoActivity.class));
        tabHost.addTab(tabSpec);
    }
}