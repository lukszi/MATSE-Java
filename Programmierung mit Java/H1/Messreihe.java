public class Messreihe

{
    private double data[];
    public Messreihe(double[] list)
    {

    }

    public Messreihe(String fileName)
    {

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
