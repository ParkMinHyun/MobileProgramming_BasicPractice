package com.example.parkminhyun.mobileprogramming_practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;

    public static final String KEY_SIMPLE_DATA = "data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButton1Clicked(View v) {
        Intent intent= new Intent(getApplicationContext(), MenuActivity.class);
        String a = "Heelow";
        SimpleData data = new SimpleData(100, a); // SimpleData객체생성
        intent.putExtra(KEY_SIMPLE_DATA, data);// 인텐트에부가데이터로넣기
        startActivityForResult(intent, REQUEST_CODE_MENU);
    }
}