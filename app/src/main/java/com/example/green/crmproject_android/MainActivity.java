package com.example.green.crmproject_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.Calendar;

import TaskPackage.Task;
import TaskPackage.TaskList;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_NAME = "com.example.green.crmproject_android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create buttons
        Button bCalendar = findViewById(R.id.buttonCalendar);
        Button bContacts = findViewById(R.id.buttonContacts);
        Button bTasks = findViewById(R.id.buttonTasks);






        /*EVERYTHING BELOW IS BUTTON ONCLICK STUFF*/

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
                //intent.putExtra(EXTRA_NAME, (Serializable) taskList);        //<-- this is where you would pass whatever variables to new activity
                startActivity(intent);
            }

        });
        //-----------------------------------------------------------------
    }
}
