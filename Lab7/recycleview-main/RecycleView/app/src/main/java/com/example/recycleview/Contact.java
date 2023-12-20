package com.example.recycleview;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String name;
    private int imageResurce;
    private String phoneNumber;

    public Contact(String name, int imageResurce, String phoneNumber) {
        this.name = name;
        this.imageResurce = imageResurce;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageResurce(int imageResurce) {
        this.imageResurce = imageResurce;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getImageResurce() {
        return imageResurce;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static List<Contact> getContacts() {
        public static List<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("Adam", R.drawable.contact_one, "4153508881"));
        contacts.add(new Contact("Brian", R.drawable.contact_two, "4153508882"));
        contacts.add(new Contact("Charlie", R.drawable.contact_three, "4153508883"));
        contacts.add(new Contact("David", R.drawable.contact_four, "4153508884"));
        contacts.add(new Contact("Edward", R.drawable.contact_five, "4153508885"));
        contacts.add(new Contact("Frank", R.drawable.contact_six, "4153508886"));
        contacts.add(new Contact("George", R.drawable.contact_seven, "4153508887"));
        contacts.add(new Contact("Henry", R.drawable.contact_eight, "4153508888"));
        contacts.add(new Contact("Ian", R.drawable.contact_nine, "4153508889"));
        contacts.add(new Contact("John", R.drawable.contact_ten, "4153508890"));

        return contacts;
    }
}
