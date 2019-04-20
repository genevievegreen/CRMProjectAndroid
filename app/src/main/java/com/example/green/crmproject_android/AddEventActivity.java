package com.example.green.crmproject_android;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Calendar;

import features.model.CurrentWeek;
import features.model.Day;
import features.model.Event;
import features.model.EventList;

public class AddEventActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private final String TAG = "TAG";

    // variables for this activity
    Spinner spinner;
    Switch remSwitch;
    Button saveEventButton;
    EditText eventName;
    ArrayAdapter adapter;
    CurrentWeek currentWeek;
    String[] dates;

    // test variables
    Calendar c;
    Event e;
    EventList testList;
    String name;
    boolean wantReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        Log.d(TAG, "In the add event activity");

        // set up dates array
        currentWeek = new CurrentWeek();
        dates = new String[7];
        int i = 0;
        for (Day d : currentWeek.getCurrentWeek()) {
            dates[i] = d.getDaysDate();
            i++;
        }

        //dates = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul"};
        testList = new EventList("Test List");
        // set up edit text
        eventName = (EditText) findViewById(R.id.NameOfEventEditText);

        //set up spinner
        spinner = (Spinner) findViewById(R.id.spinnerDate);
        // set up button
        saveEventButton = (Button) findViewById(R.id.SaveEventButton);
        saveEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = eventName.getText() + "";
                e = new Event(name, c, wantReminder);
                testList.addEvent(e);
                Log.d(TAG, testList.getEventFromList(0).getEventName());
                finish();
            }
        });
        // set up switch
        remSwitch = (Switch) findViewById(R.id.reminderSwitch);
        remSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    wantReminder = true;
                }
                else {
                    wantReminder = false;
                }
            }

        });

        //set up adapter
        adapter = new ArrayAdapter<>(AddEventActivity.this, android.R.layout.simple_spinner_dropdown_item, dates);

        //set spinner and adapter stuff
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //set this date for event
        switch(position) {
            case 0:
                c = currentWeek.getDayInWeek(0).getDay();
                break;
            case 1:
                c = currentWeek.getDayInWeek(1).getDay();
                break;
            case 2:
                c = currentWeek.getDayInWeek(2).getDay();
                break;
            case 3:
                c = currentWeek.getDayInWeek(3).getDay();
                break;
            case 4:
                c = currentWeek.getDayInWeek(4).getDay();
                break;
            case 5:
                c = currentWeek.getDayInWeek(5).getDay();
                break;
            case 6:
                c = currentWeek.getDayInWeek(6).getDay();
                break;
            default:
                c = currentWeek.getDayInWeek(0).getDay();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Default date should be today if nothing is selected
    }
}
