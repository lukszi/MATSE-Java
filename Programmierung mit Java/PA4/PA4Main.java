public class PA4Main
{
    public static void main(String args[]){
        Binaerzahl zahl = new Binaerzahl(4);
        System.out.println(zahl);
        Binaerzahl z2 = new Binaerzahl(-2);
        System.out.println(z2);
        zahl.add(z2);
        System.out.println(zahl);
    }
}
