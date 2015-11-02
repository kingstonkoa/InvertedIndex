package utilities;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class OutputBuilder {

	abstract void generateOutput();
	abstract void parseOutput(HashMap<String, ArrayList<Integer>> result);

}
