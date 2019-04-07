package com.example.shiva.cureall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import static android.content.ContentValues.TAG;

public class profile_fragment extends Fragment {
    FirebaseUser firebaseUser;
    DatabaseReference reference;
    FirebaseAuth mAuth;
    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState){
        View v=inflater.inflate(R.layout.viewuserprofile,container,false);

        final TextView e=v.findViewById(R.id.email);
        final TextView user=v.findViewById(R.id.username);
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentFirebaseUser != null) {
            Log.d(TAG, "onComplete: currentUserUid---->" + currentFirebaseUser.getUid());
            Log.d(TAG, "onComplete: currentUserEmail---->" + currentFirebaseUser.getEmail());
            Log.d(TAG, "onComplete: currentUserDisplayName---->" + currentFirebaseUser.getDisplayName());
        } else {
            Log.d(TAG, "onComplete: currentUserUid is null");
        }

        if(currentFirebaseUser.getDisplayName()==null){

            user.setText("    WELCOME");
        }
        else{
            user.setText(currentFirebaseUser.getDisplayName());
        }
        e.setText(currentFirebaseUser.getEmail());




        return v;
    }

}
