package com.example.green.crmproject_android;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import TaskPackage.Task;
import TaskPackage.TaskList;

public class RecyclerViewAdapter_Tasks extends RecyclerView.Adapter<RecyclerViewAdapter_Tasks.ViewHolder> {

    private TaskList mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    //private CheckBox checkBox;

    // data is passed into the constructor
    RecyclerViewAdapter_Tasks(Context context, TaskList data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;

    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.task_recyclerview_row, parent, false);
        //checkBox = view.findViewById(R.id.cbCheckBox);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String desc = mData.get(position);
        holder.myTextView.setText(desc);

        //final ViewHolder vHolder = holder;
        final Task task = mData.getTask(position);
        final int pos = position;

        holder.myCheckBox.setOnCheckedChangeListener(null);
        holder.myCheckBox.setChecked(task.isCompleted());
        holder.myCheckBox.setTag(mData.getTask(position));


        holder.myCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), task.getDesc() + " completed!", Toast.LENGTH_SHORT);

                if (task.isCompleted()) {
                    task.setCompleted(false);
                }
                else {
                    task.setCompleted(true);
                }
            }
        });


        /*
        holder.myCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                task.setCompleted(isChecked);

                if (task.isCompleted()) {
                    Toast.makeText(getContext(), task.getDesc() + " completed!", Toast.LENGTH_SHORT);
                }
            }
        });
        */
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        CheckBox myCheckBox;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvListDesc);
            myCheckBox = itemView.findViewById(R.id.cbCheckBox);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public void deleteItem(int position) {
        //mRecentlyDeletedItem = mData.getTask(position);
        //mRecentlyDeletedItemPosition = position;
        mData.deleteTask(position);
        notifyItemRemoved(position);
    }


    public Context getContext() {
        return mInflater.getContext();
    }

}