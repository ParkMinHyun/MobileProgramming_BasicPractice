package com.example.parkminhyun.mobileprogramming_practice;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

public class Information extends AppCompatActivity{

    EditText studentSchool;
    EditText studentName;
    EditText phoneNum;
    RadioButton isMan, isWoman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_information);

//        Toast.makeText(this, "onCreate호출됨", Toast.LENGTH_SHORT).show();
        phoneNum = (EditText) findViewById(R.id.inputPhoneTextBox);
        studentName = (EditText) findViewById(R.id.inputNameTextBox);
        studentSchool = (EditText) findViewById(R.id.inputSchoolTextBox);
        isMan = (RadioButton)findViewById(R.id.checkMan);
        isWoman = (RadioButton)findViewById(R.id.checkWoman);

        isMan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isMan.setTextColor(Color.BLUE);
            }
        });
    }

    public void onButtonClicked(View v){
        saveState();
    }

    protected void saveState() {
//        Toast.makeText(getApplicationContext(),"" + isMan.isChecked(),Toast.LENGTH_SHORT).show();
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        String A = studentName.getText().toString();
        A += "&";
        A += studentSchool.getText().toString();
        A += "&";
        A += phoneNum.getText().toString();
        A += "&";
        A += isMan.isChecked();
        A += "&";
        A += isWoman.isChecked();

        editor.putString("info", A);
        editor.commit();

        Intent intent= new Intent(); // 인텐트객체생성하고name의값을부가데이터로넣기
        setResult(RESULT_OK, intent); // 응답보내기
        finish();// 현재액티비티없애기
//
//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);
    }
}
