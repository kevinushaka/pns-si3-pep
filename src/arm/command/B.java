package arm.command;

import java.util.ArrayList;

public class B extends CommandParser{

	public B() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parse(String arg) {
		// TODO Auto-generated method stub
		boolean f1=true;
		boolean immediat=false;
		ArrayList<String> lst= new ArrayList<String>();
		for(int i=0; i<arg.length();i++) 
		{
			if(Character.isAlphabetic(arg.charAt(i)) && arg.charAt(i)!='B' )
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
			if(arg.charAt(i)=='#')
			{
				immediat=true;
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
			if(arg.charAt(i)=='.')
			{
				f1=false;
				int j=++i;
				String str="";
				while(j<arg.length() )
				{
					if(!Character.isLetterOrDigit(arg.charAt(j)))
						break;
					str+=arg.charAt(j);
					j++;
				}
				lst.add(str);
			}
				
		}
		String immediatStr="11111110";
		String condition;
		if(lst.size()==1)
			condition="1110";
		else
			condition=getConditonCode(lst.get(0));

		if(immediat)
			immediatStr=lst.get(1);

		String number="1101"+ condition+immediatStr;
		binary=BaseConversion.baseConversion(number, 2, 16);

			
	}

	String getConditonCode(String condition){
		String code=null;
		switch (condition){
			case "EQ":code="0000";break;
			case"NE":code="0001";break;
			case "CS":code="0010";break;
			case "CC":code="0011";break;
			case"MI":code="0100";break;
			case "PL":code="0101";break;
			case "VS":code="0110";break;
			case "VC":code="0111";break;
			case "HI":code="1000";break;
			case "LS":code="1000";break;
			case "GE":code="1001";break;
			case "LT":code="1010";break;
			case "GT":code="1100";break;
			case "LE":code="1101";break;
			case "AL":code="1110";break;
		}
		return  code;
	}

}
