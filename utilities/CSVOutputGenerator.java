package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVOutputGenerator extends OutputBuilder {
	
	private String output;
	
	@Override
	void generateOutput() {
		/** Create File */
		File file = null;
		String fileName = "Results.csv";
		try
		{
			file = new File(fileName);
			file.createNewFile();
		}
		catch (IOException iOException)
		{
			System.out.println("error in creating file po");
		}
		

		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(fileName));
		} catch (IOException e1) {
			System.out.println("error in creating file writer or something lels");
		}
		
		/** Write stuff to file */
		try {
			out.write(output);
		} catch (IOException e) {
			System.out.println("fail in writing to file po");
		}
	}

	@Override
	void parseOutput(HashMap<String, ArrayList<String>> result) {
		// http://stackoverflow.com/questions/19084352/how-to-write-new-line-character-to-a-file-in-java
		StringBuilder stringBuilder = new StringBuilder(output);
	}

}
