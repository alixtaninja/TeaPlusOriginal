package com.gosoft.unity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gosoft.teaplus.R;

public class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView name, price;
    public ImageView thumbnail;

    public MyViewHolder(View view) {
        super(view);
        name = view.findViewById(R.id.title);
        price = view.findViewById(R.id.price);
        thumbnail = view.findViewById(R.id.thumbnail);
    }
}
