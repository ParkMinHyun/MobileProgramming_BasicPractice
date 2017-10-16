package com.example.parkminhyun.mobileprogramming_practice;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LayoutExample extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;
    Button upBtn;
    Button downBtn;
    BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_example);

        imageView1 = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        upBtn = (Button) findViewById(R.id.up);
        downBtn = (Button) findViewById(R.id.down);


    }

    public void onUpButtonClicked(View v) {
//        imageView1.setVisibility(View.VISIBLE);
//        imageView2.setVisibility(View.INVISIBLE);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.sample0);
        int bitmapWidth= bitmap.getIntrinsicWidth();
        int bitmapHeight= bitmap.getIntrinsicHeight();
        imageView1.setImageDrawable(bitmap);
        imageView1.getLayoutParams().width = bitmapWidth;
        imageView1.getLayoutParams().height = bitmapHeight;
    }

    public void onDownButtonClicked(View v) {
//        imageView2.setVisibility(View.VISIBLE);
//        imageView1.setVisibility(View.INVISIBLE);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.sample1);
        int bitmapWidth= bitmap.getIntrinsicWidth();
        int bitmapHeight= bitmap.getIntrinsicHeight();
        imageView1.setImageDrawable(bitmap);
        imageView1.getLayoutParams().width = bitmapWidth;
        imageView1.getLayoutParams().height = bitmapHeight;
    }
}
