package com.example.parkminhyun.mobileprogramming;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView dialogText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogText = (TextView)findViewById(R.id.textView);

        showToast("onCreate호출됨.");
        showMessage();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // 가로방향전환시처리
        if (newConfig.orientation== Configuration.ORIENTATION_LANDSCAPE) {
            showToast("방향: ORIENTATION_LANDSCAPE");
        }

        // 세로방향전환시처리
        else if (newConfig.orientation== Configuration.ORIENTATION_PORTRAIT) {
            showToast("방향: ORIENTATION_PORTRAIT");
        }
    }

    public void showToast(String data) {
        LayoutInflater inflater= getLayoutInflater();// 레이아웃인플레이터객체참조
        View layout = inflater.inflate(              // 토스트를위한레이아웃인플레이터
                R.layout.toastborder,
                (ViewGroup) findViewById(R.id.toast_layout_root));
        Toast toast= new Toast(this);// 토스트객체생성
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("모양바꾼토스트");
        toast.setGravity(Gravity.CENTER, 0, -100);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);// 토스트가보이는뷰설정
        toast.show();
    }

    private void showMessage() {
        // 대화상자를만들기위한빌더객체생성
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("안내");
        builder.setMessage("종료하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String message = "예버튼이눌렀습니다.";
                dialogText.setText(message);
            }
        });
        builder.setNeutralButton("취소",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String message = "취소버튼이눌렸습니다.";
                dialogText.setText(message);
            }
        });
        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String message = "아니오버튼이눌렸습니다.";
                dialogText.setText(message);
            }
        });
        AlertDialog dialog = builder.create();// 대화상자객체생성후보여주기
        dialog.show();
    }
}