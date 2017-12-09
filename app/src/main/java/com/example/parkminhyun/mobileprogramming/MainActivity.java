package com.example.parkminhyun.mobileprogramming;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.textView);

        // 뷰를 터치했을때 이벤트를 전달 받을 리스너 등록
        View view= findViewById(R.id.view);

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();

                float curX= motionEvent.getX();// 터치한곳의좌표
                float curY= motionEvent.getY();

                if (action == MotionEvent.ACTION_DOWN) {
                    println("손가락눌림: " + curX+ ", " + curY);
                }
                else if (action == MotionEvent.ACTION_MOVE) {
                    println("손가락움직임: " + curX+ ", " + curY);
                }
                else if (action == MotionEvent.ACTION_UP) {
                    println("손가락뗌: " + curX+ ", " + curY);
                }return true;}
        });
    }
    public void println(String data) {
        textView.append(data + "\n");
    }
}