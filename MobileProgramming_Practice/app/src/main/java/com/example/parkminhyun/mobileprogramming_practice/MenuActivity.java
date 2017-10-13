package com.example.parkminhyun.mobileprogramming_practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    TextView textView;
    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = (TextView) findViewById(R.id.textView);
        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 인텐트객체를만듭니다.
                Intent intent= new Intent();
                intent.putExtra("name", "mike");
                // 응답을전달하고이액티비티를종료합니다.
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        // 메인액티비티로부터전달받은인텐트를확인합니다.
        Intent intent= getIntent();
        processIntent(intent);
    }

    /**
     * 전달된인텐트처리
     */
    private void processIntent(Intent intent) {
        if (intent != null) {
            // 인텐트안의번들객체를참조합니다.
            Bundle bundle= intent.getExtras();
            // 번들객체안의SimpleData객체를참조합니다.
            SimpleData data = (SimpleData) bundle.getParcelable(KEY_SIMPLE_DATA);
            // 텍스트뷰에값을보여줍니다.
            textView.setText("전달받은데이터\nNumber: " + data.getNumber() + "\nMessage: " + data.getMessage());
        }
    }
}