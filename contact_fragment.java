package com.example.shiva.cureall;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class contact_fragment extends Fragment {
    Button call;
    public final static int REQUESTCODE = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.contact_us, container, false);
        Button b = v.findViewById(R.id.btnOK);
        call = v.findViewById(R.id.call);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v1) {
                String to = "shivang2470@gmail.com";
                String sub = ((EditText) v.findViewById(R.id.txtSubject)).getText().toString();
                String mess = ((EditText) v.findViewById(R.id.txtMessage)).getText().toString();
                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{to});
                mail.putExtra(Intent.EXTRA_SUBJECT, sub);
                mail.putExtra(Intent.EXTRA_TEXT, mess);
                mail.setType("text/plain");
                startActivity(Intent.createChooser(mail, "Send email via:"));
                //startActivity(mail);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
        return v;
    }

    private void makePhoneCall() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUESTCODE);

        } else {
            String dial = "tel:" + "6391652112";
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUESTCODE) {
            makePhoneCall();
        }



    }
}




