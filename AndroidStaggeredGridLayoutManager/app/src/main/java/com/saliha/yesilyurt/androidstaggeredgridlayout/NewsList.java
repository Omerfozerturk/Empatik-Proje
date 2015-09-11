package com.saliha.yesilyurt.androidstaggeredgridlayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import inducesmile.com.androidstaggeredgridlayoutmanager.R;

public class NewsList extends ActionBarActivity {
    WebView webView1,webView2,webView3,webView4,webView5;
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        try {
            webView1 = (WebView) findViewById(R.id.webView1);
            webView2 = (WebView) findViewById(R.id.webView2);
            webView3 = (WebView) findViewById(R.id.webView3);
            webView4 = (WebView) findViewById(R.id.webView4);
            webView5 = (WebView) findViewById(R.id.webView5);

            imageView1 = (ImageView) findViewById(R.id.imageView1);
            imageView2 = (ImageView) findViewById(R.id.imageView2);
            imageView3 = (ImageView) findViewById(R.id.imageView3);
            imageView4 = (ImageView) findViewById(R.id.imageView4);
            imageView5 = (ImageView) findViewById(R.id.imageView5);

            sharedPref = getSharedPreferences("pref",0);

            webView1.getSettings().setJavaScriptEnabled(true);
            final String url1 = "https://gelecegiyazanlar.turkcell.com.tr/";
            webView1.loadUrl(url1);
            webView1.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Intent i = new Intent(NewsList.this, NewsDetails.class);
                    i.putExtra("url1", url1);
                    startActivity(i);
                    return true;
                }
            });

            webView2.getSettings().setJavaScriptEnabled(true);
            final String url2 = "https://gelecegiyazanlar.turkcell.com.tr/";
            webView2.loadUrl(url2);
            webView2.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Intent i = new Intent(NewsList.this, NewsDetails.class);
                    i.putExtra("url2", url2);
                    startActivity(i);
                    return true;
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.itemHome:
                Intent i = new Intent(NewsList.this, MainActivity.class);
                startActivity(i);
                return true;

            case R.id.itemStar:
                //
                return true;

            case R.id.itemSave:
                Intent iSave = new Intent(NewsList.this,SavedNews.class);
                startActivity(iSave);
                return true;

            case R.id.itemSearch:
                //openSearch();
                return true;

            case R.id.itemHelp:
                //
                return true;

            case R.id.itemAbout:
                //
                return true;

            case R.id.action_settings:
                //openSettings();
                return true;

            case R.id.itemExit:
                finish();
                System.exit(0);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
