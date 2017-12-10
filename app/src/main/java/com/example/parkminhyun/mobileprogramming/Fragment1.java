package com.example.parkminhyun.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ParkMinHyun on 2017-12-11.
 */

public class Fragment1 extends Fragment implements View.OnClickListener {

    Button f1button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        f1button = (Button) rootView.findViewById(R.id.f1button);
        f1button.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getActivity().getApplicationContext(), MyService.class);
        intent.putExtra("command", "show");
        intent.putExtra("name", "ParkMinHyun");
        getActivity().startService(intent);
    }
}
