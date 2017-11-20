package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Contact_Us_Activity extends AppCompatActivity {

    public String title = "Contact Us";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__us_);
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
        Title.setTextSize(36);

        getSupportActionBar().setCustomView(view, params);
        getSupportActionBar().setDisplayShowCustomEnabled(true); //show custom title
        getSupportActionBar().setDisplayShowTitleEnabled(false); //hide the default title


        Button btnGotIt = (Button) findViewById(R.id.btnGotIt);

        btnGotIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button btnRateUs = (Button) findViewById(R.id.btnRateUs);

        btnRateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String YourPageURL = "https://www.facebook.com/groups/1464257160356520/";
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(YourPageURL));
//
//                startActivity(browserIntent);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps?hl=en")));

//                try {
//                    Uri uri = Uri.parse("market://details?id=" + getPackageName());
//                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(goToMarket);
//                } catch (ActivityNotFoundException e) {
//                    startActivity(new Intent(Intent.ACTION_VIEW,
//                          //  Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName()
//                            Uri.parse( "https://play.google.com/store/apps?hl=en" + getPackageName()
//                            )));
//                }
            }
        });

        Button btnFB = (Button) findViewById(R.id.btnFB);
        btnFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String YourPageURL = "https://www.facebook.com/groups/1464257160356520/";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(YourPageURL));

                startActivity(browserIntent);
            }
        });
    }
}