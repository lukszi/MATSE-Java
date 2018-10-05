import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Messreihe

{
    private double data[];
    public Messreihe(double[] list)
    {

    }

    public Messreihe(String fileName)
    {
        File fIn = new File(fileName);
        int valueLines = 0;
        int commentLines = 0;
        try {
            Scanner scan = new Scanner(fIn);
            boolean firstLine = true;
            while(scan.hasNextLine())
            {
                String line = scan.nextLine();

                // Check for comments
                if(line.charAt(0) == '%')
                {
                    commentLines++;
                    continue;
                }
                try{
                    // Check if this is the line containing the list length
                    if(firstLine)
                    {
                        // If so create the array
                        this.data = new double[Integer.valueOf(line)];
                        firstLine = false;
                        continue;
                    }
                    // Check if we read more lines then indicated in the first line
                    if(valueLines >= this.data.length)
                        throw new ArithmeticException();

                    this.data[valueLines] = Double.valueOf(line);
                    valueLines++;
                }
                catch (NumberFormatException e)
                {
                    throw new ArithmeticException("Syntax error in line: " + (valueLines+commentLines+1));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public double getMax()
    {
        return this.data[this.getMaxIndex()];
    }

    public double getMin()
    {
        double ret = 0.0;
        return ret;
    }

    public boolean istEinheitlich()
    {
        boolean ret = true;
        return ret;
    }

    public int zaehleGroessere(double lim)
    {
        int count = 0;
        return count;
    }

    public int getMaxIndex()
    {
        int maxIndex = 0;
        for(int i = 1; i<this.data.length;i++)
        {
            if(this.data[maxIndex]<this.data[i])
                maxIndex = i;
        }
        return maxIndex;
    }

    public double[] getBereich()
    {
        double[] range = new double[2];
        range[0] = this.getMin();
        range[1] = this.getMax();
        return range;
    }

    public int getAnzahl()
    {
        int count = 0;
        return count;
    }
}
