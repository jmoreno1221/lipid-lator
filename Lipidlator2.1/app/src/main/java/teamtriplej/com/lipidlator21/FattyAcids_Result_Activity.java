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

        FattyAcidsActivity fa = new FattyAcidsActivity();
        double molarMass = Math.round(fa.calculateMass(ion)*10000d)/10000d;
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
