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
     * @return
     */
    public double summa(double[][] matriisi, int rivi, int sarake) {
        double summa = 0;
        if (rivi >= 0) {
            for (int i = 0; i < matriisi.length; i++) {
                summa = summa + matriisi[i][rivi];
            }
        } else if (sarake >= 0) {
            for (int i = 0; i < matriisi[0].length; i++) {
                summa = summa + matriisi[sarake][i];
            }
        }
        return summa;
    }
    
    /**
     * Metodi laskee kaikkien alkioiden summan ja palauttaa sen
     * 
     * @param matriisi
     * @return
     */
    public double summaKoko(double[][] matriisi) {
        double summa = 0;
            for (int i = 0; i < matriisi.length; i++) {
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
    public double keskiarvo(double[][] matriisi, int rivi, int sarake) {
        double keskiarvo = 0;
        int maara = 0;
        if (rivi >= 0) {
            for (int i = 0; i < matriisi.length; i++) {
                keskiarvo = keskiarvo + matriisi[i][rivi];
                maara++;
            }
        } else if (sarake >= 0) {
            for (int i = 0; i < matriisi[0].length; i++) {
                keskiarvo = keskiarvo + matriisi[sarake][i];
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
    public double keskiarvoKoko(double[][] matriisi) {
        double keskiarvo = 0;
        int maara = matriisi.length * matriisi[0].length;
            for (int i = 0; i < matriisi.length; i++) {
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
    public double[][] yhteenlasku(double[][] matriisi1, double[][] matriisi2) {
        double[][] matriisiUusi = new double[matriisi1.length][matriisi1[0].length];
        if (matriisi1.length != matriisi2.length || matriisi1[0].length != matriisi2[0].length ) throw new RuntimeException("Eivät ole keskenään sopivia");
        for (int i = 0; i < matriisiUusi.length; i++) {
            for (int j = 0; j < matriisiUusi[0].length; j++) {
                matriisiUusi[i][j] = matriisi1[i][j] + matriisi2[i][j];
            }
        }
        return matriisiUusi;
    }
    
    /**
     * Metodi laskee kahden matriisin kertolaskun ja palauttaa niiden tulosmatriisin
     * 
     * @param matriisi1
     * @param matriisi2
     * @return
     */
    public double[][] kertolasku(double[][] matriisi1, double[][] matriisi2) {
        double[][] matriisi = new double[matriisi1.length][matriisi2[0].length];
        if (matriisi1[0].length != matriisi2.length ) throw new RuntimeException("Eivät ole keskenään sopivia");
        for (int i = 0; i < matriisi.length; i++) {
            for (int j = 0; j < matriisi[0].length; j++) {
                matriisi[i][j] = 0;
                for (int k = 0; k < matriisi1[0].length; k++) {
                    matriisi[i][j] = matriisi[i][j] + (matriisi1[i][k] * matriisi2[k][j]);
                }
            }
        }
        return matriisi;
    }
    
    /**
     * Metodi laskee matriisin ja skalaarin tulon
     * 
     * @param matriisi
     * @param skalaari
     * @return
     */
    public double[][] skalaari(double[][] matriisi, double skalaari) {
        for (int i = 0; i < matriisi.length; i++) {
            for (int j = 0; j < matriisi[0].length; j++) {
                matriisi[i][j] = matriisi[i][j] * skalaari;
            }
        }
        return matriisi;
    }
    
    /**
     * Metodi luo matriisin transpoosin
     * 
     * @param matriisi
     * @return
     */
    public double[][] transpoosi(double[][] matriisi){
        double[][] transpoosi = new double[matriisi[0].length][matriisi.length];
        for(int i = 0; i < matriisi.length; i++){
            for(int j = 0; j < matriisi[0].length; j++){
                transpoosi[j][i] = matriisi[i][j];
            }
        }
        return transpoosi;
    }
    
    /**
     * Metodi laskee matriisin determinantin, jos se on neliömatriisi
     * 
     * @param matriisi
     * @return
     */
    public double determinantti(double[][] matriisi){
        double summa = 0;
        int s;
        if (matriisi.length != matriisi[0].length ) throw new RuntimeException("Ei ole neliö matriisi");
        if(matriisi.length == 1){
            return (matriisi[0][0]);
        }
        for(int i = 0; i < matriisi.length; i++){
            double[][] pienempi = new double[matriisi.length-1][matriisi.length-1];
            for(int a = 1; a < matriisi.length; a++){
                for(int b = 0; b < matriisi.length; b++){
                    if(b<i){
                        pienempi[a-1][b]=matriisi[a][b];
                    } else if(b>i){
                        pienempi[a-1][b-1]=matriisi[a][b];
                    }
                }
            }
            if(i%2==0){
                s=1;
            } else {
                s=-1;
            }
            summa += s*matriisi[0][i]*(determinantti(pienempi));
        }
        return(summa);
    }

}
