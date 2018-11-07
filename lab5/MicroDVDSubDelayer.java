import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.*;

public class MicroDVDSubDelayer {

    public static void main(String[] args){
        int licznik = 0;
        try{
            BufferedReader input = new BufferedReader(new FileReader(new File(args[0])));
            FileWriter output = new FileWriter(new File(args[1]));
            String temp;
            int delay = Integer.parseInt(args[2]);
            int fps = Integer.parseInt(args[3]);
            while ((temp = input.readLine()) != null){
                ++licznik;
                output.write(delay(temp, delay, fps));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage() + " w linii " + licznik);
        }
    }
    static String delay(String in, int delay, int fps)throws DelayExceptions{
        String[] tab = in.split("}");
        Integer begin;
        Integer end;
        if ((Pattern.matches("\\{[[0-9]]*", tab[0])) && (Pattern.matches("\\{[[0-9]]*", tab[1]))){
            tab[0] = tab[0].substring(1);
            tab[1] = tab[1].substring(1);
            begin = Integer.parseInt(tab[0]);
            end = Integer.parseInt(tab[1]);
            if (begin >= end){
                throw new DelayExceptions("pierwsza liczba wieksza lub rowna drugiej");
            }
            begin += fps * delay / 1000;
            end += fps * delay / 1000;
            return "{" + begin.toString() + "}{" + end.toString() + "}" + tab[2] + "\n";
        }
        else{
            throw new DelayExceptions("linia nie pasuje");
        }
    }
}
