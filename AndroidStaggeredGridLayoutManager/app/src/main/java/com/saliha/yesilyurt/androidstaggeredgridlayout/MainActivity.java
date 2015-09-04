package com.saliha.yesilyurt.androidstaggeredgridlayout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import inducesmile.com.androidstaggeredgridlayoutmanager.R;


public class MainActivity extends AppCompatActivity {

    private StaggeredGridLayoutManager gaggeredGridLayoutManager;
    private Button buttonGazeteSec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
        recyclerView.setLayoutManager(gaggeredGridLayoutManager);

        List<ItemObjects> gaggeredList = getListItemData();

        SolventRecyclerViewAdapter rcAdapter = new SolventRecyclerViewAdapter(MainActivity.this, gaggeredList);
        recyclerView.setAdapter(rcAdapter);

        buttonGazeteSec = (Button) findViewById(R.id.buttonHaberSec);
        buttonGazeteSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NewsList.class);
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.itemHome:
                Intent i = new Intent(MainActivity.this, MainActivity.class);
                startActivity(i);
                return true;

            case R.id.itemStar:
                Intent iStar = new Intent(MainActivity.this,SavedNews.class);
                startActivity(iStar);
                return true;

            case R.id.itemSave:
                Intent iSave = new Intent(MainActivity.this,SavedNews.class);
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
                builder2.setMessage("Proje Ekibi:\n Yılmaz Alagöz \n Ömer Faruk Özertürk\n" +
                        "Saliha Yeşilyurt\n Habib Salik\n Habibe Yorulmaz")
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

    private List<ItemObjects> getListItemData(){
        List<ItemObjects> listViewItems = new ArrayList<ItemObjects>();
        listViewItems.add(new ItemObjects("Yasam", R.drawable.one));
        listViewItems.add(new ItemObjects("Finans", R.drawable.two));
        listViewItems.add(new ItemObjects("Teknoloji", R.drawable.three));
        listViewItems.add(new ItemObjects("Kültür-Sanat", R.drawable.four));
        listViewItems.add(new ItemObjects("Eğtim", R.drawable.five));
        listViewItems.add(new ItemObjects("Yasam", R.drawable.one));
        listViewItems.add(new ItemObjects("Finans", R.drawable.two));
        listViewItems.add(new ItemObjects("Teknoloji", R.drawable.three));
        listViewItems.add(new ItemObjects("Kültür-Sanat", R.drawable.four));
        listViewItems.add(new ItemObjects("Eğtim", R.drawable.five));
        listViewItems.add(new ItemObjects("Yasam", R.drawable.one));
        listViewItems.add(new ItemObjects("Finans", R.drawable.two));
        listViewItems.add(new ItemObjects("Teknoloji", R.drawable.three));
        listViewItems.add(new ItemObjects("Kültür-Sanat", R.drawable.four));
        listViewItems.add(new ItemObjects("Eğtim", R.drawable.five));
        listViewItems.add(new ItemObjects("Yasam", R.drawable.one));
        listViewItems.add(new ItemObjects("Finans", R.drawable.two));
        listViewItems.add(new ItemObjects("Teknoloji", R.drawable.three));
        listViewItems.add(new ItemObjects("Kültür-Sanat", R.drawable.four));
        listViewItems.add(new ItemObjects("Eğtim", R.drawable.five));


        return listViewItems;
    }
}
