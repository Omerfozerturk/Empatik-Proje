package com.saliha.yesilyurt.androidstaggeredgridlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import inducesmile.com.androidstaggeredgridlayoutmanager.R;


public class MainActivity extends AppCompatActivity {

    private StaggeredGridLayoutManager gaggeredGridLayoutManager;

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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
