package com.example.parkminhyun.mobileprogramming_practice;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Toast_Snackbar_ExampleActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast__snackbar_example);
        editText= (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
    }
    public void onButton1Clicked(View v) {
        try {
            Toast toastView= Toast.makeText(this,
                    "위치가바뀐토스트메시지입니다.",
                    Toast.LENGTH_LONG);
            int xOffset= Integer.parseInt(editText.getText().toString());
            int yOffset= Integer.parseInt(editText2.getText().toString());
            toastView.setGravity(Gravity.TOP|Gravity.LEFT, xOffset, yOffset);
            toastView.show();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    public void onButton2Clicked(View v) {
        LayoutInflater inflater= getLayoutInflater();// 레이아웃인플레이터객체참조
        View layout = inflater.inflate(// 토스트를위한레이아웃인플레이터
                R.layout.toastborder,
                (ViewGroup) findViewById(R.id.toast_layout_root));
        TextView text = (TextView) layout.findViewById(R.id.text);
        Toast toast= new Toast(this);// 토스트객체생성
        text.setText("모양바꾼토스트");
        toast.setGravity(Gravity.CENTER, 0, -100);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);// 토스트가보이는뷰설정
        toast.show();
    }
    public void onButton3Clicked(View v) {
        Snackbar.make(v, "스낵바입니다.", Snackbar.LENGTH_LONG).show();
    }
}