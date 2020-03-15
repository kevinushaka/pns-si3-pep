package arm.command;

import java.util.ArrayList;

public class Adds extends CommandParser{

	public Adds() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parse(String arg) {
		// TODO Auto-generated method stub
		boolean f1=true;
		ArrayList<String> lst= new ArrayList<String>();
		for(int i=0; i<arg.length();i++) 
		{
			if(arg.charAt(i)=='r' || arg.charAt(i)=='R' ) 
			{
				int j=++i;
				String str="";
				while(j<arg.length() ) 
				{
					if(!Character.isDigit(arg.charAt(j)))
						break;
					str+=arg.charAt(j);
					j++;
				}
				lst.add(str);
			}
			if(arg.charAt(i)=='#' ) 
			{
				f1=false;
				int j=++i;
				String str="";
				while(j<arg.length() ) 
				{
					if(!Character.isDigit(arg.charAt(j)))
						break;
					str+=arg.charAt(j);
					j++;
				}
				lst.add(str);
			}
				
		}
		if(f1) {
			String number="0001100"+
					BaseConversion.GetNDigit(BaseConversion.baseConversion(lst.get(0), 10, 2),3)+
					BaseConversion.GetNDigit(BaseConversion.baseConversion(lst.get(1), 10, 2),3)+
					BaseConversion.GetNDigit(BaseConversion.baseConversion(lst.get(2), 10, 2),3);
					binary=BaseConversion.baseConversion(number, 2, 16);
		}
		else {
			String number="0001110"+
					BaseConversion.GetNDigit(BaseConversion.baseConversion(lst.get(0), 10, 2),3)+
					BaseConversion.GetNDigit(BaseConversion.baseConversion(lst.get(1), 10, 2),3)+
					BaseConversion.GetNDigit(BaseConversion.baseConversion(lst.get(2), 10, 2),3);
					binary=BaseConversion.baseConversion(number, 2, 16);
		}
			
	}

}
