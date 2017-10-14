package com.example.parkminhyun.mobileprogramming_practice;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    EditText editText;

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        editText = (EditText)findViewById(R.id.entry);
        btn = (Button)findViewById(R.id.ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
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
