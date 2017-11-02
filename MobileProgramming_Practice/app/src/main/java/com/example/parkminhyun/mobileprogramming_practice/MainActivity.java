package com.example.parkminhyun.mobileprogramming_practice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    boolean isPageOpen= false;/** 페이지가열려있는지알기위한플래그*/
    Animation translateLeftAnim;/** 애니메이션객체*/
    Animation translateRightAnim;
    LinearLayout page;/** 슬라이딩으로보여지는페이지레이아웃*/
    Button button;/** 버튼*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        page = (LinearLayout) findViewById(R.id.page);// 슬라이딩으로보여질레이아웃객체참조
// 애니메이션객체로딩
        translateLeftAnim= AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRightAnim= AnimationUtils.loadAnimation(this, R.anim.translate_right);
// 애니메이션객체에리스너설정
        SlidingPageAnimationListener animListener= new SlidingPageAnimationListener();
        translateLeftAnim.setAnimationListener(animListener);
        translateRightAnim.setAnimationListener(animListener);
    }
    public void onButton1Clicked(View v) {
        if (isPageOpen) {// 애니메이션적용
            page.startAnimation(translateRightAnim);
        } else {
            page.setVisibility(View.VISIBLE);
            page.startAnimation(translateLeftAnim);
        }
    }
    /** 애니메이션리스너정의*/
    private class SlidingPageAnimationListener implements Animation.AnimationListener{
/** 애니메이션이끝날때호출되는메소드*/
        public void onAnimationEnd(Animation animation) {
            if (isPageOpen) {
                page.setVisibility(View.INVISIBLE);
                button.setText("Open");
                isPageOpen= false;
            } else {
                button.setText("Close");
                isPageOpen= true;
            }
        }
    public void onAnimationRepeat(Animation animation) {}
    public void onAnimationStart(Animation animation) {}
}
}