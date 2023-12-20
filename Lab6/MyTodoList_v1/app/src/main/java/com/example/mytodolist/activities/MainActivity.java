package com.example.mytodolist.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.FileUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mytodolist.R;
import com.example.mytodolist.adapters.TodoAdapter;

import com.example.mytodolist.models.TodoItem;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView todoListView;
    private TodoAdapter mAdapter;
    private ArrayList<TodoItem> todoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoListView = findViewById(R.id.todoListView);
        populateItemsList();

        mAdapter = new TodoAdapter(this, todoList);
        todoListView.setAdapter(mAdapter);


    }


    private void populateItemsList() {
        todoList = TodoItem.getTodoList();
    }


}