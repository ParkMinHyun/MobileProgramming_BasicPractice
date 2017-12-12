package com.example.parkminhyun.mobileprogramming;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ParkMinHyun on 2017-12-11.
 */

public class Fragment3 extends Fragment {


    Button showButton;
    public static interface changeMessageCallback {
        public void onMessageChange();

    }

    public changeMessageCallback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof changeMessageCallback){
            callback = (changeMessageCallback) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView= (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);

        showButton = (Button)rootView.findViewById(R.id.showButton);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onMessageChange();
                }
            }
        });
        return rootView;
    }
}