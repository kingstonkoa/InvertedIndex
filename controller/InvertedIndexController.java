package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

import utilities.CSVOutputGenerator;
import utilities.OutputGenerator;
import utilities.TagalogStemmer;
import utilities.TxtReader;
import view.IInvertedIndexView;

public class InvertedIndexController {

        private IInvertedIndexView view;
        private ArrayList<String> inputTokens = new ArrayList<>();
        private ArrayList<String> documentData = new ArrayList<>();
        private HashMap<String, ArrayList<Integer>> invertedIndex = new HashMap<String, ArrayList<Integer>>();
        private ArrayList<Integer> tempArrayList = new ArrayList<>();
        private TagalogStemmer stemmer;

        public InvertedIndexController(IInvertedIndexView view) {
                this.view = view;
        }

        public void constructInvertedIndex() {
                /** STEP 1 tokenize db? */
                /** STEP 2 tokenize input */
                /** STEP 3 save to inputTokens */
                /** STEP 4 search db for substring */
                /** STEP 5 save to invertedIndex */
                String input = view.getInput();
                
                /** tokenize the input*/
		StringTokenizer st = new StringTokenizer(input);
		while (st.hasMoreElements()) {
			inputTokens.add((String) st.nextElement());
		}
                /**insert stemmer on inputTokens*/
                
                for(int i = 0; i < inputTokens.size(); i++)
                {
                    for(int j = 0; j < documentData.size(); j++)
                    {
                    if(documentData.get(i).toLowerCase().contains(inputTokens.get(i).toLowerCase()))
                        tempArrayList.add(i+1);
                    }
                    invertedIndex.put(inputTokens.get(i), tempArrayList);
                    
                }

                /** STEP 6 generate output */
                //CSVOutputGenerator outputBuilder = new CSVOutputGenerator();
                //OutputGenerator outputGenerator = new OutputGenerator(outputBuilder);
                //outputGenerator.generateOutput(invertedIndex);
        }

        public void ReadTxtFiles()
        {
            TxtReader txtReader = new TxtReader();
            documentData = txtReader.getDocumentsList();
        }


}
