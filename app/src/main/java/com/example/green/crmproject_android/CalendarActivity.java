package com.example.green.crmproject_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;

import features.model.CurrentWeek;
import features.model.Event;

public class CalendarActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.green.crmproject_android.MESSAGE";

    public static CurrentWeek currentWeek;
    private final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // Buttons for this screen.
        Button bDisplayWeek = findViewById(R.id.buttonDisplayWeek);
        Button bDisplayEvents = findViewById(R.id.buttonDisplayEvents);
        Button bAddEvent = findViewById(R.id.buttonAddEvent);

        //Set up new week
        currentWeek = new CurrentWeek();
        //set up some events. NOTE: NEED TO MODIFY EVENT RELATED CODE TO MAKE LESS CONVOLUTED!!!
        Calendar c = currentWeek.getDayInWeek(0).getDay();
        currentWeek.getDayInWeek(0).getDaysEvents().addEvent(new Event("Birthday", c, false));
        c.add(Calendar.DAY_OF_MONTH, 2);
        currentWeek.getDayInWeek(2).getDaysEvents().addEvent(new Event("Cable bill due!", c, false));



        // What the buttons do.
        bDisplayWeek.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarActivity.this, DisplayWeekActivity.class);
                intent.putExtra(EXTRA_MESSAGE, currentWeek);
                startActivity(intent);
            }
        });

        bDisplayEvents.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarActivity.this, DisplayEventsActivity.class);
                //intent.putExtra();
                startActivity(intent);
            }
        });

        bAddEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarActivity.this, AddEventActivity.class);
                //intent.putExtra();
                startActivity(intent);
            }
        });
    }

}
