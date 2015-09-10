/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonas
 */
public class LogiikkaTest {
    
    public LogiikkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testiYhteen() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi1 = new double[2][2];
        double[][] matriisi2 = new double[2][2];
        matriisi1[0][0] = 4;
        matriisi1[0][1] = 5;
        matriisi1[1][0] = 6;
        matriisi1[1][1] = 7;
        matriisi2[0][0] = 8;
        matriisi2[0][1] = 7;
        matriisi2[1][0] = 6;
        matriisi2[1][1] = 5;
        double[][] matrix = logiikka.yhteenlasku(matriisi1, matriisi2);
        double actual = matrix[0][0];
        double expected = matriisi1[0][0] + matriisi2[0][0];
        assertTrue(actual == expected);
    }
    
    public void testiYhteen1() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi1 = new double[2][2];
        double[][] matriisi2 = new double[2][2];
        matriisi1[0][0] = 1;
        matriisi1[0][1] = 1;
        matriisi1[1][0] = 1;
        matriisi1[1][1] = 1;
        matriisi2[0][0] = 1;
        matriisi2[0][1] = 1;
        matriisi2[1][0] = 1;
        matriisi2[1][1] = 1;
        double[][] matrix = logiikka.yhteenlasku(matriisi1, matriisi2);
        double actual = matrix[0][0];
        double expected = matriisi1[0][0] + matriisi2[0][0];
        assertTrue(actual == expected);
    }
    
    public void testiYhteen2() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi1 = new double[2][2];
        double[][] matriisi2 = new double[2][2];
        matriisi1[0][0] = 1;
        matriisi1[0][1] = 1;
        matriisi1[1][0] = 1;
        matriisi1[1][1] = 1;
        matriisi2[0][0] = 1;
        matriisi2[0][1] = 1;
        matriisi2[1][0] = 1;
        matriisi2[1][1] = 1;
        double[][] matrix = logiikka.yhteenlasku(matriisi1, matriisi2);
        double actual = matrix[1][1];
        double expected = matriisi1[1][1] + matriisi2[1][1];
        assertTrue(actual == expected);
    }
    
    @Test
    public void testiKeskiarvo() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[2][3];
        matriisi[0][0] = 1;
        matriisi[0][1] = 2;
        matriisi[0][2] = 1;
        matriisi[1][0] = 1;
        matriisi[1][1] = 3;
        matriisi[1][2] = 1;
        double actual = logiikka.keskiarvo(matriisi, 1, -1);
        double expected = (matriisi[0][1] + matriisi[1][1]) / 2;
        assertTrue(actual == expected);
    }
    
    @Test
    public void testiKeskiarvo1() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[2][3];
        matriisi[0][0] = 1;
        matriisi[0][1] = 1;
        matriisi[0][2] = 1;
        matriisi[1][0] = 2;
        matriisi[1][1] = 2;
        matriisi[1][2] = 2;
        double actual = logiikka.keskiarvo(matriisi, 1, -1);
        double expected = (matriisi[0][1] + matriisi[1][1]) / 2;
        assertTrue(actual == expected);
    }
    
    @Test
    public void testiKeskiarvo2() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[2][3];
        matriisi[0][0] = 1;
        matriisi[0][1] = 1;
        matriisi[0][2] = 1;
        matriisi[1][0] = 2;
        matriisi[1][1] = 2;
        matriisi[1][2] = 2;
        double actual = logiikka.keskiarvo(matriisi, -1, 1);
        double expected = (matriisi[1][0] + matriisi[1][1]+matriisi[1][2]) /3;
        assertTrue(actual == expected);
    }
    
    @Test
    public void testSumma() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[2][3];
        matriisi[0][0] = 1;
        matriisi[0][1] = 2;
        matriisi[0][2] = 1;
        matriisi[1][0] = 1;
        matriisi[1][1] = 3;
        matriisi[1][2] = 1;
        double actual = logiikka.summa(matriisi, 1, -1);
        double expected = matriisi[0][1] + matriisi[1][1];
        assertTrue(actual == expected);
    }
    
    @Test
    public void testSumma1() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[2][3];
        matriisi[0][0] = 1;
        matriisi[0][1] = 1;
        matriisi[0][2] = 1;
        matriisi[1][0] = 2;
        matriisi[1][1] = 2;
        matriisi[1][2] = 2;
        double actual = logiikka.summa(matriisi, 1, -1);
        double expected = matriisi[0][1] + matriisi[1][1];
        assertTrue(actual == expected);
    }
    
    @Test
    public void testSumma2() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[2][3];
        matriisi[0][0] = 1;
        matriisi[0][1] = 1;
        matriisi[0][2] = 1;
        matriisi[1][0] = 2;
        matriisi[1][1] = 2;
        matriisi[1][2] = 2;
        double actual = logiikka.summa(matriisi, -1, 1);
        double expected = matriisi[1][0] + matriisi[1][1]+matriisi[1][2];
        assertTrue(actual == expected);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
