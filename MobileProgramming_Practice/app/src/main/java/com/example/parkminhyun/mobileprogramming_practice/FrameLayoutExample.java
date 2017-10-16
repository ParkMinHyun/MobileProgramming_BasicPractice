package com.example.parkminhyun.mobileprogramming_practice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameLayoutExample extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;
    Button upBtn;
    Button downBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout_example);

        imageView1 = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        upBtn = (Button) findViewById(R.id.up);
        downBtn = (Button) findViewById(R.id.down);


        imageView1.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
    }

    public void onUpButtonClicked(View v) {
            imageView1.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
    }

    public void onDownButtonClicked(View v) {
            imageView2.setVisibility(View.VISIBLE);
            imageView1.setVisibility(View.INVISIBLE);
    }
}
