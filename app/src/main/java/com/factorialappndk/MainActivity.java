package com.factorialappndk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText number_edit;
    Button btn_calculate;
    TextView fact_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number_edit = (EditText) findViewById(R.id.number_edit);
        fact_value =(TextView) findViewById(R.id.fact_value);
        btn_calculate = (Button) findViewById(R.id.btn_calculate);
        btn_calculate.setOnClickListener(this);
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(String.valueOf(stringFromJNI()));
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

//    public native int factorialValue(int a);

    public native long calculateFactorialValue(int a);

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }



    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate) {
            String entered_number = number_edit.getText().toString();
            if (entered_number.equalsIgnoreCase("")) {
                Toast.makeText(getApplicationContext(), "Please enter a valid number", Toast.LENGTH_LONG).show();
            } else if (Integer.parseInt(entered_number) > 100) {
                Toast.makeText(getApplicationContext(), "Please enter number between 1 to 99", Toast.LENGTH_LONG).show();
            } else {
                int value = Integer.parseInt(entered_number);
                if (value<=15) {
                    Log.d("MainActivity ", "entered_number =" + value);
                    long factorial = calculateFactorialValue(value);
                    Log.d("MainActivity", "factorial = " + factorial);
                    fact_value.setText("Factorial is " + factorial);
                }else {
                    Toast.makeText(getApplicationContext(),"Please enter values less then 30",Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
