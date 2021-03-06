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

public class CardiolipinsActivity extends AppCompatActivity {
    public int ion, spn1Index, spn2Index, spn3Index, spn4Index;
    public String ionSelected, spn1Selected, spn2Selected, spn3Selected, spn4Selected;
    public String title = "Lipid-Lator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiolipins);
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#AA3939")));
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
        final Spinner spnIon = (Spinner) findViewById(R.id.spnIon);
        final Spinner spnSn1 = (Spinner) findViewById(R.id.spnSn1);
        final Spinner spnSn1_3 = (Spinner) findViewById(R.id.spnSn1_3);
        final Spinner spnSn2_1 = (Spinner) findViewById(R.id.spnSn2_1);
        final Spinner spnSn2_3 = (Spinner) findViewById(R.id.spnSn2_3);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ion = spnIon.getSelectedItemPosition();
                spn1Index = spnSn1.getSelectedItemPosition();
                spn2Index = spnSn1_3.getSelectedItemPosition();
                spn3Index = spnSn2_1.getSelectedItemPosition();
                spn4Index = spnSn2_3.getSelectedItemPosition();
                ionSelected = spnIon.getSelectedItem().toString();
                spn1Selected = spnSn1.getSelectedItem().toString();
                spn2Selected = spnSn1_3.getSelectedItem().toString();
                spn3Selected = spnSn2_1.getSelectedItem().toString();
                spn4Selected = spnSn2_3.getSelectedItem().toString();
                Intent intent = new Intent(CardiolipinsActivity.this, Cardiolipins_Result_Activity.class);
                intent.putExtra("ion", ion);
                intent.putExtra("spn1Index", spn1Index);
                intent.putExtra("spn2Index", spn2Index);
                intent.putExtra("spn3Index", spn3Index);
                intent.putExtra("spn4Index", spn4Index);
                intent.putExtra("ionselected", ionSelected);
                intent.putExtra("spn1Selected", spn1Selected);
                intent.putExtra("spn2Selected", spn2Selected);
                intent.putExtra("spn3Selected", spn3Selected);
                intent.putExtra("spn4Selected", spn4Selected);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
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
