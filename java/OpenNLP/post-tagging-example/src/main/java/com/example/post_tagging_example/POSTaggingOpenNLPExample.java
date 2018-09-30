package com.example.post_tagging_example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.SimpleTokenizer;


/**
 * Hello world!
 *
 */
public class POSTaggingOpenNLPExample 
{
    public static void main( String[] args )
    {
    	String sentence = "El zorro marrón rápido salta sobre perro perezoso";
		try {
			// TOKENIZE SENTENCE. Note: It's better to train your own model or use an existing model to tokenize. 
	    	SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;   
	    	String tokens[] = tokenizer.tokenize(sentence); 

	    	// POS TAGGING
			System.out.println("Maxent");
	    	InputStream iPos1 = POSTaggingOpenNLPExample.class.getClassLoader().getResource("opennlp-es-pos-maxent-pos-es.model").openStream();
	    	
	    	POSModel posModel = new POSModel(iPos1);
	    	POSTaggerME posTagger = new POSTaggerME(posModel);

	    	String tags[] = posTagger.tag(tokens);
	    	
	    	for(int i=0;i<tokens.length;i++){
                System.out.println(tokens[i]+ "/" +tags[i]);
            }
	    	
	    	// Maxent universal
	    	System.out.println("Maxent universal");
	    	InputStream iPos2 = POSTaggingOpenNLPExample.class.getClassLoader().getResource("opennlp-es-pos-maxent-pos-universal.model").openStream();
	    	
	    	posModel = new POSModel(iPos2);
	    	posTagger = new POSTaggerME(posModel);

	    	String tags2[] = posTagger.tag(tokens);
	    	
	    	for(int i=0;i<tokens.length;i++){
                System.out.println(tokens[i]+ "/" +tags2[i]);
            }
	    	
	    	// Perceptron
	    	System.out.println("Perceptron");
	    	InputStream iPos3 = POSTaggingOpenNLPExample.class.getClassLoader().getResource("opennlp-es-pos-perceptron-pos-es.model").openStream();
	    	
	    	posModel = new POSModel(iPos3);
	    	posTagger = new POSTaggerME(posModel);

	    	String tags3[] = posTagger.tag(tokens);
	    	
	    	for(int i=0;i<tokens.length;i++){
                System.out.println(tokens[i]+ "/" +tags3[i]);
            }
	    	
	    	// Perceptron universal
	    	
	    	System.out.println("Perceptron universal");
	    	InputStream iPos4 = POSTaggingOpenNLPExample.class.getClassLoader().getResource("opennlp-es-pos-perceptron-pos-universal.model").openStream();
	    	
	    	posModel = new POSModel(iPos4);
	    	posTagger = new POSTaggerME(posModel);

	    	String tags4[] = posTagger.tag(tokens);
	    	
	    	for(int i=0;i<tokens.length;i++){
                System.out.println(tokens[i]+ "/" +tags4[i]);
            }
	    	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    }
}
