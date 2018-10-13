package com.gosoft.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gosoft.entity.Movie;
import com.gosoft.teaplus.R;
import com.gosoft.unity.MyViewHolder;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<MyViewHolder>{
    private Context context;
    private List<Movie> movieList;


    public StoreAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }


    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_item_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Movie movie = movieList.get(position);
        holder.name.setText(movie.getTitle());
        holder.price.setText(movie.getPrice());

        Glide.with(context)
                .load(movie.getImage())
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, "You clicked on : " + movie.getTitle() + "with price : " + movie.getPrice(), duration);
                toast.show();
        }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
