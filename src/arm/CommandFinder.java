package arm;

import arm.command.*;

public class CommandFinder {

	CommandParser command;
	public CommandFinder() {
		// TODO Auto-generated constructor stub
	}
	
	boolean find(String command) {

		switch(command) {
		
		case "sub":this.command=new Sub();return true;
		case "movs":this.command= new Movs();return true;
		case "ldr":this.command=new Ldr();return true;
		case "str":this.command=new Str();return true;
		case "add":this.command=new Add();return true;
		case "adds":this.command=new Adds();return true;
		case "mul":this.command=new Mul();return true;
		case "muls":this.command=new Mul();return true;
		case "cmp":this.command=new Cmp();return true;
		case "b":this.command=new B();return true;
		}
		
		return false;
	}
	
	CommandParser getCommand() {return command;}

}
