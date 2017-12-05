package classes;

/**
 * 
 * @author Vincenzo Plantone 639371
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Class FileReader used to analyze Messages.
 */
public class FileClass {

	private Map<String, Integer> stringheSospette;

	/**
	 * Class constructor.
	 */
	public FileClass() {
		stringheSospette = new HashMap<>();
		stringheSospette.put("bomba", 8);
		stringheSospette.put("dos", 6);
		stringheSospette.put("uccidere", 10);
		stringheSospette.put("CIA", 9);
		stringheSospette.put("FBI", 9);
		stringheSospette.put("attacco", 5);
		stringheSospette.put("isis", 7);
	}

	/**
	 * This method detects suspicius strings.
	 * 
	 * @param m
	 * @return Rapporto
	 * @throws FileNotFoundException
	 */
	public Rapporto analisi(File m) throws FileNotFoundException {
		Rapporto rapporto = new Rapporto();
		int occorrenze = 0;
		int punteggioTot = 0;
		int lunghezza = 0;
		int righe = 1;
		Scanner in = null;
		in = new Scanner(m);
		boolean bool = in.hasNextLine();
		while (bool) {
			righe++;
			String stringa = in.nextLine();
			lunghezza += stringa.length();
			for (String s : stringheSospette.keySet()) {
				if (stringa.contains(s)) {
					++occorrenze;
					punteggioTot += stringheSospette.get(s).intValue();
					System.out.println("\n-Stringa sospetta trovata: " + s);
					System.out.println("-Riga in cui si trova: ");
					System.out.println(stringa);
				}
			}
		}
		rapporto.setLunghezza(lunghezza);
		rapporto.setNumStringhe(occorrenze);
		rapporto.setPunteggioTot(punteggioTot);
		rapporto.setPunteggioMedio(punteggioTot / righe);
		in.close();
		return rapporto;
	}

	/**
	 * Overrided toString() method.
	 */
	@Override
	public String toString() {
		return "FileReader [stringheSospette=" + stringheSospette + "]";
	}

}
