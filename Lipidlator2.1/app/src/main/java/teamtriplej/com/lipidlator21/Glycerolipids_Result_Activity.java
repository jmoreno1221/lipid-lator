package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Glycerolipids_Result_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glycerolipids_result);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnHome = (Button) findViewById(R.id.btnHome);

        // TextView
        TextView ionResult = (TextView) findViewById(R.id.tvIonResult);
        TextView molarMassResult = (TextView) findViewById(R.id.tvMolarMassResult);
        TextView formulaResult = (TextView) findViewById(R.id.tvFormulaResult);
        TextView abvResult = (TextView) findViewById(R.id.tvAbbreviationResult);
        TextView sn1Result = (TextView) findViewById(R.id.tvSn1Result);
        TextView sn2Result = (TextView) findViewById(R.id.tvSn2Result);
        TextView sn3Result = (TextView) findViewById(R.id.tvSn3Result);

        // Get Extras
        int ionIndex = getIntent().getExtras().getInt("ionIndex");
        int sn1Index = getIntent().getExtras().getInt("sn1Index");
        int sn2Index = getIntent().getExtras().getInt("sn2Index");
        int sn3Index = getIntent().getExtras().getInt("sn3Index");
        String ionSelected = getIntent().getExtras().getString("ionSelected");
        String sn1Selected = getIntent().getExtras().getString("sn1Selected");
        String sn2Selected = getIntent().getExtras().getString("sn2Selected");
        String sn3Selected = getIntent().getExtras().getString("sn3Selected");

        Calculations calc = new Calculations();
        double mass = calc.calculateGLBasicMass(sn1Index, sn2Index, sn3Index);
        double molarMass = Math.round(calc.calculateFinalMass(ionIndex, mass) * 10000d) / 10000d;
        String formula = calc.calculateFormula(calc.getNumC(), calc.getNumH(), calc.getNumO(), calc.getNumN(),
                calc.getNumAg(), calc.getNumLi(), calc.getNumNa(), calc.getNumK(), calc.getNumCl(),
                 calc.getNumP(), calc.getNumS(), calc.getNumF());

        // Set Text
        ionResult.setText(ionSelected);
        sn1Result.setText(sn1Selected);
        sn2Result.setText(sn2Selected);
        sn3Result.setText(sn3Selected);
        abvResult.setText("TG(" + sn1Selected + "/" + sn2Selected + "/" + sn3Selected + ")");
        formulaResult.setText(formula);
        molarMassResult.setText(Double.toString(molarMass));

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Glycerolipids_Result_Activity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
