package com.example.parkminhyun.mobileprogramming;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;
    TextView editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToast("onCreate호출됨.");
        editText= (TextView) findViewById(R.id.textView);
        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            // 버튼을클릭했을때사용자가입력한값을name 변수에할당
                name = editText.getText().toString();
                Toast.makeText(getApplicationContext(), "입력된값을변수에저장했습니다: " + name, Toast.LENGTH_LONG).show();
            }
        });

        // 저장되었던값복원
        if (savedInstanceState!= null) {// 이화면이초기화될때name 변수의값복원
            name = savedInstanceState.getString("name");
            Toast.makeText(getApplicationContext(), "값을복원했습니다: " + name, Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("name", name);// name 변수의값저장
    }
    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart호출됨.");
    }
    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop호출됨.");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy호출됨.");
    }
    public void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}