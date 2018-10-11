import java.io.*;
import java.util.*;

public class Bundesliga
{
    private Map<String, Integer> mannschaft = new HashMap<>();
    private Map<String, List<String>> resultate = new HashMap<>();

    public Bundesliga(String filepath) throws FileNotFoundException
    {
        File fIn = new File(filepath);
        int anz_manschaften = 18;
        try {
            int linesRead = 0;
            Scanner scan = new Scanner(fIn);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();

                // Split line by content
                String lines[] = line.split(" ");

                // Extract Mannschaft
                int mannschaftsNameLength = lines.length - anz_manschaften;
                String[] mannschaftsNameTokens = new String[mannschaftsNameLength];
                System.arraycopy(lines, 0, mannschaftsNameTokens, 0, mannschaftsNameLength);
                StringBuilder sb = new StringBuilder();
                for (String token : mannschaftsNameTokens) {
                    sb.append(token);
                    sb.append(" ");
                }
                String mannschaftsName = sb.toString().trim();
                mannschaft.put(mannschaftsName, linesRead);

                //Extract ergebnis
                String[] ergebnisTokens = new String[anz_manschaften];
                System.arraycopy(lines, lines.length - anz_manschaften, ergebnisTokens, 0, anz_manschaften);
                resultate.put(mannschaftsName, Arrays.asList(ergebnisTokens));
                linesRead++;
            }
            scan.close();
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }

    public String getResultat(String heim, String gast)
    {
        if (!this.mannschaft.containsKey(gast) || !this.mannschaft.containsKey(heim))
            throw new IllegalArgumentException();
        int gastIndex = this.mannschaft.get(gast);
        List<String> heimList = this.resultate.get(heim);
        return heimList.get(gastIndex);
    }

    public Gesamtstand getGesamtstand(String mannschaft)
    {
        List<String> ergebnisse = new ArrayList<>(this.resultate.get(mannschaft));
        int gesamtTore = 0;
        int gesamtGegentore = 0;
        int punkte = 0;

        int mannschaftIndex = this.mannschaft.get(mannschaft);

        for(String gegnerName: resultate.keySet())
        {
            List<String> spiele = resultate.get(gegnerName);
            ergebnisse.add((new StringBuilder(spiele.get(mannschaftIndex))).reverse().toString());
        }

        for(String ergebnis : ergebnisse)
        {
            //Check if mannschaft played itself
            if(ergebnis.equals("---"))
                continue;
            //Parse String
            String[] torArray = ergebnis.split(":");
            int tore = Integer.valueOf(torArray[0]);
            int gegentore = Integer.valueOf(torArray[1]);

            //Add data
            if(tore > gegentore)
                punkte += 3;
            else if(tore == gegentore)punkte += 1;
            gesamtGegentore += gegentore;
            gesamtTore += tore;
        }
        return new Gesamtstand(punkte,gesamtTore,gesamtGegentore,mannschaft);
    }
}
