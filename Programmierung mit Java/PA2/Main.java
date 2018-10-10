import java.io.FileNotFoundException;

public class Main
{
    public static void main(String args[]){
        /*String a = "FC Bayern Muenchen        --- 0:3 5:1 2:1 1:0 3:1 4:1 3:0 3:3 2:0 3:2 5:2 5:0 4:0 1:0 3:1 2:0 2:0";
        String b[] = a.split(" ");
        int i = 0;
        for(String c : b)
        {
            System.out.println("" + i + ": "+ c);
            i++;
        }*/
        Bundesliga b = null;
        try {
            b = new Bundesliga("C:\\Users\\Lukas\\Documents\\Uni\\MATSE\\Programmierung mit Java\\bundesliga1314.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(b.getResultat("Eintracht Braunschweig", "1. FC Nuernberg"));
        System.out.println(b.getGesamtstand("Eintracht Braunschweig"));
    }
}
