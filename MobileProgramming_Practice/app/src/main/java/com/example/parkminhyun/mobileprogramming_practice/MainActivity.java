package com.example.parkminhyun.mobileprogramming_practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;// 다른액티비티를띄우기위한요청코드정의
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButton1Clicked(View v) {
// 또다른액티비티를띄우기위한인텐트객체생성
        Intent intent= new Intent(getApplicationContext(), MenuActivity.class);
        intent.putExtra("hi","ABC");
//        startActivity(intent);
        startActivityForResult(intent, REQUEST_CODE_MENU);// 액티비티띄우기
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== REQUEST_CODE_MENU) {
            Toast.makeText(getApplicationContext(), "onActivityResult메소드호출됨. 요청코드: " + requestCode+ ", 결과코드: " + resultCode, Toast.LENGTH_LONG).show();
            if (resultCode== RESULT_OK) {
                String name = data.getExtras().getString("name");
                Toast.makeText(getApplicationContext(), "응답으로전달된name : " + name, Toast.LENGTH_LONG).show();
            }
        }
    }
}