package com.example.recycleviewtemp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.VH> {
    @NonNull


    private Context context;
    private List<Contact> contacts;

    public ContactAdapter(@NonNull Context context, List<Contact> contacts) {

        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false);
        return new VH(itemView, context);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Contact contact = contacts.get(position);
        holder.itemView.setTag(contact);
        holder.name.setText(contact.getName());
        holder.image.setImageResource(contact.getImagineRes());


    }

    @Override
    public int getItemCount() {


        return contacts.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        public ImageView image;

        public TextView name;
        public View rootView;

        public VH(@NonNull View itemView, Context context) {
            super(itemView);
            rootView = itemView;
            image = itemView.findViewById(R.id.imgView);
            name = itemView.findViewById(R.id.name);
            //ToDo:sett image and name

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Contact contact = (Contact) rootView.getTag();
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("contact", contact);
                    context.startActivity(intent);
                }
            });

        }
    }

}
