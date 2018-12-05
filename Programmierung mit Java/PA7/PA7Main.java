public class PA7Main
{

    public static void main(String args[]){
        Verfahren ver = new Bisektionsverfahren();
        Funktion_Aufgabe7 xSquared = new Funktion_Aufgabe7(val -> sub(Math.pow(val,2),2.0));
        System.out.println(ver.getNullstelle(xSquared, 0 , 10));
        System.out.println(xSquared);
    }

    public static double sub(double a, double b){
        return a-b;
    }
}
