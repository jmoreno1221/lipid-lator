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

public class CoA_EstersActivity extends AppCompatActivity {

    // Declare variables
    public int ionIndex, acylIndex;
    public String ionSelected, acylSelected;
    public String title = "Lipid-Lator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_a_esters);
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#864499")));
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

        // Spinners
        final Spinner spnI = (Spinner) findViewById(R.id.spnIon);
        final Spinner spnAcyl = (Spinner) findViewById(R.id.spnAcylChain);

        // Buttons
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        // Actions by Submit Button
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Get index of current ion or acyl position
                ionIndex = spnI.getSelectedItemPosition();
                acylIndex = spnAcyl.getSelectedItemPosition();

                // Save selected element to String
                ionSelected = spnI.getSelectedItem().toString();
                acylSelected = spnAcyl.getSelectedItem().toString();

                // setIon and create intent
                Intent intent = new Intent(CoA_EstersActivity.this, CoA_Esters_Result_Activity.class);

                // putExtra to be able to transfer indexes & String values
                intent.putExtra("ionIndex", ionIndex);
                intent.putExtra("acylIndex", acylIndex);
                intent.putExtra("ionSelected", ionSelected);
                intent.putExtra("acylSelected", acylSelected);

                // Start Activity
                startActivity(intent);
            }
        });

        // Back Button Action When Clicked
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
