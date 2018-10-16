package pkg1;

import java.io.*;

public class A{
	protected int number;
	String name;
	public A(int _number, String _name){
		number = _number;
		name = _name;
	}
	public void callDecrement(){
		decrement();
	}
	public void callIncrement(){
		increment();
	}
	public void callChangeName(String s){
		changeName(s);
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
	public int getNumber(){
		return number;
	}
	public String getName(){
		return name;
	}
}