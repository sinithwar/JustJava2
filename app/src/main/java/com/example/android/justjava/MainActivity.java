package com.example.android.justjava;
/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

import java.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int quantity = 0;
    private int numberOfCoffees = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //This method is for getting the class quantity
    public int getQuantity(){
        return quantity;
    }
    //This method is for getting the price of each coffee
    public int getNumberOfCoffees() {
        return numberOfCoffees;
    }
    //This increases the quantity and then updates the XML
    public void increaseQuantity(View view){
        this.quantity += 1;
        display(getQuantity());
    }
    //This decreases the quantity and then updates the XML
    public void decreaseQuantity(View view){
        this.quantity -= 1;
        display(getQuantity());
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        displayPrice(getNumberOfCoffees() * getQuantity());
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
