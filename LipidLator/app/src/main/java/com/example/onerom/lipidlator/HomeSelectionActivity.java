package com.example.onerom.lipidlator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class HomeSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_selection);

        ImageButton fattyAcids = (ImageButton) findViewById(R.id.imbtnFattyAcids);

        fattyAcids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeSelectionActivity.this, FattyAcidsActivity.class);
                startActivity(intent);
            }
        });

    }
}
