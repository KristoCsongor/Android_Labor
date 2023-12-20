package com.example.pizzaselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Pizza> pizzaList = new ArrayList<>();
    Pizza selectedPizza;
    float totalPrice;
    Spinner pizzaSpinner;
    CheckBox cheese;
    CheckBox tomato;
    TextView price;
    Button btnSendOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pizza margarita = new Pizza("Margarita", 22);
        pizzaList.add(margarita);

        Pizza pepperoni = new Pizza("Pepperoni", 21);
        pizzaList.add(pepperoni);

        Pizza vegetarian = new Pizza("Vegetarian", 24);
        pizzaList.add(vegetarian);

        // PizzaAdapter inicializálása és hozzárendelése a Spinner-hez
        ArrayAdapter<Pizza> pizzaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, pizzaList);
        pizzaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pizzaSpinner = findViewById(R.id.spinner);
        pizzaSpinner.setAdapter(pizzaAdapter);

        pizzaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedPizza = (Pizza) pizzaSpinner.getSelectedItem();
                price.setText(Double.toString(selectedPizza.getTotalPrice()) + " RON");
                //Toast.makeText(MainActivity.this, selectedPizza.getName() + selectedPizza.getBasePrice(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cheese = findViewById(R.id.cbCheese);
        //cheese.setTag("price", 0.5);
        tomato = findViewById(R.id.cbTomato);
        price = findViewById(R.id.price);
        btnSendOrder = findViewById(R.id.btnSendOrder);

        btnSendOrder.setOnClickListener((view)->{
            Toast.makeText(this, "Pizza: " + selectedPizza + "\n" + "Toppings: " + selectedPizza.getToppings().toString() + "\n"
                    + "Price:" + Double.toString(selectedPizza.getTotalPrice()) + " RON"   , Toast.LENGTH_SHORT).show();
        });
    }

    public void onClick(View v) {
        if (cheese.isChecked()) {
            if (selectedPizza != null) {
                selectedPizza.addTopping(cheese.getText().toString(), 1.5);
            }
        } else {
            selectedPizza.removeTopping(cheese.getText().toString());
        }

        if (tomato.isChecked()) {
            if (selectedPizza != null) {
                selectedPizza.addTopping(tomato.getText().toString(), 2.5);
            }
        } else {
            selectedPizza.removeTopping(tomato.getText().toString());
        }

        price.setText(Double.toString(selectedPizza.getTotalPrice()) + " RON");
    }
}