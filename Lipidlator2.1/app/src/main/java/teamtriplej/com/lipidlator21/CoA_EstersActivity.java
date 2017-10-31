package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class CoA_EstersActivity extends AppCompatActivity {

    // Declare variables
    public int ionIndex, acylIndex;
    public String ionSelected, acylSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_a_esters);
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#864499")));
        }

        // Spinners
        final Spinner spnI = (Spinner) findViewById(R.id.spnIon);
        final Spinner spnAcyl = (Spinner) findViewById(R.id.spnAcylChain);

        // Buttons
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        // Actions by Submit Button
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Get index of current ion or acyl position
                ionIndex = spnI.getSelectedItemPosition();
                acylIndex = spnAcyl.getSelectedItemPosition();

                // Save selected element to String
                ionSelected = spnI.getSelectedItem().toString();
                acylSelected = spnAcyl.getSelectedItem().toString();

                // setIon and create intent
                setIon(ionIndex);
                Intent intent = new Intent(CoA_EstersActivity.this, CoA_Esters_Result_Activity.class);

                // putExtra to be able to transfer indexes & String values
                intent.putExtra("ionIndex", getIonIndex());
                intent.putExtra("acylIndex", getAcylIndex());
                intent.putExtra("ionSelected", ionSelected);
                intent.putExtra("acylSelected", acylSelected);

                // Start Activity
                startActivity(intent);
            }
        });

        // Back Button Action When Clicked
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    // Set ion
    public void setIon(int ion){
        ionIndex = ion;
    }

    // Getters methods for indexes
    public int getIonIndex(){
        return ionIndex;
    }

    public int getAcylIndex(){
        return acylIndex;
    }

}
