package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static teamtriplej.com.lipidlator21.R.id.btnBack;

public class Cardiolipins_Result_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiolipins__result_);

        TextView tvIonResult = (TextView) findViewById(R.id.tvIonResult);
        TextView tvSpn1Result = (TextView) findViewById(R.id.tvSn1Result);
        TextView tvSpn2Result = (TextView) findViewById(R.id.tvSn1)
        Button btnBack = (Button) findViewById(btnBack);
        Button btnHome = (Button) findViewById(R.id.btnHome);

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cardiolipins_Result_Activity.this, CardiolipinsActivity.class);
                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cardiolipins_Result_Activity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
