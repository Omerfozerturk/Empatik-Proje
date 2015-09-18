package com.omer_staj;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SavedNews extends AppCompatActivity {

    WebView webView1,webView2,webView3,webView4,webView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_news);

        webView1 = (WebView) findViewById(R.id.webView1);
        webView2 = (WebView) findViewById(R.id.webView2);
        webView3 = (WebView) findViewById(R.id.webView3);
        webView4 = (WebView) findViewById(R.id.webView4);
        webView5 = (WebView) findViewById(R.id.webView5);

        if(!NewsDetails.urls.isEmpty()){
           for(int i = 0; i<NewsDetails.urls.size();i++) {
               switch (NewsDetails.urls.get(i)) {
                   case "http://www.saglikozel.com/":
                       webView1.getSettings().setJavaScriptEnabled(true);
                       webView1.setWebViewClient(new Callback());
                       webView1.loadUrl("http://www.saglikozel.com/");
                       webView1.setOnLongClickListener(new View.OnLongClickListener() {
                           @Override
                           public boolean onLongClick(View v) {
                               Intent i = new Intent(SavedNews.this, NewsDetails.class);
                               i.putExtra("url", "http://www.saglikozel.com/");
                               startActivity(i);
                               return true;
                           }
                       });
                       break;

                   case "http://www.doviz.com/":
                       webView2.getSettings().setJavaScriptEnabled(true);
                       webView2.setWebViewClient(new Callback());
                       webView2.loadUrl("http://www.saglikozel.com/");
                       webView2.setOnLongClickListener(new View.OnLongClickListener() {
                           @Override
                           public boolean onLongClick(View v) {
                               Intent i = new Intent(SavedNews.this, NewsDetails.class);
                               i.putExtra("url", "http://www.doviz.com/");
                               startActivity(i);
                               return true;
                           }
                       });
                       break;

                   case "http://www.teknoloji-haber.net":
                       webView3.getSettings().setJavaScriptEnabled(true);
                       webView3.setWebViewClient(new Callback());
                       webView3.loadUrl("http://www.saglikozel.com/");
                       webView3.setOnLongClickListener(new View.OnLongClickListener() {
                           @Override
                           public boolean onLongClick(View v) {
                               Intent i = new Intent(SavedNews.this, NewsDetails.class);
                               i.putExtra("url", "http://www.teknoloji-haber.net");
                               startActivity(i);
                               return true;
                           }
                       });
                       break;

                   case "http://sanatonline.net/":
                       webView4.getSettings().setJavaScriptEnabled(true);
                       webView4.setWebViewClient(new Callback());
                       webView4.loadUrl("http://www.saglikozel.com/");
                       webView4.setOnLongClickListener(new View.OnLongClickListener() {
                           @Override
                           public boolean onLongClick(View v) {
                               Intent i = new Intent(SavedNews.this, NewsDetails.class);
                               i.putExtra("url", "http://sanatonline.net/");
                               startActivity(i);
                               return true;
                           }
                       });
                       break;

                   case "http://www.guncelegitim.com/":
                       webView5.getSettings().setJavaScriptEnabled(true);
                       webView5.setWebViewClient(new Callback());
                       webView5.loadUrl("http://www.saglikozel.com/");
                       webView5.setOnLongClickListener(new View.OnLongClickListener() {
                           @Override
                           public boolean onLongClick(View v) {
                               Intent i = new Intent(SavedNews.this, NewsDetails.class);
                               i.putExtra("url", "http://www.guncelegitim.com/");
                               startActivity(i);
                               return true;
                           }
                       });
                       break;
               }
           }
        }
    }

    private class Callback extends WebViewClient {  //HERE IS THE MAIN CHANGE.

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return (false);
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
        switch (item.getItemId()) {
            case R.id.itemHome:
                Intent i = new Intent(SavedNews.this, MainActivity.class);
                startActivity(i);
                return true;

            case R.id.itemStar:
                Intent iStar = new Intent(SavedNews.this, SavedNews.class);
                startActivity(iStar);
                return true;

            case R.id.itemSave:
                Intent iSave = new Intent(SavedNews.this, SavedNews.class);
                startActivity(iSave);
                return true;

            case R.id.itemSearch:

                return true;

            case R.id.itemHelp:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Yardım menüsü yakın zamanda gelecektir.\nSabrınız için teşekkürler")
                        .setPositiveButton("Öyle Olsun", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                AlertDialog d = builder.create();
                d.show();
                return true;

            case R.id.itemAbout:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setMessage("Proje Ekibi: Ömer Faruk Özertürk\n" +
                        "Saliha Yeşilyurt")
                        .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                AlertDialog d2 = builder2.create();
                d2.show();
                return true;

            case R.id.action_settings:
                //openSettings();
                return true;

            case R.id.itemExit:
                System.exit(0);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
