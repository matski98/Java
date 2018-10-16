package klasy;

import java.io.*;

public class A{
	protected int number;
	String name;
	public A(int _number, String _name){
		number = _number;
		name = _name;
	}
	public void callDecrement(){
		--number;
	}
	public void callIncrement(){
		++number;
	}
	public void callChangeName(String s){
		name = s;
	}
	private void increment(){
		++number;
	}
	protected void decrement(){
		--number;
	}
	void changeName(String s){
		name = s;
	}
}