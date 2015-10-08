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
public class UI{
    private static Logiikka logiikka = new Logiikka();
    
    /**
     * Tekstikäyttöliittymä
     */
    public static void run() {
        System.out.println("Matriisilaskin");
        System.out.println("Valitse toiminto:");
        System.out.println("1 - yhteenlasku, 2 - rivin tai sarakkeen summa, 3 - rivin tai sarakkeen keskiarvo.");
        System.out.println("4 - kertolasku, 5 - koko matriisin summa, 6 - koko matriisin keskiarvo, 7 - skalaarikertolasku");
        System.out.println("8 - determinantti, 9 - transpoosi, 0 - käänteismatriisi");
        Scanner skanneri = new Scanner(System.in);
        String toiminto = skanneri.nextLine();
        
        if (toiminto.equals("1")) {
            yhteen();
            
        } else if (toiminto.equals("2")) {
            rsSumma();         
        } else if (toiminto.equals("3")) {
            rsKeskiarvo();
        } else if (toiminto.equals("4")) {
            kertolasku();
        } else if (toiminto.equals("5")) {
           summa();
        } else if (toiminto.equals("6")) {
            keskiarvo();
        
        } else if (toiminto.equals("7")) {
            skalaari();
        } else if (toiminto.equals("8")) {
           determinantti();
        } else if (toiminto.equals("9")) {
            transpoosi();
        } else if (toiminto.equals("0")) {
            kaanteis();
        }
        
    }
    

    /**
     * Metodi luo käyttäjän sille antamien arvojen perusteella matriisin, jonka se palauttaa
     * 
     * @return
     */
    public static double[][] syotettyMatriisi() {
        Scanner skanneri = new Scanner(System.in);
        try {  
        System.out.println("Anna matriisin sarakkeiden lukumäärä");
        int sarakkeet = Integer.parseInt(skanneri.nextLine());
        System.out.println("Anna matriisin rivien lukumäärä");
        int rivit = Integer.parseInt(skanneri.nextLine());
        
        double[][] matriisi = new double[rivit][sarakkeet];
        
        for (int i = 0; i < rivit; i++) {
            System.out.println("Anna matriisin " + (i+1) + " rivi.");
            String input = skanneri.nextLine();
            String[] numbers = input.split("[ ]+");
            for (int j = 0; j < sarakkeet; j++) {
                matriisi[i][j] = Integer.parseInt(numbers[j]);
            }
        }
            return matriisi;
        } catch (Exception e) {
            return null;
        }
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
                rivi = rivi.concat(" " + matriisi[i][j]);
            }
            rivi = rivi.concat(" ]");
            System.out.println(rivi);
        }
    }
    
    public static void yhteen(){
        System.out.println("Syötä ensimmäinen matriisi");
            double[][] matriisi1 = syotettyMatriisi();
            
            System.out.println("Syötä toinen matriisi");
            double[][] matriisi2 = syotettyMatriisi();

            if (matriisi1.length == matriisi2.length) {
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
    }
    
    public static void rsSumma(){
        Scanner skanneri = new Scanner(System.in);
        System.out.println("Syötä matriisi");
            double[][] matriisi = syotettyMatriisi();
            
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
    }
    
    public static void rsKeskiarvo(){
        Scanner skanneri = new Scanner(System.in);
        System.out.println("Syötä matriisi");
            double[][] matriisi = syotettyMatriisi();
            
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
        
    }
    
    public static void kertolasku(){
        System.out.println("Syötä ensimmäinen matriisi");
            double[][] matriisi1 = syotettyMatriisi();
            
            System.out.println("Syötä toinen matriisi");
            double[][] matriisi2 = syotettyMatriisi();

            if (matriisi1.length == matriisi2[0].length) {
                 double[][] tulos = logiikka.kertolasku(matriisi1, matriisi2);
                 System.out.println("Matriisien kertolaskun tulosmatriisi:");
                 tulostaMatriisi(tulos);
            } else {
                 System.out.println("Matriiseja ei voi kertoa ellei ensimmäisessä matriisissa ole yhtä monta saraketta kuin toisessa matriisissa riviä.");
            }
    }
    
    public static void summa(){
        System.out.println("Syötä matriisi");
        double[][] matriisi = syotettyMatriisi();
            
        double summa = logiikka.summaKoko(matriisi);
        System.out.println("Alkioiden summa on " + summa);
    }
    public static void keskiarvo(){
        System.out.println("Syötä matriisi");
            double[][] matriisi = syotettyMatriisi();
            
            double keskiarvo = logiikka.keskiarvoKoko(matriisi);
            System.out.println("Alkioiden keskiarvo on " + keskiarvo);
    }
    
    public static void skalaari(){
        Scanner skanneri = new Scanner(System.in);
        System.out.println("Syötä matriisi");
            double[][] matriisi = syotettyMatriisi();
            
            System.out.println("Syötä skalaariluku");
            int skalaari = skanneri.nextInt();
            
            double[][] tulos = logiikka.skalaari(matriisi, skalaari);
            System.out.println("Matriisin skalaarin tulos: ");
            tulostaMatriisi(matriisi);
    }
    
    public static void determinantti(){
         System.out.println("Syötä matriisi");
            double[][] matriisi = syotettyMatriisi();
            
            double tulos = logiikka.determinantti(matriisi);
            System.out.println("Matriisin determinantti on: " + matriisi);
    }
    
    public static void transpoosi(){
        System.out.println("Syötä matriisi");
            double[][] matriisi = syotettyMatriisi();
            
            double[][] tulos = logiikka.transpoosi(matriisi);
            System.out.println("Matriisin transpoosi");;
            tulostaMatriisi(matriisi);
    }
    
    public static void kaanteis(){
        System.out.println("Syötä matriisi");
            double[][] matriisi = syotettyMatriisi();
            
            double[][] tulos = logiikka.kaanteis(matriisi);
            System.out.println("Matriisin käänteismatriisi");;
            tulostaMatriisi(matriisi);
    }
}

