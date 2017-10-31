package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Sphingolipids_Result_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphingolipids__result_);

        TextView tvIonSelected = (TextView) findViewById(R.id.tvIonResult);
        TextView tvHeadGroup = (TextView) findViewById(R.id.tvHeadGroupResult);
        TextView tvSphingoidBase = (TextView) findViewById(R.id.tvSphingoidBaseResult);
        TextView tvNAcyl = (TextView) findViewById(R.id.tvNAcyl_Result);
        TextView tvAbbreviation = (TextView) findViewById(R.id.tvAbbreviation_Result);
        TextView tvFormula = (TextView) findViewById(R.id.tvFormula_Result);
        TextView tvMolarMass = (TextView) findViewById(R.id.tvMolarMass_Result);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnHome = (Button) findViewById(R.id.btnHome);

        int ion = getIntent().getExtras().getInt("ion");
        int headIndex = getIntent().getExtras().getInt("headIndex");
        int baseIndex = getIntent().getExtras().getInt("baseIndex");
        int acylIndex = getIntent().getExtras().getInt("acylIndex");
        String ionSelected = getIntent().getExtras().getString("ionSelected");
        String headSelected = getIntent().getExtras().getString("headSelected");
        String baseSelected = getIntent().getExtras().getString("baseSelected");
        String acylSelected = getIntent().getExtras().getString("acylSelected");

        Calculations calc = new Calculations();

        double mass = calc.calculateSLBasicMass(headIndex, baseIndex, acylIndex);
        double molarMass = Math.round(calc.calculateFinalMass(ion, mass)*10000d)/10000d;
        String formula = calc.calculateFormula(calc.getNumC(), calc.getNumH(), calc.getNumO(), calc.getNumN(),
                calc.getNumAg(), calc.getNumLi(), calc.getNumNa(), calc.getNumK(), calc.getNumCl(),
                calc.getNumP(), calc.getNumS(), calc.getNumF());
        tvMolarMass.setText(String.format(Locale.ENGLISH,"% ,4f", molarMass));
        tvFormula.setText(formula);
        tvIonSelected.setText(ionSelected);
        tvHeadGroup.setText(headSelected);
        tvSphingoidBase.setText(baseSelected);
        tvNAcyl.setText(acylSelected);

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sphingolipids_Result_Activity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
