package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.green.crmproject_android.R;

import java.util.List;
import features.model.Event;

public class RecyclerViewAdapter_DisplayEvents extends RecyclerView.Adapter<RecyclerViewAdapter_DisplayEvents.ViewHolder> {
    private List<String> mData;
    private LayoutInflater mInflater;
    private RecyclerViewAdapter_DisplayEvents.ItemClickListener mClickListener;

    // data is passed into the constructor
    public RecyclerViewAdapter_DisplayEvents(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public RecyclerViewAdapter_DisplayEvents.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_display_week_row, parent, false);
        return new RecyclerViewAdapter_DisplayEvents.ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(RecyclerViewAdapter_DisplayEvents.ViewHolder holder, int position) {
        String event = mData.get(position);
        holder.myTextView.setText(event);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvDisplayWeekRow);
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
    public void setClickListener(RecyclerViewAdapter_DisplayEvents.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

