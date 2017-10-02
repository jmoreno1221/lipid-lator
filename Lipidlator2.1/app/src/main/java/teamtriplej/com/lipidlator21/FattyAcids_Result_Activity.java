package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FattyAcids_Result_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatty_acids_result);

        TextView tvMolarMassResult = (TextView) findViewById(R.id.tvMolarMassResult);
        TextView tvFormulaResult = (TextView) findViewById(R.id.tvFormulaResult);
        TextView tvEsterSelected = (TextView) findViewById(R.id.tvEsterResult);
        TextView tvIonSelected = (TextView) findViewById(R.id.tvIonResult);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnHome = (Button) findViewById(R.id.btnHome);

        //Bring over the data from previous screen
        int ion = getIntent().getExtras().getInt("ion");
        int massIndex = getIntent().getExtras().getInt("massIndex");
        int esterIndex = getIntent().getExtras().getInt("esterIndex");
        String ionSelected = getIntent().getExtras().getString("ionSelected");
        String esterSelected = getIntent().getExtras().getString("esterSelected");

        Calculations calc = new Calculations();
        double mass = calc.calculateFABasicMass(massIndex,esterIndex);
        double molarMass = Math.round(calc.calculateFinalMass(ion, mass)*10000d)/10000d;
        String formula = calc.calculateFormula(calc.getNumC(), calc.getNumH(), calc.getNumO(), calc.getNumN(),
                calc.getNumAg(), calc.getNumLi(), calc.getNumNa(), calc.getNumK(), calc.getNumCl(),
                calc.getNumP(), calc.getNumS(), calc.getNumF());

        //Set all results here
        tvMolarMassResult.setText(Double.toString(molarMass));
        tvFormulaResult.setText(formula);
        tvIonSelected.setText(ionSelected);
        tvEsterSelected.setText(esterSelected);


        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FattyAcids_Result_Activity.this, FattyAcidsActivity.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FattyAcids_Result_Activity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
