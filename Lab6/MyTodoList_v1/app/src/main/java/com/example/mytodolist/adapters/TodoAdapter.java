package com.example.mytodolist.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.mytodolist.R;
import com.example.mytodolist.models.TodoItem;

import java.util.ArrayList;

public class TodoAdapter extends ArrayAdapter<TodoItem> {

    private Context mContext;
    //private String mCurrentTime;

    public TodoAdapter(@NonNull Context context, ArrayList<TodoItem> items) {
        super(context, 0, items);
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TodoItem item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.todo_item, parent, false);
        }

        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvBody = (TextView) convertView.findViewById(R.id.tvBody);
        TextView tvDate = (TextView) convertView.findViewById(R.id.tvDate);
        TextView tvStatus = (TextView) convertView.findViewById(R.id.tvStatus);

        // Populate the data into the template view using the data object
        tvTitle.setText(item.getTitle());
        tvBody.setText(item.getBody());
        tvDate.setText(item.getDueDate());
        if (item.getStatus() == 0) {
            tvStatus.setText("Pending");
            tvStatus.setTextColor(mContext.getResources().getColor(R.color.red));
        } else {
            tvStatus.setText("Completed");
            tvStatus.setTextColor(mContext.getResources().getColor(R.color.teal_200));
        }


        //tvTitle.setTextColor(setColor(item.priority));

        return convertView;
    }
}
