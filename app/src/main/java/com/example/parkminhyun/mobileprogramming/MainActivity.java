package com.example.parkminhyun.mobileprogramming;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 1) XML로 정의된 메뉴정보를 인플레이션하여 메모리에로딩
        getMenuInflater().inflate(R.menu.menu_main, menu);
        // 2) 메뉴 아이템중에서 검색을 위해 정의한 아이템을 뷰 객체로 참조
        View v = menu.findItem(R.id.menu_search).getActionView();
        if (v != null) {
            // 3) 검색을 위한 메뉴아이템 안에 정의한 입력상자 객체참조
            editText = (EditText) v.findViewById(R.id.editText);
            if (editText != null) {
                // 4) 입력상자 객체에 리스너설정
                editText.setOnEditorActionListener(onSearchListener);
            }
        } else {
            Toast.makeText(getApplicationContext(), "ActionViewis null.", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    /**
     * 키입력이끝났을때검색합니다.
     */
    private TextView.OnEditorActionListener onSearchListener = new TextView.OnEditorActionListener() {
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (event == null || event.getAction() == KeyEvent.ACTION_UP) {
                // 검색메소드호출
                search();
                // 키패드닫기
                InputMethodManager inputManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
            return (true);
        }
    };

    private void search() {
        String searchString = editText.getEditableText().toString();
        Toast.makeText(this, "검색어: " + searchString, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId();
        switch (curId) {
            case R.id.menu_refresh:
                Toast.makeText(this, "새로고침메뉴가선택되었습니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_search:
                Toast.makeText(this, "검색메뉴가선택되었습니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_settings:
                Toast.makeText(this, "설정메뉴가선택되었습니다.", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}