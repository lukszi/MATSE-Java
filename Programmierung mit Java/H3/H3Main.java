import java.net.MalformedURLException;
import java.net.URL;

public class H3Main
{
    public static void main(String args[])
    {
        EMailAdressBuch a = new EMailAdressBuch();
        try {
            a.mitarbeiterEinlesen(new URL("https://doc.itc.rwth-aachen.de/download/attachments/5800183/" +
                    "mitarbeiter_matse_extern.txt?version=1&modificationDate=1539692978000&api=v2"));
            a.einlesen("Programmierung mit Java/emailadressbuch.txt");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(a.toString());

    }
}
