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
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is for getting the class quantity
     */
    private int getQuantity(){
        return quantity;
    }

    /**
     * This method is for getting the price of each coffee
     * @return returns the quantity multiplied by the price
     */
    private int getTotal(){
        int coffeePrice = 5;
        return (getQuantity() * coffeePrice);
    }
    //This increases the quantity and then updates the XML
    public void increaseQuantity(View view){
        this.quantity += 1;
        quantityAndAmountDue(getTotal());
    }
    //This decreases the quantity and then updates the XML
    public void decreaseQuantity(View view){
        this.quantity -= 1;
        quantityAndAmountDue(getTotal());
    }

    /**
     * quantityAndAmountDue handles the refreshing of the quantity and the overall price before the user presses on the checkout button
     * @param total represents the total amount from multiplying the coffee price and quantity
     */
    private void quantityAndAmountDue(int total){
        displayQuantity(getQuantity());
        String containerForText = "Amount Due: ";
        displayPrice(total, containerForText);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        createOrderSummary("Tommy Mertell", getQuantity(), hasCream(), hasCoacoa());
    }
    public boolean hasCream(){
        CheckBox checked = (CheckBox) findViewById(R.id.whipped_cream);
        return checked.isChecked();
    }
    public boolean hasCoacoa(){
        CheckBox checked = (CheckBox) findViewById(R.id.coacoa);
        return checked.isChecked();
    }

    /**
     * Creates an Order Summary with a Name, Amount Ordered, and the Price with a thank you
     * @param name allows for different names to be utilized in the form of a String
     * @param quantity provides the amount of Cups of Coffee ordered
     */
    private void createOrderSummary(String name, int quantity, Boolean hasCream, Boolean hasCoacoa){
        String total = "Total: $" + getTotal();
        String creamCheck = "\nDoes this have Whipped Cream? " + hasCream;
        String coacoaCheck = "\nDoes this have Chocolate? " + hasCoacoa + "\n";
        String ty = "Thank you!";
        displayMessage("Name: " + name + "\n" + "Quantity: " + quantity + creamCheck + coacoaCheck + total + "\n" + ty) ;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays a message once the consumer increase quantity
     * @param number is the total combined cost of coffee and quantity
     * @param message is a special message concatenate before the number
     */
    private void displayPrice(int number, String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message + NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}

