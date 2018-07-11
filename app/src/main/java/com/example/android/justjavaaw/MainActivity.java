package com.example.android.justjavaaw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void decrement(View view) {
        if (quantity == 0) {
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    public void increment(View view) {
        if (quantity == 10){
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void submitOrder(View view) {

        EditText nameField = findViewById(R.id.name_field);
        Editable specifyName = nameField.getText();

        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_check_box);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_check_box);
        boolean hasChocoLate = chocolateCheckBox.isChecked();

        int calculatePrice = calculatePrice(hasWhippedCream, hasChocoLate);

        displayMessage(specifyName, calculatePrice, hasWhippedCream, hasChocoLate);
    }

    public void displayQuantity(int numberOrdered) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOrdered);
    }


    private int calculatePrice(boolean addWhippeedCream, boolean addChocolate) {
        int basePrice = 5;
        if (addWhippeedCream) {
            basePrice = basePrice + 1;
        }
        if (addChocolate) {
            basePrice = basePrice + 2;
        }
        return (basePrice * quantity);
    }

    public void displayMessage(Editable specifyName, int calculatePrice, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: " + specifyName;
        priceMessage += "\nAdd whipped Cream?" + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + calculatePrice;
        priceMessage += "\nThank You";
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(priceMessage);
    }
}
