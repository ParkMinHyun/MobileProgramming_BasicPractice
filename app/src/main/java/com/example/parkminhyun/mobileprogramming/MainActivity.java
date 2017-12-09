package com.example.parkminhyun.mobileprogramming;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startBtnClick(View view) {
        Intent intent= new Intent(this, MyService.class);
        intent.putExtra("command", "show");
        intent.putExtra("name", "ParkMinHyun");
        startService(intent);
    }

    public void stopBtnClick(View view) {
    }

    // 액티비티가 이미 메모리에 만들어져있는 경우 onNewIntent() 메소드호출됨
    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name");
            Toast.makeText(this, "command : " + command + ", name : " + name, Toast.LENGTH_LONG).show();
        }
    }
}
