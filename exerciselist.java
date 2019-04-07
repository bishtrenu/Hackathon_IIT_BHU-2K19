package com.example.shiva.cureall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class exerciselist extends Fragment implements AdapterView.OnItemClickListener  {

    ListView list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.exerciselist,container,false);
        list=v.findViewById(R.id.list);
        list.setOnItemClickListener(this);
        Fruit f1,f2,f3,f4,f5;
        ArrayList<Fruit> arrayList;

        f1=new Fruit("Pregnant and Breastfeeding Women");
        f2=new Fruit("Babies and Young Children");
        f3=new Fruit("Kids and Teens");
        f4=new Fruit("Adults");
        f5=new Fruit("Older Adults");
        arrayList=new ArrayList<>();
        arrayList.add(f1);
        arrayList.add(f2);
        arrayList.add(f3);
        arrayList.add(f4);
        arrayList.add(f5);
        FruitAdapter ad=new FruitAdapter(getActivity(),arrayList);
        list.setAdapter(ad);

        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Secondone.listposition1=position;

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,new ExerciseVideo());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
