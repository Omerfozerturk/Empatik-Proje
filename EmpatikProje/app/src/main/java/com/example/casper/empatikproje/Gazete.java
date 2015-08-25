package com.example.casper.empatikproje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;

public class Gazete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gazete);

        ArrayList<ImageView> images = new ArrayList<ImageView>();
        images.add((ImageView) findViewById(R.id.img1) );
        images.add((ImageView) findViewById(R.id.img2));
        images.add((ImageView) findViewById(R.id.img3) );
        images.add((ImageView) findViewById(R.id.img4) );

        ArrayList<String> kategoriList = new ArrayList<String>();

        Intent intent = getIntent();
        kategoriList = intent.getStringArrayListExtra("kategoriList");
        int i=0;
        for(String liste: kategoriList ){
            if(liste.contains("Teknoloji")) {images.get(i).setImageResource(R.drawable.tekno); i++; }
            if(liste.contains("Egitim")) {images.get(i).setImageResource(R.drawable.egitim); i++; }
            if(liste.contains("Ekonomi")) {images.get(i).setImageResource(R.drawable.ekonomi); i++; }
            if(liste.contains("Spor")) {images.get(i).setImageResource(R.drawable.spor); i++; }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.action_search:
                //openSearch();
                return true;
            case R.id.action_settings:
                //openSettings();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
