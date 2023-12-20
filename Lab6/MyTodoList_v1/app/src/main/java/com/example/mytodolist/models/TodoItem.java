package com.example.mytodolist.models;

import java.util.ArrayList;
import java.util.List;

public class TodoItem {
    private String title;
    private String body;
    private int priority;
    private String dueDate;
    private int status;

    public TodoItem(String title, String body, int priority, String dueDate, int status) {
        this.title = title;
        this.body = body;
        this.priority = priority;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getPriority() {
        return priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", priority=" + priority +
                ", dueDate='" + dueDate + '\'' +
                ", status=" + status +
                '}';
    }

    public static ArrayList<TodoItem> getTodoList(){
        ArrayList<TodoItem> todos = new ArrayList<>();
        todos.add(new TodoItem("Groceries", "Buy vegetables and fruits", 2, "2022.11.10", 0));
        todos.add(new TodoItem("Workout", "Exercise at the gym", 2, "2022.11.07", 1));
        todos.add(new TodoItem("Study", "Read chapter 3", 1, "2022.11.08", 1));
        todos.add(new TodoItem("Meeting", "Discuss project updates", 3, "2022.11.09", 0));
        todos.add(new TodoItem("Cleaning", "Clean the living room", 1, "2022.11.06", 0));
        todos.add(new TodoItem("Coding", "Work on the website", 2, "2022.11.11", 1));
        todos.add(new TodoItem("Appointment", "Visit the dentist", 3, "2022.11.12", 1));
        todos.add(new TodoItem("Call", "Contact customer support", 1, "2022.11.13", 0));
        todos.add(new TodoItem("Reading", "Read a new book", 2, "2022.11.14", 0));
        todos.add(new TodoItem("Hike", "Go for a hike in the mountains", 3, "2022.11.15", 0));
        return todos;
    }
}
