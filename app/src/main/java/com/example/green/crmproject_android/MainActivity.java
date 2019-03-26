package com.example.green.crmproject_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create buttons
        Button bCalendar = findViewById(R.id.buttonCalendar);
        Button bContacts = findViewById(R.id.buttonContacts);
        Button bTasks = findViewById(R.id.buttonTasks);


        //-----------------------------------------------------------------
        //When Button is pressed, it will move to Calendar activity
        bCalendar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
                //intent.putExtra()             <-- this is where you would pass whatever variables to new activity
                startActivity(intent);
            }

        });
        //-----------------------------------------------------------------

        //-----------------------------------------------------------------
        //When Button is pressed, it will move to Contacts activity
        bContacts.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
                //intent.putExtra()             <-- this is where you would pass whatever variables to new activity
                startActivity(intent);
            }

        });
        //-----------------------------------------------------------------

        //-----------------------------------------------------------------
        //When Button is pressed, it will move to Tasks activity
        bTasks.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TasksActivity.class);
                //intent.putExtra()             <-- this is where you would pass whatever variables to new activity
                startActivity(intent);
            }

        });
        //-----------------------------------------------------------------
    }
}
