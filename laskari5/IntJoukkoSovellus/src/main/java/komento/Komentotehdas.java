/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package komento;

import java.util.HashMap;
import ohtu.intjoukkosovellus.IO;
import ohtu.intjoukkosovellus.IntJoukko;

/**
 *
 * @author tonykovanen
 */

public class Komentotehdas {
    private HashMap<String, Komento> komennot;
    private IntJoukko A;
    private IntJoukko B;
    private IntJoukko C;
 
    public Komentotehdas(IO io, IntJoukko A, IntJoukko B, IntJoukko C) {
        this.A = A;
        this.B = B;
        this.C = C;
        komennot = new HashMap<String, Komento>();
        komennot.put("lisaa", new Lisaa(io, A, B, C));
        komennot.put("tulosta", new Tulosta(io, A, B, C));
        komennot.put("poista", new Poista(io, A, B, C));
        komennot.put("yhdiste", new Yhdiste(io, A, B, C));
        komennot.put("leikkaus", new Leikkaus(io, A, B, C));
        komennot.put("erotus", new Erotus(io, A, B, C));
        komennot.put("tuntematon", new Tuntematon(io));
        komennot.put("poistu", new Lopetus());
        komennot.put("kuuluu", new Kuuluu(io, A, B, C));
    }
 
    public Komento hae(String operaatio) {
        Komento komento = komennot.get(operaatio);
        if (komento == null) {
            komento = komennot.get("tuntematon");
        }
        return komento;
    }
}
