package klasy;
import java.io.*;

public class Kwadrat{
	private double a;
	public Kwadrat(double _a){
		a=_a;
	}
	public double getA(){
		return a;
	}
	public void setA(double _a){
		a=_a;
	}
	public double area(){
		return a*a;
	}
	public Boolean isBigger(Kwadrat K){
		return K.getA()>a;
	}
	
}