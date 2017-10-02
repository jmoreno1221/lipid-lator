package teamtriplej.com.lipidlator21;

/**
 * Created by Jose Moreno on 10/1/2017.
 */

public class Calculations {
    private double mass;
    private int numC, numH, numN, numO, numAg, numLi, numNa, numK, numCl, numP, numS, numF;
    public Calculations() {
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
    public double calculateFABasicMass(int massIndex, int ester)
    {
        if(massIndex == 0 && ester == 0){setMass(60.021130);setNumC(2);setNumH(4);setNumO(2);}
        else if(massIndex == 1 && ester == 0){setMass(88.052430);setNumC(4);setNumH(8);setNumO(2);}
        else if(massIndex == 2 && ester == 0){setMass(116.083730);setNumC(6);setNumH(12);setNumO(2);}
        else if(massIndex == 3 && ester == 0){setMass(144.115030);setNumC(8);setNumH(16);setNumO(2);}
        else if(massIndex == 4 && ester == 0){setMass(172.146330);setNumC(10);setNumH(20);setNumO(2);}
        else if(massIndex == 5 && ester == 0){setMass(200.177630);setNumC(12);setNumH(24);setNumO(2);}
        else if(massIndex == 6 && ester == 0){setMass(214.193280);setNumC(13);setNumH(26);setNumO(2);}
        else if(massIndex == 7 && ester == 0){setMass(228.208930);setNumC(14);setNumH(28);setNumO(2);}
        else if(massIndex == 8 && ester == 0){setMass(226.193280);setNumC(14);setNumH(26);setNumO(2);}
        else if(massIndex == 9 && ester == 0){setMass(242.224580);setNumC(15);setNumH(30);setNumO(2);}
        else if(massIndex == 10 && ester == 0){setMass(240.208930);setNumC(15);setNumH(28);setNumO(2);}
        else if(massIndex == 11 && ester == 0){setMass(256.240230);setNumC(16);setNumH(32);setNumO(2);}
        else if(massIndex == 12 && ester == 0){setMass(254.224580);setNumC(16);setNumH(30);setNumO(2);}
        else if(massIndex == 13 && ester == 0){setMass(270.255880);setNumC(17);setNumH(34);setNumO(2);}
        else if(massIndex == 14 && ester == 0){setMass(268.240230);setNumC(17);setNumH(32);setNumO(2);}
        else if(massIndex == 15 && ester == 0){setMass(266.224580);setNumC(17);setNumH(30);setNumO(2);}
        else if(massIndex == 16 && ester == 0){setMass(284.271530);setNumC(18);setNumH(36);setNumO(2);}
        else if(massIndex == 17 && ester == 0){setMass(282.255880);setNumC(18);setNumH(34);setNumO(2);}
        else if(massIndex == 18 && ester == 0){setMass(282.255880);setNumC(18);setNumH(34);setNumO(2);}
        else if(massIndex == 19 && ester == 0){setMass(280.240230);setNumC(18);setNumH(32);setNumO(2);}
        else if(massIndex == 20 && ester == 0){setMass(278.224580);setNumC(18);setNumH(30);setNumO(2);}
        else if(massIndex == 21 && ester == 0){setMass(278.224580);setNumC(18);setNumH(30);setNumO(2);}
        else if(massIndex == 22 && ester == 0){setMass(276.208930);setNumC(18);setNumH(28);setNumO(2);}
        else if(massIndex == 23 && ester == 0){setMass(298.287180);setNumC(19);setNumH(38);setNumO(2);}
        else if(massIndex == 24 && ester == 0){setMass(312.302830);setNumC(20);setNumH(40);setNumO(2);}
        else if(massIndex == 25 && ester == 0){setMass(310.287180);setNumC(20);setNumH(38);setNumO(2);}
        else if(massIndex == 26 && ester == 0){setMass(308.271530);setNumC(20);setNumH(36);setNumO(2);}
        else if(massIndex == 27 && ester == 0){setMass(306.255880);setNumC(20);setNumH(34);setNumO(2);}
        else if(massIndex == 28 && ester == 0){setMass(304.240230);setNumC(20);setNumH(32);setNumO(2);}
        else if(massIndex == 29 && ester == 0){setMass(302.224580);setNumC(20);setNumH(30);setNumO(2);}
        else if(massIndex == 30 && ester == 0){setMass(326.318480);setNumC(21);setNumH(42);setNumO(2);}
        else if(massIndex == 31 && ester == 0){setMass(340.334130);setNumC(22);setNumH(44);setNumO(2);}
        else if(massIndex == 32 && ester == 0){setMass(338.318480);setNumC(22);setNumH(42);setNumO(2);}
        else if(massIndex == 33 && ester == 0){setMass(336.302830);setNumC(22);setNumH(40);setNumO(2);}
        else if(massIndex == 34 && ester == 0){setMass(334.287180);setNumC(22);setNumH(38);setNumO(2);}
        else if(massIndex == 35 && ester == 0){setMass(332.271530);setNumC(22);setNumH(36);setNumO(2);}
        else if(massIndex == 36 && ester == 0){setMass(330.255880);setNumC(22);setNumH(34);setNumO(2);}
        else if(massIndex == 37 && ester == 0){setMass(328.240230);setNumC(22);setNumH(32);setNumO(2);}
        else if(massIndex == 38 && ester == 0){setMass(354.349780);setNumC(23);setNumH(46);setNumO(2);}
        else if(massIndex == 39 && ester == 0){setMass(368.365430);setNumC(24);setNumH(48);setNumO(2);}
        else if(massIndex == 40 && ester == 0){setMass(366.349780);setNumC(24);setNumH(46);setNumO(2);}
        else if(massIndex == 41 && ester == 0){setMass(382.381080);setNumC(25);setNumH(50);setNumO(2);}
        else if(massIndex == 42 && ester == 0){setMass(396.396730);setNumC(26);setNumH(52);setNumO(2);}
        return getMass();
    }
    public double calculateFinalMass(int ion, double basicMass)
    {
        if(ion == 0){basicMass+= 1.00727; setNumH(getNumH()+1);}
        else if(ion == 1){basicMass+= 1.00727 -(18.010565) ; setNumH(getNumH()-1); setNumO(getNumO()-1);}
        else if(ion == 2){basicMass = (2*(1.00727)+ basicMass)/2; setNumH(getNumH()+2);}
        else if(ion == 3){basicMass = (3*(1.00727)+ basicMass)/3; setNumH(getNumH()+3);}
        else if(ion == 4){basicMass = (4*(1.00727)+ basicMass)/4; setNumH(getNumH()+4);}
        else if(ion == 5){basicMass = 38.963708 - 0.000555 + basicMass; setNumK(getNumK()+1);}
        else if(ion == 6){basicMass = (2*(38.963708 - 0.000555) + basicMass)/2;  setNumK(getNumK()+2);}
        else if(ion == 7){basicMass = (2*(38.963708) - 0.000555 -1.007825) + basicMass; setNumK(getNumK()+2); setNumH(getNumH()-1);}
        else if(ion == 8){basicMass = 22.98977 - 0.000555 + basicMass; setNumNa(getNumNa()+1);}
        else if(ion == 9){basicMass = (2*(22.98977 - 0.000555) + basicMass)/2; setNumNa(getNumNa()+2);}
        else if(ion == 10){basicMass = (2*(22.98977) - 0.000555 -1.007825) + basicMass; setNumNa(getNumNa()+2); setNumH(getNumH()-1);}
        else if(ion == 11){basicMass = 7.016005  -0.000555 + basicMass; setNumLi(getNumLi()+1);}
        else if(ion == 12){basicMass = (2*(7.016005  -0.000555) + basicMass)/2; setNumLi(getNumLi()+2);}
        else if(ion == 13){basicMass = 106.905095 - 0.000555 + basicMass; setNumAg(getNumAg()+1);}
        else if(ion == 14){basicMass = (3*1.007825) + 1.00727 + 14.003074 + basicMass; setNumH(getNumH()+4);  setNumN(getNumN()+1);}
        else if(ion == 15){basicMass-= 1.00727; setNumH(getNumH()-1);}
        else if(ion == 16){basicMass = (-1.00727-(2*1.007825)-12) + basicMass; setNumH(getNumH()-3); setNumC(getNumC()-1);}
        else if(ion == 17){basicMass = (2*(-1.00727)+ basicMass)/2; setNumH(getNumH()-2);}
        else if(ion == 18){basicMass = (3*(-1.00727)+ basicMass)/3; setNumH(getNumH()-3);}
        else if(ion == 19){basicMass = (4*(-1.00727)+ basicMass)/4; setNumH(getNumH()-4);}
        else if(ion == 20){basicMass = 34.968853 + 0.000555 + basicMass;  setNumCl(getNumCl()+1);}
        else if(ion == 21){basicMass = 59.013305 + 0.000555 + basicMass;  setNumC(getNumC()+2);  setNumH(getNumH()+3);  setNumO(getNumO()+2);}
        else if(ion == 22){basicMass = 44.997655 + 0.000555 + basicMass;  setNumC(getNumC()+1);  setNumH(getNumH()+1);  setNumO(getNumO()+2);}
        return basicMass;
    }

    public double getMass() {
        return mass;
    }

    public int getNumC() {
        return numC;
    }

    public int getNumH() {
        return numH;
    }

    public int getNumN() {
        return numN;
    }

    public int getNumO() {
        return numO;
    }

    public int getNumAg() {
        return numAg;
    }

    public int getNumLi() {
        return numLi;
    }

    public int getNumNa() {
        return numNa;
    }

    public int getNumK() {
        return numK;
    }

    public int getNumCl() {
        return numCl;
    }

    public int getNumP() {
        return numP;
    }

    public int getNumS() {
        return numS;
    }

    public int getNumF() {
        return numF;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setNumC(int numC) {
        this.numC = numC;
    }

    public void setNumH(int numH) {
        this.numH = numH;
    }

    public void setNumN(int numN) {
        this.numN = numN;
    }

    public void setNumO(int numO) {
        this.numO = numO;
    }

    public void setNumAg(int numAg) {
        this.numAg = numAg;
    }

    public void setNumLi(int numLi) {
        this.numLi = numLi;
    }

    public void setNumNa(int numNa) {
        this.numNa = numNa;
    }

    public void setNumK(int numK) {
        this.numK = numK;
    }

    public void setNumCl(int numCl) {
        this.numCl = numCl;
    }

    public void setNumP(int numP) {
        this.numP = numP;
    }

    public void setNumS(int numS) {
        this.numS = numS;
    }

    public void setNumF(int numF) {
        this.numF = numF;
    }
}
