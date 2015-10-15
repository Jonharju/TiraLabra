/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Logiikka.Logiikka;
import Logiikka.Matriisi;
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
        while (true){
            System.out.println("Valitse toiminto:");
            System.out.println("1 - yhteenlasku, 2 - rivin tai sarakkeen summa, 3 - rivin tai sarakkeen keskiarvo.");
            System.out.println("4 - kertolasku, 5 - koko matriisin summa, 6 - koko matriisin keskiarvo, 7 - skalaarikertolasku");
            System.out.println("8 - determinantti, 9 - transpoosi, 0 - käänteismatriisi, x - lopeta");
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
            } else if (toiminto.equals("x")){
                break;
            }
        }
    }
    

    /**
     * Metodi luo käyttäjän sille antamien arvojen perusteella matriisin, jonka se palauttaa
     * 
     * @return
     */
    public static Matriisi syotettyMatriisi() {
        Scanner skanneri = new Scanner(System.in);
        try {  
        System.out.println("Anna matriisin sarakkeiden lukumäärä");
        int sarakkeet = Integer.parseInt(skanneri.nextLine());
        System.out.println("Anna matriisin rivien lukumäärä");
        int rivit = Integer.parseInt(skanneri.nextLine());
        
        double[][] matriisi = new double[rivit][sarakkeet];
        boolean onnistunut = false;
        while(true){
            for (int i = 0; i < rivit; i++) {
                System.out.println("Anna matriisin " + (i+1) + " rivi.");
                String input = skanneri.nextLine();
                String[] numbers = input.split(" ");
                if(numbers.length != sarakkeet){
                    System.out.println("vääränlainen syöte");
                    break;
                }
                for (int j = 0; j < sarakkeet; j++) {
                    matriisi[i][j] = Integer.parseInt(numbers[j]);
                    if(i == rivit - 1 && j == sarakkeet - 1){
                        onnistunut = true;
                    }
                }  
            }
            if(onnistunut){
                break;
            }
        }
        Matriisi m = new Matriisi(matriisi);
        
        return m;
        } catch (Exception e) {
            return null;
        }
    }
 
    /**
     * Metodi tulostaa sille annetun matriisin alkiot
     * 
     * @param matriisi
     */
    public static void tulostaMatriisi(Matriisi matriisi) {
        for (int i = 0; i < matriisi.getRivit(); i++) {
            String rivi = "[";
            for (int j = 0; j < matriisi.getSarakkeet(); j++) {
                rivi = rivi.concat(" " + matriisi.getArvot()[i][j]);
            }
            rivi = rivi.concat(" ]");
            System.out.println(rivi);
        }
    }
    
    public static void yhteen(){
        System.out.println("Syötä ensimmäinen matriisi");
            Matriisi m1 = syotettyMatriisi();
            System.out.println("Syötä toinen matriisi");
            Matriisi m2 = syotettyMatriisi();
            if (m1.getRivit() == m2.getRivit()) {
                if (m1.getSarakkeet() == m2.getSarakkeet()) {
                    Matriisi result = logiikka.yhteenlasku(m1, m2);
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
            Matriisi m= syotettyMatriisi();
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
            
            double summa = logiikka.summa(m, rivi-1, sarake-1);
            System.out.println("Alkioiden summa on " + summa);
    }
    
    public static void rsKeskiarvo(){
        Scanner skanneri = new Scanner(System.in);
        System.out.println("Syötä matriisi");
            Matriisi m = syotettyMatriisi();
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
            
            double keskiarvo = logiikka.keskiarvo(m, rivi-1, sarake-1);
            System.out.println("Alkioiden keskiarvo on " + keskiarvo);
        
    }
    
    public static void kertolasku(){
        System.out.println("Syötä ensimmäinen matriisi");
            Matriisi m1 = syotettyMatriisi();
            System.out.println("Syötä toinen matriisi");
            Matriisi m2 = syotettyMatriisi();

            if (m1.getRivit() == m2.getSarakkeet()) {
                 Matriisi tulos = logiikka.kertolasku(m1, m2);
                 System.out.println("Matriisien kertolaskun tulosmatriisi:");
                 tulostaMatriisi(tulos);
            } else {
                 System.out.println("Matriiseja ei voi kertoa ellei ensimmäisessä matriisissa ole yhtä monta saraketta kuin toisessa matriisissa riviä.");
            }
    }
    
    public static void summa(){
        System.out.println("Syötä matriisi");
        Matriisi m = syotettyMatriisi();    
        double summa = logiikka.summaKoko(m);
        System.out.println("Alkioiden summa on " + summa);
    }
    public static void keskiarvo(){
        System.out.println("Syötä matriisi");
            Matriisi m = syotettyMatriisi();
            double keskiarvo = logiikka.keskiarvoKoko(m);
            System.out.println("Alkioiden keskiarvo on " + keskiarvo);
    }
    
    public static void skalaari(){
        Scanner skanneri = new Scanner(System.in);
        System.out.println("Syötä matriisi");
            Matriisi m = syotettyMatriisi();
            System.out.println("Syötä skalaariluku");
            int skalaari = skanneri.nextInt();
            
            Matriisi tulos = logiikka.skalaari(m, skalaari);
            System.out.println("Matriisin skalaarin tulos: ");
            tulostaMatriisi(tulos);
    }
    
    public static void determinantti(){
         System.out.println("Syötä matriisi");
            Matriisi m = syotettyMatriisi();
            double tulos = logiikka.determinantti(m);
            System.out.println("Matriisin determinantti on: " + tulos);
    }
    
    public static void transpoosi(){
        System.out.println("Syötä matriisi");
            Matriisi m = syotettyMatriisi();
            Matriisi tulos = logiikka.transpoosi(m);
            System.out.println("Matriisin transpoosi");;
            tulostaMatriisi(tulos);
    }
    
    public static void kaanteis(){
        System.out.println("Syötä matriisi");
            Matriisi m = syotettyMatriisi();
            Matriisi tulos = logiikka.kaanteis(m);
            System.out.println("Matriisin käänteismatriisi");;
            tulostaMatriisi(tulos);
    }
}

