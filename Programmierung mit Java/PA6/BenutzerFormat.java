import java.util.Locale;

public class BenutzerFormat implements BruchFormat
{
    private Locale locale;
    private String format;

    public BenutzerFormat(String format, Locale locale){
        this.format = format;
        this.locale = locale;
    }

    public BenutzerFormat(String format){
        this(format, Locale.GERMAN);
    }

    @Override
    public String bruchToString(int zaehler, int nenner)
    {
        return String.format(format,(double)zaehler/nenner, locale);
    }
}
