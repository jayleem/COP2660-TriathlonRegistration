package com.jayleem.triathlonregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int FEE = 725;
    public String[] spinnerArray = {"Miami", "Lake Placid", "Big Island Hawaii"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner)findViewById(R.id.mySpinner);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, spinnerArray);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setPrompt("Select Location");
    }

    public void calcCosts(View view) {
        Spinner spinner = (Spinner)findViewById(R.id.mySpinner);
        TextView costLabel = (TextView) findViewById(R.id.costLabel);
        EditText editText = (EditText)findViewById(R.id.numAthlete);

        if(editText.getText().length() > 0){
            int cost = FEE * Integer.parseInt(editText.getText().toString());
            costLabel.setText(spinner.getSelectedItem().toString() + " race team fee is $" + cost);
        }
    }
}
