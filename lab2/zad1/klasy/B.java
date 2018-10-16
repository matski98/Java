package klasy;

import java.io.*;

public class B extends A{
	
	public B(int _number, String _name){
		super(_number,_name);
	}
	private void increment(){
		number+=2;
	}
	protected void decrement(){
		number-=2;
	}
	void changeName(String s){
		name = s;
	}
}