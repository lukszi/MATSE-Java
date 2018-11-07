public class BenutzerFormat implements BruchFormat
{
    private String format;

    public BenutzerFormat(String format){
        this.format = format;
    }

    @Override
    public String bruchToString(int zaehler, int nenner)
    {
        return String.format(format,(double)zaehler/nenner);
    }
}
