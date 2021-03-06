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

public class Glycerophospholipids_Result_Activity extends AppCompatActivity {
    public String title = "Lipid-Lator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glycerophospholipids__result_);

        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3f51b5")));
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

        //Create an instance of each of the interactive things on our screen
        //for example in this case we have 2 buttons and 7 textViews
        TextView tvIon_result = (TextView) findViewById(R.id.tvIon_Result);
        TextView tvHeadGroup_Result = (TextView) findViewById(R.id.tvHeadGroup_Result);
        TextView tvSn1_Result= (TextView) findViewById(R.id.tvSn1_Result);
        TextView tvSn2_Result= (TextView) findViewById(R.id.tvSn2_Result);
        TextView tvAbbreviation_Result= (TextView) findViewById(R.id.tvAbbreviation_Result);
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

        double mass = calc.calculateGPBasicMass(headGroupIndex, sn1_1Index, sn2_1Index);
        double molarMass = Math.round(calc.calculateFinalMass(ion, mass)*10000d)/10000d;
        String formula = calc.calculateFormula(calc.getNumC(), calc.getNumH(), calc.getNumO(), calc.getNumN(),
                calc.getNumAg(), calc.getNumLi(), calc.getNumNa(), calc.getNumK(), calc.getNumCl(),
                calc.getNumP(), calc.getNumS(), calc.getNumF());
        String formatted = String.format(Locale.ENGLISH,"%.4f",molarMass).replace(",","");
        tvMolarMass_Result.setText(formatted);
        tvFormula_Result.setText(formula);
        tvIon_result.setText(ionSelected);
        tvHeadGroup_Result.setText(headGroupSelected);
        tvSn1_Result.setText(sn1_1Selected);
        tvSn2_Result.setText(sn2_1Selected);
        tvAbbreviation_Result.setText(headGroupSelected + "(" + sn1_1Selected + "/" + sn2_1Selected + ")");
        //tvIon_result.setText();
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Glycerophospholipids_Result_Activity.this, HomeActivity.class);
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
        }else if (id == R.id.menu_help){
            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
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