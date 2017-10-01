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
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnHome = (Button) findViewById(R.id.btnHome);
        int ion = getIntent().getExtras().getInt("ion");
        int massIndex = getIntent().getExtras().getInt("massIndex");
        int esterIndex = getIntent().getExtras().getInt("esterIndex");

        Calculations calc = new Calculations();
        double mass = calc.calculateFABasicMass(0,massIndex,esterIndex,0,0,0);
        double molarMass = Math.round(calc.calculateFinalMass(ion, mass,0,0,0,0,0,0,0,0,0)*10000d)/10000d;
        tvMolarMassResult.setText(Double.toString(molarMass));


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
