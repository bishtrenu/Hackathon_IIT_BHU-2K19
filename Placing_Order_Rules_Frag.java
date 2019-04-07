package com.example.shiva.cureall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Placing_Order_Rules_Frag extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.placing_order_rules, container, false);
        Button start=v.findViewById(R.id.button2);
        TextView textView=v.findViewById(R.id.textView2);
        String str="Process:\n" +
                "\n" +
                "•\tClick on start button for placing order.\n" +
                "\n" +
                "•\tThere enter your name, email, phone Number.\n" +
                "\n" +
                "•\tUpload image of list of medicines recommended by your" +
                "Doctors By\n clicking “Upload Button”.\n" +
                "\n" +
                "•\tClick on “Order” button ,your order will be placed.\n" +
                "\n" +
                "•\tSit back and relax. Our partner delivery boy will deliver" +
                "Your healthcare product right \nat your door steps in 24 hours." +
                "\n" +
                "•\tCash on delivery.\n" +
                "\n" +
                "•\tContact this number  “7408139092” for tracing your order.\n" ;
        textView.setText(str);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,new Order());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return v;
    }
}
