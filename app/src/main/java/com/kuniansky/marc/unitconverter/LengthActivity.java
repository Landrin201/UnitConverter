package com.kuniansky.marc.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 9/17/2015
 * Created by: Marc Kuniansky
 * Modifications:
 *
 * Marc Kuniansky, 9/17/2015, Implemented the activity and set up the onCreate and getSpinnerItems methods. Added code allow the user to interact
 *                            with the spinners and make item selections. Had the text box show which item was selected to test functionality
 * Marc Kuniansky, 9/18/2015, Implemented the convertLength method. This method works in conjunction with the Converter class to convert the input
 *                            to the proper output. Made the text view show the final output.
 */
public class LengthActivity extends AppCompatActivity {

    //Instance variables
    //Need access to the spinners and the text views
    private Spinner spinner1, spinner2;
    private EditText textField1;
    private TextView textView;
    private Double number;

    //When the activity is created, the XML file needs to be shown and the spinners need to be activated and populated.
    //To populate the spinners, the addItemsOnSpinner method was created. A listener is then used to listen
    //for the spinners being used.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //instantiate textField1

        //Selector listener
        AdapterView.OnItemSelectedListener onSpinner= new AdapterView.OnItemSelectedListener()
                { @Override
                  public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                    {
                        //These do nothing- this listener merely waits to tell the convert() method what is selected.

                        //For now, this only exports the position of the selected item to the text view
                       // textView = (TextView)findViewById(R.id.length_textView2);
                        //textView.setText(spinner1.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?>  parent)
                    {
                        //This does nothing right now
                    }
                };

        setContentView(R.layout.activity_length);
        //Populate the spinners
        setSpinnerItems();
        //Activate the listener
        spinner1.setOnItemSelectedListener(onSpinner);

    }

    /**
     * Converts a number from the EditText and converts it to a specified new unit
     */
    public void convertLength(View view)
    { //Begin convert length
        //Create a double
        //Instantiate a converter
        Converter converter = new Converter();
        textField1 = (EditText) findViewById(R.id.length_input);
        //First, get the number from the text field
        String numStr = textField1.getText().toString();
        //Convert the text to a double.
        //If the user inputs nothing, or inputs an invalid character instead of a number, or
        //if the user's input contains too many decimals, return as 0
        if(numStr.equals("")) {
            number = 0.0;
        }
        else if(numStr.equals("."))
        {
            number = 0.0;
        }
        else if(numStr.contains(".."))
        {
            number = 0.0;
        }
        else
        {
            number = new Double(numStr);
        }

       // if(number.isNaN())
         //   number = 0.0;

        //Finally, get the text view we need later to display the answer
        textView = (TextView)findViewById(R.id.length_textView2);

        //Get the units to be used
        String originalUnits = spinner1.getSelectedItem().toString();
        String newUnits = spinner2.getSelectedItem().toString();

        //Feed the units and the number into the Converter class and capture the output
        Double finalNumber = converter.lengthConvert(number, originalUnits, newUnits);
        //Set the text view to show the new number. Need to convert double to string
        String finalString = Double.toString(finalNumber);
        textView.setText(finalString);
    } //End convert length

    /**
     * Sets the items in the drop down for the two spinners
     */
    public void setSpinnerItems()
    {
        //I have the array here instead of in XML because changing/adding units requires extensive editing in this file
        String[] units = {"Inches", "Feet", "Yards", "Miles", "Millimeters", "Centimeters", "Meters", "Kilometers"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, units);
        spinner1 = (Spinner)findViewById(R.id.length_unit_spinner1);
        spinner2 = (Spinner)findViewById(R.id.length_unit_spinner2);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_length, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
