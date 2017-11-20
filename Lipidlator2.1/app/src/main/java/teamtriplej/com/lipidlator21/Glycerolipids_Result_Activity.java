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

public class Glycerolipids_Result_Activity extends AppCompatActivity {
    public String title = "Lipid-Lator";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glycerolipids_result);

        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#d87c2b")));
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
        String formatted = String.format(Locale.ENGLISH,"%.4f",molarMass).replace(",","");

        // Set Text
        ionResult.setText(ionSelected);
        sn1Result.setText(sn1Selected);
        sn2Result.setText(sn2Selected);
        sn3Result.setText(sn3Selected);
        abvResult.setText("TG(" + sn1Selected + "/" + sn2Selected + "/" + sn3Selected + ")");
        formulaResult.setText(formula);
        molarMassResult.setText(formatted);

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
        }else if (id == R.id.menu_contact_us) {
            Intent intent = new Intent(this, Contact_Us_Activity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
