package com.example.casper.empatikproje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class Kategori extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);

        final ArrayList<String> kategoriList = new ArrayList<String>();

        final ImageButton imgTeknoloji = (ImageButton) findViewById(R.id.imageButtonTeknoloji);
        final ImageButton imgEgitim = (ImageButton) findViewById(R.id.imageButtonEgitim);
        final ImageButton imgEkonomi = (ImageButton) findViewById(R.id.imageButtonEkonomi);
        final ImageButton imgSpor = (ImageButton) findViewById(R.id.imageButtonSpor);

        imgTeknoloji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kategoriList.add("Teknoloji");
            }
        });

        imgEgitim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kategoriList.add("Egitim");
            }
        });

        imgEkonomi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kategoriList.add("Ekonomi");
            }
        });

        imgSpor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kategoriList.add("Spor");
            }
        });


        final Button button1 = (Button) findViewById(R.id.btnGit);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kategori.this ,Gazete.class);
                intent.putStringArrayListExtra("kategoriList", kategoriList);
                startActivity(intent);
            }
        });
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
