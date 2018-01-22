package com.example.android.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class NewsAdapter extends Adapter<NewsAdapter.ViewHolder>{
    private List<News> newses;
    private Context context;

    public NewsAdapter(Context context, List<News> newses) {
        this.context = context;
        this.newses = newses;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(context).inflate(
                        R.layout.news_layout, parent, false)
        );
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final News currentNews = newses.get(position);
        holder.titleTextView.setText(currentNews.getTitle());
        holder.sectionTextView.setText(currentNews.getSection());
        holder.authorTextView.setText(currentNews.getAuthor());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        DateFormat dfDisplay = new SimpleDateFormat("dd-MMM-yyyy \n HH:mm");
        Date startDate;

        try {
            startDate = df.parse(currentNews.getDate());
            String newDateString = dfDisplay.format(startDate);
            holder.dateTextView.setText(newDateString);
        } catch (ParseException e) {
            Log.e("DATE ISSUE", e.toString());
            holder.dateTextView.setVisibility(View.GONE);
        }
        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri newsUri = Uri.parse(currentNews.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);
                context.startActivity(websiteIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.newses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView sectionTextView;
        private TextView authorTextView;
        private TextView dateTextView;
        private View parentView;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.parentView = view;
            this.titleTextView = view.findViewById(R.id.title);
            this.sectionTextView = view.findViewById(R.id.section);
            this.authorTextView = view.findViewById(R.id.author);
            this.dateTextView = view.findViewById(R.id.date);

        }
    }
}




