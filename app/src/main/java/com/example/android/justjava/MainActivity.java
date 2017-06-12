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
        int price = calculatePrice();
        displayMessage(createOrderSummay(price));
    }

    private int calculatePrice() {
        return numberOfCoffees * priceOfCoffee;
    }

    private String createOrderSummay(int price) {
        String priceMessage = "Name: Sonya Moisset";
        priceMessage += "\nQuantity: " + numberOfCoffees;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void increment(View view) {
        numberOfCoffees++;
        displayQuantity(numberOfCoffees);
    }

    public void decrement(View view) {
        numberOfCoffees--;
        displayQuantity(numberOfCoffees);
    }
}
