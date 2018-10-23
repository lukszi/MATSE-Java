import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class EMailAdressBuch
{
    private Map<String, String> adressBuch = new HashMap<>();

    public EMailAdressBuch()
    {

    }

    /**
     * Adds a new entry to the contactlist
     *
     * @param name  name of the contact
     * @param email email-address of the contact
     */
    public void einfuegen(String name, String email)
    {
        adressBuch.put(name, email);
    }

    /**
     * fetches the email address belonging to the user identified by name
     *
     * @param name name of the user
     * @return email address of user
     */
    public String abfrage(String name)
    {
        if (!adressBuch.containsKey(name))
            throw new UnknownNameException();
        return adressBuch.get(name);
    }

    /**
     * @return String object representing this contactbook
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String name : adressBuch.keySet()) {
            sb.append(name);
            sb.append('=');
            sb.append(adressBuch.get(name));
            sb.append(", ");
        }
        sb.delete(sb.length() - 3, sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    /**
     * reads contacts from a file
     *
     * @param dateiname path to a file containing contacts
     */
    public void einlesen(String dateiname)
    {
        try {
            Scanner sc = new Scanner(new File(dateiname));
            einlesen(sc);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * reads contacts from a scanner
     *
     * @param sc scanner to read contacts from
     */
    private void einlesen(Scanner sc)
    {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] split = line.split(";");

            adressBuch.put(split[0], split[1]);
        }
    }

    /**
     * reads contacts from a url
     *
     * @param url url to read contacts from
     */
    public void mitarbeiterEinlesen(URL url)
    {
        try {
            Scanner sc = new Scanner(url.openStream());
            einlesen(sc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
