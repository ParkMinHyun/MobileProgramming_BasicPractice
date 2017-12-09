package com.example.parkminhyun.mobileprogramming;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToast("onCreate호출됨.");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
// 가로방향전환시처리
        if (newConfig.orientation== Configuration.ORIENTATION_LANDSCAPE) {
            showToast("방향: ORIENTATION_LANDSCAPE");
// 세로방향전환시처리
        } else if (newConfig.orientation== Configuration.ORIENTATION_PORTRAIT) {
            showToast("방향: ORIENTATION_PORTRAIT");
        }
    }
    public void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}