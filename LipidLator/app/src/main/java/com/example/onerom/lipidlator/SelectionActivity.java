package com.example.onerom.lipidlator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class SelectionActivity extends AppCompatActivity {

    private Button ce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ce = (Button)findViewById(R.id.btnBotRight);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

       /* ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(SelectionActivity.this, CholesterolEstersActivity.class);
                startActivity(j);
            }
        }); */
    }
}
