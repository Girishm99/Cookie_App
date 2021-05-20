package com.example.just_java;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.*;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


import org.w3c.dom.Text;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    ImageView cookie_image;
int numberOfCoffees = 0;
    private Object View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cookie_image = findViewById(R.id.cookie_image);
        Glide.with(MainActivity.this).load(R.drawable.giphy)
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(cookie_image);


    }


    public void increase_quantity(View view){

        int val = 2;
        String hello = "Hello owlrd"+val+ "";

        numberOfCoffees+=1;
        TextView quantity = (TextView) findViewById(R.id.Quantity_number);
        quantity.setText(""+numberOfCoffees);
        displayPrice(numberOfCoffees*5);


    }
    public void descrease_quantity(View view){
        if (numberOfCoffees > 1) {
                numberOfCoffees-= 1;
        }else{

        }
        TextView quantity = (TextView) findViewById(R.id.Quantity_number);
        quantity.setText(""+numberOfCoffees);
displayPrice(numberOfCoffees*5);
    }

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view){
        if(numberOfCoffees<1){
            Toast.makeText(getApplicationContext(),"Quantity of Cookies should be more then 1",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"Order Place",Toast.LENGTH_SHORT).show();

        }



    }




    public void order_Message(){
        Toast.makeText(getApplicationContext(),"Order Placed",Toast.LENGTH_SHORT).show();
    }

    /**
     * This method displays the given quantity value on the screen.
     */


    private void displayPrice(int price){
       double Price = price;
        TextView pricenumber = (TextView) findViewById(R.id.price_text);
        pricenumber.setText(Price + "rs");

    }

    //--------------------------------------------------//


    /**This method is called when the reset button is clicked
     * **/
    public void resetOrder(View view){
        reset(0);
    }

    /**This method will the reset the value of quantity number to " 0 "
     * */
    public void reset(int no){

        TextView textview = (TextView) findViewById(R.id.Quantity_number);
        textview.setText("" + no);
        TextView price_value = (TextView) findViewById(R.id.price_text);
        double zero = 0.00;
        numberOfCoffees = 0;
        price_value.setText(" ");
    }


}