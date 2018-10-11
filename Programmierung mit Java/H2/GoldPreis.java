import java.io.File;
import java.io.IOException;
import java.util.*;

public class GoldPreis
{
    private ArrayList<GoldTagesPreis> list;
    private Map<String, Integer> dayMap;

    public GoldPreis(String dateiname){
        dayMap = new HashMap<>();
        list = new ArrayList<>();
        File fIn = new File(dateiname);
        try(Scanner scan = new Scanner(fIn)){
            while(scan.hasNextLine())
            {
                String line = scan.nextLine();
                String[] lineTokens = line.split("\t");
                if(lineTokens[1].equals("kein Nachweis"))
                    continue;
                lineTokens[1] = lineTokens[1].replace(".","");
                lineTokens[1] = lineTokens[1].replace(",",".");
                GoldTagesPreis tagesPreis = new GoldTagesPreis(lineTokens[0],Double.parseDouble(lineTokens[2]));
                int preisPosition = list.size();
                list.add(tagesPreis);
                dayMap.put(lineTokens[0], preisPosition);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public String getPreis(String datum) throws NumberFormatException{
        if(!dayMap.containsKey(datum))
            throw new NumberFormatException();
        GoldTagesPreis tagesPreis = list.get(dayMap.get(datum));
        String preis = tagesPreis.toString();
        preis = preis.replace(".", ",");
        preis = preis.substring(0,2) + "." + preis.substring(2,preis.length()-1);
        return tagesPreis.datum + "\t" + preis;
    }

    public void printMinMax()
    {
        int minIndex = 0;
        int maxIndex = 0;
        ArrayList<Integer> maxList = new ArrayList<>();
        ArrayList<Integer> minList = new ArrayList<>();
        for(int i = 0; i<list.size(); i++){
            if(list.get(minIndex).preis>list.get(i).preis){
                minList = new ArrayList<>();
                minList.add(i);
                minIndex = i;
            }
            else if(list.get(minIndex).preis==list.get(i).preis) {
                minList.add(i);
            }
            if(list.get(maxIndex).preis<list.get(i).preis){
                maxList = new ArrayList<>();
                maxList.add(i);
                maxIndex = i;
            }
            else if(list.get(maxIndex).preis==list.get(i).preis){
                maxList.add(i);
            }
        }
        StringBuilder preisDateBuilder = new StringBuilder();
        for(int i : minList)
        {
            preisDateBuilder.append(String.valueOf(list.get(i).datum));
            preisDateBuilder.append(" ");
        }
        System.out.printf("Den niedrigsten Goldpreis von %f gab es an folgenden Tagen:\t %s",
                list.get(minIndex).preis, preisDateBuilder.toString());

        preisDateBuilder = new StringBuilder();
        for(int i : maxList)
        {
            preisDateBuilder.append(String.valueOf(list.get(i).datum));
            preisDateBuilder.append(" ");
        }
        System.out.printf("Den hoechsten Goldpreis von %f gab es an folgenden Tagen:\t %s",
                list.get(maxIndex).preis, preisDateBuilder.toString());
    }
}
