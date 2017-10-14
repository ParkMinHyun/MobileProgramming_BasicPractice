package com.example.parkminhyun.mobileprogramming_practice;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        editText = (EditText)findViewById(R.id.entry);
    }

    @Override
    protected void onStart() {
        super.onStart();
        restoreState();

    }

    protected void restoreState() {
        SharedPreferences pref= getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ((pref!= null) && (pref.contains("name")) ){
            String name = pref.getString("name", "");
            editText.setText(name);
        }
    }
}
