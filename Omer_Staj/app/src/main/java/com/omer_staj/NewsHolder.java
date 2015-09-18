package com.omer_staj;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Casper on 13.9.2015.
 */
public class NewsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public ImageView newsPhoto;
    public WebView webView;
    private Context context;
    SharedPreferences sharedPref;

    public NewsHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        itemView.setOnClickListener(this);
//        newsPhoto = (ImageView) itemView.findViewById(R.id.news_photo);
        webView = (WebView) itemView.findViewById(R.id.webView);
    }

    @Override
    public void onClick(View view) {
       /* switch (getPosition()){
            case 0:
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://www.saglikozel.com/");
                NewsList.webViewList.add(webView);
                break;
            case 1:
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl( "http://www.doviz.com/");
                NewsList.webViewList.add(webView);
                break;
            case 2:
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://www.teknoloji-haber.net");
                NewsList.webViewList.add(webView);
                break;
            case 3:
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://sanatonline.net/");
                NewsList.webViewList.add(webView);
                break;
            case 4:
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://www.guncelegitim.com/");
                NewsList.webViewList.add(webView);
                break;
        }*/
    }
}
