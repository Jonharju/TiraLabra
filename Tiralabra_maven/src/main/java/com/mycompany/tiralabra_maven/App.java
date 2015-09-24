package com.mycompany.tiralabra_maven;

import UI.UI;
import Logiikka.Logiikka;

/**
 * Hello world!
 *
 */
public class App {
    private static Logiikka l = new Logiikka();
    public static void main( String[] args ) {
        UI kayttis = new UI();
        kayttis.run();
    }
}
