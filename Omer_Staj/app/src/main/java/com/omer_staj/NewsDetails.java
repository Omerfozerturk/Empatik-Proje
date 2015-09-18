package com.omer_staj;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class NewsDetails extends AppCompatActivity {

    WebView webView;
    ImageButton imgStar,imgSave,imgShare;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    Context context;
    String url1;
    public static ArrayList<String> urls = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        imgStar = (ImageButton) findViewById(R.id.imageButtonStar);
        imgSave = (ImageButton) findViewById(R.id.imageButtonSave);
        imgShare = (ImageButton) findViewById(R.id.imageButtonShare);
        webView = (WebView) findViewById(R.id.webViewDetails);

        url1 = getIntent().getStringExtra("url");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new Callback());
        webView.loadUrl(url1);

        imgStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(v.getContext(), "Haber favorilere alındı.", Toast.LENGTH_SHORT).show();
                    sharedPref = getSharedPreferences("pref", 0);
                    editor = sharedPref.edit();
                    editor.putString("url1",url1);
                    editor.commit();
                    urls.add(url1);
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
                    editor = sharedPref.edit();
                    editor.putString("url1", url1);
                    editor.commit();
                    urls.add(url1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Haber Paylaşıldı.", Toast.LENGTH_SHORT).show();
            }
        });
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
        getMenuInflater().inflate(R.menu.menu_news_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.itemHome:
                Intent i = new Intent(NewsDetails.this, MainActivity.class);
                startActivity(i);
                return true;

            case R.id.itemStar:
                Intent iStar = new Intent(NewsDetails.this, SavedNews.class);
                startActivity(iStar);
                return true;

            case R.id.itemSave:
                Intent iSave = new Intent(NewsDetails.this, SavedNews.class);
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
