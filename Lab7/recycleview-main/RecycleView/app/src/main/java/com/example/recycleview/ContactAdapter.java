package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.VH> {
    private Context context;
    private List<Contact> contacts;

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).
                inflate(R.layout.list_item, parent, false);
        return new VH(itemView, context);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        public View rootview;
        public ImageView image;
        public TextView name;

        public VH(@NonNull View itemView, Context context) {
            super(itemView);
        }
    }
}
