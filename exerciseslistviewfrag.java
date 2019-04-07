package com.example.shiva.cureall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class exerciseslistviewfrag extends Fragment implements AdapterView.OnItemClickListener {


    ListView list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View v=inflater.inflate(R.layout.exercieslistview,container,false);
        list=v.findViewById(R.id.list);
     list.setOnItemClickListener(this);
       ArrayList<String> ques=new ArrayList<>();

                        ques.add("Pregnant and Breastfeeding Women");
                        ques.add("Babies and Young Children");
                        ques.add("Kids and Teens");
                        ques.add("Adults");
                        ques.add("Older Adults");

                    ArrayAdapter<String> a=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,ques);
                    list.setAdapter(a);

        return v;
}

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       Secondone.listposition=position;
        Log.d("bhanu",Secondone.listposition+"");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,new DailyMeal());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
