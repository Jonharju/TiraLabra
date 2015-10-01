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
public class Matriisi {

    /**
     *
     */
    public int rivit;

    /**
     *
     */
    public int sarakkeet;
    private double[][] arvot;

    /**
     *
     * @param arvot
     */
    public Matriisi(double[][] arvot) {
        this.arvot = arvot;
        this.rivit = arvot.length;
        this.sarakkeet = arvot[0].length;
    }

    /**
     *
     * @return
     */
    public int getRivit() {
        return rivit;
    }

    /**
     *
     * @param rivit
     */
    public void setRivit(int rivit) {
        this.rivit = rivit;
    }

    /**
     *
     * @return
     */
    public int getSarakkeet() {
        return sarakkeet;
    }

    /**
     *
     * @param sarakkeet
     */
    public void setSarakkeet(int sarakkeet) {
        this.sarakkeet = sarakkeet;
    }

    /**
     *
     * @return
     */
    public double[][] getArvot() {
        return arvot;
    }

    /**
     *
     * @param arvot
     */
    public void setArvot(double[][] arvot) {
        this.arvot = arvot;
    }
    
    
}
