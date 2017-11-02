package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class WaxEsters_Result_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wax_esters_result);
        TextView tvMolarMassResult = (TextView) findViewById(R.id.tvMolarMassResult);
        TextView tvFormulaResult = (TextView) findViewById(R.id.tvFormulaResult);
        TextView tvAlcoholResult = (TextView) findViewById(R.id.tvAlcoholResult);
        TextView tvAcidResult = (TextView) findViewById(R.id.tvAcidResult);
        TextView tvIonSelected = (TextView) findViewById(R.id.tvIonResult);
        TextView tvAbbreviation = (TextView) findViewById(R.id.tvAbbreviationResult);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnHome = (Button) findViewById(R.id.btnHome);
        //Bring over the data from previous screen
        int ion = getIntent().getExtras().getInt("ion");
        int alcoholIndex = getIntent().getExtras().getInt("alcoholIndex");
        int acidIndex = getIntent().getExtras().getInt("acidIndex");
        String ionSelected = getIntent().getExtras().getString("ionSelected");
        String alcoholSelected = getIntent().getExtras().getString("alcoholSelected");
        String acidSelected = getIntent().getExtras().getString("acidSelected");
      //  Toast.makeText(this, acidSelected, Toast.LENGTH_SHORT).show();
        Calculations calc = new Calculations();
        double mass = calc.calculateWEBasicMass(alcoholIndex,acidIndex);
        double molarMass = Math.round(calc.calculateFinalMass(ion, mass)*10000d)/10000d;
        String formula = calc.calculateFormula(calc.getNumC(), calc.getNumH(), calc.getNumO(), calc.getNumN(),
                calc.getNumAg(), calc.getNumLi(), calc.getNumNa(), calc.getNumK(), calc.getNumCl(),
                calc.getNumP(), calc.getNumS(), calc.getNumF());
        tvMolarMassResult.setText(String.format(Locale.ENGLISH,"% ,4f",molarMass));
        tvFormulaResult.setText(formula);
        tvIonSelected.setText(ionSelected);
        tvAlcoholResult.setText(alcoholSelected);
        tvAcidResult.setText(acidSelected);
        tvAbbreviation.setText("WE(" + alcoholSelected + "/" + acidSelected + ")");

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WaxEsters_Result_Activity.this,HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }

    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            // do something here
        }
        return super.onOptionsItemSelected(item);
    }
}
