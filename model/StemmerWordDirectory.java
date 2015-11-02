package model;

import java.util.ArrayList;

import utilities.TxtReader;

public class StemmerWordDirectory {
	
	private ArrayList<String> stopWords;
	private TxtReader txtReader;
	
	public StemmerWordDirectory() {
		txtReader = new TxtReader();
		initializeStopWords();
	}
		
	private void initializeStopWords() {
		txtReader.readStopWords();
		stopWords = txtReader.getStopWordsList();
	}

	public ArrayList<String> getStopWords() {
		return stopWords;
	}

	public void setStopWords(ArrayList<String> stopWords) {
		this.stopWords = stopWords;
	}
}
