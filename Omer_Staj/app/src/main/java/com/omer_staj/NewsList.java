package com.omer_staj;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class NewsList extends AppCompatActivity {
    //http://www.saglikozel.com/
    //http://www.doviz.com/
    //http://www.teknoloji-haber.net/
    //http://sanatonline.net/
    //http://www.guncelegitim.com/
    public static ArrayList<WebView> webViewList = new ArrayList<WebView>();
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private Button buttonGeriGit;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    WebView webView1,webView2,webView3,webView4,webView5;
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5;
    Bundle bundle;
    ArrayList<KategoriObject> kategoriList;
    public WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        webView1 = (WebView) findViewById(R.id.webView1);
        webView2 = (WebView) findViewById(R.id.webView2);
        webView3 = (WebView) findViewById(R.id.webView3);
        webView4 = (WebView) findViewById(R.id.webView4);
        webView5 = (WebView) findViewById(R.id.webView5);

       /* imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);*/

      /*  RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view2);
        recyclerView.setHasFixedSize(true);

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,1);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);*/



        if(!MainActivity.addedListKategori.isEmpty()) {
            bundle = getIntent().getExtras();
            kategoriList = bundle.getParcelableArrayList("addedListKategori");
            for(int i = 0; i<kategoriList.size();i++) {
                switch (kategoriList.get(i).getName()) {
                    case "Yasam":
                        webView1.getSettings().setJavaScriptEnabled(true);
                        webView1.setWebViewClient(new Callback());
                        webView1.loadUrl("http://www.saglikozel.com/");
                        NewsList.webViewList.add(webView1);
                        webView1.setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                Intent i = new Intent(NewsList.this, NewsDetails.class);
                                i.putExtra("url","http://www.saglikozel.com/");
                                startActivity(i);
                                return true;
                            }
                        });
                        break;
                    case "Finans":
                        webView2.getSettings().setJavaScriptEnabled(true);
                        webView2.setWebViewClient(new Callback());
                        webView2.loadUrl("http://www.doviz.com/");
                        NewsList.webViewList.add(webView2);
                        webView2.setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                Intent i = new Intent(NewsList.this, NewsDetails.class);
                                i.putExtra("url","http://www.doviz.com/");
                                startActivity(i);
                                return true;
                            }
                        });
                        break;
                    case "Teknoloji":
                        webView3.getSettings().setJavaScriptEnabled(true);
                        webView3.setWebViewClient(new Callback());
                        webView3.loadUrl("http://www.teknoloji-haber.net");
                        NewsList.webViewList.add(webView3);
                        webView3.setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                Intent i = new Intent(NewsList.this, NewsDetails.class);
                                i.putExtra("url","http://www.teknoloji-haber.net");
                                startActivity(i);
                                return true;
                            }
                        });
                        break;
                    case "Kültür-Sanat":
                        webView4.getSettings().setJavaScriptEnabled(true);
                        webView4.setWebViewClient(new Callback());
                        webView4.loadUrl("http://sanatonline.net/");
                        NewsList.webViewList.add(webView4);
                        webView4.setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                Intent i = new Intent(NewsList.this, NewsDetails.class);
                                i.putExtra("url","http://sanatonline.net/");
                                startActivity(i);
                                return true;
                            }
                        });
                        break;
                    case "Eğitim":
                        webView5.getSettings().setJavaScriptEnabled(true);
                        webView5.setWebViewClient(new Callback());
                        webView5.loadUrl("http://www.guncelegitim.com/");
                        NewsList.webViewList.add(webView5);
                        webView5.setOnLongClickListener(new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                Intent i = new Intent(NewsList.this, NewsDetails.class);
                                i.putExtra("url","http://www.guncelegitim.com/");
                                startActivity(i);
                                return true;
                            }
                        });
                        break;
                }
            }
        }

        /*NewsAdapter newsAdapter = new NewsAdapter(NewsList.this, NewsList.webViewList);
        recyclerView.setAdapter(newsAdapter);*/


        buttonGeriGit = (Button) findViewById(R.id.buttonGeriGit);
        buttonGeriGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NewsList.this, MainActivity.class);
                startActivity(i);
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
                Intent iStar = new Intent(NewsList.this, SavedNews.class);
                startActivity(iStar);
                return true;

            case R.id.itemSave:
                Intent iSave = new Intent(NewsList.this, SavedNews.class);
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
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setMessage("Ayarlar menüsü yakın zamanda gelecektir.\nSabrınız için teşekkürler")
                        .setPositiveButton("Öyle Olsun", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                return true;

            case R.id.itemExit:
                System.exit(0);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
