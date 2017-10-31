package chakl_tarc.lab12bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Main extends AppCompatActivity
{
    //data variable
    private float weight = 0;
    private float height = 0;
    private float BMI = 0;

    //UI Variable
    private EditText editTextWeight;
    private EditText editTextHeight;
    private Button buttonCalculate;
    private Button buttonReset;
    private TextView textViewBMI;
    private ImageView imageViewBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = (EditText) findViewById(R.id.inputWeight);
        editTextHeight = (EditText) findViewById(R.id.inputHeight);
        buttonCalculate = (Button) findViewById(R.id.calculateButton);
        buttonReset = (Button) findViewById(R.id.resetButton);
        imageViewBMI = (ImageView) findViewById (R.id.bmiImage);
        textViewBMI = (TextView) findViewById(R.id.bmiText);



    }

    public void buttonCalculate(View v)
    {

        String displayMessage = "";

        if(inputValidation())
        {
            height = Float.parseFloat(editTextHeight.getText().toString());
            weight = Float.parseFloat(editTextWeight.getText().toString());
            BMI = weight / (height * height);

            if (BMI <= 18.5)
            {
                displayMessage = "You are under weight!";
                imageViewBMI.setImageResource(R.drawable.under);
            }

            else if (BMI >= 21)
            {
                displayMessage = "You are over weight!";
                imageViewBMI.setImageResource(R.drawable.over);
            }

            else
            {
                displayMessage = "You are normal!";
                imageViewBMI.setImageResource(R.drawable.normal);
            }

        }

        else
        {
            displayMessage = "Please enter your height and weight!";
            imageViewBMI.setImageResource(R.drawable.empty);
        }

        textViewBMI.setText(displayMessage);
    }

    public void buttonReset(View v)
    {
        editTextHeight.setText("");
        editTextWeight.setText("");
        textViewBMI.setText("Please enter your BMI.");
        imageViewBMI.setImageResource(R.drawable.empty);
    }

    private boolean inputValidation()
    {
        return (!editTextHeight.getText().toString().isEmpty() || !editTextWeight.getText().toString().isEmpty());
    }
}
