import java.io.FileNotFoundException;

public class H2Main
{
    public static void main(String args[])
    {
        try{
            GoldPreis test = new GoldPreis("./Programmierung mit Java/H2/gold.txt");
            System.out.println(test.getPreis("2009-10-20")); //22870.0
            System.out.println(test.getPreis("2009-02-07")); //-1
            test.printMinMax();
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
        }
    }
}
