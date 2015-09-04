package com.saliha.yesilyurt.androidstaggeredgridlayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.Toast;

import inducesmile.com.androidstaggeredgridlayoutmanager.R;

public class NewsDetails extends ActionBarActivity {

    WebView webView;
    ImageButton imgStar,imgSave,imgShare;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        imgStar = (ImageButton) findViewById(R.id.imageButtonStar);
        imgSave = (ImageButton) findViewById(R.id.imageButtonSave);
        imgShare = (ImageButton) findViewById(R.id.imageButtonShare);
        webView = (WebView) findViewById(R.id.webViewDetails);

        final String url1 = getIntent().getStringExtra("url1");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url1);

        imgStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(v.getContext(), "Haber favorilere alındı.", Toast.LENGTH_SHORT).show();
                    sharedPref = getSharedPreferences("pref", 0);
                    editor.putString("url1", url1);
                    editor.commit();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        imgSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(v.getContext(), "Haber kaydedildi.", Toast.LENGTH_SHORT).show();
                    sharedPref = getSharedPreferences("pref", 0);
                    editor.putString("url1", url1);
                    editor.commit();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Haber Paylaşıldı.",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
