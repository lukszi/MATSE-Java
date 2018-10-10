public class Gesamtstand
{
    private int punkte;
    private int tore;
    private int gegentore;
    private String vereinsName;

    public Gesamtstand(int punkte, int tore, int gegentore, String vereinsName)
    {
        this.vereinsName = vereinsName;
        this.tore = tore;
        this.gegentore = gegentore;
        this.punkte = punkte;
    }

    public String getVereinsName()
    {
        return vereinsName;
    }

    public void setVereinsName(String vereinsName)
    {
        this.vereinsName = vereinsName;
    }

    public int getPunkte()
    {
        return punkte;
    }

    public void setPunkte(int punkte)
    {
        this.punkte = punkte;
    }

    public int getTore()
    {
        return tore;
    }

    public void setTore(int tore)
    {
        this.tore = tore;
    }

    public int getGegentore()
    {
        return gegentore;
    }

    public void setGegentore(int gegentore)
    {
        this.gegentore = gegentore;
    }

    @Override
    public String toString()
    {
        return this.vereinsName + "\t" + this.tore + ":" + this.gegentore + "\t" + this.punkte;
    }
}
