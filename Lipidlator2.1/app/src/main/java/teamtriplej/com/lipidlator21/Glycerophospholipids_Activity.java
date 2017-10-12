package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class Glycerophospholipids_Activity extends AppCompatActivity {
    public int ionIndex, headGroupIndex, sn1_1Index, sn2_1Index;
    public String ionString, headGroupString, sn1_1String, sn2_1String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glycerophospholipids_);

        final Spinner spnIon = (Spinner) findViewById(R.id.spnIon);
        final Spinner spnHeadGroup = (Spinner) findViewById(R.id.spnHeadGroup);
        final Spinner spnSn1_1 = (Spinner) findViewById(R.id.spnSn1_1);
        final Spinner spnSn2_1 = (Spinner) findViewById(R.id.spnSn2_1);

        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ionIndex = spnIon.getSelectedItemPosition();
                headGroupIndex = spnHeadGroup.getSelectedItemPosition();
                sn1_1Index = spnSn1_1.getSelectedItemPosition();
                sn2_1Index = spnSn2_1.getSelectedItemPosition();
                setIon(ionIndex);

                Intent intent = new Intent(Glycerophospholipids_Activity.this, Glycerophospholipids_Result_Activity.class);
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

    public void setIon(int ion2)
    {
        ionIndex = ion2;
    }
    public int getIonIndex()
    {
        return ionIndex;
    }
    public int getHeadGroupIndex()
    {
        return headGroupIndex;
    }
}