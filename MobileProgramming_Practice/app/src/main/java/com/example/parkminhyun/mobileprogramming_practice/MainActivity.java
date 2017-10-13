package com.example.parkminhyun.mobileprogramming_practice;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate호출됨", Toast.LENGTH_LONG).show();
        nameInput = (EditText) findViewById(R.id.editText);
    }

    public void onButton1Clicked(View v) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart호출됨", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop호출됨", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy호출됨", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause호출됨", Toast.LENGTH_LONG).show();
        saveState();// 현재입력상자에입력된데이터를저장
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume호출됨", Toast.LENGTH_LONG).show();
        restoreState();// 설정정보에저장된데이터를복원
    }
    protected void restoreState() {
        SharedPreferences pref= getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ((pref!= null) && (pref.contains("name")) ){
            String name = pref.getString("name", "");
            nameInput.setText(name);
        }
    }
    protected void saveState() {
        SharedPreferences pref= getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString( "name", nameInput.getText().toString() );
        editor.commit();
    }
    protected void clearMyPrefs() {
        SharedPreferences pref= getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }

}