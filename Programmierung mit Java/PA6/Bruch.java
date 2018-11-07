/**
 * Repraesentiert einen Bruch mit Integer-Werten als Zaehler und Nenner.
 * Invariante: Der Bruch ist immer gekuerzt. Der Nenner ist immer groesser als 0.
 *
 * @author H. Pflug, ITC, RWTH Aachen
 *
 */
public class Bruch {

    // Attribute
    private int zaehler;
    private int nenner;
    private BruchFormat format;

    /**
     * Erzeugt einen Bruch mit dem gegebenen Zaehler und Nenner.
     *
     * @param zaehler
     *            der Zaehler des Bruchs
     * @param nenner
     *            der Nenner des Bruchs
     * @throws ArithmeticException
     *             falls der Nenner gleich 0 ist.
     */

    public Bruch(int zaehler, int nenner) {
        if (nenner == 0) {
            throw new ArithmeticException("Nenner gleich 0");
        }
        this.zaehler = zaehler;
        this.nenner = nenner;
        this.normalisiere();
    }

    /**
     * Initialisiert den Bruch mit einem String des Formats
     * \<zaehler\>/\<nenner\>.
     *
     * @param bruch
     *            der String im Format \<zaehler\>/\<nenner\>.
     * @throws NumberFormatException
     *             falls das Format nicht stimmt.
     * @throws ArithmeticException
     *             falls der Nenner 0 ist.
     */
    public Bruch(String bruch) {
        String[] b = bruch.split("/");
        if (b.length != 2) {
            throw new NumberFormatException("Format muss zaehler/nenner sein");
        }
        this.zaehler = Integer.parseInt(b[0]);
        this.setNenner(Integer.parseInt(b[1]));

    }

    /**
     * Erzeugt eine Kopie (Klon) des uebergebenen Bruchs (Copy-Konstruktor).
     *
     * @param r
     *            der Bruch, der geklont werden soll.
     */
    public Bruch(Bruch r) {
        this.zaehler = r.zaehler;
        this.nenner = r.nenner;
    }

    /**
     * Setzt den Nenner des Bruchs.
     *
     * @param nenner
     *            der Nenner des Bruchs.
     * @throws ArithmeticException
     *             falls der Nenner 0 ist.
     */

    public void setNenner(int nenner) {
        if (nenner != 0) {
            this.nenner = nenner;
            this.normalisiere();
        } else {
            throw new ArithmeticException("Nenner gleich 0");
        }
    }

    /**
     * Gibt den Nenner des Bruchs zurueck.
     *
     * @return der Nenner des Bruchs.
     */
    public int getNenner() {
        return this.nenner;
    }

    /**
     * Setzt den Zaehler des Bruchs.
     *
     * @param zaehler
     *            der Zaehler des Bruchs.
     */
    public void setZaehler(int zaehler) {
        this.zaehler = zaehler;
        this.normalisiere();
    }

    /**
     * Gibt den Zaehler des Bruchs zurueck.
     *
     * @return der Zaehler des Bruchs.
     */
    public int getZaehler() {
        return this.zaehler;
    }

    /**
     * Gibt den Wert des Bruchs als double-Wert zurueck.
     *
     * @return der Wert des Bruchs als double-Wert.
     */
    public double getDoubleWert() {
        // Casten in double fuer Fliesskomma-Division
        return this.zaehler / (double) this.nenner;
    }

    /**
     * Multipliziert den Bruch mit dem angegebenen Faktor.
     *
     * @param faktor
     *            der Faktor, mit dem der Bruch multipliziert wird.
     */
    public void mult(int faktor) {
        this.zaehler = this.zaehler * faktor;
        this.normalisiere();
    }

    /**
     * Multipliziert den Bruch mit dem uebergebenen Bruch.
     *
     * @param r
     *            der Bruch, mit dem multipliziert werden soll.
     */
    public void mult(Bruch r) {
        this.zaehler = this.zaehler * r.zaehler;
        this.nenner = this.nenner * r.nenner;
        this.normalisiere();
    }

    /**
     * Addiert den uebergebenen Bruch.
     *
     * @param b
     *            der zu addierende Bruch
     */
    public void add(Bruch b) {
        this.zaehler = this.zaehler * b.nenner + this.nenner * b.zaehler;
        this.nenner = this.nenner * b.nenner;
        this.normalisiere();
    }

    /**
     * Invertiert den Bruch.
     *
     * @throws ArithmeticException
     *             falls der Zaehler 0 war.
     */
    public void inverse() {
        int temp = this.zaehler;
        if (temp == 0) {
            throw new ArithmeticException("Nenner gleich 0");
        }
        this.zaehler = this.nenner;
        this.nenner = temp;
        this.normalisiere();
    }

    /**
     * Gibt die Inverse des Bruchs zurueck.
     *
     * @return die Inverse des Bruchs.
     * @throws ArithmeticException
     *             falls der Zaehler 0 war.
     */
    public Bruch getInverse() {
        Bruch b = new Bruch(this);
        b.inverse();
        return b;
    }

    /**
     * Gibt String in der Form Zaehler/Nenner zurueck.
     */
    @Override
    public String toString() {
        return this.format.bruchToString(this.zaehler, this.nenner);
    }

    /**
     * Gibt zurueck, ob die Zaehler und Nenner zweier Brueche gleich sind.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Bruch) {
            Bruch b = (Bruch) o;
            if (this.zaehler == b.zaehler && this.nenner == b.nenner) {
                return true;
            }
        }
        return false;
    }

    private void normalisiere() {
        if (this.nenner < 0) {
            this.nenner = -this.nenner;
            this.zaehler = -this.zaehler;
        }
        // Bruch kuerzen
        if (this.zaehler == 0) {
            this.nenner = 1;
        } else {
            int a = this.zaehler;
            int b = this.nenner;
            if (a < 0) {
                a = -a;
            }
            // Suchen des groessten gemeinsamen Teilers
            // Euklidischer Algorithmus
            while (b != 0) {
                int h = a % b;
                a = b;
                b = h;
            }
            // a ist jetzt der groesste gemeinsame Teiler
            this.zaehler = this.zaehler / a;
            this.nenner = this.nenner / a;
        } // if (zaehler!=0)
    } // normalisiere

    public void setFormat(BruchFormat format){
        this.format = format;
    }

} // class
