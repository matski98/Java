package main;
import java.io.*;
import pkg1.*;
import pkg2.C;
public class Main {

   public static void main(String args[]) {
    A a = new A (0,"klasa A");
	B b = new B (0,"klasa B");
	C c = new C (0,"klasa C");
	System.out.println(a.getNumber()+" | "+a.getName());
	System.out.println(b.getNumber()+" | "+b.getName());
	System.out.println(c.getNumber()+" | "+c.getName());
	a.callDecrement();
	a.callIncrement();
	b.callDecrement();
	b.callIncrement();
	c.callDecrement();
	c.callIncrement();
	a.callChangeName("a");
	b.callChangeName("b");
	c.callChangeName("c");
	System.out.println(a.getNumber()+" | "+a.getName());
	System.out.println(b.getNumber()+" | "+b.getName());
	System.out.println(c.getNumber()+" | "+c.getName());
   }
}