/*
 * Klasse zum Testen, ob die einzelnen Formate die gewuenschte Ausgabe erzielen
 */
public class BruchTest {

    public static void main(String[] args) {
        Bruch b1 = new Bruch(23, 3);

        b1.setFormat(new DoubleFormat());
        System.out.println(b1);

        b1.setFormat(new SchraegstrichFormat());
        System.out.println(b1);

        b1.setFormat(new BenutzerFormat("%.2f"));
        System.out.println(b1);

        b1.setFormat(new DreizeilenFormat());
        System.out.println(b1);
    }

}
