package com.saliha.yesilyurt.androidstaggeredgridlayout;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import inducesmile.com.androidstaggeredgridlayoutmanager.R;

public class SolventViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView categoryName;
    public ImageView categoryPhoto;

    public SolventViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        categoryName = (TextView) itemView.findViewById(R.id.category_name);
        categoryPhoto = (ImageView) itemView.findViewById(R.id.category_photo);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}
