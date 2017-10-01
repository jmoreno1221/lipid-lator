package teamtriplej.com.lipidlator21;

/**
 * Created by Jose Moreno on 10/1/2017.
 */

public class Calculations {
    public Calculations() {
    }

    public Calculations (double mass, int numC, int numH, int numO, int numN
            , int numAg, int numLi, int numNa, int numK, int numCl, int numP, int numS, int numF)
    {

    }
    public String calculateFormula(int numC, int numH, int numO, int numN
            , int numAg, int numLi, int numNa, int numK, int numCl, int numP, int numS, int numF)
    {
        String formula = "C" + numC + "H" + numH;
        if(numN == 1){formula+= "N";} else if(numN > 1){formula+= "N"+numN;}
        if(numO == 1){formula+= "O";} else if(numO > 1){formula+= "O"+numO;}
        if(numP == 1){formula+= "P";} else if(numP > 1){formula+= "P"+numP;}
        if(numS == 1){formula+= "S";} else if(numS > 1){formula+= "S"+numS;}
        if(numAg == 1){formula+= "Ag";} else if(numAg > 1){formula+= "Ag"+numAg;}
        if(numLi == 1){formula+= "Li";} else if(numLi > 1){formula+= "Li"+numLi;}
        if(numNa == 1){formula+= "Na";} else if(numNa > 1){formula+= "Na"+numNa;}
        if(numK == 1){formula+= "K";} else if(numK > 1){formula+= "K"+numK;}
        if(numCl == 1){formula+= "Cl";} else if(numCl > 1){formula+= "Cl"+numCl;}
        if(numF == 1){formula+= "F";} else if(numF > 1){formula+= "F"+numF;}
        return formula;
    }
    public double calculateFABasicMass(double basicMass, int massIndex, int ester, int numC, int numH, int numO)
    {
        if(massIndex == 0 && ester == 0){basicMass = 60.021130; numC = 2; numH = 4; numO = 2;}
        else if(massIndex == 1 && ester == 0){basicMass =60.021130;numC =2;numH =4;numO =2;}
        else if(massIndex == 2 && ester == 0){basicMass =88.052430;numC =4;numH =8;numO =2;}
        else if(massIndex == 3 && ester == 0){basicMass =116.083730;numC =6;numH =12;numO =2;}
        else if(massIndex == 4 && ester == 0){basicMass =144.115030;numC =8;numH =16;numO =2;}
        else if(massIndex == 5 && ester == 0){basicMass =172.146330;numC =10;numH =20;numO =2;}
        else if(massIndex == 6 && ester == 0){basicMass =200.177630;numC =12;numH =24;numO =2;}
        else if(massIndex == 7 && ester == 0){basicMass =214.193280;numC =13;numH =26;numO =2;}
        else if(massIndex == 8 && ester == 0){basicMass =228.208930;numC =14;numH =28;numO =2;}
        else if(massIndex == 9 && ester == 0){basicMass =226.193280;numC =14;numH =26;numO =2;}
        else if(massIndex == 10 && ester == 0){basicMass =242.224580;numC =15;numH =30;numO =2;}
        else if(massIndex == 11 && ester == 0){basicMass =240.208930;numC =15;numH =28;numO =2;}
        else if(massIndex == 12 && ester == 0){basicMass =256.240230;numC =16;numH =32;numO =2;}
        else if(massIndex == 13 && ester == 0){basicMass =254.224580;numC =16;numH =30;numO =2;}
        else if(massIndex == 14 && ester == 0){basicMass =270.255880;numC =17;numH =34;numO =2;}
        else if(massIndex == 15 && ester == 0){basicMass =268.240230;numC =17;numH =32;numO =2;}
        else if(massIndex == 16 && ester == 0){basicMass =266.224580;numC =17;numH =30;numO =2;}
        else if(massIndex == 17 && ester == 0){basicMass =284.271530;numC =18;numH =36;numO =2;}
        else if(massIndex == 18 && ester == 0){basicMass =282.255880;numC =18;numH =34;numO =2;}
        else if(massIndex == 19 && ester == 0){basicMass =282.255880;numC =18;numH =34;numO =2;}
        else if(massIndex == 20 && ester == 0){basicMass =280.240230;numC =18;numH =32;numO =2;}
        else if(massIndex == 21 && ester == 0){basicMass =278.224580;numC =18;numH =30;numO =2;}
        else if(massIndex == 22 && ester == 0){basicMass =278.224580;numC =18;numH =30;numO =2;}
        else if(massIndex == 23 && ester == 0){basicMass =276.208930;numC =18;numH =28;numO =2;}
        else if(massIndex == 24 && ester == 0){basicMass =298.287180;numC =19;numH =38;numO =2;}
        else if(massIndex == 25 && ester == 0){basicMass =312.302830;numC =20;numH =40;numO =2;}
        else if(massIndex == 26 && ester == 0){basicMass =310.287180;numC =20;numH =38;numO =2;}
        else if(massIndex == 27 && ester == 0){basicMass =308.271530;numC =20;numH =36;numO =2;}
        else if(massIndex == 28 && ester == 0){basicMass =306.255880;numC =20;numH =34;numO =2;}
        else if(massIndex == 29 && ester == 0){basicMass =304.240230;numC =20;numH =32;numO =2;}
        else if(massIndex == 30 && ester == 0){basicMass =302.224580;numC =20;numH =30;numO =2;}
        else if(massIndex == 31 && ester == 0){basicMass =326.318480;numC =21;numH =42;numO =2;}
        else if(massIndex == 32 && ester == 0){basicMass =340.334130;numC =22;numH =44;numO =2;}
        else if(massIndex == 33 && ester == 0){basicMass =338.318480;numC =22;numH =42;numO =2;}
        else if(massIndex == 34 && ester == 0){basicMass =336.302830;numC =22;numH =40;numO =2;}
        else if(massIndex == 35 && ester == 0){basicMass =334.287180;numC =22;numH =38;numO =2;}
        else if(massIndex == 36 && ester == 0){basicMass =332.271530;numC =22;numH =36;numO =2;}
        else if(massIndex == 37 && ester == 0){basicMass =330.255880;numC =22;numH =34;numO =2;}
        else if(massIndex == 38 && ester == 0){basicMass =328.240230;numC =22;numH =32;numO =2;}
        else if(massIndex == 39 && ester == 0){basicMass =354.349780;numC =23;numH =46;numO =2;}
        else if(massIndex == 40 && ester == 0){basicMass =368.365430;numC =24;numH =48;numO =2;}
        else if(massIndex == 41 && ester == 0){basicMass =366.349780;numC =24;numH =46;numO =2;}
        else if(massIndex == 42 && ester == 0){basicMass =382.381080;numC =25;numH =50;numO =2;}
        else if(massIndex == 43 && ester == 0){basicMass =396.396730;numC =26;numH =52;numO =2;}
        return basicMass;

    }
    public double calculateFinalMass(int ion, double basicMass, int numC, int numH, int numO, int numN
    , int numAg, int numLi, int numNa, int numK, int numCl)
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
}
