package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int numberOfCoffees;
    int priceOfCoffee = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        String priceMessage = "Total: $" + (numberOfCoffees * priceOfCoffee);
        priceMessage = priceMessage + "\nThank you!";
        displayMessage(priceMessage);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void increment(View view) {
        numberOfCoffees++;
        display(numberOfCoffees);
    }

    public void decrement(View view) {
        numberOfCoffees--;
        display(numberOfCoffees);
    }
}
