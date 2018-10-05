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
        double ret = 0.0;
        return ret;
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
        int i = 0;
        return i;
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
