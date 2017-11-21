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

public class Sphingolipids_Result_Activity extends AppCompatActivity {
    public String title = "Lipid-Lator";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphingolipids__result_);

        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1b738e")));
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

        TextView tvIonSelected = (TextView) findViewById(R.id.tvIonResult);
        TextView tvHeadGroup = (TextView) findViewById(R.id.tvHeadGroupResult);
        TextView tvSphingoidBase = (TextView) findViewById(R.id.tvSphingoidBaseResult);
        TextView tvNAcyl = (TextView) findViewById(R.id.tvNAcyl_Result);
        TextView tvAbbreviationResult = (TextView) findViewById(R.id.tvAbbreviation_Result);
        TextView tvFormula = (TextView) findViewById(R.id.tvFormula_Result);
        TextView tvMolarMass = (TextView) findViewById(R.id.tvMolarMass_Result);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnHome = (Button) findViewById(R.id.btnHome);

        int ion = getIntent().getExtras().getInt("ion");
        int headIndex = getIntent().getExtras().getInt("headIndex");
        int baseIndex = getIntent().getExtras().getInt("baseIndex");
        int acylIndex = getIntent().getExtras().getInt("acylIndex");
        String ionSelected = getIntent().getExtras().getString("ionSelected");
        String headSelected = getIntent().getExtras().getString("headSelected");
        String baseSelected = getIntent().getExtras().getString("baseSelected");
        String acylSelected = getIntent().getExtras().getString("acylSelected");

        Calculations calc = new Calculations();

        double mass = calc.calculateSLBasicMass(headIndex, baseIndex, acylIndex);
        double molarMass = Math.round(calc.calculateFinalMass(ion, mass)*10000d)/10000d;
        String formula = calc.calculateFormula(calc.getNumC(), calc.getNumH(), calc.getNumO(), calc.getNumN(),
                calc.getNumAg(), calc.getNumLi(), calc.getNumNa(), calc.getNumK(), calc.getNumCl(),
                calc.getNumP(), calc.getNumS(), calc.getNumF());
        tvMolarMass.setText(String.format(Locale.ENGLISH,"%.4f", molarMass));
        tvFormula.setText(formula);
        tvIonSelected.setText(ionSelected);
        tvHeadGroup.setText(headSelected);
        tvSphingoidBase.setText(baseSelected);
        tvNAcyl.setText(acylSelected);
        tvAbbreviationResult.setText(headSelected + "(" + baseSelected + "/" + acylSelected + ")");
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sphingolipids_Result_Activity.this, HomeActivity.class);
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
        }else if (id == R.id.menu_help){
            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
            // do something here
        }else if (id == R.id.menu_contact_us) {
            Intent intent = new Intent(this, Contact_Us_Activity.class);
            startActivity(intent);
        } else if (id == R.id.menu_more_info){
            Intent intent = new Intent(this, MoreInfoActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
