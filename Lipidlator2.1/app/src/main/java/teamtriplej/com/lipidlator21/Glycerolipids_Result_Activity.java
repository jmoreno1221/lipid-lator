package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Glycerolipids_Result_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glycerolipids_result);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnHome = (Button) findViewById(R.id.btnHome);
        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Glycerolipids_Result_Activity.this, GlycerolipidsActivity.class);
                startActivity(intent);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Glycerolipids_Result_Activity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
