package utilities;

import java.util.ArrayList;
import java.util.HashMap;

public class OutputGenerator {
	
	OutputBuilder builder;
	
	public OutputGenerator ( OutputBuilder builder ) {
		this.builder = builder;
	}
	
	public void generateOutput( HashMap<String, ArrayList<String>> result ) {
		builder.parseOutput(result);
		builder.generateOutput();
	}
}
