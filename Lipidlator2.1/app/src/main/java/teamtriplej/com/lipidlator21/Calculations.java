package teamtriplej.com.lipidlator21;

/**
 * Created by Jose Moreno on 10/1/2017
 */

public class Calculations {
    private double mass;
    private int numC, numH, numN, numO, numAg, numLi, numNa, numK, numCl, numP, numS, numF;
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
    public double calculateFABasicMass(int massIndex, int esterIndex)
    {
        if(massIndex == 0 && esterIndex == 0){setMass(60.021130);setNumC(2);setNumH(4);setNumO(2);}
        else if(massIndex == 1 && esterIndex == 0){setMass(88.052430);setNumC(4);setNumH(8);setNumO(2);}
        else if(massIndex == 2 && esterIndex == 0){setMass(116.083730);setNumC(6);setNumH(12);setNumO(2);}
        else if(massIndex == 3 && esterIndex == 0){setMass(144.115030);setNumC(8);setNumH(16);setNumO(2);}
        else if(massIndex == 4 && esterIndex == 0){setMass(172.146330);setNumC(10);setNumH(20);setNumO(2);}
        else if(massIndex == 5 && esterIndex == 0){setMass(200.177630);setNumC(12);setNumH(24);setNumO(2);}
        else if(massIndex == 6 && esterIndex == 0){setMass(214.193280);setNumC(13);setNumH(26);setNumO(2);}
        else if(massIndex == 7 && esterIndex == 0){setMass(228.208930);setNumC(14);setNumH(28);setNumO(2);}
        else if(massIndex == 8 && esterIndex == 0){setMass(226.193280);setNumC(14);setNumH(26);setNumO(2);}
        else if(massIndex == 9 && esterIndex == 0){setMass(242.224580);setNumC(15);setNumH(30);setNumO(2);}
        else if(massIndex == 10 && esterIndex == 0){setMass(240.208930);setNumC(15);setNumH(28);setNumO(2);}
        else if(massIndex == 11 && esterIndex == 0){setMass(256.240230);setNumC(16);setNumH(32);setNumO(2);}
        else if(massIndex == 12 && esterIndex == 0){setMass(254.224580);setNumC(16);setNumH(30);setNumO(2);}
        else if(massIndex == 13 && esterIndex == 0){setMass(270.255880);setNumC(17);setNumH(34);setNumO(2);}
        else if(massIndex == 14 && esterIndex == 0){setMass(268.240230);setNumC(17);setNumH(32);setNumO(2);}
        else if(massIndex == 15 && esterIndex == 0){setMass(266.224580);setNumC(17);setNumH(30);setNumO(2);}
        else if(massIndex == 16 && esterIndex == 0){setMass(284.271530);setNumC(18);setNumH(36);setNumO(2);}
        else if(massIndex == 17 && esterIndex == 0){setMass(282.255880);setNumC(18);setNumH(34);setNumO(2);}
        else if(massIndex == 18 && esterIndex == 0){setMass(282.255880);setNumC(18);setNumH(34);setNumO(2);}
        else if(massIndex == 19 && esterIndex == 0){setMass(280.240230);setNumC(18);setNumH(32);setNumO(2);}
        else if(massIndex == 20 && esterIndex == 0){setMass(278.224580);setNumC(18);setNumH(30);setNumO(2);}
        else if(massIndex == 21 && esterIndex == 0){setMass(278.224580);setNumC(18);setNumH(30);setNumO(2);}
        else if(massIndex == 22 && esterIndex == 0){setMass(276.208930);setNumC(18);setNumH(28);setNumO(2);}
        else if(massIndex == 23 && esterIndex == 0){setMass(298.287180);setNumC(19);setNumH(38);setNumO(2);}
        else if(massIndex == 24 && esterIndex == 0){setMass(312.302830);setNumC(20);setNumH(40);setNumO(2);}
        else if(massIndex == 25 && esterIndex == 0){setMass(310.287180);setNumC(20);setNumH(38);setNumO(2);}
        else if(massIndex == 26 && esterIndex == 0){setMass(308.271530);setNumC(20);setNumH(36);setNumO(2);}
        else if(massIndex == 27 && esterIndex == 0){setMass(306.255880);setNumC(20);setNumH(34);setNumO(2);}
        else if(massIndex == 28 && esterIndex == 0){setMass(304.240230);setNumC(20);setNumH(32);setNumO(2);}
        else if(massIndex == 29 && esterIndex == 0){setMass(302.224580);setNumC(20);setNumH(30);setNumO(2);}
        else if(massIndex == 30 && esterIndex == 0){setMass(326.318480);setNumC(21);setNumH(42);setNumO(2);}
        else if(massIndex == 31 && esterIndex == 0){setMass(340.334130);setNumC(22);setNumH(44);setNumO(2);}
        else if(massIndex == 32 && esterIndex == 0){setMass(338.318480);setNumC(22);setNumH(42);setNumO(2);}
        else if(massIndex == 33 && esterIndex == 0){setMass(336.302830);setNumC(22);setNumH(40);setNumO(2);}
        else if(massIndex == 34 && esterIndex == 0){setMass(334.287180);setNumC(22);setNumH(38);setNumO(2);}
        else if(massIndex == 35 && esterIndex == 0){setMass(332.271530);setNumC(22);setNumH(36);setNumO(2);}
        else if(massIndex == 36 && esterIndex == 0){setMass(330.255880);setNumC(22);setNumH(34);setNumO(2);}
        else if(massIndex == 37 && esterIndex == 0){setMass(328.240230);setNumC(22);setNumH(32);setNumO(2);}
        else if(massIndex == 38 && esterIndex == 0){setMass(354.349780);setNumC(23);setNumH(46);setNumO(2);}
        else if(massIndex == 39 && esterIndex == 0){setMass(368.365430);setNumC(24);setNumH(48);setNumO(2);}
        else if(massIndex == 40 && esterIndex == 0){setMass(366.349780);setNumC(24);setNumH(46);setNumO(2);}
        else if(massIndex == 41 && esterIndex == 0){setMass(382.381080);setNumC(25);setNumH(50);setNumO(2);}
        else if(massIndex == 42 && esterIndex == 0){setMass(396.396730);setNumC(26);setNumH(52);setNumO(2);}
        else if(massIndex == 0 && esterIndex == 1){setMass(74.036780);setNumC(3);setNumH(6);setNumO(2);}
        else if(massIndex == 1 && esterIndex == 1){setMass(102.068080);setNumC(5);setNumH(10);setNumO(2);}
        else if(massIndex == 2 && esterIndex == 1){setMass(130.099380);setNumC(7);setNumH(14);setNumO(2);}
        else if(massIndex == 3 && esterIndex == 1){setMass(158.130680);setNumC(9);setNumH(18);setNumO(2);}
        else if(massIndex == 4 && esterIndex == 1){setMass(186.161980);setNumC(11);setNumH(22);setNumO(2);}
        else if(massIndex == 5 && esterIndex == 1){setMass(214.193280);setNumC(13);setNumH(26);setNumO(2);}
        else if(massIndex == 6 && esterIndex == 1){setMass(228.208930);setNumC(14);setNumH(28);setNumO(2);}
        else if(massIndex == 7 && esterIndex == 1){setMass(242.224580);setNumC(15);setNumH(30);setNumO(2);}
        else if(massIndex == 8 && esterIndex == 1){setMass(240.208930);setNumC(15);setNumH(28);setNumO(2);}
        else if(massIndex == 9 && esterIndex == 1){setMass(256.240230);setNumC(16);setNumH(32);setNumO(2);}
        else if(massIndex == 10 && esterIndex == 1){setMass(254.224580);setNumC(16);setNumH(30);setNumO(2);}
        else if(massIndex == 11 && esterIndex == 1){setMass(270.255880);setNumC(17);setNumH(34);setNumO(2);}
        else if(massIndex == 12 && esterIndex == 1){setMass(268.240230);setNumC(17);setNumH(32);setNumO(2);}
        else if(massIndex == 13 && esterIndex == 1){setMass(284.271530);setNumC(18);setNumH(36);setNumO(2);}
        else if(massIndex == 14 && esterIndex == 1){setMass(282.255880);setNumC(18);setNumH(34);setNumO(2);}
        else if(massIndex == 15 && esterIndex == 1){setMass(280.240230);setNumC(18);setNumH(32);setNumO(2);}
        else if(massIndex == 16 && esterIndex == 1){setMass(298.287180);setNumC(19);setNumH(38);setNumO(2);}
        else if(massIndex == 17 && esterIndex == 1){setMass(296.271530);setNumC(19);setNumH(36);setNumO(2);}
        else if(massIndex == 18 && esterIndex == 1){setMass(296.271530);setNumC(19);setNumH(36);setNumO(2);}
        else if(massIndex == 19 && esterIndex == 1){setMass(294.255880);setNumC(19);setNumH(34);setNumO(2);}
        else if(massIndex == 20 && esterIndex == 1){setMass(292.240230);setNumC(19);setNumH(32);setNumO(2);}
        else if(massIndex == 21 && esterIndex == 1){setMass(292.240230);setNumC(19);setNumH(32);setNumO(2);}
        else if(massIndex == 22 && esterIndex == 1){setMass(290.224580);setNumC(19);setNumH(30);setNumO(2);}
        else if(massIndex == 23 && esterIndex == 1){setMass(312.302830);setNumC(20);setNumH(40);setNumO(2);}
        else if(massIndex == 24 && esterIndex == 1){setMass(326.318480);setNumC(21);setNumH(42);setNumO(2);}
        else if(massIndex == 25 && esterIndex == 1){setMass(324.302830);setNumC(21);setNumH(40);setNumO(2);}
        else if(massIndex == 26 && esterIndex == 1){setMass(322.287180);setNumC(21);setNumH(38);setNumO(2);}
        else if(massIndex == 27 && esterIndex == 1){setMass(320.271530);setNumC(21);setNumH(36);setNumO(2);}
        else if(massIndex == 28 && esterIndex == 1){setMass(318.255880);setNumC(21);setNumH(34);setNumO(2);}
        else if(massIndex == 29 && esterIndex == 1){setMass(316.240230);setNumC(21);setNumH(32);setNumO(2);}
        else if(massIndex == 30 && esterIndex == 1){setMass(340.334130);setNumC(22);setNumH(44);setNumO(2);}
        else if(massIndex == 31 && esterIndex == 1){setMass(354.349780);setNumC(23);setNumH(46);setNumO(2);}
        else if(massIndex == 32 && esterIndex == 1){setMass(352.334130);setNumC(23);setNumH(44);setNumO(2);}
        else if(massIndex == 33 && esterIndex == 1){setMass(350.318480);setNumC(23);setNumH(42);setNumO(2);}
        else if(massIndex == 34 && esterIndex == 1){setMass(348.302830);setNumC(23);setNumH(40);setNumO(2);}
        else if(massIndex == 35 && esterIndex == 1){setMass(346.287180);setNumC(23);setNumH(38);setNumO(2);}
        else if(massIndex == 36 && esterIndex == 1){setMass(344.271530);setNumC(23);setNumH(36);setNumO(2);}
        else if(massIndex == 37 && esterIndex == 1){setMass(342.255880);setNumC(23);setNumH(34);setNumO(2);}
        else if(massIndex == 38 && esterIndex == 1){setMass(368.365430);setNumC(24);setNumH(48);setNumO(2);}
        else if(massIndex == 39 && esterIndex == 1){setMass(382.381080);setNumC(25);setNumH(50);setNumO(2);}
        else if(massIndex == 40 && esterIndex == 1){setMass(380.365430);setNumC(25);setNumH(48);setNumO(2);}
        else if(massIndex == 41 && esterIndex == 1){setMass(396.396730);setNumC(26);setNumH(52);setNumO(2);}
        else if(massIndex == 42 && esterIndex == 1){setMass(410.412380);setNumC(27);setNumH(54);setNumO(2);}
        else if(massIndex == 0 && esterIndex == 2){setMass(240.020970);setNumC(9);setNumH(5);setNumO(2);setNumF(5);}
        else if(massIndex == 1 && esterIndex == 2){setMass(268.052270);setNumC(11);setNumH(9);setNumO(2);setNumF(5);}
        else if(massIndex == 2 && esterIndex == 2){setMass(296.083570);setNumC(13);setNumH(13);setNumO(2);setNumF(5);}
        else if(massIndex == 3 && esterIndex == 2){setMass(324.114870);setNumC(15);setNumH(17);setNumO(2);setNumF(5);}
        else if(massIndex == 4 && esterIndex == 2){setMass(352.146170);setNumC(17);setNumH(21);setNumO(2);setNumF(5);}
        else if(massIndex == 5 && esterIndex == 2){setMass(380.177470);setNumC(19);setNumH(25);setNumO(2);setNumF(5);}
        else if(massIndex == 6 && esterIndex == 2){setMass(394.193120);setNumC(20);setNumH(27);setNumO(2);setNumF(5);}
        else if(massIndex == 7 && esterIndex == 2){setMass(408.208770);setNumC(21);setNumH(29);setNumO(2);setNumF(5);}
        else if(massIndex == 8 && esterIndex == 2){setMass(406.193120);setNumC(21);setNumH(27);setNumO(2);setNumF(5);}
        else if(massIndex == 9 && esterIndex == 2){setMass(422.224420);setNumC(22);setNumH(31);setNumO(2);setNumF(5);}
        else if(massIndex == 10 && esterIndex == 2){setMass(420.208770);setNumC(22);setNumH(29);setNumO(2);setNumF(5);}
        else if(massIndex == 11 && esterIndex == 2){setMass(436.240070);setNumC(23);setNumH(33);setNumO(2);setNumF(5);}
        else if(massIndex == 12 && esterIndex == 2){setMass(434.224420);setNumC(23);setNumH(31);setNumO(2);setNumF(5);}
        else if(massIndex == 13 && esterIndex == 2){setMass(450.255720);setNumC(24);setNumH(35);setNumO(2);setNumF(5);}
        else if(massIndex == 14 && esterIndex == 2){setMass(448.240070);setNumC(24);setNumH(33);setNumO(2);setNumF(5);}
        else if(massIndex == 15 && esterIndex == 2){setMass(446.224420);setNumC(24);setNumH(31);setNumO(2);setNumF(5);}
        else if(massIndex == 16 && esterIndex == 2){setMass(464.271370);setNumC(25);setNumH(37);setNumO(2);setNumF(5);}
        else if(massIndex == 17 && esterIndex == 2){setMass(462.255720);setNumC(25);setNumH(35);setNumO(2);setNumF(5);}
        else if(massIndex == 18 && esterIndex == 2){setMass(462.255720);setNumC(25);setNumH(35);setNumO(2);setNumF(5);}
        else if(massIndex == 19 && esterIndex == 2){setMass(460.240070);setNumC(25);setNumH(33);setNumO(2);setNumF(5);}
        else if(massIndex == 20 && esterIndex == 2){setMass(458.224420);setNumC(25);setNumH(31);setNumO(2);setNumF(5);}
        else if(massIndex == 21 && esterIndex == 2){setMass(458.224420);setNumC(25);setNumH(31);setNumO(2);setNumF(5);}
        else if(massIndex == 22 && esterIndex == 2){setMass(456.208770);setNumC(25);setNumH(29);setNumO(2);setNumF(5);}
        else if(massIndex == 23 && esterIndex == 2){setMass(478.287020);setNumC(26);setNumH(39);setNumO(2);setNumF(5);}
        else if(massIndex == 24 && esterIndex == 2){setMass(492.302670);setNumC(27);setNumH(41);setNumO(2);setNumF(5);}
        else if(massIndex == 25 && esterIndex == 2){setMass(490.287020);setNumC(27);setNumH(39);setNumO(2);setNumF(5);}
        else if(massIndex == 26 && esterIndex == 2){setMass(488.271370);setNumC(27);setNumH(37);setNumO(2);setNumF(5);}
        else if(massIndex == 27 && esterIndex == 2){setMass(486.255720);setNumC(27);setNumH(35);setNumO(2);setNumF(5);}
        else if(massIndex == 28 && esterIndex == 2){setMass(484.240070);setNumC(27);setNumH(33);setNumO(2);setNumF(5);}
        else if(massIndex == 29 && esterIndex == 2){setMass(482.224420);setNumC(27);setNumH(31);setNumO(2);setNumF(5);}
        else if(massIndex == 30 && esterIndex == 2){setMass(506.318320);setNumC(28);setNumH(43);setNumO(2);setNumF(5);}
        else if(massIndex == 31 && esterIndex == 2){setMass(520.333970);setNumC(29);setNumH(45);setNumO(2);setNumF(5);}
        else if(massIndex == 32 && esterIndex == 2){setMass(518.318320);setNumC(29);setNumH(43);setNumO(2);setNumF(5);}
        else if(massIndex == 33 && esterIndex == 2){setMass(516.302670);setNumC(29);setNumH(41);setNumO(2);setNumF(5);}
        else if(massIndex == 34 && esterIndex == 2){setMass(514.287020);setNumC(29);setNumH(39);setNumO(2);setNumF(5);}
        else if(massIndex == 35 && esterIndex == 2){setMass(512.271370);setNumC(29);setNumH(37);setNumO(2);setNumF(5);}
        else if(massIndex == 36 && esterIndex == 2){setMass(510.255720);setNumC(29);setNumH(35);setNumO(2);setNumF(5);}
        else if(massIndex == 37 && esterIndex == 2){setMass(508.240070);setNumC(29);setNumH(33);setNumO(2);setNumF(5);}
        else if(massIndex == 38 && esterIndex == 2){setMass(534.349620);setNumC(30);setNumH(47);setNumO(2);setNumF(5);}
        else if(massIndex == 39 && esterIndex == 2){setMass(548.365270);setNumC(31);setNumH(49);setNumO(2);setNumF(5);}
        else if(massIndex == 40 && esterIndex == 2){setMass(546.349620);setNumC(31);setNumH(47);setNumO(2);setNumF(5);}
        else if(massIndex == 41 && esterIndex == 2){setMass(562.380920);setNumC(32);setNumH(51);setNumO(2);setNumF(5);}
        else if(massIndex == 42 && esterIndex == 2){setMass(576.396570);setNumC(33);setNumH(53);setNumO(2);setNumF(5);}
        return getMass();
    }
    public double calculateWEBasicMass(int alcoholIndex, int acidIndex)
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
