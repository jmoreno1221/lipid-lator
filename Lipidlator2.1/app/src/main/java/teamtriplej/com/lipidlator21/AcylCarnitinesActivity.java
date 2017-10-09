package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class AcylCarnitinesActivity extends AppCompatActivity {
    public int ionIndex, acylIndex;
    public String ionSelected, acylSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acyl_carnitines);
        final Spinner spnI = (Spinner) findViewById(R.id.spnIon);
        final Spinner spnAcyl = (Spinner) findViewById(R.id.spnAcylChain);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ionIndex = spnI.getSelectedItemPosition(); //Returns index value of Ion Spinner of currently selected.
                acylIndex = spnAcyl.getSelectedItemPosition();
                ionSelected = spnI.getSelectedItem().toString();
                acylSelected = spnAcyl.getSelectedItem().toString();
                setIon(ionIndex);
                Intent intent = new Intent(AcylCarnitinesActivity.this, AcylCarnitines_Result_Activity.class);
                intent.putExtra("ionIndex", getIonIndex());
                intent.putExtra("acylIndex", getAcylIndex());
                intent.putExtra("ionSelected", ionSelected);
                intent.putExtra("acylSelected", acylSelected);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AcylCarnitinesActivity.this, HomeActivity.class);
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
    public int getAcylIndex()
    {
        return acylIndex;
    }
}
