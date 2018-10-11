import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 */
public class GoldPreis
{
    // Contains a list of all prices
    private ArrayList<GoldTagesPreis> list;
    // Contains a mapping of dates to the indices in the list
    private Map<String, Integer> dateMap;

    /**
     * Creates a new object by parsing the passed text file
     * @param dateiname path to a text file
     * @throws FileNotFoundException if the file couldn't be opened
     */
    public GoldPreis(String dateiname)throws FileNotFoundException
    {
        // Create structures
        dateMap = new HashMap<>();
        list = new ArrayList<>();

        // Parse the file
        File fIn = new File(dateiname);
        // No closing needed, see https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        try(Scanner scan = new Scanner(fIn)){
            while(scan.hasNextLine())
            {
                String line = scan.nextLine();
                String[] lineTokens = line.split("\t");

                // Handle line without price
                if(lineTokens[1].equals("kein Nachweis"))
                {
                    list.add(new GoldTagesPreis(lineTokens[0],-1));
                    dateMap.put(lineTokens[0], list.size()-1);
                    continue;
                }

                // Create price, add it into the list and update the dateMap
                GoldTagesPreis tagesPreis = new GoldTagesPreis(lineTokens[0], lineTokens[1]);
                list.add(tagesPreis);
                dateMap.put(lineTokens[0], list.size()-1);
            }
        }
        catch (IOException e)
        {
            throw new FileNotFoundException();
        }
    }

    /**
     * fetches the price at a certain date
     * @param datum date for the price to be fetched
     * @return the price as a formatted String as found in the provided file
     * @throws NumberFormatException if the date couldn't be found
     */
    public String getPreis(String datum) throws NumberFormatException{
        //Check if date is in our List
        if(!dateMap.containsKey(datum))
            throw new NumberFormatException();

        GoldTagesPreis tagesPreis = list.get(dateMap.get(datum));
        return tagesPreis.parsePriceToString(tagesPreis.preis);
    }

    /**
     * Prints all occurrences of extremal prices
     */
    public void printMinMax()
    {
        //Stores the index of the first occurrence of the current extremal price
        int minIndex = 0;
        int maxIndex = 0;
        //Stores all indices of extremal price occurrences
        ArrayList<Integer> maxList = new ArrayList<>();
        ArrayList<Integer> minList = new ArrayList<>();

        //Loop over price list
        for(int i = 0; i<list.size(); i++){
            //If price is undefined skip
            if(list.get(i).preis == -1)
                continue;
            //New lowest price
            if(list.get(minIndex).preis>list.get(i).preis){
                minList = new ArrayList<>();
                minList.add(i);
                minIndex = i;
            }
            //Lowest price found again, add it to list
            else if(list.get(minIndex).preis==list.get(i).preis) {
                minList.add(i);
            }
            //New highest price
            if(list.get(maxIndex).preis<list.get(i).preis){
                maxList = new ArrayList<>();
                maxList.add(i);
                maxIndex = i;
            }
            //Highest price found again, add to list
            else if(list.get(maxIndex).preis==list.get(i).preis){
                maxList.add(i);
            }
        }
        String preisDate = extremeListToString(minList);
        System.out.printf("Den niedrigsten Goldpreis von %f gab es an folgenden Tagen:\n %s\n",
                list.get(minIndex).preis, preisDate);

        preisDate = extremeListToString(maxList);
        System.out.printf("Den hoechsten Goldpreis von %f gab es an folgenden Tagen:\n %s\n",
                list.get(maxIndex).preis, preisDate);
    }

    /**
     * Converts a list of extremal indices to a String to output
     * @param extremeList list of extremal indices
     * @return formatted String
     */
    private String extremeListToString(ArrayList<Integer> extremeList)
    {
        StringBuilder preisDateBuilder = new StringBuilder();
        for(int i : extremeList)
        {
            preisDateBuilder.append(String.valueOf(list.get(i).datum));
            preisDateBuilder.append(" ");
        }
        return preisDateBuilder.toString();
    }
}
