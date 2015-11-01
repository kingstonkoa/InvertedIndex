package model;

import java.util.ArrayList;

public class StemmerWordDirectory {
	
	private ArrayList<String> stopWords;
	
	public StemmerWordDirectory() {
		initializeStopWords();
	}
		
	private void initializeStopWords() {
		
	}

	public ArrayList<String> getStopWords() {
		return stopWords;
	}

	public void setStopWords(ArrayList<String> stopWords) {
		this.stopWords = stopWords;
	}
}
