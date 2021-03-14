package edu.Gresbach.Nathaniel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Declare our variables
    double costPerCredit;
    int numberOfCredits;
    double totalCostSemester;
    String semesterSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText costPerCredText=(EditText)findViewById(R.id.costPerCredit);
        final EditText numOfCredText=(EditText)findViewById(R.id.numberOfCredits);
        final Spinner group = (Spinner)findViewById(R.id.spinner);
        final TextView resultTextBox=(TextView) findViewById(R.id.textView5);
        Button calculate = (Button) findViewById(R.id.button);

        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                costPerCredit = Double.parseDouble(costPerCredText.getText( ).toString( ));
                numberOfCredits = Integer.parseInt(numOfCredText.getText( ).toString( ));
                semesterSelected = group.getSelectedItem( ).toString( );
                totalCostSemester = (numberOfCredits * costPerCredit) + 125; // $125 Technology fee
                DecimalFormat currency = new DecimalFormat("$###,###.##");

                String resultText = "Your total cost for the " + semesterSelected +
                        " semester is " + currency.format(totalCostSemester);
                resultTextBox.setText(resultText);
            }
        });
    }
}