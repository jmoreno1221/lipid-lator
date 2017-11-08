package teamtriplej.com.lipidlator21;

/**
 * Created by Jose Moreno on 10/1/2017
 */

class Calculations {
    private double mass;
    private int numC, numH, numN, numO, numAg, numLi, numNa, numK, numCl, numP, numS, numF;
    Calculations() {
    }
    String calculateFormula(int numC, int numH, int numO, int numN
            , int numAg, int numLi, int numNa, int numK, int numCl, int numP, int numS, int numF)
    {
        String SUB_ZERO = "\u2080";String SUB_FIVE = "\u2085";
        String SUB_ONE = "\u2081";String SUB_SIX = "\u2086";
        String SUB_TWO = "\u2082";String SUB_SEVEN = "\u2087";
        String SUB_THREE = "\u2083";String SUB_EIGHT = "\u2088";
        String SUB_FOUR = "\u2084";String SUB_NINE = "\u2089";
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
        return formula.replaceAll("0", SUB_ZERO).replaceAll("1", SUB_ONE)
                .replaceAll("2", SUB_TWO).replaceAll("3", SUB_THREE).replaceAll("4", SUB_FOUR)
                .replaceAll("5", SUB_FIVE).replaceAll("6", SUB_SIX).replaceAll("7", SUB_SEVEN)
                .replaceAll("8", SUB_EIGHT).replaceAll("9", SUB_NINE);
    }
    double calculateFABasicMass(int massIndex, int esterIndex)
    {
        int[] esterArray1 = {2,4,4,8,6,12,8,16,10,20,12,24,13,26,14,28,14,26,15,30,15,
                28,16,32,16,30,17,34,17,32,17,30,18,36,18,34,18,34,18,32,18,30,18,30,
                18,28,19,38,20,40,20,38,20,36,20,34,20,32,20,30,21,42,22,44,22,42,22,
                40,22,38,22,36,22,34,22,32,23,46,24,48,24,46,25,50,26,52};
        int[] esterArray2 = {3,6,5,10,7,14,9,18,11,22,13,26,14,28,15,30,15,28,16,32,16,
                30,17,34,17,32,18,36,18,34,18,32,19,38,19,36,19,36,19,34,19,32,19,32,19,
                30,20,40,21,42,21,40,21,38,21,36,21,34,21,32,22,44,23,46,23,44,23,42,23,
                40,23,38,23,36,23,34,24,48,25,50,25,48,26,52,27,54};
        int[] esterArray3 = {9,5,11,9,13,13,15,17,17,21,19,25,20,27,21,29,21,27,22,31,22,
                29,23,33,23,31,24,35,24,33,24,31,25,37,25,35,25,35,25,33,25,31,25,31,25,
                29,26,39,27,41,27,39,27,37,27,35,27,33,27,31,28,43,29,45,29,43,29,41,29,
                39,29,37,29,35,29,33,30,47,31,49,31,47,32,51,33,53};
        if(esterIndex == 0){
            setNumC(esterArray1[(massIndex * 2)]);
            setNumH(esterArray1[(massIndex * 2)+1]);
            setNumO(2);
        }else if(esterIndex == 1){
            setNumC(esterArray2[(massIndex * 2)]);
            setNumH(esterArray2[(massIndex * 2)+1]);
            setNumO(2);
        }else if(esterIndex == 2){
            setNumC(esterArray3[(massIndex * 2)]);
            setNumH(esterArray3[(massIndex * 2)+1]);
            setNumO(2);
            setNumF(5);}
        setMass(calculateInitialMass(getNumC(), getNumH(), getNumO(), getNumN(),
                getNumAg(), getNumLi(), getNumNa(), getNumK(), getNumCl(),
                getNumP(), getNumS(), getNumF()));
        return getMass();
    }
    double calculateWEBasicMass(int alcoholIndex, int acidIndex)
    {
        int[] ratioValues = {2,4,4,8,6,12,8,16,10,20,12,24,13,26,14,28,14,26,15,30,15,28,16,
                32,16,30,17,34,17,32,17,30,18,36,18,34,18,34,18,32,18,30,18,30,18,28,19,38,
                20,40,20,38,20,36,20,34,20,32,20,30,21,42,22,44,22,42,22,40,22,38,22,36,22,
                34,22,32,23,46,24,48,24,46,25,50,26,52};
        int carbonAlcohol = ratioValues[(alcoholIndex * 2)];
        int hydrogenAlcohol = ratioValues[(alcoholIndex*2)+1];
        int carbonAcid = ratioValues[(acidIndex*2)];
        int hydrogenAcid = ratioValues[(acidIndex*2)+1];
        setNumC(carbonAlcohol + carbonAcid);
        setNumH(hydrogenAlcohol + hydrogenAcid);
        setNumO(2);
        setMass(calculateInitialMass(getNumC(), getNumH(), getNumO(), getNumN(),
                getNumAg(), getNumLi(), getNumNa(), getNumK(), getNumCl(),
                getNumP(), getNumS(), getNumF()));
        return getMass();
    }
    double calculateACBasicMass(int acylIndex)
    {
        int[] acArray = {9,17,11,21,13,25,15,29,17,33,19,37,20,39,21,41,21,39,22,43,22,
                41,23,45,23,43,24,47,24,45,24,43,25,49,25,47,25,47,25,45,25,43,25,43,
                25,41,26,51,27,53,27,51,27,49,27,47,27,45,27,43,28,55,29,57,29,55,29,
                53,29,53,29,49,29,47,29,45,30,59,31,61,31,59,32,63,33,65};
        setNumC(acArray[(acylIndex*2)]);
        setNumH(acArray[(acylIndex*2)+1]);
        setNumO(4);
        setNumN(1);
        setMass(calculateInitialMass(getNumC(), getNumH(), getNumO(), getNumN(),
                getNumAg(), getNumLi(), getNumNa(), getNumK(), getNumCl(),
                getNumP(), getNumS(), getNumF()));
        return getMass();
    }
    double calculateCLBasicMass(int index1, int index2, int index3, int index4)
    {
        int cCount = 15;
        int hCount = 26;
        int trueCount = 0;
        int[] sn1_elements = {2,4,4,8,6,12,8,16,10,20,12,24,13,26,14,28,14,26,15,30,15,28,16,
                34,16,32,16,32,16,30,17,34,17,32,17,30,18,38,18,36,18,36,18,34,18,34,18,32,18,30,
                18,30,18,28,19,38,20,42,20,40,20,40,20,38,20,36,20,34,20,32,20,30,21,42,22,44,22,
                42,22,40,22,38,22,36,22,34,22,32,23,46,24,48,24,46,25,50,26,52};
        int[] other_sn_elements = {2,4,4,8,6,12,8,16,10,20,12,24,13,26,14,28,14,26,15,30,15,28,
                16,32,16,30,17,34,17,32,17,30,18,36,18,34,18,34,18,32,18,30,18,30,18,28,19,38,20,
                40,20,38,20,36,20,34,20,32,20,30,21,42,22,44,22,42,22,40,22,38,22,36,22,34,22,32,
                23,46,24,48,24,46,25,50,26,52};
        int numC1, numC2, numC3, numC4, numH1, numH2, numH3, numH4;
        numC1 = sn1_elements[index1*2];
        numC2 = other_sn_elements[index2*2];
        numC3 = other_sn_elements[index3*2];
        numC4 = other_sn_elements[index4*2];
        numH1 = sn1_elements[(index1*2)+1];
        numH2 = other_sn_elements[(index2*2)+1];
        numH3 = other_sn_elements[(index3*2)+1];
        numH4 = other_sn_elements[(index4*2)+1];
        if(index1 == 0){numC1 = 0; numH1 = 0;}
        if(index2 == 0){numC2 = 0; numH2 = 0;}
        if(index3 == 0){numC3 = 0; numH3 = 0;}
        if(index4 == 0){numC4 = 0; numH4 = 0;}
        if(index1 > 0){trueCount++;}
        if(index2 > 0){trueCount++;}
        if(index3 > 0){trueCount++;}
        if(index4 > 0){trueCount++;}
        if(trueCount == 0){
            setNumC(((numC1+numC2+numC3+numC4)+cCount)+2);
            setNumH(((numH1+numH2+numH3+numH4)+hCount)+4);
        }else if(trueCount == 1){
            setNumC(((numC1+numC2+numC3+numC4)+cCount));
            setNumH(((numH1+numH2+numH3+numH4)+hCount));
        }else if(trueCount == 2){
            setNumC(((numC1+numC2+numC3+numC4)+cCount)-2);
            setNumH(((numH1+numH2+numH3+numH4)+hCount)-4);
        }else if(trueCount == 3){
            setNumC(((numC1+numC2+numC3+numC4)+cCount)-4);
            setNumH(((numH1+numH2+numH3+numH4)+hCount)-8);
        }else{
            setNumC(((numC1+numC2+numC3+numC4)+cCount)-6);
            setNumH(((numH1+numH2+numH3+numH4)+hCount)-12);
        }
        if(index1 == 11 ||index1 == 12 ||index1 == 18 ||index1 == 19 ||index1 == 28 ||index1 == 29){
            setNumO(16);
        }else{
            setNumO(17);}
        setNumP(2);
        setMass(calculateInitialMass(getNumC(), getNumH(), getNumO(), getNumN(),
                getNumAg(), getNumLi(), getNumNa(), getNumK(), getNumCl(),
                getNumP(), getNumS(), getNumF()));
        return getMass();
    }
    double calculateCoABasicMass(int acylIndex)
    {
        int[] coaArray = {23,38,25,42,27,46,29,50,31,54,33,58,34,60,35,62,35,60,36,64,
                36,62,37,66,37,64,38,68,38,66,38,64,39,70,39,68,39,68,39,66,39,64,
                39,64,39,62,40,72,41,74,41,72,41,70,41,68,41,66,41,64,42,76,43,78,
                43,76,43,74,43,72,43,70,43,68,43,66,44,80,45,82,45,80,46,84,47,86};

        setNumC(coaArray[(acylIndex*2)]);
        setNumH(coaArray[(acylIndex*2)+1]);
        setNumO(17);
        setNumN(7);
        setNumP(3);
        setNumS(1);

        setMass(calculateInitialMass(getNumC(), getNumH(), getNumO(), getNumN(),
                getNumAg(), getNumLi(), getNumNa(), getNumK(), getNumCl(),
                getNumP(), getNumS(), getNumF()));
        return getMass();
    }
    double calculateCHEBasicMass(int acylIndex)
    {
        int[] arrayCHE = {29,48,31,52,33,56,35,60,37,64,39,68,40,70,41,72,41,70,42,74,42,
                72,43,76,43,74,44,78,44,76,44,74,45,80,45,78,45,78,45,76,45,74,45,72,46,
                82,47,84,47,82,47,80,47,78,47,76,47,74,48,86,49,86,49,88,49,86,49,84,49,
                82,49,80,49,78,49,76,50,90,51,92,51,90,52,94,53,96};
        setNumC(arrayCHE[(acylIndex*2)]);
        setNumH(arrayCHE[(acylIndex*2)+1]);
        setNumO(2);
        setMass(calculateInitialMass(getNumC(), getNumH(), getNumO(), getNumN(),
                getNumAg(), getNumLi(), getNumNa(), getNumK(), getNumCl(),
                getNumP(), getNumS(), getNumF()));
        return getMass();
    }

    /** Method: calculateGLBasicMass(int i1, int i2, int i3)
     * This method takes the indexes of sn1, sn2, and sn3 for Glycerolipids.
     * The indexes are used to figure out/set how much C, H, O there are in
     * the molecular formula. This method returns the basic mass of Glycerolipids.
     *
     * @param i1 index of sn1 dropdown menu
     * @param i2 index of sn2 dropdown menu
     * @param i3 index of sn3 dropdown menu
     * @return the basic mass of Glycerolipids
     */
    double calculateGLBasicMass(int i1, int i2, int i3)
    {

        // Array of Glycerolipid's num of Carbon, Hydrogen repeated (for SN1 Dropdown Menu's values)
        int[] arrayGL_sn1 = {
                5,10,    7,14,   9,18,  11,22, 13,26,  15,30,  16,32,  17,34,
                17,32,  18,36,  18,34,  19,40, 19,38,  19,38,  19,36,  20,40,
                20,38,  20,36,  21,44,  21,42, 21,42,  21,40,  21,40,  21,38,
                21,36,  21,36,  21,34,  22,44, 23,48,  23,46,  23,46,  23,44,
                23,42,  23,40,  23,38,  23,36, 24,48,  25,50,  25,48,  25,46,
                25,44,  25,42,  25,40,  25,38, 26,52,  27,54,  27,52,  28,56, 29,58};

        // addCarbon array: Amount of increase in Carbon when on certain sn2 & sn3 index position
        int[] addCarbon = {
                0, 2, 4, 6, 8, 10, 12, 13, 14, 14, 15, 15, 16, 16, 17, 17, 17,
                18, 18, 18, 18, 18, 18, 18, 19, 20, 20, 20, 20,	20,	20, 21, 22,
                22,	22,	22,	22, 22, 22, 23, 24, 24, 25, 26 };

        // addHydrogen array: Amount of increase in Hydrogen when on certain sn2 & sn3 index position
        int[] addHydrogen = {
                0, 2, 6, 10, 14, 18, 22, 24, 26, 24, 28, 26, 30, 28, 32, 30, 28,
                34,	32,	32,	30,	28,	28,	26,	36,	38,	36,	34,	32,	30,	28,	40,	42,
                40,	38,	36,	34,	32,	30,	44,	46,	44,	48,	50 };

        // Get the # of C & H depending on the index position of SN1's dropdown menu
        int numOfC = arrayGL_sn1[i1 * 2], numOfH = arrayGL_sn1[i1 * 2 + 1];

        // Add carbon & hydrogen depending on SN2 and SN3 dropdown menu's index position
        numOfC = numOfC + addCarbon[i2] + addCarbon[i3];
        numOfH = numOfH + addHydrogen[i2] + addHydrogen[i3];

        /* Set Number of Carbon & Hydrogen */
        setNumC(numOfC); setNumH(numOfH);

        /* Set Number of Oxygen */

        // If SN1 Dropdown index is not O or P
        if (i1 != 11 && i1 != 12 && i1 != 18 && i1 != 19 && i1 != 28 && i1 != 29) {

            if (i2 == 0 && i3 == 0){ setNumO(4); }
            else if (i2 == 0 || i3 == 0) { setNumO(5); }
            else setNumO(6);

        // If SN1 Dropdown index is O or P
        } else {

            if (i2 == 0 && i3 == 0){ setNumO(3); }
            else if (i2 == 0 || i3 == 0) { setNumO(4); }
            else setNumO(5);
        }

        // Sets the basic mass based on the elemental composition of the monoisotopic distribution
        setMass(calculateInitialMass(getNumC(), getNumH(), getNumO(), getNumN(), getNumAg(),
                getNumLi(), getNumNa(), getNumK(), getNumCl(), getNumP(), getNumS(), getNumF()));

        // Return basic mass
        return getMass();
    }
    double calculateGPBasicMass(int index2, int index3, int index4)
    {
        int[] newsn1_elements = {0,0,0,2,4,0,4,8,0,6,12,0,8,16,0,10,20,0,
                11,22,0,12,24,0,12,22,0,13,26,0,13,24,0,14,30,-1,14,28,-1,
                14,28,0,14,26,0,15,30,0,15,28,0,15,26,0,16,34,-1,16,32,-1,
                16,32,0,16,30,0,16,30,0,16,28,0,16,26,0,16,26,0,16,24,0,
                17,34,0,18,38,-1,18,36,-1,18,36,0,18,34,0,18,32,0,18,30,0,
                18,28,0,18,26,0,19,38,0,20,40,0,20,38,0,20,36,0,20,34,0,
                20,32,0,20,30,0,20,28,0,21,42,0,22,44,0,22,42,0,23,46,0,24,48,0};

        int[] newsn2_elements = {0,0,0,2,2,1,4,6,1,5,6,2,6,10,1,8,14,1,9,14,2,
                10,18,1,12,22,1,13,24,1,14,26,1,14,24,1,15,28,1,15,26,1,16,30,
                1,16,28,1,17,32,1,17,30,1,17,28,1,18,34,1,18,32,1,18,32,1,18,
                30,1,18,28,1,18,28,1,18,26,1,19,36,1,20,38,1,20,36,1,20,34,1,
                20,32,1,20,30,1,20,28,1,21,40,1,22,42,1,22,40,1,22,38,1,22,36,
                1,22,34,1,22,32,1,22,30,1,23,44,1,24,46,1,24,44,1,25,48,1,26,50,1};

        int[] hg_elements={10,22,7,1,0,1,0,5,11,7,0,0,1,0,8,16,9,1,0,1,0,
                           7,16,7,1,0,1,0,8,17,9,0,0,1,0,8,18,12,0,0,2,0,
                           11,21,12,0,0,1,0,11,22,15,0,0,2,0,11,23,18,0,0,
                            3,0,11,24,21,0,0,4,0};

        setNumC((hg_elements[(index2*7)])+(newsn1_elements[(index3*3)])+(newsn2_elements[(index4*3)]));
        setNumH((hg_elements[(index2*7)+1])+(newsn1_elements[(index3*3)+1])+(newsn2_elements[(index4*3)+1]));
        setNumO((hg_elements[(index2*7)+2])+(newsn1_elements[(index3*3)+2])+(newsn2_elements[(index4*3)+2]));
        setNumN(hg_elements[(index2*7)+3]);
        setNumP(hg_elements[(index2*7)+5]);

        setMass(calculateInitialMass(getNumC(), getNumH(), getNumO(), getNumN(),
                getNumAg(), getNumLi(), getNumNa(), getNumK(), getNumCl(),
                getNumP(), getNumS(), getNumF()));
        return getMass();
    }
    double calculateSLBasicMass(int headgroup, int sBase, int nAcyl)
    {
        int[] sBaseDif = {0,0,0,0,0,2,0,0,0,-2,0,0,0,2,1,0,0,0,1,0,2,4,0,0,
                2,6,0,0,2,2,0,0,2,6,1,0,2,4,1,0,-2,-4,0,0,-2,-2,0,0,-2,-6,0,0,
                -2,-2,1,0,-2,-4,1,0,-4,-8,0,0,-4,-6,0,0,-4,-10,0,0,-4,-6,1,0,
                -4,-8,1,0,-3,-6,0,0,-3,-4,0,0,-3,-8,0,0,-3,-4,1,0,-3,-6,1,0,
                -1,-2,0,0,-1,0,0,0,-1,-4,0,0,-1,0,1,0,-1,-2,1,0,1,2,0,0,1,4,
                0,0,1,0,0,0,1,4,1,0,1,2,1,0,3,6,0,0,3,8,0,0,3,4,0,0,3,8,1,0,
                3,6,1,0,4,8,0,0,4,10,0,0,4,6,0,0,4,10,1,0,4,8,1,0};
        int[] nAcylDif = {0,0,0,0,1,2,0,0,2,4,0,0,2,4,1,0,3,6,0,0,3,6,1,0,4,8,0,0,
                4,6,0,0,4,8,1,0,4,6,1,0,5,10,0,0,5,10,1,0,6,12,0,0,6,10,0,0,6,12,1,0,
                6,10,1,0,7,14,0,0,7,14,1,0,8,16,0,0,8,14,0,0,8,16,1,0,8,14,1,0,9,18,0,0,
                9,18,1,0,10,20,0,0,10,18,0,0,10,20,1,0,10,18,1,0,11,22,0,0,11,22,1,0,
                12,24,0,0,12,22,0,0,12,24,1,0,12,22,1,0,13,26,0,0,13,26,1,0,14,28,0,0,
                14,26,0,0,14,28,1,0,14,26,1,0,15,30,0,0,15,30,1,0,16,32,0,0,16,32,1,0,
                17,34,0,0,17,34,1,0,18,36,0,0,18,36,1,0,19,38,0,0,19,38,1,0,20,40,0,0,20,40,1,0};
        int carbon, hydrogen, oxygen, nitrogen, phosphorus = 0;
        if(headgroup==0){carbon = 30;hydrogen = 59;oxygen = 3;nitrogen = 1;}
        else if(headgroup==1){carbon = 35;hydrogen = 71;oxygen = 6;nitrogen = 2;}
        else if(headgroup==2){carbon = 30;hydrogen = 60;oxygen = 6;nitrogen = 1;phosphorus = 1;}
        else if(headgroup==3){carbon = 32;hydrogen = 65;oxygen = 6;nitrogen = 2;phosphorus = 1;}
        else if(headgroup==4){carbon = 36;hydrogen = 70;oxygen = 11;nitrogen = 1;phosphorus = 1;}
        else if(headgroup==5){carbon = 36;hydrogen = 69;oxygen = 8;nitrogen = 1;}
        else if(headgroup==6){carbon = 36;hydrogen = 69;oxygen = 8;nitrogen = 1;}
        else if(headgroup==7){carbon = 42;hydrogen = 79;oxygen = 13;nitrogen = 1;}
        else if(headgroup==8){carbon = 53;hydrogen = 96;oxygen = 21;nitrogen = 2;}
        else if(headgroup==9){carbon = 47;hydrogen = 86;oxygen = 16;nitrogen = 2;}
        else if(headgroup==10){carbon = 48;hydrogen = 89;oxygen = 8;nitrogen = 1;}
        else if(headgroup==11){carbon = 48;hydrogen = 89;oxygen = 8;nitrogen = 1;}
        else if(headgroup==12){carbon = 50;hydrogen = 92;oxygen = 18;nitrogen = 2;}
        else if(headgroup==13){carbon = 50;hydrogen = 92;oxygen = 18;nitrogen = 2;}
        else if(headgroup==14){carbon = 42;hydrogen = 79;oxygen = 13;nitrogen = 1;}
        else if(headgroup==15){carbon = 48;hydrogen = 89;oxygen = 18;nitrogen = 1;}
        else {carbon = 50;hydrogen = 92;oxygen = 18;nitrogen = 2;}

        setNumC(carbon+(sBaseDif[sBase * 4])+(nAcylDif[nAcyl * 4]));
        setNumH(hydrogen+(sBaseDif[(sBase * 4)+1])+(nAcylDif[(nAcyl * 4)+1]));
        setNumO(oxygen+(sBaseDif[(sBase * 4)+2])+(nAcylDif[(nAcyl * 4)+2]));
        setNumN(nitrogen+(sBaseDif[(sBase * 4)+3])+(nAcylDif[(nAcyl * 4)+3]));
        setNumP(phosphorus);

        setMass(calculateInitialMass(getNumC(), getNumH(), getNumO(), getNumN(),
                getNumAg(), getNumLi(), getNumNa(), getNumK(), getNumCl(),
                getNumP(), getNumS(), getNumF()));

        return getMass();
    }

    /** calculateInitialMass()
     *
     *  This method takes the amount of C, H, O, N, Ag, Li, Na, K, Cl, P, S, and F
     *  and returns the sum of intial mass that will be used to find the monoisotopic mass
     */
    private double calculateInitialMass(int numC, int numH, int numO, int numN
            , int numAg, int numLi, int numNa, int numK, int numCl, int numP, int numS, int numF)
    {
        double CARBON = 12.000000;
        double HYDROGEN = 1.007825;
        double NITROGEN = 14.003074;
        double OXYGEN = 15.994915;
        double SILVER = 106.905090;
        double LITHIUM = 7.016004;
        double SODIUM = 22.989771;
        double POTASSIUM = 38.963707;
        double CHLORIDE = 34.968853;
        double PHOSPHORUS = 30.973761;
        double SULFUR = 31.972071;
        double FLUORIDE = 18.998404;
        return mass = ((CARBON *numC)+(HYDROGEN*numH)+(OXYGEN*numO)+(NITROGEN*numN)+(SILVER*numAg)+
                (LITHIUM*numLi)+(SODIUM*numNa)+(POTASSIUM*numK)+(CHLORIDE*numCl)+(PHOSPHORUS*numP)+
                (SULFUR*numS)+(FLUORIDE*numF));
    }

    double calculateFinalMass(int ion, double basicMass)
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

    private double getMass() {
        return mass;
    }

    int getNumC() {
        return numC;
    }

    int getNumH() {
        return numH;
    }

    int getNumN() {
        return numN;
    }

    int getNumO() {
        return numO;
    }

    int getNumAg() {
        return numAg;
    }

    int getNumLi() {
        return numLi;
    }

    int getNumNa() {
        return numNa;
    }

    int getNumK() {
        return numK;
    }

    int getNumCl() {
        return numCl;
    }

    int getNumP() {
        return numP;
    }

    int getNumS() {
        return numS;
    }

    int getNumF() {
        return numF;
    }

    private void setMass(double mass) {
        this.mass = mass;
    }

    private void setNumC(int numC) {
        this.numC = numC;
    }

    private void setNumH(int numH) {
        this.numH = numH;
    }

    private void setNumN(int numN) {
        this.numN = numN;
    }

    private void setNumO(int numO) {
        this.numO = numO;
    }

    private void setNumAg(int numAg) {
        this.numAg = numAg;
    }

    private void setNumLi(int numLi) {
        this.numLi = numLi;
    }

    private void setNumNa(int numNa) {
        this.numNa = numNa;
    }

    private void setNumK(int numK) {
        this.numK = numK;
    }

    private void setNumCl(int numCl) {
        this.numCl = numCl;
    }

    private void setNumP(int numP) {
        this.numP = numP;
    }

    private void setNumS(int numS) {
        this.numS = numS;
    }

    private void setNumF(int numF) {
        this.numF = numF;
    }
}
