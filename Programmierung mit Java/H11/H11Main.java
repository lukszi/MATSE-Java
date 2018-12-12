/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class H11Main
{
    /**
     * Schreibt die Punkte der Kochkurve des rek-ten Grades in den stdout
     * @param ax x Koordinate des Startpunkts
     * @param ay y Koordinate des Startpunkts
     * @param bx x Koordinate des Anfangspunkts
     * @param by y Koordinate des Endpunkts
     * @param rek Anzahl der Rekursionen
     */
    public static void kochKurve(double ax, double ay, double bx, double by, int rek)
    {
        // bessere Lesbarkeit
        double[] start = new double[2];
        start[0] = ax;
        start[1] = ay;
        double[] end = new double[2];
        end[0] = bx;
        end[1] = by;

        if (rek == 0) {
            System.out.printf(" (%.2f/%2f)", start[0], start[1]);
            return;
        }

        double[][] zwp = new double[3][2];

        // Zwischenpunkt 1, 1/3 des Weges
        double[] v = new double[2];
        v[0] = end[0] - start[0];
        v[1] = end[1] - start[1];
        v[0] /= 3;
        v[1] /= 3;
        v[0] += start[0];
        v[1] += start[1];
        zwp[0] = v;

        // Zwischenpunkt 2
        v = new double[2];
        double[] a = new double[2];
        a[0] = start[0];
        a[1] = start[1];

        // v is der weg von Anfang zu zwp1
        v[0] = end[0] - start[0];
        v[1] = end[1] - start[1];
        v[0] = v[0]/3;
        v[1] = v[1]/3;

        a[0] += v[0];
        a[1] += v[1];


        // Rotiere v
        double x = (v[0] * Math.cos(Math.toRadians(-60))) - (v[1] * Math.sin(Math.toRadians(-60)));
        double y = (v[0] * Math.sin(Math.toRadians(-60))) + (v[1] * Math.cos(Math.toRadians(-60)));
        v[0] = x;
        v[1] = y;

        a[0] += v[0];
        a[1] += v[1];

        zwp[1] = a;

        // Zwischenpunkt 3, 2/3 des Weges
        v = new double[2];
        v[0] = end[0] - start[0];
        v[1] = end[1] - start[1];
        v[0] = 2*v[0]/3;
        v[1] = 2*v[1]/3;
        v[0] += start[0];
        v[1] += start[1];

        zwp[2] = v;

        //Rekursion und drucken
        kochKurve(start[0], start[1], zwp[0][0], zwp[0][1], rek-1);
        kochKurve(zwp[0][0], zwp[0][1], zwp[1][0], zwp[1][1], rek-1);
        kochKurve(zwp[1][0], zwp[1][1], zwp[2][0], zwp[2][1], rek-1);
        kochKurve(zwp[2][0], zwp[2][1], end[0], end[1], rek-1);

        System.out.printf(" (%.2f/%.2f)", end[0], end[1]);
    }

    public static void main(String[] args)
    {
        System.out.print("Rekursiontiefe 0:");
        kochKurve(0,500,500,500,0);
        System.out.print("\nRekursiontiefe 1:");
        kochKurve(0,500,500,500,1);
        System.out.print("\nRekursiontiefe 2:");
        kochKurve(0,500,500,500,2);
    }
}
