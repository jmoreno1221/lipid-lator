package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class CholesterylEstersActivity extends AppCompatActivity {

    public String ionSelected, acylSelected;
    public int ionIndex, acylIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cholesteryl_esters);
        final Spinner spnIon = (Spinner) findViewById(R.id.spnIon);
        final Spinner spnAcyl = (Spinner) findViewById(R.id.spnAcylChain);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ionIndex = spnIon.getSelectedItemPosition();
                acylIndex = spnAcyl.getSelectedItemPosition();
                ionSelected = spnIon.getSelectedItem().toString();
                acylSelected = spnAcyl.getSelectedItem().toString();
                setIon(ionIndex);
                Intent intent = new Intent(CholesterylEstersActivity.this, CholesterylEsters_Result_Activity.class);
                intent.putExtra("ionIndex", getIonIndex());
                intent.putExtra("acylIndex", getAcyIndex());
                intent.putExtra("ionSelected", ionSelected);
                intent.putExtra("acylSelected", acylSelected);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CholesterylEstersActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setIon(int ion2) {
        ionIndex = ion2;
    }

    public int getIonIndex() {
        return ionIndex;
    }

    public int getAcyIndex() {
        return acylIndex;
    }
}

