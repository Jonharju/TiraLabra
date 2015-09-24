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
    public void testiYhteen2x2() {
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
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                double actual = matrix[i][j];
                double expected = matriisi1[i][j] + matriisi2[i][j];
                assertTrue(actual == expected);
            }
        } 
    }
    
    public void testiYhteen3x3() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi1 = new double[3][3];
        double[][] matriisi2 = new double[3][3];
        matriisi1[0][0] = 1;
        matriisi1[0][1] = 1;
        matriisi1[0][2] = 1;
        matriisi1[1][0] = 1;
        matriisi1[1][1] = 1;
        matriisi1[1][2] = 1;
        matriisi1[2][0] = 1;
        matriisi1[2][1] = 1;
        matriisi1[2][2] = 1;
        matriisi2[0][0] = 1;
        matriisi2[0][1] = 1;
        matriisi2[0][2] = 1;
        matriisi2[1][0] = 1;
        matriisi2[1][1] = 1;
        matriisi2[1][2] = 1;
        matriisi2[2][0] = 1;
        matriisi2[2][1] = 1;
        matriisi2[2][2] = 1;
        double[][] matrix = logiikka.yhteenlasku(matriisi1, matriisi2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                double actual = matrix[i][j];
                double expected = matriisi1[i][j] + matriisi2[i][j];
                assertTrue(actual == 2);
            }
        }
    }
    
    public void testiYhteen2x3() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi1 = {{6, -3},{22, -3},{5,5}};
        double[][] matriisi2 = {{2, 3},{2, -3},{12,-4}};
        double[][] yhteen = {{8, 0},{24, -6},{17,1}};
        double[][] matrix = logiikka.yhteenlasku(matriisi1, matriisi2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                double actual = matrix[i][j];
                double expected = yhteen[i][j];
                assertTrue(actual == expected);
            }
        }
    }
    
    @Test
    public void testiKeskiarvoRivi() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[2][3];
        matriisi[0][0] = 1;
        matriisi[0][1] = 2;
        matriisi[0][2] = 1;
        matriisi[1][0] = 1;
        matriisi[1][1] = 3;
        matriisi[1][2] = 1;
        double actual = logiikka.keskiarvo(matriisi, 1, -1);
        double expected = 5.0/2;
        assertTrue(actual == expected);
    }
    
    @Test
    public void testiKeskiarvoSarake() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[2][3];
        matriisi[0][0] = 1;
        matriisi[0][1] = 1;
        matriisi[0][2] = 1;
        matriisi[1][0] = 3;
        matriisi[1][1] = 2;
        matriisi[1][2] = 2;
        double actual = logiikka.keskiarvo(matriisi, -1, 1);
        double expected = 7.0/3;
        assertTrue(actual == expected);
    }
    
    @Test
    public void testiKeskiarvoRiviJaSarake() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[2][3];
        matriisi[0][0] = 1;
        matriisi[0][1] = 1;
        matriisi[0][2] = 1;
        matriisi[1][0] = 2;
        matriisi[1][1] = 2;
        matriisi[1][2] = 2;
        double actual = logiikka.keskiarvo(matriisi, 2, -1);
        double actual1 = logiikka.keskiarvo(matriisi, -1, 0);
        double expected = 3.0/2;
        double expected1 = 1.0;
        assertTrue(actual == expected);
        assertTrue(actual1 == expected1);
    }
    
    @Test
    public void testSummaRivi() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[2][3];
        matriisi[0][0] = 1;
        matriisi[0][1] = 2;
        matriisi[0][2] = 1;
        matriisi[1][0] = 1;
        matriisi[1][1] = 3;
        matriisi[1][2] = 1;
        double actual = logiikka.summa(matriisi, 1, -1);
        double expected = 5.0;
        assertTrue(actual == expected);
    }
    
    @Test
    public void testSummaSarake() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[2][3];
        matriisi[0][0] = 1;
        matriisi[0][1] = 1;
        matriisi[0][2] = 1;
        matriisi[1][0] = 2;
        matriisi[1][1] = 2;
        matriisi[1][2] = 2;
        double actual = logiikka.summa(matriisi, -1, 1);
        double expected = 6;
        assertTrue(actual == expected);
    }
    
    @Test
    public void testSummaRiviJaSarake() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[2][3];
        matriisi[0][0] = 1;
        matriisi[0][1] = 1;
        matriisi[0][2] = 1;
        matriisi[1][0] = 2;
        matriisi[1][1] = 2;
        matriisi[1][2] = 2;
        double actual = logiikka.summa(matriisi, 2, -1);
        double actual1 = logiikka.summa(matriisi, -1,0);
        double expected = 3.0;
        double expected1 = 3.0;
        assertTrue(actual == expected);
        assertTrue(actual1 == expected1);
    }
    
    
    @Test
    public void testSummaKoko2x3() {
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
    public void testSummaKoko3x3() {
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
    public void testiKeskiarvoKoko2x3() {
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
    public void testiKeskiarvoKoko3x3() {
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
        double[][] matriisi1 = {{6, -3},{22, -3},{5,5}};
        double[][] matriisi2 = {{1, 3},{2, 5}};
        double[][] matrix = logiikka.kertolasku(matriisi1, matriisi2);
        double [][] actual =  {{0, 3}, {16, 51}, {15, 40}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                assertTrue(matrix[i][j] == actual[i][j]);
            }
        }
       
    }
    
    
    @Test
    public void testSkalaari() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[1][2];
        matriisi[0][0] = 2;
        matriisi[0][1] = 1;
        double[][] tulos = logiikka.skalaari(matriisi, -2);
        double actual = matriisi[0][0];
        double actual1 = matriisi[0][1];
        double expected = -4;
        double expected1 = -2;
        assertTrue(actual == expected);
        assertTrue(actual1 == expected1); 
    }
    
    
    @Test
    public void testDeterminantti2x2() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[2][2];
        matriisi[0][0] = 14;
        matriisi[0][1] = 22;
        matriisi[1][0] = 3;
        matriisi[1][1] = 7;
        double actual = logiikka.determinantti(matriisi);
        double expected = 32;
        assertTrue(actual == expected);
    }
    
    @Test
    public void testDeterminantti3x3() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[3][3];
        matriisi[0][0] = 2;
        matriisi[0][1] = 3;
        matriisi[0][2] = 3;
        matriisi[1][0] = 3;
        matriisi[1][1] = 1;
        matriisi[1][2] = 2;
        matriisi[2][0] = 4;
        matriisi[2][1] = 5;
        matriisi[2][2] = 3;
        double actual = logiikka.determinantti(matriisi);
        double expected = 16;
        assertTrue(actual == expected);
    }
    
    @Test
    public void testDeterminantti4x4() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = {{3,7,5,0},{8,8,9,5},{1,7,8,9},{6,0,3,2}};
        double actual = logiikka.determinantti(matriisi);
        double expected = 178;
        assertTrue(actual == expected);
    }
    
    @Test
    public void testTranspoosi2x2() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[2][2];
        matriisi[0][0] = 14;
        matriisi[0][1] = 22;
        matriisi[1][0] = 3;
        matriisi[1][1] = 7;
        double[][] matriisit = new double[2][2];
        matriisit[0][0] = 14;
        matriisit[0][1] = 3;
        matriisit[1][0] = 22;
        matriisit[1][1] = 7;
        double[][] actual = logiikka.transpoosi(matriisi);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertTrue(actual[i][j] == matriisit[i][j]);
            }
        }
    }
    
    @Test
    public void testTranspoosi3x2() {
        Logiikka logiikka = new Logiikka();
        double[][] matriisi = new double[3][2];
        matriisi[0][0] = 3;
        matriisi[0][1] = 4;
        matriisi[1][0] = -1;
        matriisi[1][1] = 2;
        matriisi[2][0] = 9;
        matriisi[2][1] = 8;
        double[][] matriisit = new double[2][3];
        matriisit[0][0] = 3;
        matriisit[0][1] = -1;
        matriisit[0][2] = 9;
        matriisit[1][0] = 4;
        matriisit[1][1] = 2;
        matriisit[1][2] = 8;
        double[][] actual = logiikka.transpoosi(matriisi);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(actual[i][j] == matriisit[i][j]);
            }
        }
    }
        @Test
        public void testTranspoosi2x3() {
            Logiikka logiikka = new Logiikka();
            double[][] matriisi = new double[3][2];
            matriisi[0][0] = 3;
            matriisi[0][1] = 4;
            matriisi[1][0] = -1;
            matriisi[1][1] = 2;
            matriisi[2][0] = 9;
            matriisi[2][1] = 8;
            double[][] matriisit = new double[2][3];
            matriisit[0][0] = 3;
            matriisit[0][1] = -1;
            matriisit[0][2] = 9;
            matriisit[1][0] = 4;
            matriisit[1][1] = 2;
            matriisit[1][2] = 8;
            double[][] actual = logiikka.transpoosi(matriisit);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    assertTrue(actual[i][j] == matriisi[i][j]);
            }
        }
    }

}
