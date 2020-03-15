package arm;
import java.io.*;
import java.util.Scanner;

import arm.command.BaseConversion;

/**
 * 
 */

/**
 * @author Invitéé
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
        String fileName;
        String directory;

        /**Get file from input**/
        InputStream input = System.in;

        try {
            String dest="calculator.txt";
            //BufferedWrite write text files
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(dest));
            fileWriter.write("v2 . 0 raw");
            fileWriter.newLine();

            // FileReader reads text files in the default encoding.
            ///FileReader fileReader =
             //   new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(input));

            //Parse a line
            LineParser lineParser=
            	new LineParser();

            // This will reference one line at a time
                String line = null;

                //Number of instructions
                int nbInstructions=1;

            while((line = bufferedReader.readLine()) != null) {
            	if(lineParser.parse(line)) {
            	    if(nbInstructions==1)
                        fileWriter.write(lineParser.getBinary());
            	    else
                        fileWriter.write(" "+lineParser.getBinary());
                    nbInstructions++;

                }
            }

            // Always close files.
            //bufferedReader.close();
            fileWriter.close();
        }
        catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch(IOException ex) {
             ex.printStackTrace();
        }

	}

}
