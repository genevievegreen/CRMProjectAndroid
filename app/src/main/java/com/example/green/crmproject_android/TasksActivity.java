package com.example.green.crmproject_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import TaskPackage.Task;
import TaskPackage.TaskList;

public class TasksActivity extends AppCompatActivity  implements RecyclerViewAdapter_Tasks.ItemClickListener {

    RecyclerViewAdapter_Tasks adapter;
    TaskList list;
    String inputThis;
    Button bAddTask;
    EditText input;

    //logger
    private static final String TAG ="TaskActivity: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        Log.d(TAG, "Successfully moved to Task Activity");

        //declare objects
        bAddTask = findViewById(R.id.buttonAddTask);
        input = findViewById(R.id.editTaskInput);

        //FUTURE THINGS TO IMPLEMENT:
        //LOAD SAVED TASKS
        //CREATE NEW TASKS IF LOAD FAILS

        list = new TaskList();
        list.addTask(new Task("Do something"));
        list.addTask(new Task("Do that thing again"));
        list.addTask(new Task("Do something"));
        list.addTask(new Task("Do that thing again"));
        list.addTask(new Task("Do something"));


        //Add Task Button stuff
        bAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputThis = input.getText().toString();
                Log.d(TAG, inputThis);

                if (inputThis.equals(null) || inputThis.equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "You must enter a task", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    list.addTask(new Task(inputThis));
                    adapter.notifyDataSetChanged(); //refreshes the recyclerview
                    input.setText("");
                }

            }
        });




        //Recycler View stuff
        RecyclerView recyclerView = findViewById(R.id.rv_Tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter_Tasks(this, list);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new Task_Swiper(adapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    @Override
    public void onItemClick(View view, int position) {
        //remove from recyclerview and change task to COMPLETED
    }


}
