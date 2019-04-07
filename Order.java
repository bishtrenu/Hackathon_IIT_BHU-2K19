package com.example.shiva.cureall;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Order extends Fragment {
    ImageView imageView;
    EditText name,email,phoneno;
    Button upload,submit,button;
    TextView t;
    private static final int GALLARY=4;
    private static final int CAMERA=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.order, container, false);
        upload=v.findViewById(R.id.upload);
        submit=v.findViewById(R.id.submit);
        t=v.findViewById(R.id.textView8);

        imageView=v.findViewById(R.id.uploadimg);
        name=v.findViewById(R.id.name);
        email=v.findViewById(R.id.email);
        button=v.findViewById(R.id.button);
        phoneno=v.findViewById(R.id.phoneno);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,GALLARY);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent,CAMERA);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setText("You Order Has Taken... It will be delivered as soon as possible");
                t.setVisibility(View.VISIBLE);

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Fragment newFragment = new home();

                        FragmentTransaction transaction = getFragmentManager().beginTransaction();


                        transaction.replace(R.id.fragment_container, newFragment);
                        transaction.addToBackStack(null);


                        transaction.commit();


                    }
                }, 1500);



            }
        });


        return v;

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GALLARY) {
            Uri uri = data.getData();
            imageView.setImageURI(uri);
        }
        else if (requestCode==CAMERA)
        {
            Bitmap bitmap=(Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }

    }

}
