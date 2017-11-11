package teamtriplej.com.lipidlator21;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Jose Moreno on 11/11/2017.
 */

public class HelpPopup extends AppCompatActivity{
    public void showHelpPopup(){
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("AlertDialog");
        builder.setMessage("Would you like to continue learning how to use Android alerts?");

        // add the buttons
        builder.setPositiveButton("Continue", null);
        builder.setNegativeButton("Cancel", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

