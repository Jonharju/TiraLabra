package com.mycompany.tiralabra_maven;

import UI.UI;
import Logiikka.Logiikka;

/**
 * Hello world!
 *
 */
public class App {
    private static Logiikka l = new Logiikka();

    /**
     *
     * @param args
     */
    public static void main( String[] args ) {
        Logiikka logiikka = new Logiikka();
        UI kayttis = new UI();
        kayttis.run();
    }
}
