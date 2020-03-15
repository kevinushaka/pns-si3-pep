package arm.command;

import java.util.ArrayList;

public class Cmp extends CommandParser {

	public Cmp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parse(String arg) {
		// TODO Auto-generated method stub
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
			String number="0100001010"+
			BaseConversion.GetNDigit(BaseConversion.baseConversion(lst.get(1), 10, 2),3)+
			BaseConversion.GetNDigit(BaseConversion.baseConversion(lst.get(0), 10, 2),3);
			binary=BaseConversion.baseConversion(number, 2, 16);

	}

}
