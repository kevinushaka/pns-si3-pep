package arm.command;

public class BaseConversion {

	public BaseConversion() {
		// TODO Auto-generated constructor stub
	}

	public static String baseConversion(String number, 
            int sBase, int dBase) 
	{ 
			// Parse the number with source radix  
			// and return in specified radix(base) 
			return Integer.toString( 
					Integer.parseInt(number, sBase), 
					dBase); 
	}

	public static String GetNDigit(String str,int n) {
		int k=n-str.length();
		String zero="";
		while(zero.length()!=k)zero+="0";
		return zero+str;
	}
}
