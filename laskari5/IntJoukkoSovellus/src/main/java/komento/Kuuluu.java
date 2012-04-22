/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package komento;

import ohtu.intjoukkosovellus.IO;
import ohtu.intjoukkosovellus.IntJoukko;

/**
 *
 * @author tonykovanen
 */
public class Kuuluu extends YhdenJoukonOperaatio {

    public Kuuluu(IO io, IntJoukko A, IntJoukko B, IntJoukko C) {
        super(io, A, B, C);
    }

    @Override
    protected IntJoukko suoritaOperaatio(IntJoukko operandi) {
        io.print("Anna luku: ");
        int luku = io.nextInt();
        if (operandi.kuuluu(luku)) {
            io.print("Luku kuuluu joukkoon");
        } else {
            io.print("Luku ei kuulu joukkoon");
            io.print("Tulostetaan joukko: ");

        }
        return operandi;
    }
}