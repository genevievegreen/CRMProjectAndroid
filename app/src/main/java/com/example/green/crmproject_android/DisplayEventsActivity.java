package com.example.green.crmproject_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import Adapters.RecyclerViewAdapter_DisplayEvents;
import Adapters.RecyclerViewAdapter_DisplayWeek;
import features.model.CurrentWeek;
import features.model.Day;

public class DisplayEventsActivity extends AppCompatActivity implements RecyclerViewAdapter_DisplayEvents.ItemClickListener {

    RecyclerViewAdapter_DisplayEvents adapter;
    private final String TAG = "TAG";
    public static final String EXTRA_MESSAGE = "com.example.green.crmproject_android.CURRENTWEEK";
    List<String> allEvents;
    String[] events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_events);

        Intent intent = getIntent();
        events = intent.getStringArrayExtra(EXTRA_MESSAGE);

        for (String s: events) {
            allEvents.add(s);
        }


        RecyclerView recyclerView = findViewById(R.id.rvDisplayWeek);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter_DisplayEvents(this, allEvents);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(View view, int position) {
        //
    }
}
