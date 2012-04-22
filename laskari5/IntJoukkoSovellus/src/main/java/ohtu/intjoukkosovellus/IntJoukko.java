package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        joukko = new int[OLETUSKAPASITEETTI];
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            joukko = new int[OLETUSKAPASITEETTI];
        } else {

            alkioidenLkm = 0;
            this.kasvatuskoko = OLETUSKASVATUS;
            joukko = new int[kapasiteetti];

        }
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        this(kapasiteetti);
        if (kasvatuskoko >= 0) {
            this.kasvatuskoko = kasvatuskoko;
        } else {
            this.kasvatuskoko = OLETUSKASVATUS;
        }

    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
            return false;
        }

        if (alkioidenLkm == joukko.length) {
            kasvataJoukkoa();
        }

        joukko[alkioidenLkm] = luku;
        alkioidenLkm++;
        return true;

    }

    private void kasvataJoukkoa() {
        int[] uusi = new int[joukko.length + kasvatuskoko];
        System.arraycopy(joukko, 0, uusi, 0, joukko.length);
        this.joukko = uusi;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (joukko[i] == luku) {
                return true;
            }
        }

        return false;
    }

    public boolean poista(int luku) {
        int poistettavanIndeksi = haeIndeksi(luku);

        if (poistettavanIndeksi == -1) {
            return false;
        }

        siirraTaaksepainKohtaan(poistettavanIndeksi);
        alkioidenLkm--;
        return true;

    }

    private void siirraTaaksepainKohtaan(int indeksi) {
        for (int i = indeksi + 1; i < alkioidenLkm; i++) {
            joukko[i - 1] = joukko[i];
        }
    }

    private int haeIndeksi(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (joukko[i] == luku) {
                return i;
            }
        }
        return -1;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String palautettava = "{";
        
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            palautettava += joukko[i] + ", ";
        }
        
        if (alkioidenLkm > 0) {
        palautettava += joukko[alkioidenLkm - 1];
        }
        
        palautettava += "}";
        
        return palautettava;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(joukko, 0, taulu, 0, taulu.length);
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko uusi = new IntJoukko();
        int[] ensimmaisenLuvut = a.toIntArray();
        int[] toisenLuvut = b.toIntArray();
        for (int i = 0; i < ensimmaisenLuvut.length; i++) {
            uusi.lisaa(ensimmaisenLuvut[i]);
        }
        for (int i = 0; i < toisenLuvut.length; i++) {
            uusi.lisaa(toisenLuvut[i]);
        }
        return uusi;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko uusi = new IntJoukko();
        int[] ensimmaisenLuvut = a.toIntArray();
        for (int i : ensimmaisenLuvut) {
            if (b.kuuluu(i)) 
                uusi.lisaa(i);
        }
        return uusi;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko uusi = new IntJoukko();
        int[] ensimmaisenLuvut = a.toIntArray();
        for (int i : ensimmaisenLuvut) {
            if (!b.kuuluu(i)) {
                uusi.lisaa(i);
            }
        }
        return uusi;
        
    }
}