/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

/**
 *
 * @author Jonas
 */
public class Logiikka {

    /**
     * Metodi laskee rivin tai sarakkeen alkioiden summan ja palauttaa sen
     * 
     * @param matriisi
     * @param rivi
     * @param sarake
     * @return summa
     */
    public double summa(Matriisi matriisi, int rivi, int sarake) {
        double summa = 0;
        if (rivi >= 0) {
            for (int i = 0; i < matriisi.getRivit(); i++) {
                summa = summa + matriisi.getArvot()[i][rivi];
            }
        } else if (sarake >= 0) {
            for (int i = 0; i < matriisi.getSarakkeet(); i++) {
                summa = summa + matriisi.getArvot()[sarake][i];
            }
        }
        return summa;
    }
    
    /**
     * Metodi laskee kaikkien alkioiden summan ja palauttaa sen
     * 
     * @param matriisi
     * @return summa
     */
    public double summaKoko(Matriisi matriisi) {
        double summa = 0;
            for (int i = 0; i < matriisi.rivit; i++) {
                summa = summa + summa(matriisi, -1, i);
            }
        return summa;
    }
    

    /**
     * Metodi laskee rivin tai sarakkeen alkioiden keskiarvon ja palauttaa sen
     * 
     * @param matriisi
     * @param rivi
     * @param sarake
     * @return
     */
    public double keskiarvo(Matriisi matriisi, int rivi, int sarake) {
        double keskiarvo = 0;
        int maara = 0;
        if (rivi >= 0) {
            for (int i = 0; i < matriisi.getRivit(); i++) {
                keskiarvo = keskiarvo + matriisi.getArvot()[i][rivi];
                maara++;
            }
        } else if (sarake >= 0) {
            for (int i = 0; i < matriisi.getSarakkeet(); i++) {
                keskiarvo = keskiarvo + matriisi.getArvot()[sarake][i];
                maara++;
            }
        }
        keskiarvo = keskiarvo / maara;
        return keskiarvo;
    }
    
    /**
     * Metodi laskee kaikkien alkioiden keskiarvon ja palauttaa sen
     * 
     * @param matriisi
     * @return
     */
    public double keskiarvoKoko(Matriisi matriisi) {
        double keskiarvo = 0;
        int maara = matriisi.getRivit() * matriisi.getSarakkeet();
            for (int i = 0; i < matriisi.getRivit(); i++) {
                keskiarvo = keskiarvo + summa(matriisi, -1, i);
            }
        
        keskiarvo = keskiarvo / maara;
        return keskiarvo;
    }
    
    /**
     * Metodi laksee kahden matriisin alkiot yhteen ja palauttaa tulosmatriisin käyttäjälle
     * 
     * @param matriisi1
     * @param matriisi2
     * @return 
     */
    public Matriisi yhteenlasku(Matriisi matriisi1, Matriisi matriisi2) {
        double[][] matriisiUusi = new double[matriisi1.getRivit()][matriisi1.getSarakkeet()];
        if (matriisi1.getRivit() != matriisi2.getRivit() || matriisi1.getSarakkeet() != matriisi2.getSarakkeet() ) throw new RuntimeException("Eivät ole keskenään sopivia");
        for (int i = 0; i < matriisiUusi.length; i++) {
            for (int j = 0; j < matriisiUusi[0].length; j++) {
                matriisiUusi[i][j] = matriisi1.getArvot()[i][j] + matriisi2.getArvot()[i][j];
            }
        }
        Matriisi uusi = new Matriisi(matriisiUusi);
        return uusi;
    }
    
    /**
     * Metodi laskee kahden matriisin kertolaskun ja palauttaa niiden tulosmatriisin
     * 
     * @param matriisi1
     * @param matriisi2
     * @return
     */
    public Matriisi kertolasku(Matriisi matriisi1, Matriisi matriisi2) {
        double[][] matriisi = new double[matriisi1.getRivit()][matriisi2.getSarakkeet()];
        if (matriisi1.getSarakkeet()!= matriisi2.getRivit() ) throw new RuntimeException("Eivät ole keskenään sopivia");
        for (int i = 0; i < matriisi1.getRivit(); i++) {
            for (int j = 0; j < matriisi2.getSarakkeet(); j++) {
                matriisi[i][j] = 0;
                for (int k = 0; k < matriisi1.getSarakkeet(); k++) {
                    matriisi[i][j] = matriisi[i][j] + (matriisi1.getArvot()[i][k] * matriisi2.getArvot()[k][j]);
                }
            }
        }
        Matriisi m = new Matriisi(matriisi);
        return m;
    }
    
    /**
     * Metodi laskee matriisin ja skalaarin tulon
     * 
     * @param matriisi
     * @param skalaari
     * @return
     */
    public Matriisi skalaari(Matriisi matriisi, double skalaari) {
        double[][] matriisiUusi = new double[matriisi.getRivit()][matriisi.getSarakkeet()];
        for (int i = 0; i < matriisi.getRivit(); i++) {
            for (int j = 0; j < matriisi.getSarakkeet(); j++) {
                matriisiUusi[i][j] = matriisi.getArvot()[i][j] * skalaari;
            }
        }
        Matriisi uusi = new Matriisi(matriisiUusi);
        return uusi;
    }
    
    /**
     * Metodi luo matriisin transpoosin
     * 
     * @param matriisi
     * @return
     */
    public Matriisi transpoosi(Matriisi matriisi){
        double[][] transpoosi = new double[matriisi.getSarakkeet()][matriisi.getRivit()];
        for(int i = 0; i < matriisi.getRivit(); i++){
            for(int j = 0; j < matriisi.getSarakkeet(); j++){
                transpoosi[j][i] = matriisi.getArvot()[i][j];
            }
        }
        Matriisi t = new Matriisi(transpoosi);
        return t;
    }
    
    /**
     * Metodi laskee matriisin determinantin, jos se on neliömatriisi
     * 
     * @param matriisi
     * @return
     */
    public double determinantti(Matriisi matriisi){
        if (matriisi.getRivit() != matriisi.getSarakkeet() ) throw new RuntimeException("Ei ole neliö matriisi");
        double summa = 0;
        int s;
        if (matriisi.getRivit() != matriisi.getSarakkeet() ) throw new RuntimeException("Ei ole neliö matriisi");
        if(matriisi.getRivit()== 1){
            return (matriisi.getArvot()[0][0]);
        }
        for(int i = 0; i < matriisi.getRivit(); i++){
            double[][] pienempi = new double[matriisi.getRivit()-1][matriisi.getSarakkeet()-1];
            for(int a = 1; a < matriisi.getRivit(); a++){
                for(int b = 0; b < matriisi.getSarakkeet(); b++){
                    if(b<i){
                        pienempi[a-1][b]=matriisi.getArvot()[a][b];
                    } else if(b>i){
                        pienempi[a-1][b-1]=matriisi.getArvot()[a][b];
                    }
                }
            }
            if(i%2==0){
                s=1;
            } else {
                s=-1;
            }
            Matriisi p = new Matriisi(pienempi);
            summa += s*matriisi.getArvot()[0][i]*(determinantti(p));
        }
        return(summa);
    }
    
    /**
     * Metodi laskee Matriisin determinanten, käyttäen apunaan LU-hajotelmaa
     * 
     * @param matriisi
     * @return
     */
    public double determinanttiLU(Matriisi matriisi) {
        if (matriisi.getRivit() != matriisi.getSarakkeet() ) throw new RuntimeException("Ei ole neliö matriisi");
        LUhajotelma logic = new LUhajotelma();
        matriisi.setArvot(logic.LUHajotelma(matriisi.getArvot()));
        return logic.determinanttiU(matriisi.getArvot());
    }
    
    /**
     * Metodi laskee neliömatriisin käänteismatriisin
     * 
     * @param matriisi
     * @return
     */
    public Matriisi kaanteis(Matriisi matriisi) {
        Kaanteis k = new Kaanteis();
        if (matriisi.getRivit() != matriisi.getSarakkeet()) throw new RuntimeException("Ei ole neliö matriisi");
        double[][] matrix = k.lisaaYksikkoMatriisi(matriisi.getArvot());
        double [][] rrefMatrix = k.redusoitu(matrix);
        return new Matriisi(k.jaaKaanteisMatriisi(rrefMatrix));
    }
}
