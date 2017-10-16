package com.example.parkminhyun.mobileprogramming_practice;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;

public class MenuActivity extends AppCompatActivity {

    RadioButton checkSex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        checkSex = (RadioButton)findViewById(R.id.checkSex);

        restoreState();
    }

    protected void restoreState() {
        SharedPreferences pref= getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ((pref!= null) && (pref.contains("info")) ){
            String text = pref.getString("info", "");
            String[] data = text.split("&");
            checkSex.setChecked(Boolean.parseBoolean(data[3]));
        }
    }

}