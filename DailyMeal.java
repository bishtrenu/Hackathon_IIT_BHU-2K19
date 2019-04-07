package com.example.shiva.cureall;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class DailyMeal extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.dailymeal,container,false);
        TextView textView=v.findViewById(R.id.justtitle);
        TextView textView1=v.findViewById(R.id.diet);
        int i=Secondone.listposition;
        switch( i)
        {
            case 0:
                textView.setText("Healthy eating when pregnant and breastfeeding");
                textView1.setText(new bean().getOne());break;
            case 1:
                textView.setText("Healthy eating for babies and young children");
                textView1.setText(new bean().getTwo());break;
            case 2:
                textView.setText("Healthy eating for kids and teens");
                textView1.setText(new bean().getThree());break;
            case 3:
                textView.setText("Healthy eating for adults");
                textView1.setText(new bean().getFour());break;
            case 4:
                textView.setText("Healthy eating for older adults");
                textView1.setText(new bean().getFive());break;


        }
        return v;
    }

}
