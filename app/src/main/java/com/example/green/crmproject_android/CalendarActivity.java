package com.example.green.crmproject_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        // Buttons for this screen.
        Button bDisplayWeek = findViewById(R.id.buttonDisplayWeek);
        Button bDisplayEvents = findViewById(R.id.buttonDisplayEvents);
        Button bAddEvent = findViewById(R.id.buttonAddEvent);

        // What the buttons do.
        bDisplayWeek.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarActivity.this, DisplayWeekActivity.class);
                //intent.putExtra();
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
