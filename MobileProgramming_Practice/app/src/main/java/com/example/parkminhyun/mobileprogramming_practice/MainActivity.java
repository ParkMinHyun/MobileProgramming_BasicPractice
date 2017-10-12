package com.example.parkminhyun.mobileprogramming_practice;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView;
    ImageView imageView;
    ImageView imageView2;
    BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        scrollView.setHorizontalScrollBarEnabled(true);
        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.sample1);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;


        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.sample0);
        int bitmapWidth2 = bitmap.getIntrinsicWidth();
        int bitmapHeight2 = bitmap.getIntrinsicHeight();

        imageView2.setImageDrawable(bitmap);
        imageView2.getLayoutParams().width = bitmapWidth;
        imageView2.getLayoutParams().height = bitmapHeight;
    }
}