/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ohtu.intjoukkosovellus.IntJoukko;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author tonykovanen
 */
public class IntJoukkoTest {
    private IntJoukko joukko;
    
    public IntJoukkoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        joukko = new IntJoukko();
        joukko.lisaa(3);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void lisaaLisaaAlkioidenMaaraaJaUusiLukuLoytyyJoukosta() {
        assertEquals("Tarkista että joukon koko kasvaa yhdellä", 1, joukko.mahtavuus());
        assertTrue("Tarkista että lisätty luku löytyy lisäyksen jälkeen joukosta", joukko.kuuluu(3));
    }
    
    @Test
    public void lisaysEiLisaaMitaanJosLukuOnJoJoukossa() {
        joukko.lisaa(3);
        assertEquals(1, joukko.mahtavuus());
    }
    
    @Test
    public void kuuluuTosiJosAlkioLoytyyJoukosta() {
        assertTrue(joukko.kuuluu(3));
    }
    
    @Test
    public void kuuluuEpatosiJosJoukossaEiHaettuaAlkiota() {
        assertFalse(joukko.kuuluu(9));
    }
    
    @Test
    public void joukostaPoistaminenVahentaaKokoaJaPoistettuaAlkiotaEiEnaaOle() {
        joukko.poista(3);
        assertEquals(0, joukko.mahtavuus());
        assertFalse(joukko.kuuluu(3));
    }
    
    @Test
    public void mahtavuusKasvaaYhdellaKunJoukkoonLisataanYksiAlkioJaSeOnAluksiTyhja() {
        assertEquals(1, joukko.mahtavuus());
    }
    
    @Test
    public void toIntArrayPalauttaaOikeanMaaraAlkioitaJaNeOvatOIkeatAlkiot() {
        joukko.lisaa(4);
        int[] array = joukko.toIntArray();
        assertEquals(2, array.length);
        assertEquals(3, array[0]);
        assertEquals(4, array[1]);
    }
    
    @Test
    public void yhdisteKasvattaaKokoaOikeanVerranJaOikeatAlkiotLoytyat() {
        IntJoukko yhdistettava = new IntJoukko();
        yhdistettava.lisaa(7);
        yhdistettava.lisaa(9);
        IntJoukko yhdiste = IntJoukko.yhdiste(joukko, yhdistettava);
        assertEquals(3, yhdiste.mahtavuus());
        assertTrue(yhdiste.kuuluu(3) && yhdiste.kuuluu(7) && yhdiste.kuuluu(9));
    }
    
    @Test
    public void leikkausVahentaaKokoaJaErottaaOikeatAlkiot() {
        IntJoukko erotettava = new IntJoukko();
        erotettava.lisaa(3);
        joukko.lisaa(5);
        IntJoukko erotus = IntJoukko.erotus(joukko, erotettava);
        assertTrue("Tarkista että oikeat alkiot poistetaan", !erotus.kuuluu(3) && erotus.kuuluu(5));
        assertEquals("Tarkista ettei erotus vähennä liikaa tai liiän vähän alkiota", 1, erotus.mahtavuus());
        
    }
    
}
