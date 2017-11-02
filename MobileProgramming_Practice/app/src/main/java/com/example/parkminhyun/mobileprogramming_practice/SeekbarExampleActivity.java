package com.example.parkminhyun.mobileprogramming_practice;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekbarExampleActivity extends AppCompatActivity {
    ProgressDialog dialog;
    private SeekBar seekBar;// 시크바객체
    private int brightness = 50;// 기본밝기값
    TextView seekBarText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar_example);
        seekBarText= (TextView) findViewById(R.id.seekBarText);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout seekBarPanel= (LinearLayout) findViewById(R.id.seekBarPanel);
                seekBarPanel.setVisibility(View.VISIBLE);// 시크바보이기
            }
        });
        SeekBar
                seekBar= (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override // 시크바값을변경했을때처리할리스너설정
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                setBrightness(i);
                seekBarText.setText("시크바의값: " + i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
    private void setBrightness(int value) {
        if (value < 10) {
            value = 10;
        } else if (value > 100) {
            value = 100;
        }
        brightness = value;
// 화면밝기변경
        WindowManager.LayoutParams params= getWindow().getAttributes();
        params.screenBrightness= (float) value / 100;
        getWindow().setAttributes(params);
    }
}