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
public class Tulosta extends YhdenJoukonOperaatio {
    
    public Tulosta(IO io, IntJoukko A, IntJoukko B, IntJoukko C) {
        super(io, A, B, C);
    }


    @Override
    protected IntJoukko suoritaOperaatio(IntJoukko operandi) {
        return operandi;
    }
    
    
}
