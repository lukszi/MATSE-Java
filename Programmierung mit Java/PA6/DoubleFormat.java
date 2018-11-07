public class DoubleFormat implements BruchFormat
{

    @Override
    public String bruchToString(int zaehler, int nenner)
    {
        return String.valueOf((double)zaehler/nenner);
    }
}
