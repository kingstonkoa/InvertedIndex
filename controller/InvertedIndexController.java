package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Document;

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
        private ArrayList<Document> detailedDocumentList;
        private TagalogStemmer stemmer;

        public InvertedIndexController(IInvertedIndexView view) {
                this.view = view;
                inputTokens = new ArrayList<>();
                documentData = new ArrayList<>();
                tempArrayList = new ArrayList<>();
                detailedDocumentList = new ArrayList<>();
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
        inputTokens = new ArrayList<String>();
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
        String combinedInput = "";
        /** add more to hashmap oyeh!! */
        for(int i = 0; i < inputTokens.size(); i++)
        {
        	combinedInput+= inputTokens.get(i) + " ";
        }
        combinedInput = combinedInput.trim();
        for(int j = 0; j < documentData.size(); j++)
        {
            if(documentData.get(j).toLowerCase().contains(combinedInput.toLowerCase()))
                tempArrayList.add(j+1);
        }
        invertedIndex.put(combinedInput, tempArrayList);
        tempArrayList = new ArrayList<>();
        
        boolean found = true;
        /** add more to hashmap hiwahiwalay!!! */
        for(int i = 0; i < documentData.size(); i++)
        {
        	for(String inputString: inputTokens) {
        		if(!(documentData.get(i).toLowerCase().contains(inputString.toLowerCase()))) {
        			found = false;
        			break;
        		}
        		else found = true;
        	}
        	if(found==true){
        		tempArrayList.add(i+1);
        	}
        }
        invertedIndex.put(combinedInput+" HIWAHIWALAY", tempArrayList);
        tempArrayList = new ArrayList<>();
        
        
        /** STEP 6 generate output */
        CSVOutputGenerator outputBuilder = new CSVOutputGenerator();
        OutputGenerator outputGenerator = new OutputGenerator(outputBuilder);
        outputGenerator.generateOutput(invertedIndex, "boolean results.csv");
        }
        
        public void constructInvertedIndex1(){
        /*STEP 1: tokenize and stem input**/
        /*STEP 2: place all data on ArrayList<Document> w/ score for each document is 0**/
        /*STEP 3: transverse through tokens and count the term frequency and update the score for each document**/
        /*STEP 4: arrange document by score**/
        /*STEP 5: place on csv file with name "ranked search activity 1.csv"**/   
            String input = view.getInput();
            /*1**/
            inputTokens = new ArrayList<String>();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreElements()) {
                    inputTokens.add((String) st.nextElement());
        }
            /** stem inputs */
            inputTokens = stemmer.getStems(inputTokens);
            invertedIndex = new HashMap<String, ArrayList<Integer>>();
        
            /*2**/
            for(int i = 0; i < documentData.size(); i++)
            {
            Document tempDocument = new Document(i+1, documentData.get(i), 0.00);
            detailedDocumentList.add(tempDocument);
            }
            /*3**/
            for(int i = 0; i < inputTokens.size(); i++)
            {
                for(int j = 0; j < detailedDocumentList.size(); j++ )
                {
               String str = detailedDocumentList.get(j).getContent().toLowerCase();
                Pattern p = Pattern.compile(inputTokens.get(i).toLowerCase());
                Matcher m = p.matcher(str);
                int frequency = 0;
                while (m.find()){
                    frequency += 1;
                }
               
                if(frequency == 0)
                    detailedDocumentList.get(j).setScore(detailedDocumentList.get(j).getScore()+(0.0)); //formula 1+ log(tf)
                else
                    detailedDocumentList.get(j).setScore(detailedDocumentList.get(j).getScore()+(1+Math.log10(frequency)));
                
                }
                
            }
            /*print score**/
               for(int j = 0; j < detailedDocumentList.size(); j++ )
                {
               System.out.println(j+1 +" Score = "+detailedDocumentList.get(j).getScore());
                
                }
            /*4**/
            Collections.sort(detailedDocumentList);
            Collections.reverse(detailedDocumentList);
            for(int i = 0; i< detailedDocumentList.size(); i++)
            {
            if(detailedDocumentList.get(i).getScore() == Double.valueOf(0))
                detailedDocumentList.remove(i);
                else
                {
                    tempArrayList.add(detailedDocumentList.get(i).getId());
                }
            }
            invertedIndex.put(input, tempArrayList);
            tempArrayList = new ArrayList<>();
            /*5**/
            CSVOutputGenerator outputBuilder = new CSVOutputGenerator();
            OutputGenerator outputGenerator = new OutputGenerator(outputBuilder);
            outputGenerator.generateOutput(invertedIndex, "ranked search activity 1.csv");
            }
        
        public void constructInvertedIndex2(){
            String input = view.getInput();
            /*1**/
            inputTokens = new ArrayList<String>();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreElements()) {
                    inputTokens.add((String) st.nextElement());
        }
            /** stem inputs */
            inputTokens = stemmer.getStems(inputTokens);
            invertedIndex = new HashMap<String, ArrayList<Integer>>();
        
            /*2**/
            for(int i = 0; i < documentData.size(); i++)
            {
            Document tempDocument = new Document(i+1, documentData.get(i), 0.00);
            detailedDocumentList.add(tempDocument);
            }
            /*3**/
            for(int i = 0; i < inputTokens.size(); i++)
            {
                int df = getDocumentFrequency(inputTokens.get(i));
                for(int j = 0; j < detailedDocumentList.size(); j++ )
                {
               String str = detailedDocumentList.get(j).getContent().toLowerCase();
                Pattern p = Pattern.compile(inputTokens.get(i).toLowerCase());
                Matcher m = p.matcher(str);
                int frequency = 0;
                while (m.find()){
                    frequency += 1;
                }
               
                if(frequency == 0)
                    detailedDocumentList.get(j).setScore(detailedDocumentList.get(j).getScore()+(0.0*(Math.log10(303/df)))); // formula 1+log(tf)* log(N/df)
                else
                    detailedDocumentList.get(j).setScore(detailedDocumentList.get(j).getScore()+(1+Math.log10(frequency)*(Math.log10(303/df))));
                
                }
                
            }
            /*print score**/
               for(int j = 0; j < detailedDocumentList.size(); j++ )
                {
               System.out.println(j+1 +" Score = "+detailedDocumentList.get(j).getScore());
                
                }
            /*4**/
            Collections.sort(detailedDocumentList);
            Collections.reverse(detailedDocumentList);
            for(int i = 0; i< detailedDocumentList.size(); i++)
            {
            if(detailedDocumentList.get(i).getScore() == Double.valueOf(0))
                detailedDocumentList.remove(i);
                else
                {
                    tempArrayList.add(detailedDocumentList.get(i).getId());
                }
            }
            invertedIndex.put(input, tempArrayList);
            tempArrayList = new ArrayList<>();
            /*5**/
            CSVOutputGenerator outputBuilder = new CSVOutputGenerator();
            OutputGenerator outputGenerator = new OutputGenerator(outputBuilder);
            outputGenerator.generateOutput(invertedIndex, "ranked search activity 2.csv");
        
        }

        public void ReadTxtFiles()
        {
            TxtReader txtReader = new TxtReader();
            documentData = txtReader.getDocumentsList();
        }

    private int getDocumentFrequency(String token)
    {
        int df = 0;
            for(int j = 0; j < documentData.size(); j++)
            {
	            if(documentData.get(j).toLowerCase().contains(token.toLowerCase()))
                        df += 1;
	                
            }
           return df;
        
    }


}
