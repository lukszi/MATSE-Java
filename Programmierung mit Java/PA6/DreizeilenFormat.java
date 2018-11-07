public class DreizeilenFormat implements BruchFormat
{
    @Override
    public String bruchToString(int zaehler, int nenner)
    {
        int zaehlerLength = String.valueOf(zaehler).length();
        int nennerLength = String.valueOf(nenner).length();

        // Figure out which line is the longest, the difference between them and the max length
        boolean zaehlerKuerzer = zaehlerLength<nennerLength;
        int length = Math.max(zaehlerLength, nennerLength);
        int diff = zaehlerKuerzer ? length - zaehlerLength : length-nennerLength;

        // Draw the middleLine
        StringBuilder middleLineSb = new StringBuilder();
        for(int i = 0; i< length; i++){
            middleLineSb.append("-");
        }

        // Create nenner and zaehler String represetations
        StringBuilder nennerSb = new StringBuilder();
        StringBuilder zaehlerSb = new StringBuilder();
        nennerSb.append(nenner);
        zaehlerSb.append(zaehler);

        // Figure out which String to space and space it
        StringBuilder spaceIt = zaehlerKuerzer ? zaehlerSb.reverse():nennerSb.reverse();
        for(int i = 0; i< diff; i++){
            spaceIt.append(" ");
        }
        spaceIt.reverse();

        // Return the formatted String
        return zaehlerSb.append("\n").append(middleLineSb).append("\n").append(nennerSb).toString();
    }
}
