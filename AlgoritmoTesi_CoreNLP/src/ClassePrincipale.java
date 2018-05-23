import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
    
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;

public class ClassePrincipale {
	
	public static int rimozioneTerminiIninfluenti(Map<String, Integer> raccoltaScoreNomi){
		
		System.out.println("\n" + raccoltaScoreNomi + "\n");
		
		Set<String> keySet = raccoltaScoreNomi.keySet();
		
		ArrayList<String> nomiIninfluenti = new ArrayList<String>();
		nomiIninfluenti.add("film");
		nomiIninfluenti.add("films");
		nomiIninfluenti.add("movie");
		nomiIninfluenti.add("movies");
		nomiIninfluenti.add("time");
		nomiIninfluenti.add("times");
		nomiIninfluenti.add("s");
		nomiIninfluenti.add("children");
		nomiIninfluenti.add("version");
		nomiIninfluenti.add("family");
		nomiIninfluenti.add("adults");
		nomiIninfluenti.add("man");
		
		ArrayList<String> nomiDaEliminare = new ArrayList<String>();
		
		int numeroRecensioni = 0;
		
		//vado a predenre il numero delle recensioni che avevo messo nel map
		for(String key:keySet){
				
				if(key.equals("numeroRec")){
					numeroRecensioni = raccoltaScoreNomi.get(key);
				}

		}
		nomiDaEliminare.add("numeroRec");
		//System.out.println(numeroRecensioni);
		//fine 
		
		for(String key:keySet){
			
			for(String nomeIninfluente:nomiIninfluenti){
				
				if(key.equals(nomeIninfluente)){
					nomiDaEliminare.add(key);
				}
			}
			//elimina le parole che iniziano con una lettera maiuscola, per eliminare nomi propri di attori o altri film
			if(Character.isUpperCase(key.charAt(0))){
				nomiDaEliminare.add(key);
			}
		}
		
		for(String nomeDaEliminare:nomiDaEliminare){
			
				raccoltaScoreNomi.remove(nomeDaEliminare);
		}
		
		return numeroRecensioni;
	}
	
	public static ArrayList<String> ordinamento(Map<String, Integer> raccoltaScoreNomi, int numeroRecensioni) {
		
		Set<String> keySet = raccoltaScoreNomi.keySet();
		ArrayList<String> nomiMigliori = new ArrayList<String>();
		String nomeMigliore = null;
		int massimo;
		
		int massimoSoglia = 0;
		
		System.out.println("\n" + raccoltaScoreNomi + "\n");
		
		
		Map<String, Integer> nomiPreferibili = new HashMap<String, Integer>();
		nomiPreferibili.put("oscar", (numeroRecensioni / 3));
		nomiPreferibili.put("oscars", (numeroRecensioni / 3));
		nomiPreferibili.put("award", (numeroRecensioni / 3));
		nomiPreferibili.put("awards", (numeroRecensioni / 3));
		nomiPreferibili.put("photography", (numeroRecensioni / 3));
		nomiPreferibili.put("dialogue", (numeroRecensioni / 3));
		nomiPreferibili.put("dialogues", (numeroRecensioni / 3));
		nomiPreferibili.put("scene", (numeroRecensioni / 7));
		nomiPreferibili.put("scenes", (numeroRecensioni / 5));
		nomiPreferibili.put("character", (numeroRecensioni / 4));
		nomiPreferibili.put("characters", (numeroRecensioni / 5));
		nomiPreferibili.put("actor", (numeroRecensioni / 4));
		nomiPreferibili.put("actors", (numeroRecensioni / 5));
		nomiPreferibili.put("sequence", (numeroRecensioni / 4));
		nomiPreferibili.put("sequences", (numeroRecensioni / 4));
		nomiPreferibili.put("interpretation", (numeroRecensioni / 4));
		nomiPreferibili.put("plot", (numeroRecensioni / 4));
		nomiPreferibili.put("director", (numeroRecensioni / 4));
		nomiPreferibili.put("soundtrack", (numeroRecensioni / 4));
		nomiPreferibili.put("sound", (numeroRecensioni / 4));
		nomiPreferibili.put("performance", (numeroRecensioni / 4));
		nomiPreferibili.put("story", (numeroRecensioni / 9));
		nomiPreferibili.put("end", (numeroRecensioni / 5));
		nomiPreferibili.put("effects", (numeroRecensioni / 5));
		nomiPreferibili.put("montage", (numeroRecensioni / 5));
		nomiPreferibili.put("editing", (numeroRecensioni / 5));
		
		Set<String> keySet1 = nomiPreferibili.keySet();
		
		for(String key:keySet){
		
			for(String key1:keySet1){
			
				if(key.equals(key1)){
					raccoltaScoreNomi.put(key, raccoltaScoreNomi.get(key) + nomiPreferibili.get(key1));
				}
			}		
		}
		
		System.out.println("\n" + raccoltaScoreNomi + "\n");
		
		
		for(int i=0; i<4; i++){
			
			massimo = 0;
				
			for(String key:keySet){
				
				if(massimo == 0){
					massimo = raccoltaScoreNomi.get(key);
					nomeMigliore = key;
					//System.out.println("Il massimo è " + massimo + " .\n\n");
				}
				else{
					if(raccoltaScoreNomi.get(key) > massimo){
						massimo = raccoltaScoreNomi.get(key);
						nomeMigliore = key;
						//System.out.println("Il massimo è " + massimo + " .\n\n");
					}
					
				}
			}
			
			massimoSoglia = massimo;
		
			nomiMigliori.add(nomeMigliore);
			raccoltaScoreNomi.remove(nomeMigliore);
		}
		
		
		System.out.println(nomiMigliori + "\n");
		
		
		return nomiMigliori;
	
	}
	
	
	public static void costruzioneSpiegazione(ArrayList<String> nomiMigliori) {
		
		Random random = new Random();
		
		int sentinella = 0;
		int controllo = 0;
		
		String spiegazione = "I recommend you " + "Reservoir Dogs " + "because some people who have seen it, said that ";
		
		ArrayList<String> frasiOscar = new ArrayList<String>(Arrays.asList("this film won an Oscar"));
		ArrayList<String> frasiOscars = new ArrayList<String>(Arrays.asList("this film won some Oscars"));
		ArrayList<String> frasiAward = new ArrayList<String>(Arrays.asList("this film won an award"));
		ArrayList<String> frasiAwards = new ArrayList<String>(Arrays.asList("this film won some awards"));
		ArrayList<String> frasiScene = new ArrayList<String>(Arrays.asList("opening scene is great", "has a spectacular scene"));
		ArrayList<String> frasiScenes = new ArrayList<String>(Arrays.asList("is able to capture the public's attention with simple scenes", "has scenes to watch over and over again"));
		ArrayList<String> frasiCharacter = new ArrayList<String>(Arrays.asList("main character is great", "main character is well defined"));
		ArrayList<String> frasiCharacters = new ArrayList<String>(Arrays.asList("main characters are fantastic", "characters are well defined", "characters have interesting stories"));
		ArrayList<String> frasiActor = new ArrayList<String>(Arrays.asList("main actor is fantastic", "main actor make feel emotions"));
		ArrayList<String> frasiActors = new ArrayList<String>(Arrays.asList("actors are great in their roles", "many actors act very well", "actors make feel emotions"));
		ArrayList<String> frasiDialogue = new ArrayList<String>(Arrays.asList("dialogue is intelligent", "dialogue is simple and clear"));
		ArrayList<String> frasiDialogues = new ArrayList<String>(Arrays.asList("dialogues are intelligent", "dialogues are simple and clear", "dialogues remain in the mind"));
		ArrayList<String> frasiSequence = new ArrayList<String>(Arrays.asList("opening sequence is great"));
		ArrayList<String> frasiSequences = new ArrayList<String>(Arrays.asList("some sequences are amazing", "sequences are simple and direct"));
		ArrayList<String> frasiPhotography = new ArrayList<String>(Arrays.asList("photography is spectacular, the impact of images is amazing", "photography is well done, framing and lights are perfect", "photography is well done, focus, color and depth of field are impressive "));
		ArrayList<String> frasiEnd = new ArrayList<String>(Arrays.asList("end is really unexpected", "whole ending was just amazing", "end is one of the best parts of the film"));
		ArrayList<String> frasiEffects = new ArrayList<String>(Arrays.asList("special effects increase attention", "special effects increase suspense"));
		ArrayList<String> frasiEditing = new ArrayList<String>(Arrays.asList("editing is just perfection", "editing is really well done", "editing helps to have a simple and clear narration"));		
		
		ArrayList<String> frasiPlotOrStory = new ArrayList<String>(Arrays.asList("plot is complicated, but easy to follow", "plot is great", "whole plot is very well laid out", "plot twists are exciting and unexpected"));
		ArrayList<String> frasiDirectorOrMontage = new ArrayList<String>(Arrays.asList("thanks to the director, content of the shots is sensational", "director defines expressive and narrative methods very well"));
		ArrayList<String> frasiSoundtrackOrSound = new ArrayList<String>(Arrays.asList("soundtrack is beautiful", "soundtrack gives a sense of reality to the scenes", "soundtrack emphasizes the great moments"));
		ArrayList<String> frasiInterpretationOrPerformance = new ArrayList<String>(Arrays.asList("interpretation and performance are superb in this film"));
		
		
		//crea la spiegazione
		for(String nomeMigliore:nomiMigliori){
			
			if(nomeMigliore.equals("oscar")){
				spiegazione = spiegazione + frasiOscar.get(random.nextInt(frasiOscar.size()));
			}
			if(nomeMigliore.equals("oscars")){
				spiegazione = spiegazione + frasiOscars.get(random.nextInt(frasiOscars.size()));
			}
			if(nomeMigliore.equals("award")){
				spiegazione = spiegazione + frasiAward.get(random.nextInt(frasiAward.size()));
			}
			if(nomeMigliore.equals("awards")){
				spiegazione = spiegazione + frasiAwards.get(random.nextInt(frasiAwards.size()));
			}
			if(nomeMigliore.equals("scene")){
				spiegazione = spiegazione + frasiScene.get(random.nextInt(frasiScene.size()));
			}
			if(nomeMigliore.equals("scenes")){
				spiegazione = spiegazione + frasiScenes.get(random.nextInt(frasiScenes.size()));
			}
			if(nomeMigliore.equals("character")){
				spiegazione = spiegazione + frasiCharacter.get(random.nextInt(frasiCharacter.size()));
			}
			if(nomeMigliore.equals("characters")){
				spiegazione = spiegazione + frasiCharacters.get(random.nextInt(frasiCharacters.size()));
			}
			if(nomeMigliore.equals("actor")){
				spiegazione = spiegazione + frasiActor.get(random.nextInt(frasiActor.size()));
			}
			if(nomeMigliore.equals("actors")){
				spiegazione = spiegazione + frasiActors.get(random.nextInt(frasiActors.size()));
			}
			if(nomeMigliore.equals("dialogue")){
				spiegazione = spiegazione + frasiDialogue.get(random.nextInt(frasiDialogue.size()));
			}
			if(nomeMigliore.equals("dialogues")){
				spiegazione = spiegazione + frasiDialogues.get(random.nextInt(frasiDialogues.size()));
			}
			if(nomeMigliore.equals("sequence")){
				spiegazione = spiegazione + frasiSequence.get(random.nextInt(frasiSequence.size()));
			}
			if(nomeMigliore.equals("sequences")){
				spiegazione = spiegazione + frasiSequences.get(random.nextInt(frasiSequences.size()));
			}
			if(nomeMigliore.equals("photography")){
				spiegazione = spiegazione + frasiPhotography.get(random.nextInt(frasiPhotography.size()));
			}
			if(nomeMigliore.equals("end")){
				spiegazione = spiegazione + frasiEnd.get(random.nextInt(frasiEnd.size()));
			}
			if(nomeMigliore.equals("effects")){
				spiegazione = spiegazione + frasiEffects.get(random.nextInt(frasiEffects.size()));
			}
			if(nomeMigliore.equals("editing")){
				spiegazione = spiegazione + frasiEditing.get(random.nextInt(frasiEditing.size()));
			}
			if((nomeMigliore.equals("plot") || nomeMigliore.equals("story")) && sentinella == 0){
				spiegazione = spiegazione + frasiPlotOrStory.get(random.nextInt(frasiPlotOrStory.size()));
				sentinella++;
			}
			if(nomeMigliore.equals("director") || nomeMigliore.equals("montage")){
				spiegazione = spiegazione + frasiDirectorOrMontage.get(random.nextInt(frasiDirectorOrMontage.size()));
			}
			if(nomeMigliore.equals("soundtrack") || nomeMigliore.equals("sound")){
				spiegazione = spiegazione + frasiSoundtrackOrSound.get(random.nextInt(frasiSoundtrackOrSound.size()));
			}
			if(nomeMigliore.equals("interpretation") || nomeMigliore.equals("performance")){
				spiegazione = spiegazione + frasiInterpretationOrPerformance.get(random.nextInt(frasiInterpretationOrPerformance.size()));
			}
			
			controllo++;
			
			if(controllo == 1){
				spiegazione = spiegazione + "\nand ";
			}
			if(controllo == 2){
				spiegazione = spiegazione + "; moreover other people have said that ";
			}
			if(controllo == 3){
				spiegazione = spiegazione + " and\n";
			}
		}
		spiegazione = spiegazione + ".";
		System.out.println(spiegazione);
		
	}
	
	

	public static Map<String, Integer> estrazioneSentimentNomi(int idFilmNumerico){
		
		
		ArrayList<String> recensioni = new ArrayList();
		String tokenRec = null;
		String idFilm;
		Map<String, Integer> raccoltaScoreNomi = new HashMap<String, Integer>();
		
		//ArrayList<String> nomiMigliori;
		
		
        // creates a StanfordCoreNLP object
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, pos, parse, sentiment");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		
		
		//inizio codice per estrazione da file delle sole recensioni
		try{
				idFilm = "I:" + Integer.toString(idFilmNumerico);
			
				BufferedReader reader = new BufferedReader(new FileReader("provaRecensioni.txt"));
				String line = reader.readLine();
        
				while(line!=null){	        		
					StringTokenizer st = new StringTokenizer(line, "\t");
        		
					//controlla che il primo token, cioè l'id del film, sia quello cercato
					if(st.nextToken().equals(idFilm)){
        		
        					while(st.hasMoreTokens()){
        						tokenRec = st.nextToken();
        					}
        					recensioni.add(tokenRec);
					}
					line = reader.readLine();
				}
				System.out.println("\n\nReview of this film " + recensioni.size());          	
		}catch(Exception e){};
		//fine
		
		int numeroRecensioni;
		//numeroRecensioni = recensioni.size();
		numeroRecensioni = 20;
		
		//il ciclo for deve essere fatto su tutta la dimensione delle recensioni, cioè x<recensioni.size()
		for(int x=0; x<numeroRecensioni; x++){	
			
			// read some text in the text variable
			System.out.println("\n\nREVIEW NUMBER " + (x+1) + "\n");
			String text = recensioni.get(x);
		
			// create an empty Annotation just with the given text
			Annotation document = new Annotation(text);
		
			// run all Annotators on this text
			pipeline.annotate(document);
		
			// these are all the sentences in this document
			// a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
			List<CoreMap> sentences = document.get(SentencesAnnotation.class);

			int sc = 1;
			for (CoreMap sentence : sentences) {
				
				
				//inizio prova
				//System.out.println("\nSentiment of sentence\n");
				String sentimentRecensione = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
				//System.out.println(mamma + "\n\n");
				//fine prova
				
				System.out.println("===== Sentence " + sc + " ===== Sentiment = " + sentimentRecensione + " =====");
				
				if(sentimentRecensione.equals("Positive") || sentimentRecensione.equals("Very positive")){
				
			
				// traversing the words in the current sentence
				// a CoreLabel is a CoreMap with additional token-specific methods
					   int tc = 1;
				   
					   for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
						   
							// this is the text of the token
						    String word = token.get(TextAnnotation.class);
							// this is the POS tag of the token
							String pos = token.get(PartOfSpeechAnnotation.class);
							// this is the NER label of the token
							//String ne = token.get(NamedEntityTagAnnotation.class);
							
							
							//inizio prova hashmap
							if(pos.equals("NN") || pos.equals("NNS")){
								
								if(sentimentRecensione.equals("Positive")){
	
									if(raccoltaScoreNomi.containsKey(word)){
										raccoltaScoreNomi.put(word, raccoltaScoreNomi.get(word)+1);
									}
									else{
										raccoltaScoreNomi.put(word, 1);
									}
								}
								
								if(sentimentRecensione.equals("Very positive")){
									
									if(raccoltaScoreNomi.containsKey(word)){
										raccoltaScoreNomi.put(word, raccoltaScoreNomi.get(word)+2);
									}
									else{
										raccoltaScoreNomi.put(word, 2);
									}
								}
								
								
							}
							//fine prova hashmap
							
							
							//System.out.println(tc + "\t" + word + "\t" + pos + "\t" + ne);
							System.out.println(tc + "\t\t" + word + "\t\t" + pos);
							tc++;
					   }
				}
		   
			   // inizio escluso per ora
		   
			   // this is the parse tree of the current sentence
			   //System.out.println("Parsed tree\n");
			   //Tree tree = sentence.get(TreeAnnotation.class);
			   //System.out.println(tree.toString());
			   
			   //props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, sentiment");
			   
			   //fine escluso per ora
		   
		   
			   //inizio prova
			   //System.out.println("\nSentiment of sentence\n");
			   //String mamma = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
			   //System.out.println(mamma + "\n\n");
			   //fine prova
		   
			   sc++;
			}

		}
		
		//rimozioneTerminiIninfluenti(raccoltaScoreNomi);
		//nomiMigliori = ordinamento(raccoltaScoreNomi);
		//costruzioneSpiegazione(nomiMigliori);
		
		raccoltaScoreNomi.put("numeroRec", numeroRecensioni);
		
		return raccoltaScoreNomi;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> raccoltaScoreNomi = new HashMap<String, Integer>();
		ArrayList<String> nomiMigliori;
		int numeroRecensioni;
		int idFilmNumerico = 8652;
		
		
		raccoltaScoreNomi = estrazioneSentimentNomi(idFilmNumerico);
		numeroRecensioni = rimozioneTerminiIninfluenti(raccoltaScoreNomi);
		nomiMigliori = ordinamento(raccoltaScoreNomi, numeroRecensioni);
		costruzioneSpiegazione(nomiMigliori);
	}

}
