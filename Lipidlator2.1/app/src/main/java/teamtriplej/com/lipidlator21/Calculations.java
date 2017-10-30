package teamtriplej.com.lipidlator21;

/**
 * Created by Jose Moreno on 10/1/2017
 */

class Calculations {
    private double mass;
    private String newFormula;
    private int numC, numH, numN, numO, numAg, numLi, numNa, numK, numCl, numP, numS, numF;
    private final double CARBON = 12.000000;
    private final double HYDROGEN = 1.007825;
    private final double NITROGEN = 14.003074;
    private final double OXYGEN = 15.994915;
    private final double SILVER = 106.905090;
    private final double LITHIUM = 7.016004;
    private final double SODIUM = 22.989771;
    private final double POTASSIUM = 38.963707;
    private final double CHLORIDE = 34.968853;
    private final double PHOSPHORUS = 30.973761;
    private final double SULFUR = 31.972071;
    private final double FLUORIDE = 18.998404;
    private double[] ratioValues = {28.02908,2,4,56.06038,4,8,84.09168,6,12,112.12298,8,16,
            140.15428,10,20,168.18558,12,24,182.20123,13,26,
            196.21688,14,28,194.20123,14,26,210.23253,15,30,
            208.21688,15,28,224.24818,16,32,222.23253,16,30,
            238.26383,17,34,236.24818,17,32,234.23253,17,30,
            252.27948,18,36,250.26383,18,34,250.26383,18,34,
            248.24818,18,32,246.23253,18,30,246.23253,18,30,
            244.21688,18,28,266.29513,19,38,280.31078,20,40,
            278.29513,20,38,276.27948,20,36,274.26383,20,34,
            272.24818,20,32,270.23253,20,30,294.32643,21,42,
            308.34208,22,44,306.32643,22,42,304.31078,22,40,
            302.29513,22,38,300.27948,22,36,298.26383,22,34,
            296.24818,22,32,322.35773,23,46,336.37338,24,48,
            334.35773,24,46,350.38903,25,50,364.40468,26,52};
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
        return newFormula = formula.replaceAll("0", SUB_ZERO).replaceAll("1", SUB_ONE)
                .replaceAll("2", SUB_TWO).replaceAll("3", SUB_THREE).replaceAll("4", SUB_FOUR)
                .replaceAll("5", SUB_FIVE).replaceAll("6", SUB_SIX).replaceAll("7", SUB_SEVEN)
                .replaceAll("8", SUB_EIGHT).replaceAll("9", SUB_NINE);
    }
    double calculateFABasicMass(int massIndex, int esterIndex)
    {
        double[] esterArray1 = {60.021130,2,4,88.052430,4,8,116.083730,6,12,
                144.115030,8,16,172.146330,10,20,200.177630,12,24,
                214.193280,13,26,228.208930,14,28,226.193280,14,26,
                242.224580,15,30,240.208930,15,28,256.240230,16,32,
                254.224580,16,30,270.255880,17,34,268.240230,17,32,
                266.224580,17,30,284.271530,18,36,282.255880,18,34,
                282.255880,18,34,280.240230,18,32,278.224580,18,30,
                278.224580,18,30,276.208930,18,28,298.287180,19,38,
                312.302830,20,40,310.287180,20,38,308.271530,20,36,
                306.255880,20,34,304.240230,20,32,302.224580,20,30,
                326.318480,21,42,340.334130,22,44,338.318480,22,42,
                336.302830,22,40,334.287180,22,38,332.271530,22,36,
                330.255880,22,34,328.240230,22,32,354.349780,23,46,
                368.365430,24,48,366.349780,24,46,382.381080,25,50,
                396.396730,26,52};
        double[] esterArray2 = {74.036780,3,6,102.068080,5,10,130.099380,7,14,
                158.130680,9,18,186.161980,11,22,214.193280,13,26,
                228.208930,14,28,242.224580,15,30,240.208930,15,28,
                256.240230,16,32,254.224580,16,30,270.255880,17,34,
                268.240230,17,32,284.271530,18,36,282.255880,18,34,
                280.240230,18,32,298.287180,19,38,296.271530,19,36,
                296.271530,19,36,294.255880,19,34,292.240230,19,32,
                292.240230,19,32,290.224580,19,30,312.302830,20,40,
                326.318480,21,42,324.302830,21,40,322.287180,21,38,
                320.271530,21,36,318.255880,21,34,316.240230,21,32,
                340.334130,22,44,354.349780,23,46,352.334130,23,44,
                350.318480,23,42,348.302830,23,40,346.287180,23,38,
                344.271530,23,36,342.255880,23,34,368.365430,24,48,
                382.381080,25,50,380.365430,25,48,396.396730,26,52,
                410.412380,27,54};
        double[] esterArray3 = {240.020970,9,5,268.052270,11,9,296.083570,13,13,
                324.114870,15,17,352.146170,17,21,380.177470,19,25,394.193120,20,27,
                408.208770,21,29,406.193120,21,27,422.224420,22,31,420.208770,22,29,
                436.240070,23,33,434.224420,23,31,450.255720,24,35,448.240070,24,33,
                446.224420,24,31,464.271370,25,37,462.255720,25,35,462.255720,25,35,
                460.240070,25,33,458.224420,25,31,458.224420,25,31,456.208770,25,29,
                478.287020,26,39,492.302670,27,41,490.287020,27,39,488.271370,27,37,
                486.255720,27,35,484.240070,27,33,482.224420,27,31,506.318320,28,43,
                520.333970,29,45,518.318320,29,43,516.302670,29,41,514.287020,29,39,
                512.271370,29,37,510.255720,29,35,508.240070,29,33,534.349620,30,47,
                548.365270,31,49,546.349620,31,47,562.380920,32,51,576.396570,33,53};
        if(esterIndex == 0){
            setMass(esterArray1[(massIndex * 3)]);
            setNumC((int)esterArray1[(massIndex * 3)+1]);
            setNumH((int)esterArray1[(massIndex * 3)+2]);
            setNumO(2);
        }else if(esterIndex == 1){
            setMass(esterArray2[(massIndex * 3)]);
            setNumC((int)esterArray2[(massIndex * 3)+1]);
            setNumH((int)esterArray2[(massIndex * 3)+2]);
            setNumO(2);
        }else if(esterIndex == 2){
            setMass(esterArray3[(massIndex * 3)]);
            setNumC((int)esterArray3[(massIndex * 3)+1]);
            setNumH((int)esterArray3[(massIndex * 3)+2]);
            setNumO(2);
            setNumF(5);}
        return getMass();
    }
    double calculateWEBasicMass(int alcoholIndex, int acidIndex)
    {
        double alcohol = ratioValues[(alcoholIndex * 3)];
        int carbonAlcohol = (int)ratioValues[(alcoholIndex * 3) + 1];
        int hydrogenAlcohol = (int)ratioValues[(alcoholIndex * 3) + 2];
        double acid = ratioValues[(acidIndex * 3)];
        int carbonAcid = (int)ratioValues[(acidIndex * 3) + 1];
        int hydrogenAcid = (int)ratioValues[(acidIndex * 3) + 2];
        setMass((alcohol + acid) + 31.99205);
        setNumC(carbonAlcohol + carbonAcid);
        setNumH(hydrogenAlcohol + hydrogenAcid);
        setNumO(2);
        return getMass();
    }
    double calculateACBasicMass(int acylIndex)
    {
        double[] acArray = {203.115759,9,17,231.147059,11,21,259.178359,13,25,287.209659,15,29,
                315.240959,17,33,343.272259,19,37,357.287909,20,39,371.303559,21,41,
                369.287909,21,39,385.319209,22,43,383.303559,22,41,399.334859,23,45,
                397.319209,23,43,413.350509,24,47,411.334859,24,45,409.319209,24,43,
                427.366159,25,49,425.350509,25,47,425.350509,25,47,423.334859,25,45,
                421.319209,25,43,421.319209,25,43,419.303559,25,41,441.381809,26,51,
                455.397459,27,53,453.381809,27,51,451.366159,27,49,449.350509,27,47,
                447.334859,27,45,445.319209,27,43,469.413109,28,55,483.428759,29,57,
                481.413109,29,55,479.397459,29,53,479.397459,29,53,475.366159,29,49,
                473.350509,29,47,471.334859,29,45,497.444409,30,59,511.460059,31,61,
                509.444409,31,59,525.475709,32,63,539.491359,33,65};
        setMass(acArray[(acylIndex * 3)]);
        setNumC((int)acArray[(acylIndex * 3) + 1]);
        setNumH((int)acArray[(acylIndex * 3) + 2]);
        setNumO(4);
        setNumN(1);
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
        double[] coaArray = {809.125784,23,38,837.157084,25,42,865.188384,27,46,
                893.219684,29,50,921.250984,31,54,949.282284,33,58,963.297934,34,60,
                977.313584,35,62,975.297934,35,60,991.329234,36,64,989.313584,36,62,
                1005.344884,37,66,1003.329234,37,64,1019.360534,38,68,
                1017.344884,38,66,1015.329234,38,64,1033.376184,39,70,
                1031.360534,39,68,1031.360534,39,68,1029.344884,39,66,
                1027.329234,39,64,1027.329234,39,64,1025.313584,39,62,
                1047.391834,40,72,1061.407484,41,74,1059.391834,41,72,
                1057.376184,41,70,1055.360534,41,68,1053.344884,41,66,
                1051.329234,41,64,1075.423134,42,76,1089.438784,43,78,
                1087.423134,43,76,1085.407484,43,74,1083.391834,43,72,
                1081.376184,43,70,1079.360534,43,68,1077.344884,43,66,
                1103.454434,44,80,1117.470084,45,82,1115.454434,45,80,
                1131.485734,46,84,1145.501384,47,86};

        setMass(coaArray[acylIndex * 3]);
        setNumC((int)coaArray[(acylIndex * 3) + 1]);
        setNumH((int)coaArray[(acylIndex * 3) + 2]);
        setNumO(17);
        setNumN(7);
        setNumP(3);
        setNumS(1);

        return getMass();
    }
    double calculateCHEBasicMass(int acylIndex)
    {
        double[] arrayCHE = {428.365430,29,48,456.396730,31,52,484.428030,33,56,
                512.459330,35,60,540.490630,37,64,568.521930,39,68,582.537580,40,70,
                596.553230,41,72,594.537580,41,70,610.568880,42,74,608.553230,42,72,
                624.584530,43,76,622.568880,43,74,638.600180,44,78,636.584530,44,76,
                634.568880,44,74,652.615830,45,80,650.600180,45,78,650.600180,45,78,
                648.584530,45,76,646.568880,45,74,644.553230,45,72,666.631480,46,82,
                680.647130,47,84,678.631480,47,82,676.615830,47,80,674.600180,47,78,
                672.584530,47,76,670.568880,47,74,694.662780,48,86,706.662780,49,86,
                708.678430,49,88,706.662780,49,86,704.647130,49,84,702.631480,49,82,
                700.615830,49,80,698.600180,49,78,696.584530,49,76,722.694080,50,90,
                736.709730,51,92,734.694080,51,90,750.725380,52,94,764.741030,53,96};
        setMass(arrayCHE[acylIndex * 3]);
        setNumC((int)arrayCHE[(acylIndex * 3) + 1]);
        setNumH((int)arrayCHE[(acylIndex * 3) + 2]);
        setNumO(2);
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

    double calculateGLBasicMass(int i1, int i2, int i3){

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

    double calculateGPBasicMass(int index1, int index2, int index3, int index4)
    {
        int[] sn1_elements = {10,22,7,1,0,1,0
                ,12,26,7,1,0,1,0,14,30,7,1,0,1,0,16,34,7,1,0,1,0
                ,18,38,7,1,0,1,0,20,42,7,1,0,1,0,21,44,7,1,0,1,0
                ,22,46,7,1,0,1,0,22,44,7,1,0,1,0,23,48,7,1,0,1,0
                ,23,46,7,1,0,1,0,24,52,6,1,0,1,0,24,50,6,1,0,1,0
                ,24,50,7,1,0,1,0,24,48,7,1,0,1,0,25,52,7,1,0,1,0
                ,25,50,7,1,0,1,0,25,48,7,1,0,1,0,26,56,6,1,0,1,0
                ,26,54,6,1,0,1,0,26,54,7,1,0,1,0,26,52,7,1,0,1,0
                ,26,52,7,1,0,1,0,26,50,7,1,0,1,0,26,48,7,1,0,1,0
                ,26,48,7,1,0,1,0,26,46,7,1,0,1,0,27,56,7,1,0,1,0
                ,28,60,6,1,0,1,0,28,58,6,1,0,1,0,28,58,7,1,0,1,0
                ,28,56,7,1,0,1,0,28,54,7,1,0,1,0,28,52,7,1,0,1,0
                ,28,50,7,1,0,1,0,28,48,7,1,0,1,0,29,60,7,1,0,1,0
                ,30,62,7,1,0,1,0,30,60,7,1,0,1,0,30,58,7,1,0,1,0
                ,30,56,7,1,0,1,0,30,54,7,1,0,1,0,30,52,7,1,0,1,0
                ,30,50,7,1,0,1,0,31,64,7,1,0,1,0,32,66,7,1,0,1,0
                ,32,64,7,1,0,1,0,33,68,7,1,0,1,0,34,70,7,1,0,1,0};

        int[] sn2_elements = {12,24,8,1,0,1,0,14,28,8,1,0,1,0,15,28,9,1,0,1,0,16,32,8,1,0,1,0,18,36,8,1,0,1,0,
                19,36,9,1,0,1,0,20,40,8,1,0,1,0,22,44,8,1,0,1,0,23,46,8,1,0,1,0,24,48,8,1,0,1,0,24,46,8,1,0,1,0,25,50,8,1,0,1,0,25,48,8,1,0,1,0,
                26,52,8,1,0,1,0,26,50,8,1,0,1,0,27,54,8,1,0,1,0,27,52,8,1,0,1,0,27,50,8,1,0,1,0,28,56,8,1,0,1,0,28,54,8,1,0,1,0,28,54,8,1,0,1,0,
                28,52,8,1,0,1,0,28,50,8,1,0,1,0,28,50,8,1,0,1,0,28,48,8,1,0,1,0,29,58,8,1,0,1,0,30,60,8,1,0,1,0,30,58,8,1,0,1,0,30,56,8,1,0,1,0,
                30,54,8,1,0,1,0,30,52,8,1,0,1,0,30,50,8,1,0,1,0,31,62,8,1,0,1,0,32,64,8,1,0,1,0,32,62,8,1,0,1,0,32,60,8,1,0,1,0,32,58,8,1,0,1,0,
                32,56,8,1,0,1,0,32,54,8,1,0,1,0,32,52,8,1,0,1,0,33,66,8,1,0,1,0,34,68,8,1,0,1,0,34,66,8,1,0,1,0,35,70,8,1,0,1,0,36,72,8,1,0,1,0};

        int[] hg_elements={10,22,7,1,0,1,0,5,11,7,0,0,1,0,8,16,9,1,0,1,0,
                           7,16,7,1,0,1,0,8,17,9,0,0,1,0,8,18,12,0,0,2,0,
                           11,21,12,0,0,1,0,11,22,15,0,0,2,0,11,23,18,0,0,3,0,11,24,21,0,0,4,0};

        if(index4 == 0){
        setNumC((sn1_elements[index3 * 7 + 0]));
        setNumH((sn1_elements[index3 * 7 + 1]));
        setNumO((sn1_elements[index3 * 7 + 2]));
        setNumN((sn1_elements[index3 * 7 + 3]));
        setNumF((sn1_elements[index3 * 7 + 4]));
        setNumP((sn1_elements[index3 * 7 + 5]));
        setNumS((sn1_elements[index3 * 7 + 6]));
        }
        else{
            setNumC((sn1_elements[index4 * 7 + 0]));
            setNumH((sn1_elements[index4 * 7 + 1] - 2));
            setNumO((sn1_elements[index4 * 7 + 2] + 1));
            setNumN((sn1_elements[index4 * 7 + 3]));
            setNumF((sn1_elements[index4 * 7 + 4]));
            setNumP((sn1_elements[index4 * 7 + 5]));
            setNumS((sn1_elements[index4 * 7 + 6]));
        }

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
    double calculateInitialMass(int numC, int numH, int numO, int numN
            , int numAg, int numLi, int numNa, int numK, int numCl, int numP, int numS, int numF)
    {
        return mass = ((CARBON*numC)+(HYDROGEN*numH)+(OXYGEN*numO)+(NITROGEN*numN)+(SILVER*numAg)+
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
