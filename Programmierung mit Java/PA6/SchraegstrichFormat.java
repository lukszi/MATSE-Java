public class SchraegstrichFormat implements BruchFormat
{
    @Override
    public String bruchToString(int zaehler, int nenner)
    {
        return zaehler + "/" + nenner;
    }
}
