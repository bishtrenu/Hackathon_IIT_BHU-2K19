package com.example.shiva.cureall;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ratting extends Fragment {
    RatingBar ratingBar;
    TextView textView;
    Button button;
    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.ratting_fragment, container, false);
        ratingBar = v.findViewById(R.id.ratingBar);
        ratingBar.getSolidColor();
        textView = v.findViewById(R.id.textView2);
        button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float ratingvalue = ratingBar.getRating();
                if (ratingvalue < 2) {
                    ratingBar.bringToFront();

                    textView.setText("Rating: " + ratingvalue + "\n will try better next time");
                }
                if (ratingvalue <= 3 && ratingvalue >= 2) {
                    ratingBar.bringToFront();
                    textView.setText("Rating: " + ratingvalue + "\n we are constantly working on it");
                }
                if (ratingvalue <= 4 && ratingvalue >= 3) {
                    ratingBar.bringToFront();
                    textView.setText("Rating: " + ratingvalue + "\n we have worked on it");
                }
                if (ratingvalue >= 4) {
                    ratingBar.bringToFront();
                    textView.setText("Rating: " + ratingvalue + "\n thank you!!!!");
                }
            }
        });
        return v;
    }
    }




