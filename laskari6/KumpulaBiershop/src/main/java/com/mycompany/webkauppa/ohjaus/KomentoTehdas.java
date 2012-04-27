/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webkauppa.ohjaus;

import com.mycompany.webkauppa.sovelluslogiikka.Ostoskori;

/**
 *
 * @author tonykovanen
 */
public class KomentoTehdas {
    public OstoksenLisaysKoriin ostoksenLisaysKoriin(Ostoskori ostoskori, long tuoteId) {
        return new OstoksenLisaysKoriin(ostoskori, tuoteId);
    }
    
    public OstoksenPoistoKorista ostoksenPoistoKorista(Ostoskori ostoskori, long tuoteId) {
        return new OstoksenPoistoKorista(ostoskori, tuoteId);
    }
    
    public OstoksenSuoritus ostoksenSuoritus(String nimi, String osoite, String luottokorttinumero, Ostoskori ostoskori) {
        return new OstoksenSuoritus(nimi, osoite, luottokorttinumero, ostoskori);
    }
}
