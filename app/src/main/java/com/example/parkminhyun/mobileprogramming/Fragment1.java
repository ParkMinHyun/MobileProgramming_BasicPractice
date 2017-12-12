package com.example.parkminhyun.mobileprogramming;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ParkMinHyun on 2017-12-11.
 */

public class Fragment1 extends Fragment implements View.OnClickListener{

    Button startButton, stopButton;
    TextView timeTextView;

    CountReceiver countReceiver;

    Intent serviceIntent;

    private static Fragment1 instance;

    public static Fragment1 getInstance(){
        if(instance == null)
            instance = new Fragment1();

        return instance;
    }

    @Override
    public void onStart() {
        countReceiver = new CountReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MyService.ACTION_UPDATE_CNT);
        getActivity().registerReceiver(countReceiver, intentFilter);
        super.onStart();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        timeTextView = (TextView)rootView.findViewById(R.id.timeTextView);
        startButton = (Button) rootView.findViewById(R.id.startButton);
        startButton.setOnClickListener(this);

        stopButton = (Button) rootView.findViewById(R.id.stopButton);
        stopButton.setOnClickListener(this);

        stopButton.setText(MainActivity.a.toString());
        return rootView;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.startButton:
                if(serviceIntent != null)
                    getActivity().stopService(serviceIntent);
                serviceIntent = new Intent(getActivity().getApplicationContext(), MyService.class);
                getActivity().startService(serviceIntent);
                break;
            case R.id.stopButton:
                if(serviceIntent != null)
                    getActivity().stopService(serviceIntent);
                serviceIntent = null;
                break;
        }
    }

    public void onMessageChange(String text) {
        Log.i("Text 확인", text);
        stopButton.setText(text);
    }

    private class CountReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(MyService.ACTION_UPDATE_CNT)){
                double double_from_service = intent.getDoubleExtra(MyService.KEY_INT_FROM_SERVICE, 0);
                timeTextView.setText(String.format("%.2f",double_from_service));
            }
        }
    }
}
