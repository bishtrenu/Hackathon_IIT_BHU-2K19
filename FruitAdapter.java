package com.example.shiva.cureall;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends BaseAdapter
{
    private List<Fruit> fruitlist;
   private LayoutInflater inflater=null;
   Context context=null;
   public FruitAdapter(Activity activity, List<Fruit> fruitlist)
   {context=activity.getApplicationContext();
   this.fruitlist=fruitlist;
   inflater=LayoutInflater.from(activity);

   }

    @Override
    public int getCount() {
        return fruitlist.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.custom,parent,false);

        }
        TextView tv=convertView.findViewById(R.id.txtname);
        ImageView im=convertView.findViewById(R.id.img);
        Fruit f=fruitlist.get(position);
        tv.setText(f.getName());

        return convertView;
    }
}
