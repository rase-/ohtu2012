/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package komento;

import ohtu.intjoukkosovellus.IO;

/**
 *
 * @author tonykovanen
 */
public class Tuntematon implements Komento {

    private IO io;

    public Tuntematon(IO io) {
        this.io = io;
    }

    public void suorita() {
        io.print("Tervetuloa joukkolaboratorioon!");
        io.print("Käytössäsi ovat joukot A, B ja C.");
        io.print("Komennot ovat lisaa, poista, kuuluu, yhdiste, erotus, leikkaus ja poistu.");
        io.print("Komento tulosta tulostaa valistemasi joukon");
    }
}
