package com.example.onerom.lipidlator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Glycerophospholipids_Result_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glycerophospholipids__result_);

        Button home = (Button) findViewById(R.id.btnHome);
        Button back = (Button) findViewById(R.id.btnBack);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Glycerophospholipids_Result_Activity.this, HomeSelectionActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Glycerophospholipids_Result_Activity.this, Glycerophospholipids_activity.class);
                startActivity(intent);
            }
        });
    }
}
