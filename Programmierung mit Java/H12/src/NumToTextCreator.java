import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Lukas Szimtenings on 24.12.2018.
 */
public class NumToTextCreator
{
    public static void main(String[] args)
    {
        File file = new File("Zahlwort.asc");
        
            try
            {
                if(!file.exists())
                    file.createNewFile();
                FileOutputStream out = new FileOutputStream(file);
                StringBuilder a = new StringBuilder();
                //a.append("public class ZahlwortBak\n{\npublic static String getZahlwort(int x)\n{switch(x){\n");
                for(int i = 0; i<= 9999; i++){
                    a.append(String.valueOf(i)).append(":").append(Zahlwort.getZahlwort(i)).append("\n");
                    //a.append("case ").append(i).append(":").append("\n");
                    //a.append("return ").append("\"").append(Zahlwort.zahlWort(i)).append("\";");
                }
                //a.append("default:\n throw new ArithmeticException();").append("}\n}\n}");
                out.write(a.toString().getBytes());
            } catch (IOException e)
            {
                e.printStackTrace();
            }
    }
}
