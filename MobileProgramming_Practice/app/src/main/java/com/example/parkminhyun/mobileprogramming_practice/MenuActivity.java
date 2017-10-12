package com.example.parkminhyun.mobileprogramming_practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button button= (Button) findViewById(R.id.button2);// 버튼객체참조
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent= new Intent(); // 인텐트객체생성하고name의값을부가데이터로넣기
                intent.putExtra("name", "mike");
                setResult(RESULT_OK, intent); // 응답보내기
                finish();// 현재액티비티없애기
            }
        });
    }
}