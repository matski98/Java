package katalog2;
public class PESEL{
	public static Boolean check(String pesel){
		if(pesel.length()!=11) return false;
		for(int i = 0; i<11; ++i)
			if(!Character.isDigit(pesel.charAt(i))) return false;
		int a = 9*Integer.parseInt(String.valueOf(pesel.charAt(0)))
		+7*Integer.parseInt(String.valueOf(pesel.charAt(1)))
		+3*Integer.parseInt(String.valueOf(pesel.charAt(2)))
		+Integer.parseInt(String.valueOf(pesel.charAt(3)))
		+9*Integer.parseInt(String.valueOf(pesel.charAt(4)))
		+7*Integer.parseInt(String.valueOf(pesel.charAt(5)))
		+3*Integer.parseInt(String.valueOf(pesel.charAt(6)))
		+Integer.parseInt(String.valueOf(pesel.charAt(7)))
		+9*Integer.parseInt(String.valueOf(pesel.charAt(8)))
		+7*Integer.parseInt(String.valueOf(pesel.charAt(9)));
		String c = new StringBuilder(Integer.toString(a)).reverse().toString();
		if(c.charAt(0)==pesel.charAt(10)){
			return true;
		}
		return false;
	}
}