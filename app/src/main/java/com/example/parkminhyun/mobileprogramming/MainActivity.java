package com.example.parkminhyun.mobileprogramming;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ChangeMessageCallback {
    Toolbar toolbar;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    List<Fragment> fragments = new ArrayList<>();
    int index = 0;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        fragment1 = Fragment1.getInstance();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("통화기록"));
        tabs.addTab(tabs.newTab().setText("스팸기록"));
        tabs.addTab(tabs.newTab().setText("연락처"));
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("MainActivity", "선택된탭: " + position);
                Fragment selected = null;
                if (position == 0) {
                    selected = fragment1;
                } else if (position == 1) {
                    selected = fragment2;
                } else if (position == 2) {
                    selected = fragment3;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        View v = menu.findItem(R.id.menu_search).getActionView();
        if (v != null) {
            // 3) 검색을 위한 메뉴 아이템 안에 정의한 입력상자 객체 참조
            editText = (EditText) v.findViewById(R.id.editText);
            if (editText != null) {
                // 4) 입력상자 객체에 리스너설정
                editText.setOnEditorActionListener(onSearchListener);
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curID = item.getItemId();
        Fragment selected = null;
        switch (curID) {
            case R.id.menu_refresh:
                if (index != 0) {
                    selected = fragments.get(--index);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
                }
                break;
            case R.id.menu_settings:
                if (index != 2) {
                    selected = fragments.get(++index);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
                }
                break;
            default:
                break;
        }
        return true;
    }

    private TextView.OnEditorActionListener onSearchListener = new TextView.OnEditorActionListener() {

        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (event == null || event.getAction() == KeyEvent.ACTION_UP) {
                // 검색 메소드 호출
                search();
                // 키패드 닫기
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
    public void onMessageChange() {
        Button button = (Button)findViewById(R.id.showButton);
        button.setText(editText.getText());
    }
}