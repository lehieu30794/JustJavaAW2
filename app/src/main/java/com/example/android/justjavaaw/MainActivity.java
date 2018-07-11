package com.example.android.justjavaaw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int quantity = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void submitOrder(View view) {
        displayMessage();
    }

    public void displayQuantity(int numberOrdered) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOrdered);
    }

    public boolean hasWhippedCream() {
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_check_box);
        whippedCreamCheckBox.isChecked();
        return hasWhippedCream();
    }

//    private int calculatePrice (){
//        if (hasWhippedCream()){
//            int baseprice = 5 + 1;
//            int price = baseprice * quantity;
//            return price;
//        }
//    }

    public void displayMessage() {
        String priceMessage = "Name:";
        priceMessage += "\nAdd whipped Cream?";
        priceMessage += "\nAdd chocolate";
        priceMessage += "\nQuantity" + quantity;
        priceMessage += "\nTotal: $";
        priceMessage += "\nThank You";
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(priceMessage);
    }
}
