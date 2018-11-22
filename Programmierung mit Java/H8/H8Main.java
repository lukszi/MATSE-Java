import java.util.Comparator;

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class H8Main
{
    public static void main(String[] args)
    {
        //Verschiedene Blaetter zum Testen erzeugen
        Blatt drillingNiedrig = new Blatt(new int[]{2, 2, 2});
        Blatt drillingHoch = new Blatt(new int[]{9, 9, 9});
        Blatt paarNiedrig = new Blatt(new int[]{2, 2, 3});
        Blatt paarHoch = new Blatt(new int[]{2, 5, 5});
        Blatt paarHoch2 = new Blatt(new int[]{10, 5, 5});
        //Weder Paar noch Drilling, alle Karten sind unterschiedlich
        Blatt einfachNiedrig = new Blatt(new int[]{2, 3, 8});
        Blatt einfachHoch = new Blatt(new int[]{3, 4, 10});
        //Verschiedene Blaetter testen
        BlattVergleich bv = new BlattVergleich();
        werteAus(paarHoch, drillingNiedrig, bv);
        werteAus(paarNiedrig, einfachNiedrig, bv);
        werteAus(drillingHoch, drillingNiedrig, bv);
        werteAus(paarHoch, paarNiedrig, bv);
        werteAus(paarHoch, paarHoch2, bv);
        werteAus(einfachNiedrig, einfachHoch, bv);
    }

    /**
     * Die Methode prueft fuer zwei Blaetter, welches gewonnen hat, und gibt das
     * Ergebnis aus
     *
     * @param b1 Blatt 1
     * @param b2 Blatt 2
     * @param cb Comparator, der zum Vergleich der Blaetter verwendet wird
     */
    private static void werteAus(Blatt b1, Blatt b2, Comparator<Blatt> cb)
    {
        int vergleich = cb.compare(b1, b2);
        String ergebnis = "";
        if (vergleich < 0) {
            ergebnis = " verliert gegen ";
        } else if (vergleich == 0) {
            ergebnis = " ist gleichwertig mit ";
        } else {
            ergebnis = " schlaegt ";
        }
        System.out.println(b1.toString() + ergebnis + b2.toString());
    }
}
