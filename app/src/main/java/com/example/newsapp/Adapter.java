package com.example.newsapp;


import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> modelClassesArrayList;

    public Adapter(Context context, ArrayList<ModelClass> modelClassesArrayList) {
        this.context = context;
        this.modelClassesArrayList = modelClassesArrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,webView.class);
                    intent.putExtra("url",modelClassesArrayList.get(holder.getAdapterPosition()).getUrl());
                    context.startActivity(intent);
                }
            });

            holder.mtime.setText("Published At:-" + modelClassesArrayList.get(holder.getAdapterPosition()).getPublishedAt());
            holder.mauthor.setText(modelClassesArrayList.get(holder.getAdapterPosition()).getAuthor());
            holder.mheading.setText(modelClassesArrayList.get(holder.getAdapterPosition()).getTitle());
            holder.mcontent.setText(modelClassesArrayList.get(holder.getAdapterPosition()).getDescription());

            Glide.with(context).load(modelClassesArrayList.get(holder.getAdapterPosition()).getUrlToImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return modelClassesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mheading,mcontent,mauthor,mtime;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mheading = itemView.findViewById(R.id.mainHeading);
            imageView= itemView.findViewById(R.id.imageview);
            cardView = itemView.findViewById(R.id.cardView);
            mauthor = itemView.findViewById(R.id.author);
            mcontent = itemView.findViewById(R.id.content);
            mtime = itemView.findViewById(R.id.time);

        }
    }
}
