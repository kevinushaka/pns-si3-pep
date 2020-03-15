package arm;

import java.util.ArrayList;

import arm.command.CommandParser;

public class LineParser {
	
	String binary;
	public LineParser() {
		// TODO Auto-generated constructor stub
	}
	
	CommandParser find(String line) {
		
		return null;
	}
	
	boolean parse(String line) {
		boolean bFinded=false;
		ArrayList<String> commandAndParams=getCommandAndParam(line);
		
		//for(String str:commandAndParams)
			//System.out.println(str);
		CommandParser commandParser = null;
		CommandFinder commandFinder= new CommandFinder();
		if(commandAndParams.size()==0)
			return false;
		if(commandFinder.find(commandAndParams.get(0).toLowerCase()))
		{
				bFinded=true;
				commandParser=commandFinder.getCommand();
		}
		
		
		if(bFinded) 
		{
			String params="";
			for(int i=1; i<commandAndParams.size();i++) 
			{
				params+=commandAndParams.get(i)+" ";
			}
			commandParser.parse(params);
			binary= commandParser.getBinary();				
			return true;
			
		}
		
			
			
		return false;
	}
	
	ArrayList<String> getCommandAndParam(String str){
		ArrayList<String> commandStr=new ArrayList<String>();
		int indexStr;
		boolean firstB=false;
		for( indexStr=0; indexStr< str.length();indexStr++) 
		{
			boolean conditionnal=false;
			if(
					Character.isAlphabetic(str.charAt(indexStr)) || 
					str.charAt(indexStr)=='#'||
					str.charAt(indexStr)=='['
					) 
			{
				if(str.charAt(indexStr)=='B'||str.charAt(indexStr)=='b'){
					firstB=true;
					conditionnal=true;
				}

				String w_temp="";
				while(indexStr<str.length()) 
				{
					if(str.charAt(indexStr)==' '||
							str.charAt(indexStr)==','||
							str.charAt(indexStr)=='\n'||
							str.charAt(indexStr)=='\t')
						break;
					if(Character.isAlphabetic(str.charAt(indexStr)) && conditionnal &&!firstB)
						break;
					w_temp+=str.charAt(indexStr);indexStr++;
				}
				commandStr.add(w_temp);
			}
		}
		
		return commandStr;
	}
	String getBinary() {return binary;}
	
}
