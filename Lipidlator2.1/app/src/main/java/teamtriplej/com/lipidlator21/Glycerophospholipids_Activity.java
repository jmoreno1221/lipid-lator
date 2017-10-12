package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class Glycerophospholipids_Activity extends AppCompatActivity {
    public int ionIndex, headGroupIndex, sn1_1Index, sn2_1Index;
    public String ionSelected, headGroupSelected, sn1_1Selected, sn2_1Selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glycerophospholipids_);
        //Create an instance of each of the interactive things on our screen
        //for example in this case we have 2 buttons and 4 spinners

        final Spinner spnIon = (Spinner) findViewById(R.id.spnIon);
        final Spinner spnHeadGroup = (Spinner) findViewById(R.id.spnHeadGroup);
        final Spinner spnSn1_1 = (Spinner) findViewById(R.id.spnSn1_1);
        final Spinner spnSn2_1 = (Spinner) findViewById(R.id.spnSn2_1);

        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Retrieve all data from whatever is selected in each of the
                //spinners to set our variables to them.

                ionIndex = spnIon.getSelectedItemPosition();
                headGroupIndex = spnHeadGroup.getSelectedItemPosition();
                sn1_1Index = spnSn1_1.getSelectedItemPosition();
                sn2_1Index = spnSn2_1.getSelectedItemPosition();

                ionSelected = spnIon.getSelectedItem().toString();
                headGroupSelected = spnHeadGroup.getSelectedItem().toString();
                sn1_1Selected = spnSn1_1.getSelectedItem().toString();
                sn2_1Selected = spnSn2_1.getSelectedItem().toString();

                Intent intent = new Intent(Glycerophospholipids_Activity.this, Glycerophospholipids_Result_Activity.class);
                //After creating the intent to prepare to go to the next screen, before
                //we start the screen, we need to also add the variables above to our
                //intent to make sure we don't leave anything behind.
                intent.putExtra("ion",ionIndex);
                intent.putExtra("headGroupIndex", headGroupIndex);
                intent.putExtra("sn1_1Index", sn1_1Index);
                intent.putExtra("sn2_1Index", sn2_1Index);

                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Glycerophospholipids_Activity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}