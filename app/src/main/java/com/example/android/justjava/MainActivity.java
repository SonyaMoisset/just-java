package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int numberOfCoffees = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();

        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckbox.isChecked();

        EditText customerNameInput = (EditText) findViewById(R.id.customer_name_input);
        String customerName = customerNameInput.getText().toString();

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        displayMessage(createOrderSummay(price, hasWhippedCream, hasChocolate, customerName));
    }

    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;

        if (addWhippedCream) {
            basePrice += + 1;
        }
        if (addChocolate) {
            basePrice += + 2;
        }

        return numberOfCoffees * basePrice;
    }

    private String createOrderSummay(int price, boolean addWhippedCream, boolean addChocolate, String name) {
        String priceMessage = getResources().getString(R.string.order_summary_name, name);
        priceMessage += "\n" + getResources().getString(R.string.order_summary_whipped_cream, addWhippedCream);
        priceMessage += "\n" + getResources().getString(R.string.order_summary_chocolate, addChocolate);
        priceMessage += "\n" + getResources().getString(R.string.order_summary_quantity, numberOfCoffees);
        priceMessage += "\n" + getResources().getString(R.string.order_summary_price, price);
        priceMessage += "\n" + getResources().getString(R.string.thank_you);
        return priceMessage;
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public void increment(View view) {
        if (numberOfCoffees == 100) {
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        numberOfCoffees++;
        displayQuantity(numberOfCoffees);
    }

    public void decrement(View view) {
        if (numberOfCoffees == 1) {
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        numberOfCoffees--;
        displayQuantity(numberOfCoffees);
    }
}
