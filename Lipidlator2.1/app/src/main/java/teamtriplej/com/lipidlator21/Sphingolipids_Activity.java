package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class Sphingolipids_Activity extends AppCompatActivity {
    private int ion, headIndex, baseIndex, acylIndex;
    private String ionSelected, headSelected, baseSelected, acylSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphingolipids_);
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1b738e")));
        }
        final Spinner spnI = (Spinner) findViewById(R.id.spnIon);
        final Spinner spnH = (Spinner) findViewById(R.id.spnHeadGroup);
        final Spinner spnB = (Spinner) findViewById(R.id.spnSphingoidBase);
        final Spinner spnA = (Spinner) findViewById(R.id.spnNAcyl);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ion = spnI.getSelectedItemPosition();
                headIndex = spnH.getSelectedItemPosition();
                baseIndex = spnB.getSelectedItemPosition();
                acylIndex = spnA.getSelectedItemPosition();
                ionSelected = spnI.getSelectedItem().toString();
                headSelected = spnH.getSelectedItem().toString();
                baseSelected = spnB.getSelectedItem().toString();
                acylSelected = spnA.getSelectedItem().toString();
                Intent intent = new Intent(Sphingolipids_Activity.this, Sphingolipids_Result_Activity.class);
                intent.putExtra("ion", ion);
                intent.putExtra("headIndex", headIndex);
                intent.putExtra("baseIndex", baseIndex);
                intent.putExtra("acylIndex", acylIndex);
                intent.putExtra("ionSelected", ionSelected);
                intent.putExtra("headSelected", headSelected);
                intent.putExtra("baseSelected", baseSelected);
                intent.putExtra("acylSelected", acylSelected);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sphingolipids_Activity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
