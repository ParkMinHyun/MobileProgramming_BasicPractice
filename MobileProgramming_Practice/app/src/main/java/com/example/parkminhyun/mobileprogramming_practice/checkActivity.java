package com.example.parkminhyun.mobileprogramming_practice;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioButton;


public class checkActivity extends AppCompatActivity {

    EditText studentSchool;
    EditText studentName;
    EditText phoneNum;
    RadioButton isMan, isWoman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toast.makeText(this, "onCreate호출됨", Toast.LENGTH_SHORT).show();
        phoneNum = (EditText) findViewById(R.id.inputPhoneTextBox);
        studentName = (EditText) findViewById(R.id.inputNameTextBox);
        studentSchool = (EditText) findViewById(R.id.inputSchoolTextBox);
        isMan = (RadioButton) findViewById(R.id.checkMan);
        isWoman = (RadioButton) findViewById(R.id.checkWoman);

        restoreState();
    }


    protected void restoreState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ((pref != null) && (pref.contains("info"))) {
            String name = pref.getString("name", "");
//            nameInput.setText(name);
        }
    }
}
