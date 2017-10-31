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

public class AcylCarnitinesActivity extends AppCompatActivity {
    public int ion, acylIndex;
    public String ionSelected, acylSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acyl_carnitines);
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#07b78e")));
        }
        final Spinner spnI = (Spinner) findViewById(R.id.spnIon);
        final Spinner spnAcyl = (Spinner) findViewById(R.id.spnAcylChain);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ion = spnI.getSelectedItemPosition(); //Returns index value of Ion Spinner of currently selected.
                acylIndex = spnAcyl.getSelectedItemPosition();
                ionSelected = spnI.getSelectedItem().toString();
                acylSelected = spnAcyl.getSelectedItem().toString();
                Intent intent = new Intent(AcylCarnitinesActivity.this, AcylCarnitines_Result_Activity.class);
                intent.putExtra("ionIndex", ion);
                intent.putExtra("acylIndex", acylIndex);
                intent.putExtra("ionSelected", ionSelected);
                intent.putExtra("acylSelected", acylSelected);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
