import java.io.FileNotFoundException;

public class PA2Main
{
    public static void main(String args[])
    {
        Bundesliga b = null;
        try {
            b = new Bundesliga("C:\\Users\\Lukas\\Documents\\Uni\\MATSE\\Programmierung mit Java\\bundesliga1314.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(b.getResultat("Eintracht Braunschweig", "1. FC Nuernberg"));
        try{
            System.out.println(b.getGesamtstand("Borussia Dortmund"));
            System.out.println(b.getGesamtstand("Alemannia Aachen"));
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
        }
    }
}
