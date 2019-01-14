import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Lukas Szimtenings
 * @author Felix Szimtenings
 * @author Sebastian Schmitz
 * A happy new year to the MATSE department too
 */
public class Huffman
{
    /**
     * Decodes a Huffman encoded file
     * @param f the Huffman encoded file
     * @return the original String encoded in the file
     * @throws IllegalArgumentException if file f has a wrong encoding
     */
    public static String decode(File f) throws IllegalArgumentException{
        StringBuilder ret = new StringBuilder();

        // Read file
        Scanner scan;
        ArrayList<String> lines = new ArrayList<>();
        try {
            scan = new Scanner(new FileInputStream(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        }
        while(scan.hasNextLine()){
            lines.add(scan.nextLine());
        }
        scan.close();

        String encodedText = lines.get(0);
        lines.remove(encodedText);

        // Generate encoding map
        HashMap<String, Character> encoding = new HashMap<>();
        for(int i = 0; i< lines.size()-1;++i){
            encoding.put(lines.get(i), (char) ('A'+i));
        }
        // Put in the space
        encoding.put(lines.get(lines.size()-1), ' ');

        // Iterate over the encoded text, and decode it
        char[] encodedChars = encodedText.toCharArray();
        StringBuilder buffer = new StringBuilder();
        for(char a : encodedChars){
            buffer.append(a);
            // Check if buffer is contained in the encoding
            if(encoding.containsKey(buffer.toString())){
                // Append corresponding character to the result
                ret.append(encoding.get(buffer.toString()));
                // Reset buffer
                buffer.setLength(0);
            }
        }
        // Check if encoding was correct
        if(buffer.length()>0||lines.size()!=27){
            throw new IllegalArgumentException(lines.size()!=27? "Dateilänge falsch" : "Code unvollständig");
        }
        return ret.toString();
    }

    public static void main(String[] args)
    {
        String filePath = JOptionPane.showInputDialog("Dateipfad");
        File f = new File(filePath);
        System.out.println(decode(f));
    }
}
