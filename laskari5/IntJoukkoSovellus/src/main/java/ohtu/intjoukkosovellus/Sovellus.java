package ohtu.intjoukkosovellus;

import java.util.Scanner;
import komento.Komentotehdas;

public class Sovellus {

    private IO io;
    private Komentotehdas komennot;

    public Sovellus(IO io) {
        this.io = io;
        this.komennot = new Komentotehdas(io, new IntJoukko(), new IntJoukko(), new IntJoukko());
    }

    public void suorita() {
        io.print("Tervetuloa joukkolaboratorioon!");
        io.print("Käytössäsi ovat joukot A, B ja C.");
        io.print("Komennot ovat lisaa, poista, kuuluu, yhdiste, erotus, leikkaus ja poistu.");
        io.print("Komento tulosta tulostaa valistemasi joukon");
        while (true) {
            String komento = io.nextString();
            komennot.hae(komento).suorita();
            
        }
    }

    public static void main(String[] args) {
        Sovellus sovellus = new Sovellus(new StdIO());
        sovellus.suorita();
    }
}
