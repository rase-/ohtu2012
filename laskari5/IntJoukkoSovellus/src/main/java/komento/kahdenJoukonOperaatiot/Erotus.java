/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package komento.kahdenJoukonOperaatiot;

import ohtu.intjoukkosovellus.IO;
import ohtu.intjoukkosovellus.IntJoukko;

/**
 *
 * @author tonykovanen
 */
public class Erotus extends KahdenJoukonOperaatio {
    
    public Erotus(IO io, IntJoukko A, IntJoukko B, IntJoukko C) {
        super(io, A, B, C);
    }
    
    @Override
    protected IntJoukko suoritaOperaatio(IntJoukko ensimmainenOperandi, IntJoukko toinenOperandi) {
        return IntJoukko.erotus(ensimmainenOperandi, toinenOperandi);
    }
    
    

}
