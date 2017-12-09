package com.example.parkminhyun.mobileprogramming;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    GestureDetector detector;// 제스처디텍터객체선언
    boolean backFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.textView);

        // 뷰를 터치했을때 이벤트를 전달 받을 리스너 등록
        View view= findViewById(R.id.view);
        View view2 = findViewById(R.id.view2);

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

        // 뷰를터치했을때발생하는터치이벤트를제스처디텍터로전달
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return true;
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                println("onDown() 호출됨.");
                return true;
            }
            @Override
            public void onShowPress(MotionEvent motionEvent) {
                println("onShowPress() 호출됨.");
            }
            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                println("onSingleTapUp() 호출됨.");
                return true;
            }
            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                println("onScroll() 호출됨: " + v + ", " + v1);
                return true;
            }
            @Override
            public void onLongPress(MotionEvent motionEvent) {
                println("onLongPress() 호출됨.");
            }
            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                println("onFling() 호출됨: " + v + ", " + v1);
                return true;
            }
        });
    }
    public void println(String data) {
        textView.append(data + "\n");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        // 시스템BACK 버튼이눌렸을경우토스트메시지보여주기
        if(keyCode== KeyEvent.KEYCODE_BACK) {

            if(backFlag)
                this.finish();

            backFlag = true;

            Toast.makeText(this, "시스템BACK 버튼이눌렸습니다.", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

}