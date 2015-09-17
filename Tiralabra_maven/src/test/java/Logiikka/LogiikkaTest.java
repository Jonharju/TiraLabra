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
    
    
    @Test
    public void testSummaKoko() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[2][3];
        matriisi[0][0] = 1;
        matriisi[0][1] = 2;
        matriisi[0][2] = 1;
        matriisi[1][0] = 1;
        matriisi[1][1] = 3;
        matriisi[1][2] = 1;
        double actual = logiikka.summaKoko(matriisi);
        double expected = 9;
        assertTrue(actual == expected);
    }
    
    @Test
    public void testSummaKoko1() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[3][3];
        matriisi[0][0] = 3;
        matriisi[0][1] = 4;
        matriisi[0][2] = 5;
        matriisi[1][0] = -1;
        matriisi[1][1] = 2;
        matriisi[1][2] = 5;
        matriisi[2][0] = 9;
        matriisi[2][1] = 8;
        matriisi[2][2] = 7;
        double actual = logiikka.summaKoko(matriisi);
        double expected = 42;
        assertTrue(actual == expected);
    }
    
    
    @Test
    public void testiKeskiarvoKoko() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[2][3];
        matriisi[0][0] = 2;
        matriisi[0][1] = 3;
        matriisi[0][2] = 1;
        matriisi[1][0] = 4;
        matriisi[1][1] = 5;
        matriisi[1][2] = 3;
        double actual = logiikka.keskiarvoKoko(matriisi);
        double expected = 3;
        assertTrue(actual == expected);
    }
    
    @Test
    public void testiKeskiarvoKoko1() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[3][3];
        matriisi[0][0] = 6;
        matriisi[0][1] = 8;
        matriisi[0][2] = 6;
        matriisi[1][0] = -2;
        matriisi[1][1] = 3;
        matriisi[1][2] = 6;
        matriisi[2][0] = 10;
        matriisi[2][1] = 8;
        matriisi[2][2] = 9;
        double actual = logiikka.keskiarvoKoko(matriisi);
        double expected = 6;
        assertTrue(actual == expected);
    }
    
    @Test
    public void testKertoma() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi1 = new double[2][3];
        double[][] matriisi2 = new double[3][2];
        matriisi1[0][0] = 2;
        matriisi1[0][1] = 1;
        matriisi1[0][2] = 4;
        matriisi1[1][0] = 3;
        matriisi1[1][1] = 4;
        matriisi1[1][2] = 3;
        matriisi2[0][0] = 2;
        matriisi2[0][1] = 4;
        matriisi2[1][0] = 2;
        matriisi2[1][1] = 4;
        matriisi2[2][0] = 4;
        matriisi2[2][1] = 2;
        double[][] matrix = logiikka.kertolasku(matriisi1, matriisi2);
        double actual = matrix[1][1];
        double expected = 18;
        assertTrue(actual == expected);
    }
    
    @Test
    public void testSkalaari() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[1][2];
        matriisi[0][0] = 2;
        matriisi[0][1] = 1;
        double[][] tulos = logiikka.skalaari(matriisi, -2);
        double actual = matriisi[0][0];
        double expected = -4;
        assertTrue(actual == expected); 
    }
    
    
}
