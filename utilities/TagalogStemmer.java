package utilities;

import java.util.ArrayList;

import model.StemmerWordDirectory;

public class TagalogStemmer {
	
	private ArrayList<String> tokens;
	private StemmerWordDirectory directory;
	
	public TagalogStemmer() {
		directory = new StemmerWordDirectory();
		tokens = new ArrayList<String>();
	}
	
	public ArrayList<String> getStems(ArrayList<String> tokens) {
		
		ArrayList<String> result = new ArrayList<String>();
		
		for(String token: tokens){ 
			
			if(checkIfStopWord(token)) {
				// does not add to result
			}
			else {
				/** stem word */
				result.add(simpleStem(token));
			}
				
			
		}
		return result;
		
	}

	private String simpleStem(String token) {
		token = token.replaceAll("mag", "");
		return token;
	}

	private boolean checkIfStopWord(String token) {
		for(String stopWord : directory.getStopWords()) {
			if(token.equalsIgnoreCase(stopWord))
				return true;
		}
		return false;
	}
	
}
