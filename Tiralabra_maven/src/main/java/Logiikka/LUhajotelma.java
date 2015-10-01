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
public class LUhajotelma {

    /**
     * Metodi laskee LUhajotelman, ja palauttaa U-matriisin
     * 
     * @param matriisi
     * @return
     */
    public double[][] LUHajotelma(double[][] matriisi) {
        int n = matriisi.length;
        // Luodaan ja alustetaan matriisit L ja U.
        double[][] matriisiL = new double[n][n];
        double[][] matriisiU = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriisiL[i][j] = 0;
                matriisiU[i][j] = 0;
                if (i == j) {
                    matriisiL[i][j] = 1;
                }
            }
        }
        // Lasketaan hajotelma L- ja U-matriiseihin syötematriisin avulla.
        for (int k = 0; k < n; k++) {
            Double luku = Double.valueOf(matriisi[k][k]);
            matriisiU[k][k] = Double.valueOf(luku);
            for (int i = k + 1; i < n; i++) {
                matriisiL[k][i] = matriisi[k][i] / matriisiU[k][k];
                Double luku2 = Double.valueOf(matriisi[i][k]);
                matriisiU[i][k] = Double.valueOf(luku2);
            }
            for (int i = k + 1; i < n; i++) {
                for (int j = k + 1; j < n; j++) {
                    matriisi[j][i] = matriisi[j][i] - matriisiL[k][i] * matriisiU[j][k];
                }
            }
        }
        return matriisiU;
    }
    
    /**
     * Metodi laskee U-matriisin perusteella determinantin
     * 
     * @param matriisi
     * @return
     */
    public double determinanttiU(double[][] matriisi) {
        int n = matriisi.length;
        // Lasketaan determinantti hajotelman U-matriisista.
        double determinatti = matriisi[0][0];
        for (int k = 1; k < n; k++) {
            determinatti = determinatti * matriisi[k][k];
        }
        // Pyöristetään laskennassa käytetyistä epätarkoista liukuluvuista aiheutuvat ylimääräiset desimaalit.
        // Koska LU-hajotelmassa murtoluvut käsitellään epätarkkoina liukulukuina, on determinanttina
        // ilman pyöristystä usein x.00000000000001 silloin kun todellinen determinantti on x.
        String det = Double.toString(determinatti);
        if (det.length() > 10) {
            if (det.charAt(4) == '0' && det.charAt(10) == '0') {
                determinatti = Math.round(determinatti);
                System.out.println(determinatti);
            } else if (det.charAt(4) == '9' && det.charAt(10) == '9'){
                determinatti = Math.round(determinatti);
                System.out.println(determinatti);
            }
        }
        return determinatti;
    }
}
