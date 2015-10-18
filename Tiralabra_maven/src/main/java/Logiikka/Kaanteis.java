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
public class Kaanteis {
    

    double[][] jaaKaanteisMatriisi(double[][] matriisi) {
        double[][] kaanteis = new double[matriisi.length][matriisi.length];

        for (int i = 0; i < matriisi.length; i++) {
            for (int j = matriisi[i].length / 2; j < matriisi[i].length; j++) {
                kaanteis[i][j - matriisi.length] = matriisi[i][j];
            }
        }
        
        return kaanteis;
    }
    

    double[][] lisaaYksikkoMatriisi(double[][] matriisi) {
        double[][] yhdiste = new double[matriisi.length][matriisi.length * 2];
        
        for (int i = 0; i < matriisi.length; i++) {
            for (int j = 0; j < matriisi.length; j++) {
                yhdiste[i][j] = matriisi[i][j];
            }
            
        }
        for (int i = matriisi.length; i < yhdiste[0].length; i++) {
            yhdiste[i - matriisi.length][i] = 1;
        }
        
        return yhdiste;
    }
    
    /**
     * Laskee matriisin redusoidun porrasmatriisin
     * 
     * @param matrisii
     * @return
     */
    public double [][] redusoitu(double [][] matrisii) {

        int riviMaksimiJohtoalkiolla = 0;

        for (int k = 0; k < matrisii.length; k++) {
            riviMaksimiJohtoalkiolla = k;

            // Pivotoidaan suurimman alkion mukaan
            for (int i = k; i < matrisii.length; i++) {
                if (matrisii[i][k] > matrisii[riviMaksimiJohtoalkiolla][k]) {
                    riviMaksimiJohtoalkiolla = i;
                }
            }

            vaihdaRivit(matrisii, k, riviMaksimiJohtoalkiolla);

            // Muutetaan yläkolmiomuotoon
            for (int i = k + 1; i < matrisii.length; i++) {
                for (int j = k + 1; j < matrisii[k].length; j++) {
                    matrisii[i][j] = matrisii[i][j] - matrisii[k][j] * (matrisii[i][k] / matrisii[k][k]);
                }
                matrisii[i][k] = 0;
            }
        }

        // Nollataan kaikki nollattavissa olevat arvot yläkolmiomatriisista
        for (int k = matrisii.length - 1; k >= 0; k--) {
            int indeksi = loydaJohtavaAlkio(matrisii[k]);

            for (int i = 0; i < k; i++) {
                double multiplier = matrisii[i][indeksi] / matrisii[k][indeksi];
                vahennaRiviKertoimella(matrisii[k], matrisii[i], multiplier);
            }
            double pivot = matrisii[k][indeksi];

            for (int i = indeksi; i < matrisii[k].length; i++) {
                matrisii[k][i] /= pivot;
            }
        }

        return matrisii;
    }

    /**
     * Etsii ensimmäisen nollasta poikkeavan alkion
     * 
     * @param row
     * @return
     */
    public int loydaJohtavaAlkio(double[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Vähentää ensimmäisestä rivistä toista riviä multiplier-parametrin lukumäärän
     * @param row1
     *@param row2 
     * @param multiplier     */
    public void vahennaRiviKertoimella(double[] row1, double[] row2, double multiplier) {
        if (row1.length != row2.length) {
            throw new IllegalArgumentException("Rivien on oltava yhtä pitkiä");
        }
        
        for (int i = 0; i < row1.length; i++) {
            row2[i] -= row1[i] * multiplier;
        }
    }

    /**
     * Vaihtaa kahden rivin paikkaa matriisissa
     *    * @param 
     * @param matrix
     * @param row1@param row2     */
    public void vaihdaRivit(double[][] matrix, int row1, int row2) {
        double[] temp = matrix[row1];
        
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }
}
