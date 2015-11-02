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
        private ArrayList<String> inputTokens;
        private ArrayList<String> documentData;
        private HashMap<String, ArrayList<Integer>> invertedIndex;
        private ArrayList<Integer> tempArrayList;
        private TagalogStemmer stemmer;

        public InvertedIndexController(IInvertedIndexView view) {
                this.view = view;
                inputTokens = new ArrayList<>();
                documentData = new ArrayList<>();
                tempArrayList = new ArrayList<>();
                invertedIndex = new HashMap<String, ArrayList<Integer>>();
                stemmer = new TagalogStemmer();
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
        /** stem inputs */
        inputTokens = stemmer.getStems(inputTokens);
        
        invertedIndex = new HashMap<String, ArrayList<Integer>>();
        /** add result to hashmap */
        for(int i = 0; i < inputTokens.size(); i++)
        {
            for(int j = 0; j < documentData.size(); j++)
            {
            if(documentData.get(j).toLowerCase().contains(inputTokens.get(i).toLowerCase()))
                tempArrayList.add(j+1);
            }
            invertedIndex.put(inputTokens.get(i), tempArrayList);
            tempArrayList = new ArrayList<>();
        }

        /** STEP 6 generate output */
        CSVOutputGenerator outputBuilder = new CSVOutputGenerator();
        OutputGenerator outputGenerator = new OutputGenerator(outputBuilder);
        outputGenerator.generateOutput(invertedIndex);
        }

        public void ReadTxtFiles()
        {
            TxtReader txtReader = new TxtReader();
            documentData = txtReader.getDocumentsList();
        }


}
