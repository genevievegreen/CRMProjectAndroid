package com.example.green.crmproject_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import TaskPackage.Task;
import TaskPackage.TaskList;

public class TasksActivity extends AppCompatActivity  implements RecyclerViewAdapter_Tasks.ItemClickListener {

    RecyclerViewAdapter_Tasks adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        TaskList list = new TaskList();
        list.addTask(new Task("Do something"));
        list.addTask(new Task("Do that thing again"));
        list.addTask(new Task("Do something"));
        list.addTask(new Task("Do that thing again"));
        list.addTask(new Task("Do something"));
        list.addTask(new Task("Do that thing again"));
        list.addTask(new Task("Do something"));
        list.addTask(new Task("Do that thing again"));
        list.addTask(new Task("Do something"));
        list.addTask(new Task("Do that thing again"));
        list.addTask(new Task("Do something"));
        list.addTask(new Task("Do that thing again"));
        list.addTask(new Task("Do something"));
        list.addTask(new Task("Do that thing again"));



        RecyclerView recyclerView = findViewById(R.id.rv_Tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter_Tasks(this, list);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        //do nothing
    }
}
