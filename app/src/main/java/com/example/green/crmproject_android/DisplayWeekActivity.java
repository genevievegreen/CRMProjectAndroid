package com.example.green.crmproject_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import Adapters.RecyclerViewAdapter_DisplayWeek;
import features.model.CurrentWeek;
import features.model.Day;

public class DisplayWeekActivity extends AppCompatActivity implements RecyclerViewAdapter_DisplayWeek.ItemClickListener {

    RecyclerViewAdapter_DisplayWeek adapter;

    public static CurrentWeek currentWeek;

    private final String TAG = "TAG";
    public static final String EXTRA_MESSAGE = "com.example.green.crmproject_android.CURRENTWEEK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_week);

        Intent intent = getIntent();
        //currentWeek = (CurrentWeek) intent.getParcelableExtra(EXTRA_MESSAGE);
        //****WE'RE IN CALENDAR BRANCH 2
        currentWeek = new CurrentWeek();
        for (Day d : currentWeek.getCurrentWeek()) {
            Log.d(TAG, d.getDaysDate());
        }

        Log.d(TAG, "In DisplayWeekActivity");

        RecyclerView recyclerView = findViewById(R.id.rvDisplayWeek);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter_DisplayWeek(this, currentWeek);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        // FILL IN
    }
}
