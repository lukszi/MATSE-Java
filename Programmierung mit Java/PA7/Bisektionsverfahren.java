public class Bisektionsverfahren implements Verfahren
{

    @Override
    public double getNullstelle(Funktion_Aufgabe7 f, double xMin, double xMax)
    {
        double threshold = Math.pow(10,-10);
        double ret = (xMax+xMin)/2;
        while(xMax-xMin>threshold)
        {
            System.out.println("Using xMax=" + xMax +", xMin=" + xMax +", ret="+ret);
            if(Math.abs(f.getY(ret)) < threshold)
                break;
            if(f.getY(xMin)*f.getY(ret) <0)
                xMax = ret;
            if(f.getY(xMax)*f.getY(ret) < 0)
                xMin = ret;
            ret = (xMax+xMin)/2;
        }
        return ret;
    }
}
