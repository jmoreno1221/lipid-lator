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

public class WaxEstersActivity extends AppCompatActivity {
    public int ion, alcoholIndex, acidIndex;
    public String ionSelected, alcoholSelected, acidSelected;
    public String title = "Lipid-Lator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wax_esters);
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2E6D27")));
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
        final Spinner spnI = (Spinner) findViewById(R.id.spnIon);
        final Spinner spnAc = (Spinner) findViewById(R.id.spnAcid);
        final Spinner spnAl = (Spinner) findViewById(R.id.spnAlcohol);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ion = spnI.getSelectedItemPosition();
                acidIndex = spnAc.getSelectedItemPosition();
                alcoholIndex = spnAl.getSelectedItemPosition();
                ionSelected = spnI.getSelectedItem().toString();
                alcoholSelected = spnAl.getSelectedItem().toString();
                acidSelected = spnAc.getSelectedItem().toString();
                Intent intent = new Intent(WaxEstersActivity.this, WaxEsters_Result_Activity.class);
                intent.putExtra("ion",ion);
                intent.putExtra("alcoholIndex", alcoholIndex);
                intent.putExtra("acidIndex", acidIndex);
                intent.putExtra("ionSelected",ionSelected);
                intent.putExtra("alcoholSelected",alcoholSelected);
                intent.putExtra("acidSelected", acidSelected);
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
