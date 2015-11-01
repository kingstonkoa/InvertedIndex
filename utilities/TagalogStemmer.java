package utilities;

import java.util.ArrayList;

import model.StemmerWordDirectory;

public class TagalogStemmer {
	
	private ArrayList<String> tokens;
	private StemmerWordDirectory directory;
	
	public ArrayList<String> getStems(ArrayList<String> tokens) {
		
		ArrayList<String> result = new ArrayList<String>();
		
		for(String token: tokens){ 
			
			if(checkIfStopWord(token)) {
				
			}
//			else if ()
				
			
		}
		return result;
		
	}

	private boolean checkIfStopWord(String token) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
