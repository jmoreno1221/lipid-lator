package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
                Intent intent = new Intent(HomeActivity.this, Cardiolipins.class);
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
}
