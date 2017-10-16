package com.example.parkminhyun.mobileprogramming_practice;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText id;
    EditText password;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = (Button)findViewById(R.id.loginBtn);
        id = (EditText)findViewById(R.id.loginID);
        password = (EditText)findViewById(R.id.loginPassword);
    }

    public void registerBtnClicked(View v){
        Intent intent = new Intent(this,Information.class);
        startActivityForResult(intent,101);
    }
    public void loginBtnClicked(View v){
        if(id.getText().toString().equals(a) && password.getText().toString().equals(b)){
            Toast.makeText(getApplicationContext(),"딩동댕",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(),"땡",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== 101) {
            Toast.makeText(getApplicationContext(), "onActivityResult메소드호출됨. 요청코드: " + requestCode+ ", 결과코드: " + resultCode, Toast.LENGTH_LONG).show();
            if (resultCode== RESULT_OK) {
                restoreState();
            }
        }
    }


    String a;
    String b;
    protected void restoreState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if ((pref != null) && (pref.contains("info"))) {
            String text = pref.getString("info", "");
            String[] data = text.split("&");

            a = data[0];
            b = data[1];
        }
    }

}
