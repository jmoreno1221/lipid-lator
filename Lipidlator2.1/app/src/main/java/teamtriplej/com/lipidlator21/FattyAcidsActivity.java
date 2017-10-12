package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class FattyAcidsActivity extends AppCompatActivity {
    //Create all the necessary variables
    public int ion, massIndex, esterIndex;
    public String ionSelected, esterSelected, acidSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatty_acids);
        //Create an instance of each of the interactive things on our screen
        //for example in this case we have 2 buttons and 3 spinners
        final Spinner spnI = (Spinner) findViewById(R.id.spnIon);
        final Spinner spnA = (Spinner) findViewById(R.id.spnAcid);
        final Spinner spnE = (Spinner) findViewById(R.id.spnEster);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Retrieve all data from whatever is selected in each of the
                //spinners to set our variables to them.
                ion = spnI.getSelectedItemPosition();
                massIndex = spnA.getSelectedItemPosition();
                esterIndex = spnE.getSelectedItemPosition();
                ionSelected = spnI.getSelectedItem().toString();
                esterSelected = spnE.getSelectedItem().toString();
                acidSelected = spnA.getSelectedItem().toString();
                Intent intent = new Intent(FattyAcidsActivity.this, FattyAcids_Result_Activity.class);
                //After creating the intent to prepare to go to the next screen, before
                //we start the screen, we need to also add the variables above to our
                //intent to make sure we don't leave anything behind.
                intent.putExtra("ion",ion);
                intent.putExtra("massIndex", massIndex);
                intent.putExtra("esterIndex", esterIndex);
                intent.putExtra("ionSelected",ionSelected);
                intent.putExtra("esterSelected",esterSelected);
                intent.putExtra("acidSelected", acidSelected);
                //Once everything has been added to the intent, we can start the new screen
                startActivity(intent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FattyAcidsActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

}
