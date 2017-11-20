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

public class FattyAcidsActivity extends AppCompatActivity {
    //Create all the necessary variables
    public int ionIndex, esterIndex, acidIndex;
    public String ionSelected, esterSelected, acidSelected;
    public String title = "Lipid-Lator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatty_acids);
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
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
        getSupportActionBar().setDisplayShowCustomEnabled(true); //show custom title
        getSupportActionBar().setDisplayShowTitleEnabled(false); //hide the default title
        //Create an instance of each of the interactive things on our screen
        //for example in this case we have 2 buttons and 3 spinners
        final Spinner spnI = (Spinner) findViewById(R.id.spnIon);
        final Spinner spnA = (Spinner) findViewById(R.id.spnAcid);
        final Spinner spnE = (Spinner) findViewById(R.id.spnEster);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Retrieve all data from whatever is selected in each of the
                //spinners to set our variables to them.
                ionIndex = spnI.getSelectedItemPosition();
                acidIndex = spnA.getSelectedItemPosition();
                esterIndex = spnE.getSelectedItemPosition();
                ionSelected = spnI.getSelectedItem().toString();
                esterSelected = spnE.getSelectedItem().toString();
                acidSelected = spnA.getSelectedItem().toString();
                Intent intent = new Intent(FattyAcidsActivity.this, FattyAcids_Result_Activity.class);
                //After creating the intent to prepare to go to the next screen, before
                //we start the screen, we need to also add the variables above to our
                //intent to make sure we don't leave anything behind.
                intent.putExtra("ionIndex",ionIndex);
                intent.putExtra("acidIndex", acidIndex);
                intent.putExtra("esterIndex", esterIndex);
                intent.putExtra("ionSelected",ionSelected);
                intent.putExtra("esterSelected",esterSelected);
                intent.putExtra("acidSelected", acidSelected);
                //Once everything has been added to the intent, we can start the new screen
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
            // do something here
        }else if (id == R.id.menu_contact_us) {
            Intent intent = new Intent(this, Contact_Us_Activity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
