package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import utilities.CSVOutputGenerator;
import utilities.OutputGenerator;
import utilities.TagalogStemmer;
import view.IInvertedIndexView;

public class InvertedIndexController {
	
	private IInvertedIndexView view;
	private ArrayList<String> inputTokens;
	private HashMap<String, ArrayList<String>> invertedIndex;
	private TagalogStemmer stemmer;
	
	public InvertedIndexController(IInvertedIndexView view) {
		stemmer = new TagalogStemmer();
		inputTokens = new ArrayList<String>();
		this.view = view;
	}
	
	public void constructInvertedIndex() {
		String input = view.getInput();
		/** Save input to inputTokens */
		inputTokens = new ArrayList<String>(Arrays.asList(input.split(" ")));
		/** Stem input */
		inputTokens = stemmer.getStems(inputTokens);
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
