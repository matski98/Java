package main;
import klasy.*;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try{
            File in = new File(args[0]);
            File out = new File(args[1]);
            System.out.println("1 aby szyfrowac");
            System.out.println("2 aby deszyfrowac");
            String s;
            Scanner scan = new Scanner(System.in);
            s=scan.nextLine();
            switch (s) {
                case "1":
                    System.out.println("Jakiego algorytmu uzyc do szyfracji?");
                    System.out.println("1 aby uzyc algortytmu ROT11");
                    System.out.println("2 aby uzyc algorytmu Polibiusza");
                    String d;
                    Scanner scan2 = new Scanner(System.in);
                    d = scan2.nextLine();
                    switch (d) {
                        case "1":
                            Cryptographer.cryptfile(in, out, new ROT11());
                            break;
                        case "2":
                            Cryptographer.cryptfile(in, out, new Polibiusz());
                            break;
                    }
                    break;
                case "2":
                    System.out.println("Jakiego algorytmu uzyc do deszyfracji?");
                    System.out.println("1 aby uzyc algorytmu ROT11");
                    System.out.println("2 aby uzyc algorytmu Polibiusza");
                    String e;
                    Scanner scan3 = new Scanner(System.in);
                    e = scan3.nextLine();
                    switch (e) {
                        case "1":
                            Cryptographer.decryptfile(in, out, new ROT11());
                            break;
                        case "2":
                            Cryptographer.decryptfile(in, out, new Polibiusz());
                            break;
                    }
                    break;
            }
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Brak argumentów programu");
        }
    }
}
