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
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    public String title = "Lipid-Lator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun", true);
        if (firstrun){
            //... Display the dialog message here ...
            Alert alert = new Alert();
            alert.show(getFragmentManager(),"hello");
            // Save the state
            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("firstrun", false)
                    .apply();
        }

        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
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

        ImageButton fattyAcids = (ImageButton) findViewById(R.id.imbtnFattyAcids);

        fattyAcids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, FattyAcidsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton waxEsters = (ImageButton) findViewById(R.id.imbtnWaxEsters);

        waxEsters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, WaxEstersActivity.class);
                startActivity(intent);
            }
        });

        ImageButton acylCarnitines = (ImageButton) findViewById(R.id.imbtnAcylCarnitines);

        acylCarnitines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AcylCarnitinesActivity.class);
                startActivity(intent);
            }
        });

        ImageButton coA_Esters = (ImageButton) findViewById(R.id.imbtnCoAEsters);

        coA_Esters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CoA_EstersActivity.class);
                startActivity(intent);
            }
        });

        ImageButton glycerolipids = (ImageButton) findViewById(R.id.imbtnGlycerolipids);

        glycerolipids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, GlycerolipidsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton cholesterylEsters = (ImageButton) findViewById(R.id.imbtnCholesterylEsters);

        cholesterylEsters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CholesterylEstersActivity.class);
                startActivity(intent);
            }
        });

        ImageButton sphingolipids = (ImageButton) findViewById(R.id.imbtnSphingolipids);

        sphingolipids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Sphingolipids_Activity.class);
                startActivity(intent);
            }
        });

        ImageButton cardiolipins = (ImageButton) findViewById(R.id.imbtnCardiolipins);

        cardiolipins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CardiolipinsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton glycerophospholipids = (ImageButton) findViewById(R.id.imbtnGlycerophospholipids);

        glycerophospholipids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Glycerophospholipids_Activity.class);
                startActivity(intent);
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
