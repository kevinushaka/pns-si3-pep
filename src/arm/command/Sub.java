package arm.command;

import java.util.ArrayList;

public class Sub extends CommandParser{

	public Sub() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void parse(String arg) {
		// TODO Auto-generated method stub
		ArrayList<String> lst= new ArrayList<String>();
		for(int i=0; i<arg.length();i++) 
		{
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
		String number="101100001"+
		BaseConversion.GetNDigit(BaseConversion.baseConversion(lst.get(0), 10, 2),7);
		binary=BaseConversion.baseConversion(number, 2, 16);
	}

}
