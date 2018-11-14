public class Sekantenverfahren implements Verfahren
{

    @Override
    public double getNullstelle(Funktion f, double xMin, double xMax)
    {
        double ret = calcRet(f, xMin, xMax);
        double threshold = Math.pow(10,-10);
        while(xMax-xMin > threshold){
            if(Math.abs(f.getY(ret)) < threshold)
                break;
            if(f.getY(xMin)*f.getY(ret) <0)
                xMax = ret;
            if(f.getY(xMax)*f.getY(ret) < 0)
                xMin = ret;
            ret = calcRet(f,xMin,xMax);
        }
        return ret;
    }

    private double calcRet(Funktion f, double x1, double x2)
    {
        return (x1*f.getY(x2)-x2*f.getY(x1))/(f.getY(x2)-f.getY(x1));
    }
}
