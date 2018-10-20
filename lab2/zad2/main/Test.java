package main;
import java.io.*;
import java.util.*;
import klasy.*;
public class Test {
	static LinkedList<Prostokat> lista = new LinkedList<Prostokat>();
   	public static void main(String args[]) {
   		System.out.print("\033[H\033[2J");
        	System.out.flush();
   		while(true){
	   		System.out.println("Aby wczytac prostokat wpisz 1");
	   		System.out.println("Aby wyświetic wszystkie prostokaty wpisz 2");
	   		System.out.println("Aby obliczyc sume pol wszytskich prostokatow wpisz 3");
	   		System.out.println("Aby zakonczyc wpisz 4");
	      	String s;
	      	Scanner odczyt = new Scanner(System.in);
	      	s=odczyt.nextLine();
	      	switch(s){
	      		case "1":{
	      			double a,b;
	      			System.out.println("podaj bok A prostokata");
	      			Scanner p = new Scanner(System.in);
	      			a=Double.parseDouble(p.nextLine());
	      			System.out.println("podaj bok B prostokata");
	      			Scanner d = new Scanner(System.in);
	      			b=Double.parseDouble(d.nextLine());
	      			Prostokat pro = new Prostokat(a,b);
	      			lista.add(pro);
	      			System.out.print("\033[H\033[2J");
            			System.out.flush();
	      			break;
	      		}
	      		case "2":{
	      			System.out.print("\033[H\033[2J");
            			System.out.flush();
	      			for(int i = 0; i<lista.size(); ++i){
	      				System.out.println("Prostokat nr: "+(i+1)+" bok A: "+lista.get(i).getA()+" bok B: "+lista.get(i).getB());
	      			}
	      			break;
	      		}
	      		case "3":{
	      			System.out.print("\033[H\033[2J");
            			System.out.flush();
	      			double suma=0;
	      			for(int i = 0; i<lista.size(); ++i){
	      				suma+=lista.get(i).area();
	      			}
	      			System.out.println("Suma pol wszystkich prostokatow to: "+suma);
	      			break;
	      		}
	      		case "4":{
	      			return;
	      		}
	      	}
      	}
   	}
}
