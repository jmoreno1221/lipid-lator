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
import android.widget.Spinner;
import android.widget.TextView;

public class Glycerophospholipids_Activity extends AppCompatActivity {
    public int ionIndex, headGroupIndex, sn1_1Index, sn2_1Index;
    public String ionSelected, headGroupSelected, sn1_1Selected, sn2_1Selected;
    public String title = "Lipid-Lator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glycerophospholipids_);
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
        //for example in this case we have 2 buttons and 4 spinners

        final Spinner spnIon = (Spinner) findViewById(R.id.spnIon);
        final Spinner spnHeadGroup = (Spinner) findViewById(R.id.spnHeadGroup);
        final Spinner spnSn1_1 = (Spinner) findViewById(R.id.spnSn1_1);
        final Spinner spnSn2_1 = (Spinner) findViewById(R.id.spnSn2_1);

        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Retrieve all data from whatever is selected in each of the
                //spinners to set our variables to them.

                ionIndex = spnIon.getSelectedItemPosition();
                headGroupIndex = spnHeadGroup.getSelectedItemPosition();
                sn1_1Index = spnSn1_1.getSelectedItemPosition();
                sn2_1Index = spnSn2_1.getSelectedItemPosition();

                ionSelected = spnIon.getSelectedItem().toString();
                headGroupSelected = spnHeadGroup.getSelectedItem().toString();
                sn1_1Selected = spnSn1_1.getSelectedItem().toString();
                sn2_1Selected = spnSn2_1.getSelectedItem().toString();

                Intent intent = new Intent(Glycerophospholipids_Activity.this, Glycerophospholipids_Result_Activity.class);
                //After creating the intent to prepare to go to the next screen, before
                //we start the screen, we need to also add the variables above to our
                //intent to make sure we don't leave anything behind.
                intent.putExtra("ionIndex",ionIndex);
                intent.putExtra("headGroupIndex", headGroupIndex);
                intent.putExtra("sn1_1Index", sn1_1Index);
                intent.putExtra("sn2_1Index", sn2_1Index);
                intent.putExtra("ionSelected", ionSelected);
                intent.putExtra("headGroupSelected", headGroupSelected);
                intent.putExtra("sn1_1Selected", sn1_1Selected);
                intent.putExtra("sn2_1Selected", sn2_1Selected);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
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