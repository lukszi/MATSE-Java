/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class H4Main
{
    /**
     * Kopiert vom Aufgabenblatt
     * @param args wird ignoriert, dient nur der Funktionssignatur
     */
    public static void main(String args[]){
        PositiveNumber zs = new PositiveNumber();
        zs.setDecimal("144");
        System.out.println("Binaer:\t\t\t" + zs.getBinary());
        zs.setHexadecimal("affe");
        System.out.println("Dezimal:\t\t" + zs.getDecimal());
        zs.setBinary("1000101011");
        System.out.println("Hexadezimal:\t" + zs.getHexadecimal());
    }
}
