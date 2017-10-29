package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Glycerophospholipids_Result_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glycerophospholipids__result_);
        //Create an instance of each of the interactive things on our screen
        //for example in this case we have 2 buttons and 7 textviews
        TextView tvIon_result = (TextView) findViewById(R.id.tvIon_Result);
        TextView tvHeadGroup_Result = (TextView) findViewById(R.id.tvHeadGroup_Result);
        TextView tvSn1_Result= (TextView) findViewById(R.id.tvSn1_Result);
        TextView tvSn2_Result= (TextView) findViewById(R.id.tvSn2_Result);
        TextView Abbreviation_Result= (TextView) findViewById(R.id.tvAbbreviation_Result);
        TextView tvMolarMass_Result= (TextView) findViewById(R.id.tvMolarMass_Result);
        TextView tvFormula_Result= (TextView) findViewById(R.id.tvFormula_Result);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnHome = (Button) findViewById(R.id.btnHome);

        //Bring over all of the additional data that was stored into the intent and
        //set them into new variables on this screen

        int ion = getIntent().getExtras().getInt("ionIndex");
        int headGroupIndex = getIntent().getExtras().getInt("headGroupIndex");
        int sn1_1Index = getIntent().getExtras().getInt("sn1_1Index");
        int sn2_1Index = getIntent().getExtras().getInt("sn2_1Index");

        String ionSelected = getIntent().getExtras().getString("ionSelected");
        String headGroupSelected = getIntent().getExtras().getString("headGroupSelected");
        String sn1_1Selected = getIntent().getExtras().getString("sn1_1Selected");
        String sn2_1Selected = getIntent().getExtras().getString("sn2_1Selected");

        //Create an instance of Calculations to be able to use all of the methods in calculations
        Calculations calc = new Calculations();
        //Call each calculation method which will mostly always be the calculateBasicMass
        //of your lipid, then calculateFinalMass to be able to bring in the ion that will
        //change the final mass of the basic mass, and finally the calculateFormula to be
        //able to create your formula string

        double mass = calc.calculateGPBasicMass(ion, headGroupIndex, sn1_1Index, sn1_1Index);
        double molarMass = Math.round(calc.calculateFinalMass(ion, mass)*10000d)/10000d;
        String formula = calc.calculateFormula(calc.getNumC(), calc.getNumH(), calc.getNumO(), calc.getNumN(),
                calc.getNumAg(), calc.getNumLi(), calc.getNumNa(), calc.getNumK(), calc.getNumCl(),
                calc.getNumP(), calc.getNumS(), calc.getNumF());
        String formatted = String.format(Locale.ENGLISH,"% ,4f",molarMass).replace(",","");

        //tvIon_result.setText();
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Glycerophospholipids_Result_Activity.this, Glycerophospholipids_Activity.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Glycerophospholipids_Result_Activity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}