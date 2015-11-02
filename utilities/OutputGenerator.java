package utilities;

import java.util.ArrayList;
import java.util.HashMap;

public class OutputGenerator {
	
	OutputBuilder builder;
	
	public OutputGenerator ( OutputBuilder builder ) {
		this.builder = builder;
	}
	
	public void generateOutput( HashMap<String, ArrayList<Integer>> result ) {
		builder.parseOutput(result);
		builder.generateOutput();
	}

}
