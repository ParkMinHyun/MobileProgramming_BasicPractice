package com.example.parkminhyun.mobileprogramming_practice;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameInput;
    TextView studentId;
    TextView studentName;
    EditText phoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_layout);
        Toast.makeText(this, "onCreate호출됨", Toast.LENGTH_SHORT).show();
        phoneNum = (EditText) findViewById(R.id.editText3);
//        nameInput = (EditText) findViewById(R.id.editText);
//        studentId = (TextView) findViewById(R.id.studentId1);
//        studentName = (TextView) findViewById(R.id.studentName1);
    }

    public void onButton1Clicked(View v) {
//        Intent intent = new Intent(this, MenuActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        startActivity(intent);
/////////////////////////////////////////////////////////////////////////////////////

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1111-2222"));
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart호출됨", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop호출됨", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy호출됨", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause호출됨", Toast.LENGTH_SHORT).show();
//        saveState();// 현재입력상자에입력된데이터를저장
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume호출됨", Toast.LENGTH_SHORT).show();
//        restoreState();// 설정정보에저장된데이터를복원
    }

    protected void restoreState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ((pref != null) && (pref.contains("name"))) {
            String name = pref.getString("name", "");
            nameInput.setText(name);
        }
    }

    protected void saveState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        String A = nameInput.getText().toString();
        A += "&";
        A += studentId.getText().toString();
        A += "&";
        A += studentName.getText().toString();

        editor.putString("name", A);
        editor.commit();
    }

    protected void clearMyPrefs() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
