package com.koogawa.listsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.reim.android.filterrecyclerview.FilterRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SubActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String[] myDataset = new String[20];

    Toolbar toolbar;

    private FilterRecyclerView filterRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        filterRecyclerView = (FilterRecyclerView) findViewById(R.id.activity_main_filter_recycler_view);
        filterRecyclerView.setAdapter(new MainFilterRecyclerAdapter(this));

        List<ListItem> itemList = new ArrayList<>();
        itemList.add(new ListItem("Sam", "Dog"));
        itemList.add(new ListItem("Spot", "Cat"));
        itemList.add(new ListItem("Pip", "Cat"));
        itemList.add(new ListItem("Piper", "Dog"));

        filterRecyclerView.initializeItemList(itemList);

        /*
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

        for(int i=0; i<myDataset.length; i++) {
            myDataset[i] = "Data_0"+String.valueOf(i);
        }

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
        */
    }

    @Override
    public void onBackPressed() {
        if (filterRecyclerView.isOpened()) {
            filterRecyclerView.close();
            return;
        }
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_search:
                filterRecyclerView.open(true);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}

