/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Logiikka.Logiikka;
import java.util.Scanner;
/**
 *
 * @author Jonas
 */
public class UI {
    private static Logiikka logiikka = new Logiikka();
 
    /**
     * Tekstikäyttöliittymä
     */
    public static void run() {
        System.out.println("Matriisilaskin");
        System.out.println("Valitse toiminto:");
        System.out.println("1 - yhteenlasku, 2 - rivin tai sarakkeen summa, 3 - rivin tai sarakkeen keskiarvo.");
        System.out.println("4 - kertolasku, 5 - koko matriisin summa, 6 - koko matriisin keskiarvo, 7 - skalaarikertolasku");
        Scanner skanneri = new Scanner(System.in);
        String toiminto = skanneri.nextLine();
        
        if (toiminto.equals("1")) {
            System.out.println("Syötä ensimmäinen matriisi");
            double[][] matriisi1 = syotettyMatriisi();
            System.out.println("Ensimmäinen syötetty matriisi:");
            tulostaMatriisi(matriisi1);
            
            System.out.println("Syötä toinen matriisi");
            double[][] matriisi2 = syotettyMatriisi();
            System.out.println("Toinen syötetty matriisi:");
            tulostaMatriisi(matriisi2);

            if (matriisi1.length == matriisi2.length) {
                System.out.println("Syötä matriisi");
                if (matriisi1[0].length == matriisi2[0].length) {
                    double[][] result = logiikka.yhteenlasku(matriisi1, matriisi2);
                    System.out.println("Tulosmatriisi:");
                    tulostaMatriisi(result);
                 } else {
                    System.out.println("Matriisit ovat erityyppiset");
                 }
             } else {
                System.out.println("Erityyppisiä matriiseja ei voi laskea yhteen.");
            }
            
        } else if (toiminto.equals("2")) {
            System.out.println("Syötä matriisi");
            double[][] matriisi = syotettyMatriisi();
            System.out.println("Syötetty matriisi:");
            tulostaMatriisi(matriisi);
            
            System.out.println("R - rivi, S - sarake");
            String syote = skanneri.nextLine();
            
            int rivi = -1;
            int sarake = -1;
            
            if (syote.equals("R")) {
                System.out.println("Rivin numero");
                rivi = skanneri.nextInt();
            } else if (syote.equals("S")) {
                System.out.println("Sarakkeen numero");
                sarake = skanneri.nextInt();
            }
            
            double summa = logiikka.summa(matriisi, rivi-1, sarake-1);
            System.out.println("Alkioiden summa on " + summa);
         
        } else if (toiminto.equals("3")) {
            System.out.println("Syötä matriisi");
            double[][] matriisi = syotettyMatriisi();
            System.out.println("Syötetty matriisi:");
            tulostaMatriisi(matriisi);
            
            System.out.println("R - rivi, S - sarake");
            String syote = skanneri.nextLine();
            int rivi = -1;
            int sarake = -1;
            
            if (syote.equals("R")) {
                System.out.println("Rivin numero, alkaa nollasta");
                rivi = skanneri.nextInt();
             } else if (syote.equals("S")) {
                System.out.println("Sarakkeen numero, alkaa nollasta");
                sarake = skanneri.nextInt();
            }
            
            double keskiarvo = logiikka.keskiarvo(matriisi, rivi-1, sarake-1);
            System.out.println("Alkioiden keskiarvo on " + keskiarvo);
        
        } else if (toiminto.equals("4")) {
            System.out.println("Syötä ensimmäinen matriisi");
            double[][] matriisi1 = syotettyMatriisi();
            System.out.println("Ensimmäinen syötetty matriisi:");
            tulostaMatriisi(matriisi1);
            
            System.out.println("Syötä toinen matriisi");
            double[][] matriisi2 = syotettyMatriisi();
            System.out.println("Toinen syötetty matriisi:");
            tulostaMatriisi(matriisi2);

            if (matriisi1.length == matriisi2[0].length) {
                 double[][] tulos = logiikka.kertolasku(matriisi1, matriisi2);
                 System.out.println("Matriisien kertolaskun tulosmatriisi:");
                 tulostaMatriisi(tulos);
             } else {
                 System.out.println("Matriiseja ei voi kertoa ellei ensimmäisessä matriisissa ole yhtä monta saraketta kuin toisessa matriisissa riviä.");
             }
            
        } else if (toiminto.equals("5")) {
            System.out.println("Syötä matriisi");
            double[][] matriisi = syotettyMatriisi();
            System.out.println("Syötetty matriisi:");
            tulostaMatriisi(matriisi);
            
            double summa = logiikka.summaKoko(matriisi);
            System.out.println("Alkioiden summa on " + summa);
         
        } else if (toiminto.equals("6")) {
            System.out.println("Syötä matriisi");
            double[][] matriisi = syotettyMatriisi();
            System.out.println("Syötetty matriisi:");
            tulostaMatriisi(matriisi);
            
            double keskiarvo = logiikka.keskiarvoKoko(matriisi);
            System.out.println("Alkioiden keskiarvo on " + keskiarvo);
        
        } else if (toiminto.equals("7")) {
            System.out.println("Syötä matriisi");
            double[][] matriisi = syotettyMatriisi();
            System.out.println("Syötetty matriisi:");
            tulostaMatriisi(matriisi);
            
            System.out.println("Syötä skalaariluku");
            int skalaari = skanneri.nextInt();
            
            double[][] tulos = logiikka.skalaari(matriisi, skalaari);
            System.out.println("Matriisin skalaarin tulos: ");
            tulostaMatriisi(matriisi);
        }
        
    }

    /**
     * Metodi luo käyttäjän sille antamien arvojen perusteella matriisin, jonka se palauttaa
     * 
     * @return
     */
    public static double[][] syotettyMatriisi() {
        Scanner skanneri = new Scanner(System.in);
        System.out.println("Anna matriisin sarakkeiden lukumäärä (toistaiseksi enintään 5).");
        
        int sarakkeet = skanneri.nextInt();
        if (sarakkeet > 5) {
            sarakkeet = 5;
        }
        System.out.println("Anna matriisin rivien lukumäärä (toistaiseksi enintään 5).");
        int rivit = skanneri.nextInt();
        if (rivit > 5) {
            rivit = 5;
        }
        
        double[][] matriisi = new double[sarakkeet][rivit];
        
        for (int i = 0; i < rivit; i++) {
            for (int j = 0; j < sarakkeet; j++) {
                System.out.println("Anna matriisin " + (i + 1) + ". rivin " + (j + 1) + ". luku.");
                matriisi[j][i] = skanneri.nextInt();
            }
        }
        return matriisi;
    }
 
    /**
     * Metodi tulostaa sille annetun matriisin alkiot
     * 
     * @param matriisi
     */
    public static void tulostaMatriisi(double[][] matriisi) {
        for (int i = 0; i < matriisi[0].length; i++) {
            String rivi = "[";
            for (int j = 0; j < matriisi.length; j++) {
                rivi = rivi.concat(" " + matriisi[j][i]);
            }
            rivi = rivi.concat(" ]");
            System.out.println(rivi);
        }
    }
}
