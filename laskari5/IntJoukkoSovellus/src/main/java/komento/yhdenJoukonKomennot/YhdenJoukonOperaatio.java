/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package komento.yhdenJoukonKomennot;

import komento.Komento;
import ohtu.intjoukkosovellus.IO;
import ohtu.intjoukkosovellus.IntJoukko;

/**
 *
 * @author tonykovanen
 */
public abstract class YhdenJoukonOperaatio implements Komento {
    protected IO io;
    protected IntJoukko A;
    protected IntJoukko B;
    protected IntJoukko C;
    
    public YhdenJoukonOperaatio(IO io, IntJoukko A, IntJoukko B, IntJoukko C) {
        this.io = io;
        this.A = A;
        this.B = B;
        this.C = C;
    }
    
    private IntJoukko valitseJoukko() {
        io.print("Mikä joukko?");
        String syote = io.nextString();
        while (!validiJoukko(syote)) {
            io.print("Anna validi joukko: ");
            syote = io.nextString();
        }
        return muutaJoukoksi(syote);
    }

    private boolean validiJoukko(String syote) {
        if (syote.equalsIgnoreCase("a") || syote.equalsIgnoreCase("b") || syote.equalsIgnoreCase("c")) {
            return true;
        }
        return false;
    }

    private IntJoukko muutaJoukoksi(String syote) {
        if (syote.equalsIgnoreCase("a")) {
            return A;
        }

        if (syote.equalsIgnoreCase("b")) {
            return B;
        }

        return C;
    }
    
    @Override
    public void suorita() {
        IntJoukko operandi = valitseJoukko();
        io.print(suoritaOperaatio(operandi).toString());
    }
    
    protected abstract IntJoukko suoritaOperaatio(IntJoukko operandi);
}
