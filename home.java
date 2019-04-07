package com.example.shiva.cureall;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class home extends Fragment {
    Button a,b,c,d,e,f;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);

            a = v.findViewById(R.id.a);
            b = v.findViewById(R.id.b);
            c = v.findViewById(R.id.c);
            d = v.findViewById(R.id.d);
            e = v.findViewById(R.id.e);
            f = v.findViewById(R.id.f);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new exerciseslistviewfrag();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();


                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);


                transaction.commit();
            }});
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new exerciselist();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();


                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);


                transaction.commit();
            }});
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new symptoms();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();


                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);


                transaction.commit();
            }});











        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment newFragment = new Placing_Order_Rules_Frag();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();


                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);


                transaction.commit();
            }});

        return v;

    }
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }



}

