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

import static teamtriplej.com.lipidlator21.R.id.spnIon;

public class GlycerolipidsActivity extends AppCompatActivity {

    // Variables
    public int ionIndex, sn1Index, sn2Index, sn3Index;
    public String ionSelected,sn1Selected, sn2Selected, sn3Selected;
    public String title = "Lipid-Lator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glycerolipids);
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
        // Spinners and Buttons
        final Spinner spnI = (Spinner) findViewById(spnIon);
        final Spinner spnSn1 = (Spinner) findViewById(R.id.spnSn1);
        final Spinner spnSn2 = (Spinner) findViewById(R.id.spnSn2);
        final Spinner spnSn3 = (Spinner) findViewById(R.id.spnSn3);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);

        // Submit Button
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Get spinners' data
                ionIndex = spnI.getSelectedItemPosition();
                sn1Index = spnSn1.getSelectedItemPosition();
                sn2Index = spnSn2.getSelectedItemPosition();
                sn3Index = spnSn3.getSelectedItemPosition();
                ionSelected = spnI.getSelectedItem().toString();
                sn1Selected = spnSn1.getSelectedItem().toString();
                sn2Selected = spnSn2.getSelectedItem().toString();
                sn3Selected = spnSn3.getSelectedItem().toString();
                Intent intent = new Intent(GlycerolipidsActivity.this, Glycerolipids_Result_Activity.class);

                // putExtra to transfer data to result screen activity
                intent.putExtra("ionIndex", ionIndex);
                intent.putExtra("sn1Index", sn1Index);
                intent.putExtra("sn2Index", sn2Index);
                intent.putExtra("sn3Index", sn3Index);
                intent.putExtra("ionSelected", ionSelected);
                intent.putExtra("sn1Selected", sn1Selected);
                intent.putExtra("sn2Selected", sn2Selected);
                intent.putExtra("sn3Selected", sn3Selected);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.menu_about){
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }



}
