package klasy;
import java.io.*;

public class Prostokat extends Kwadrat{
	private double b;
	public Prostokat(double _a, double _b){
		super(_a);
		b=_b;
	}
	public double getB(){
		return b;
	}
	public void setB(double _b){
		b=_b;
	}
	public double area(){
		return this.getA()*b;
	}
	public Boolean isBigger(Prostokat P){
		return P.area()>this.area();
	}
	
}