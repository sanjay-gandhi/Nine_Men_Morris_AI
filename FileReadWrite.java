import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReadWrite {
	static Scanner in = new Scanner(System.in);
	static String inputFile = in.next();
	static String outputFile = in.next();

	public static String getInput(){

		String contents = "";		
		try {
			Scanner fileRead = new Scanner(new FileReader(inputFile));
			contents = fileRead.nextLine().trim();
			fileRead.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return contents;
	}

	public static void writeOutput(String result) throws IOException{
		try{
			FileWriter fw = new FileWriter(outputFile);
			fw.write(result);
			fw.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} 
	}
}


