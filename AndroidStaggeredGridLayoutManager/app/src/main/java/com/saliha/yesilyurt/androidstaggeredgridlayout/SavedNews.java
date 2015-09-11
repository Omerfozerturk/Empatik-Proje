package com.saliha.yesilyurt.androidstaggeredgridlayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import inducesmile.com.androidstaggeredgridlayoutmanager.R;

public class SavedNews extends ActionBarActivity {

    WebView webView1,webView2,webView3,webView4,webView5;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_news);

        webView1 = (WebView) findViewById(R.id.webView1);
        webView2 = (WebView) findViewById(R.id.webView2);
        webView3 = (WebView) findViewById(R.id.webView3);
        webView4 = (WebView) findViewById(R.id.webView4);
        webView5 = (WebView) findViewById(R.id.webView5);

       
        try {
            webView1.getSettings().setJavaScriptEnabled(true);
            sharedPref = getSharedPreferences("pref", 0);
            final String url1 = sharedPref.getString("url1",null);
            webView1.loadUrl(url1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_saved_news, menu);
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
