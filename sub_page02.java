package com.example.shiva.cureall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class sub_page02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_sub_page01);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Placing_Order_Rules_Frag()).commit();
    }
}

