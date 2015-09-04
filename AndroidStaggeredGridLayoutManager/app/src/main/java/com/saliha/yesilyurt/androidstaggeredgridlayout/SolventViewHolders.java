package com.saliha.yesilyurt.androidstaggeredgridlayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import inducesmile.com.androidstaggeredgridlayoutmanager.R;

public class SolventViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView categoryName;
    public ImageButton categoryPhoto;
    private Context context;
    SharedPreferences sharedPref;

    public SolventViewHolders(View itemView, Context context) {
        super(itemView);
        this.context = context;
        itemView.setOnClickListener(this);
        categoryName = (TextView) itemView.findViewById(R.id.category_name);
        categoryPhoto = (ImageButton) itemView.findViewById(R.id.category_photo);

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();
        sharedPref = context.getSharedPreferences("pref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("id", getPosition());
        editor.commit();
    }
}
