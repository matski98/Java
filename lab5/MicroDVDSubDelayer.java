import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.*;

public class MicroDVDSubDelayer {

    public static void main(String[] args){
        int licznik = 0;
        if (args.length != 4) return;
        try{
            BufferedReader input = new BufferedReader(new FileReader(new File(args[0])));
            FileWriter output = new FileWriter(new File(args[1]));
            String line;
            int delay = Integer.parseInt(args[2]);
            int fps = Integer.parseInt(args[3]);
            while ((line = input.readLine()) != null){
                ++licznik;
                try{
                    output.write(delay(line, delay, fps, licznik));
                }
                catch (DelayExceptions e){
                    System.out.println(e.getMessage());
                    continue;
                }
                catch (Exception e){
                    System.out.println("nieobslugiwany typ wyjatku w linii: " + licznik + " tresc: " + line);
                    continue;
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
    static String delay(String in, int delay, int fps, int licznik)throws DelayExceptions{
        String[] tab = in.split("}");
        Integer begin;
        Integer end;
        if ((Pattern.matches("\\{[[0-9]]*", tab[0])) && (Pattern.matches("\\{[[0-9]]*", tab[1]))){
            tab[0] = tab[0].substring(1);
            tab[1] = tab[1].substring(1);
            begin = Integer.parseInt(tab[0]);
            end = Integer.parseInt(tab[1]);
            if (begin >= end){
                throw new DelayExceptions("pierwsza liczba wieksza lub rowna drugiej w linii " + licznik + " tresc linii: " + in);
            }
            begin += fps * delay / 1000;
            end += fps * delay / 1000;
            return "{" + begin.toString() + "}{" + end.toString() + "}" + tab[2] + "\n";
        }
        else{
            throw new DelayExceptions("linia nie pasuje w linii " + licznik +  " tresc linii: " + in);
        }
    }
}
