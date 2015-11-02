package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVOutputGenerator extends OutputBuilder {
	
	private String output;
	
	public CSVOutputGenerator() {
		this.output = "";
	}
	
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
			System.out.println(output);
			System.out.println("DONE WRITING TO RESULTS.CSV PO??");
		} catch (IOException e) {
			System.out.println("fail in writing to file po");
		}
		
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	void parseOutput(HashMap<String, ArrayList<Integer>> result) {
		// http://stackoverflow.com/questions/19084352/how-to-write-new-line-character-to-a-file-in-java
		StringBuilder stringBuilder = new StringBuilder(output);
		stringBuilder.append("Word,Document #");
		
		ArrayList<Integer> listOfDocs = new ArrayList<Integer>();
		/** Iterate through hashmap */
		for (String key: result.keySet()) {
			stringBuilder.append(System.lineSeparator());
			stringBuilder.append(key+",");
			listOfDocs = result.get(key);
			for (Integer docNum : listOfDocs) {
				stringBuilder.append(Integer.toString(docNum)+",");
			}
		}
		
		output = stringBuilder.toString();
	}

}
