package arm.command;

public abstract class CommandParser {

	String binary;
	public CommandParser() {
		// TODO Auto-generated constructor stub
	}

	public abstract void parse(String arg);
	
	public String getBinary() {return binary;};
}
