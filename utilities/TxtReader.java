
package utilities;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Kingston
 */
public class TxtReader
{
    private int numOfDocuments = 303;
    StringBuilder stringBuilder = new StringBuilder();
    ArrayList<String> documentsAL = new ArrayList<>();
    
    public TxtReader() {
    	for(int i = 0; i < numOfDocuments; i++) {
			try{
			  FileInputStream fstream = new FileInputStream("src/resources/Tagalog News - "+(i+1)+".txt");
			
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
	
			  while ((strLine = br.readLine()) != null){
			      stringBuilder.append(strLine);
			  }
			  //Close the input stream
			  in.close();
			  String finalString = stringBuilder.toString();
			  documentsAL.add(finalString);
			
			  //System.out.println(finalString);
			  }catch (Exception e){//Catch exception if any
			    System.err.println("Error: " + e.getMessage());
			  }
    	}
    }
    

    public ArrayList<String> getDocumentsList()
    {
    	return documentsAL;
    }
}
