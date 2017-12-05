package main;

/**
 * 
 * @author Vincenzo Plantone 639371
 * 
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import classes.FileReader;
import classes.Rapporto;

/**
 * Main class for tests.
 * 
 */
public class TestMain {

	/**
	 * Static main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		File[] messaggi = new File[7];
		for (int i = 0; i < messaggi.length; i++) {
			messaggi[i] = new File("m" + i + ".txt");
		}
		FileReader fr = new FileReader();
		FileWriter fw = null;
		Rapporto rapporto;

		try {
			for (File m : messaggi) {
				fw = new FileWriter("rapporto.txt", true);
				System.out.println("________________________________________________________________________________________________");
				System.out.println("\nMessaggio: " + m);
				rapporto = fr.analisi(m);
				System.out.println(rapporto.toString());
				fw.write("\nMessaggio: " + m);
				fw.write(rapporto.toString());
			}
		} catch (IOException e) {
			System.out.println("IOExcpetion()");
		} finally {
			fw.close();
		}

	}

}
