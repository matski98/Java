package klasy;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Cryptographer {

    public static void cryptfile(File in, File out, Algorithm algorithm){
        try{
            BufferedReader input = new BufferedReader(new FileReader(in));
            FileWriter output = new FileWriter(out);
            String temp;
            while ((temp = input.readLine()) != null) {
                output.write(algorithm.crypt(temp));
            }
            input.close();
            output.close();

        }
        catch (IOException e) {
            System.out.println("Brak pliku");
        }

    }
    public static void decryptfile(File in, File out, Algorithm algorithm){
        try{
            BufferedReader input = new BufferedReader(new FileReader(in));
            FileWriter output = new FileWriter(out);
            String temp;
            while ((temp = input.readLine()) != null) {
                output.write(algorithm.decrypt(temp));
            }
            input.close();
            output.close();
        }

        catch (IOException e) {
            System.out.println("Brak pliku");
        }

    }
}
