package com.omer_staj;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Casper on 13.9.2015.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsHolder> {
    private ArrayList<WebView> webList;
    private Context context;

    public NewsAdapter(Context context, ArrayList<WebView> webList){
        this.context = context;
        this.webList = webList;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.solvent_newslist, null);
        NewsHolder holder = new NewsHolder(layoutView,context);
        return holder;
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
//        holder.newsPhoto.setImageResource(webList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
