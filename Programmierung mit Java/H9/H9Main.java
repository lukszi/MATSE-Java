/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class H9Main
{
    public static void main(String[] args)
    {
        Schiebepuzzle puzzle = new Schiebepuzzle();
        // Mischen nicht vergessen, ansonsten hat der Spieler sehr schnell gewonnen
        puzzle.mische();
        System.out.println(puzzle);
        System.out.println("\n\n");
        // Testen des Loesungsalgorithmus
        // -> zufaellig schieben
        Loesungsalgorithmus alg1 = new SchiebAlg1();
        alg1.loese(puzzle);
        System.out.println(puzzle);
        System.out.println("\n\n");
    }
}
