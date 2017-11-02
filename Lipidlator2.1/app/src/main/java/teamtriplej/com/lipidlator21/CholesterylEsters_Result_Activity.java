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


public class CholesterylEsters_Result_Activity extends AppCompatActivity {
    public String title = "Lipid-Lator";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cholesteryl_esters__result_);

        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#844007")));
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
        getSupportActionBar().setDisplayShowCustomEnabled(true); //show custom title
        getSupportActionBar().setDisplayShowTitleEnabled(false); //hide the default title

        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnHome = (Button) findViewById(R.id.btnHome);

        TextView ionResult = (TextView) findViewById(R.id.tvIonResult);
        TextView acylResult = (TextView) findViewById(R.id.tvAcylChainResult);
        TextView abbreviationResult = (TextView) findViewById(R.id.tvAbbreviationResult);
        TextView formulaResult = (TextView) findViewById(R.id.tvFormulaResult);
        TextView molarMassResult = (TextView) findViewById(R.id.tvMolarMassResult);

        int ion = getIntent().getExtras().getInt("ionIndex");
        int acyl = getIntent().getExtras().getInt("acylIndex");
        String ionSelected = getIntent().getExtras().getString("ionSelected");
        String acylSelected = getIntent().getExtras().getString("acylSelected");
        Calculations calc = new Calculations();
        double mass = calc.calculateCHEBasicMass(acyl);

        double molarMass = Math.round(calc.calculateFinalMass(ion, mass)*10000d)/10000d;
        String formula = calc.calculateFormula(calc.getNumC(), calc.getNumH(), calc.getNumO(), calc.getNumN(),
                calc.getNumAg(), calc.getNumLi(), calc.getNumNa(), calc.getNumK(), calc.getNumCl(),
                calc.getNumP(), calc.getNumS(), calc.getNumF());
        molarMassResult.setText(Double.toString(molarMass));
        formulaResult.setText(formula);
        ionResult.setText(ionSelected);
        acylResult.setText(acylSelected);
        abbreviationResult.setText("CE(" + acylSelected + ")");

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CholesterylEsters_Result_Activity.this, HomeActivity.class);
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
