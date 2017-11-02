package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class FattyAcids_Result_Activity extends AppCompatActivity {

    public String title = "Lipid-Lator";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatty_acids_result);

        ActionBar bar = getSupportActionBar();
        if (bar != null){
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#B5A10E")));
        }
        View view = getLayoutInflater().inflate(R.layout.action_bar, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);

        TextView Title = (TextView) view.findViewById(R.id.actionbar_title);
        Title.setText(title);
        Title.setTextColor(Color.parseColor("#FFFFFF"));

        getSupportActionBar().setCustomView(view,params);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        //Create an instance of each of the interactive things on our screen
        //for example in this case we have 2 buttons and 5 textviews
        TextView tvMolarMassResult = (TextView) findViewById(R.id.tvMolarMassResult);
        TextView tvFormulaResult = (TextView) findViewById(R.id.tvFormulaResult);
        TextView tvEsterSelected = (TextView) findViewById(R.id.tvEsterResult);
        TextView tvAcidSelected = (TextView) findViewById(R.id.tvAcidResult);
        TextView tvIonSelected = (TextView) findViewById(R.id.tvIonResult);
        TextView tvAbbreviation = (TextView) findViewById(R.id.tvAbbreviationResult);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnHome = (Button) findViewById(R.id.btnHome);
        //Bring over all of the additional data that was stored into the intent and
        //set them into new variables on this screen
        int ionIndex = getIntent().getExtras().getInt("ionIndex");
        int acidIndex = getIntent().getExtras().getInt("acidIndex");
        int esterIndex = getIntent().getExtras().getInt("esterIndex");
        String ionSelected = getIntent().getExtras().getString("ionSelected");
        String esterSelected = getIntent().getExtras().getString("esterSelected");
        String acidSelected = getIntent().getExtras().getString("acidSelected");
        //Create an instance of Calculations to be able to use all of the methods in calculations
        Calculations calc = new Calculations();
        //Call each calculation method which will mostly always be the calculateBasicMass
        //of your lipid, then calculateFinalMass to be able to bring in the ion that will
        //change the final mass of the basic mass, and finally the calculateFormula to be
        //able to create your formula string
        double mass = calc.calculateFABasicMass(acidIndex,esterIndex);
        double molarMass = Math.round(calc.calculateFinalMass(ionIndex, mass)*10000d)/10000d;
        String formula = calc.calculateFormula(calc.getNumC(), calc.getNumH(), calc.getNumO(), calc.getNumN(),
                calc.getNumAg(), calc.getNumLi(), calc.getNumNa(), calc.getNumK(), calc.getNumCl(),
                calc.getNumP(), calc.getNumS(), calc.getNumF());
        //Set all textviews from above to the newly calculated results
        tvMolarMassResult.setText(String.format(Locale.ENGLISH,"%.4f",molarMass));
        tvFormulaResult.setText(formula);
        tvIonSelected.setText(ionSelected);
        tvEsterSelected.setText(esterSelected);
        tvAcidSelected.setText(acidSelected);
        if(esterIndex == 0){tvAbbreviation.setText(acidSelected);}else
            tvAbbreviation.setText(acidSelected + " " + esterSelected);
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FattyAcids_Result_Activity.this, HomeActivity.class);
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
