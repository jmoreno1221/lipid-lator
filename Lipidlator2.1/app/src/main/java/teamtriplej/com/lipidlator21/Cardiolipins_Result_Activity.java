package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Cardiolipins_Result_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiolipins__result_);
        TextView tvIonResult = (TextView) findViewById(R.id.tvIonResult);
        TextView tvSpn1Result = (TextView) findViewById(R.id.tvSn1_Result);
        TextView tvSpn2Result = (TextView) findViewById(R.id.tvSn1_3_Result);
        TextView tvSpn3Result = (TextView) findViewById(R.id.tvSn2_1_Result);
        TextView tvSpn4Result = (TextView) findViewById(R.id.tvSn2_3_Result);
        TextView tvMolarMassResult = (TextView) findViewById(R.id.tvMolarMass_Result);
        TextView tvAbbreviation = (TextView) findViewById(R.id.tvAbbreviation_Result);
        TextView tvFormulaResult = (TextView) findViewById(R.id.tvFormula_Result);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnHome = (Button) findViewById(R.id.btnHome);

        int ion = getIntent().getExtras().getInt("ion");
        int index1 = getIntent().getExtras().getInt("spn1Index");
        int index2 = getIntent().getExtras().getInt("spn2Index");
        int index3 = getIntent().getExtras().getInt("spn3Index");
        int index4 = getIntent().getExtras().getInt("spn4Index");
        String ionselected = getIntent().getExtras().getString("ionselected");
        String spn1selected = getIntent().getExtras().getString("spn1Selected");
        String spn2selected = getIntent().getExtras().getString("spn2Selected");
        String spn3selected = getIntent().getExtras().getString("spn3Selected");
        String spn4selected = getIntent().getExtras().getString("spn4Selected");
        Calculations calc = new Calculations();
        double mass = calc.calculateCLBasicMass(index1, index2, index3, index4);
        double molarMass = Math.round(calc.calculateFinalMass(ion, mass)*10000d)/10000d;
        String formula = calc.calculateFormula(calc.getNumC(), calc.getNumH(), calc.getNumO(), calc.getNumN(),
                calc.getNumAg(), calc.getNumLi(), calc.getNumNa(), calc.getNumK(), calc.getNumCl(),
                calc.getNumP(), calc.getNumS(), calc.getNumF());
        String formatted = String.format(Locale.ENGLISH,"% ,4f",molarMass).replace(",","");
        tvMolarMassResult.setText(formatted);
        tvFormulaResult.setText(formula);
        tvIonResult.setText(ionselected);
        tvSpn1Result.setText(spn1selected);
        tvSpn2Result.setText(spn2selected);
        tvSpn3Result.setText(spn3selected);
        tvSpn4Result.setText(spn4selected);
        tvAbbreviation.setText("CL(" + spn1selected + "/" + spn2selected + "/" + spn3selected
        + "/" + spn4selected + ")");

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cardiolipins_Result_Activity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}
