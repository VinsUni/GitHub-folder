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
		int cinque = 5;
		int sei = 6;
		int sette = 7;
		int otto = 8; 
		int nove = 9;
		int dieci = 10;
		stringheSospette.put("bomba", otto);
		stringheSospette.put("dos", sei);
		stringheSospette.put("uccidere", dieci);
		stringheSospette.put("CIA", nove);
		stringheSospette.put("FBI", nove);
		stringheSospette.put("attacco", cinque);
		stringheSospette.put("isis", sette);
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
					System.out.print("\n-Stringa sospetta trovata: ");
					System.out.println(s);
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
