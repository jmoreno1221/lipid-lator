package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Loading extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        tv = (TextView) findViewById(R.id.appTitle);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        tv.startAnimation(animation);
        final Intent i = new Intent(this, HomeActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(1750);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally{
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
