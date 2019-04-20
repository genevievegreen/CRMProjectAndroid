package com.example.green.crmproject_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Adapters.RecyclerViewAdapter_DisplayWeek;
import features.model.CurrentWeek;
import features.model.Day;
import features.model.Event;

//*************************************

public class CalendarActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.green.crmproject_android.CURRENTWEEK";

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
        currentWeek.getDayInWeek(2).getDaysEvents().addEvent(new Event("Visit Grandma", c, false));
        c.add(Calendar.DAY_OF_MONTH, 1);
        currentWeek.getDayInWeek(3).getDaysEvents().addEvent(new Event("BBQ Contest", c, false));
        c.add(Calendar.DAY_OF_MONTH, 2);
        currentWeek.getDayInWeek(5).getDaysEvents().addEvent(new Event("Dentist appt.", c, false));



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


/*
//********TRYING TO PUT EVERYTHING IN ONE ACTIVITY!!!!
public class CalendarActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RecyclerViewAdapter_DisplayWeek.ItemClickListener {

    public static final String EXTRA_MESSAGE = "com.example.green.crmproject_android.CURRENTWEEK";

    public static CurrentWeek currentWeek;
    private final String TAG = "TAG";

    RecyclerViewAdapter_DisplayWeek adapter;

    Spinner spinner0; //spinner1, spinner2, spinner3, spinner4, spinner5, spinner6;
    //String[] events0, events1, events2, events3, events4, events5, events6;
    ArrayAdapter adapt0; //adapt1, adapt2, adapt3, adapt4, adapt5, adapt6;
    List<String> allEvents;
    String[] eventStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // Buttons for this screen.
       // Button bAddEvent = findViewById(R.id.buttonAddEvent);

        //Set up new week
        currentWeek = new CurrentWeek();
        //set up some events. NOTE: CODE IS VERY CONVOLUTED!
        Calendar c = currentWeek.getDayInWeek(0).getDay();
        currentWeek.getDayInWeek(0).getDaysEvents().addEvent(new Event("Birthday", c, false));
        c.add(Calendar.DAY_OF_MONTH, 2);
        currentWeek.getDayInWeek(2).getDaysEvents().addEvent(new Event("Cable bill due!", c, false));
        currentWeek.getDayInWeek(2).getDaysEvents().addEvent(new Event("Visit Grandma", c, false));
        c.add(Calendar.DAY_OF_MONTH, 1);
        currentWeek.getDayInWeek(3).getDaysEvents().addEvent(new Event("BBQ Contest", c, false));
        c.add(Calendar.DAY_OF_MONTH, 2);
        currentWeek.getDayInWeek(5).getDaysEvents().addEvent(new Event("Dentist appt.", c, false));

        // set up strings
        allEvents = new ArrayList<>();
        for (Day d : currentWeek.getCurrentWeek()) {
            for (Event e : d.getDaysEvents().getEventList()) {
                String s = d.getDaysDate() + ": " + e.getEventName();
                allEvents.add(s);
            }
        }
        int size = allEvents.size();
        eventStrings = new String[size];
        for (int i = 0; i < size; i++) {
            eventStrings[i] = allEvents.get(i);
        }

        Log.d(TAG, "STRINGS HAVE BEEN SET UP");
        // set up spinners
        spinner0 = findViewById(R.id.spin0);
        //set up adapter
        adapt0 = new ArrayAdapter<>(CalendarActivity.this, android.R.layout.simple_spinner_dropdown_item, eventStrings);

        //set spinner and adapter stuff
        adapt0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner0.setAdapter(adapt0);
        spinner0.setOnItemSelectedListener(this);


        spinner0 = (Spinner) findViewById(R.id.spin0);
        setUpAdapterStuff(adapt0, spinner0, events0);
        Log.d(TAG ,"SPIN0");
        spinner1 = (Spinner) findViewById(R.id.spin1);
        setUpAdapterStuff(adapt1, spinner1, events1);
        spinner2 = (Spinner) findViewById(R.id.spin2);
        setUpAdapterStuff(adapt2, spinner2, events2);
        spinner3 = (Spinner) findViewById(R.id.spin3);
        setUpAdapterStuff(adapt3, spinner3, events3);
        spinner4 = (Spinner) findViewById(R.id.spin4);
        setUpAdapterStuff(adapt4, spinner4, events4);
        spinner5 = (Spinner) findViewById(R.id.spin5);
        setUpAdapterStuff(adapt5, spinner5, events5);
        spinner6 = (Spinner) findViewById(R.id.spin6);
        setUpAdapterStuff(adapt6, spinner6, events6);
        Log.d(TAG, "SPINNERS HAVE BEEN SET UP");



        RecyclerView recyclerView = findViewById(R.id.rvDisplayWeek);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter_DisplayWeek(this, currentWeek);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        Log.d(TAG, "RECYCLERVIEW SET UP");


        // What the buttons do.

        bAddEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarActivity.this, AddEventActivity.class);
                //intent.putExtra();
                startActivity(intent);
            }
        });

    }


    public void setUpAdapterStuff(ArrayAdapter adapter, Spinner spinner, String[] events) {
        //set up adapter
        adapter = new ArrayAdapter<>(CalendarActivity.this, android.R.layout.simple_spinner_dropdown_item, events);

        //set spinner and adapter stuff
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //do nothing
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //
    }

    @Override
    public void onItemClick(View view, int position) {
        //
    }


}
*/

