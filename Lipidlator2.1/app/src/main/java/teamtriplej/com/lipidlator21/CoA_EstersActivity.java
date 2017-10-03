package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CoA_EstersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_a_esters);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoA_EstersActivity.this, CoA_Esters_Result_Activity.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoA_EstersActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
