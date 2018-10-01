package com.example.ner_tagging_example;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;

import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.pipeline.StanfordCoreNLPClient;
import edu.stanford.nlp.util.CoreMap;

/**
 * Hello world!
 *
 */
public class Ner_example 
{
    public static void main( String[] args )
    {
    	BasicConfigurator.configure();

    	Properties props = new Properties();
    	props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner");
    	StanfordCoreNLPClient pipeline = new StanfordCoreNLPClient(props, "http://localhost", 9000, 2);
    	// read some text in the text variable
    	String text = "Si la fecha es mayor que 16/04/2019 entonces el descuento será del 15%";
    	// create an empty Annotation just with the given text
    	Annotation document = new Annotation(text);
    	// run all Annotators on this text
    	pipeline.annotate(document);
    	//StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    	
    	//Annotation document = new Annotation("Si la fecha es mayor que 16/04/2018 entonces el descuento será del 15%");
        //pipeline.annotate(document);
    
        List<CoreMap> sentences = document.get(SentencesAnnotation.class);
     
        for(CoreMap sentence: sentences) {
            for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
                String word = token.get(TextAnnotation.class);
                String pos = token.get(PartOfSpeechAnnotation.class);
                String ne = token.get(NamedEntityTagAnnotation.class);
     
                //if(ne.equals("LOC"))
                System.out.println("Palabra: " + word + " pos: " + pos + " ner:" + ne);
            }
        }
    }
    
}
