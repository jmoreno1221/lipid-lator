package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import static teamtriplej.com.lipidlator21.R.id.spnIon;

public class GlycerolipidsActivity extends AppCompatActivity {

    // Variables
    public int ionIndex, sn1Index, sn2Index, sn3Index;
    public String ionSelected,sn1Selected, sn2Selected, sn3Selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glycerolipids);
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#d87c2b")));
        }
        // Spinners and Buttons
        final Spinner spnI = (Spinner) findViewById(spnIon);
        final Spinner spnSn1 = (Spinner) findViewById(R.id.spnSn1);
        final Spinner spnSn2 = (Spinner) findViewById(R.id.spnSn2);
        final Spinner spnSn3 = (Spinner) findViewById(R.id.spnSn3);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        // Submit Button
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Get spinners' data
                ionIndex = spnI.getSelectedItemPosition();
                sn1Index = spnSn1.getSelectedItemPosition();
                sn2Index = spnSn2.getSelectedItemPosition();
                sn3Index = spnSn3.getSelectedItemPosition();
                ionSelected = spnI.getSelectedItem().toString();
                sn1Selected = spnSn1.getSelectedItem().toString();
                sn2Selected = spnSn2.getSelectedItem().toString();
                sn3Selected = spnSn3.getSelectedItem().toString();
                Intent intent = new Intent(GlycerolipidsActivity.this, Glycerolipids_Result_Activity.class);

                // putExtra to transfer data to result screen activity
                intent.putExtra("ionIndex", ionIndex);
                intent.putExtra("sn1Index", sn1Index);
                intent.putExtra("sn2Index", sn2Index);
                intent.putExtra("sn3Index", sn3Index);
                intent.putExtra("ionSelected", ionSelected);
                intent.putExtra("sn1Selected", sn1Selected);
                intent.putExtra("sn2Selected", sn2Selected);
                intent.putExtra("sn3Selected", sn3Selected);

                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GlycerolipidsActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
