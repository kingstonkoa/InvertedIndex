package controller;

import java.util.ArrayList;
import java.util.HashMap;

import utilities.CSVOutputGenerator;
import utilities.OutputGenerator;
import view.IInvertedIndexView;

public class InvertedIndexController {
	
	private IInvertedIndexView view;
	private ArrayList<String> inputTokens;
	private HashMap<String, ArrayList<String>> invertedIndex;
	
	public InvertedIndexController(IInvertedIndexView view) {
		this.view = view;
	}
	
	public void constructInvertedIndex() {
		/** STEP 1 tokenize db? */
		/** STEP 2 tokenize input */
		/** STEP 3 save to inputTokens */
		/** STEP 4 search db for substring */
		/** STEP 5 save to invertedIndex */
		
		/** STEP 6 generate output */
		CSVOutputGenerator outputBuilder = new CSVOutputGenerator();
		OutputGenerator outputGenerator = new OutputGenerator(outputBuilder);
		outputGenerator.generateOutput(invertedIndex);
	}

}
