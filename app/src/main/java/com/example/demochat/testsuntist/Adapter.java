package com.example.demochat.testsuntist;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 1/23/2018.
 */

public class Adapter    extends  RecyclerView.Adapter<Adapter.ViewHolder>{

    private List<Model> mEntries;
    private Context mContext;
    Typeface typeface;


    public class ViewHolder extends RecyclerView.ViewHolder {

      public   TextView user_sex,user_age,user_name;



        public ViewHolder(View itemView) {
            super(itemView);
            user_name=(TextView)itemView.findViewById(R.id.user_name);
            user_age=(TextView)itemView.findViewById(R.id.user_age);
            user_sex=(TextView)itemView.findViewById(R.id.user_sex);

        }
    }



    public Adapter(Context context, List<Model> items) {

        mEntries = items;
        mContext = context;
    }

    public Context getmContext() {
        return mContext;
    }



    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.child, parent, false);
        Adapter.ViewHolder vh = new Adapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Model p=mEntries.get(position);

        if(p!=null) {
            holder.user_name.setText(p.getName());
            holder.user_age.setText(p.getAge());
            holder.user_sex.setText(p.getSex());
        }
          }



    @Override
    public int getItemCount() {
        return mEntries.size();
    }

}

