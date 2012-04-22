/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package komento.yhdenJoukonKomennot;

import ohtu.intjoukkosovellus.IO;
import ohtu.intjoukkosovellus.IntJoukko;

/**
 *
 * @author tonykovanen
 */
public class Lisaa extends YhdenJoukonOperaatio {
    public Lisaa(IO io, IntJoukko A, IntJoukko B, IntJoukko C) {
        super(io, A, B, C);
    }


    @Override
    protected IntJoukko suoritaOperaatio(IntJoukko operandi) {
        io.print("Anna luku: ");
        int luku = io.nextInt();
        operandi.lisaa(luku);
        return operandi;
    }
    
}
