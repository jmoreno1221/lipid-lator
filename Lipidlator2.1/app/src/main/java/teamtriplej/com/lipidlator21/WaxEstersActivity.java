package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class WaxEstersActivity extends AppCompatActivity {
    public int ion, alcoholIndex, acidIndex;
    public double basicMass = 0.00;
    public String ionSelected, alcoholSelected, acidSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wax_esters);
        final Spinner spnI = (Spinner) findViewById(R.id.spnIon);
        final Spinner spnAc = (Spinner) findViewById(R.id.spnAcid);
        final Spinner spnAl = (Spinner) findViewById(R.id.spnAlcohol);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ion = spnI.getSelectedItemPosition();
                acidIndex = spnAc.getSelectedItemPosition();
                alcoholIndex = spnAl.getSelectedItemPosition();
                ionSelected = spnI.getSelectedItem().toString();
                alcoholSelected = spnAl.getSelectedItem().toString();
                acidSelected = spnAc.getSelectedItem().toString();
                setIon(ion);
                Intent intent = new Intent(WaxEstersActivity.this, WaxEsters_Result_Activity.class);
                intent.putExtra("ion",getIon());
                intent.putExtra("alcoholIndex", getAlcoholIndex());
                intent.putExtra("acidIndex", getAcidIndex());
                intent.putExtra("ionSelected",ionSelected);
                intent.putExtra("alcoholSelected",alcoholSelected);
                intent.putExtra("acidSelected", acidSelected);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WaxEstersActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
    public void setIon(int ion2)
    {
        ion = ion2;
    }
    public int getIon()
    {
        return ion;
    }
    public double getBasicMass()
    {
        return basicMass;
    }
    public int getAlcoholIndex()
    {
        return alcoholIndex;
    }
    public int getAcidIndex()
    {
        return acidIndex;
    }
}
