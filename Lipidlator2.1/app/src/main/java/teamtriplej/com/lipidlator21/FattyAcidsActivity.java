package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import static teamtriplej.com.lipidlator21.R.id.spnIon;

public class FattyAcidsActivity extends AppCompatActivity {

    public int ion;
    public double basicMass = 60.02;
    private int numC, numH, numO, numN, numP, numAg,numS, numLi, numNa, numK, numCl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatty_acids);

        final Spinner spnI = (Spinner) findViewById(spnIon);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);


        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ion = spnI.getSelectedItemPosition();
                setIon(ion);
                Intent intent = new Intent(FattyAcidsActivity.this, FattyAcids_Result_Activity.class);
                intent.putExtra("ion",getIon());
                startActivity(intent);

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FattyAcidsActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });




    }


    public double calculateMass(int ion)
    {
        if(ion == 0){basicMass+= 1.00727; numH++;}
        else if(ion == 1){basicMass+= 1.00727 -(18.010565) ; numH--; numO--;}
        else if(ion == 2){basicMass = (2*(1.00727)+ basicMass)/2; numH+=2;}
        else if(ion == 3){basicMass = (3*(1.00727)+ basicMass)/3; numH+=3;}
        else if(ion == 4){basicMass = (4*(1.00727)+ basicMass)/4; numH+=4;}
        else if(ion == 5){basicMass = 38.963708 - 0.000555 + basicMass; numK++;}
        else if(ion == 6){basicMass = (2*(38.963708 - 0.000555) + basicMass)/2;  numK+=2;}
        else if(ion == 7){basicMass = (2*(38.963708) - 0.000555 -1.007825) + basicMass; numK+=2; numH--;}
        else if(ion == 8){basicMass = 22.98977 - 0.000555 + basicMass; numNa++;}
        else if(ion == 9){basicMass = (2*(22.98977 - 0.000555) + basicMass)/2; numNa+=2;}
        else if(ion == 10){basicMass = (2*(22.98977) - 0.000555 -1.007825) + basicMass; numNa+=2; numH--;}
        else if(ion == 11){basicMass = 7.016005  -0.000555 + basicMass; numLi++;}
        else if(ion == 12){basicMass = (2*(7.016005  -0.000555) + basicMass)/2; numLi+=2;}
        else if(ion == 13){basicMass = 106.905095 - 0.000555 + basicMass; numAg++;}
        else if(ion == 14){basicMass = (3*1.007825) + 1.00727 + 14.003074 + basicMass; numH+=4;  numN++;}
        else if(ion == 15){basicMass-= 1.00727; numH --;}
        else if(ion == 16){basicMass = (-1.00727-(2*1.007825)-12) + basicMass; numH-=3; numC--;}
        else if(ion == 17){basicMass = (2*(-1.00727)+ basicMass)/2; numH-=2;}
        else if(ion == 18){basicMass = (3*(-1.00727)+ basicMass)/3; numH-=3;}
        else if(ion == 19){basicMass = (4*(-1.00727)+ basicMass)/4; numH-=4;}
        else if(ion == 20){basicMass = 34.968853 + 0.000555 + basicMass;  numCl++;}
        else if(ion == 21){basicMass = 59.013305 + 0.000555 + basicMass;  numC+=2;  numH+=3;  numO+=2;}
        else if(ion == 22){basicMass = 44.997655 + 0.000555 + basicMass;  numC++;  numH++;  numO+=2;}
        return basicMass;
    }

    public void setIon(int ion2)
    {
        ion = ion2;
    }
    public int getIon()
    {
        return ion;
    }
}
