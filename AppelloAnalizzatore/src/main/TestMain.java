package main;

/**
 * 
 * @author Vincenzo Plantone 639371
 * 
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import classes.FileClass;
import classes.Rapporto;

/**
 * Main class for tests.
 * 
 */
public class TestMain {

	private TestMain() {}
	
	/**
	 * Static main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		
		File[] messaggi = new File[7];
		for (int i = 0; i < messaggi.length; i++) {
			messaggi[i] = new File("m" + i + ".txt");
		}
		FileClass fr = new FileClass();
		FileWriter fw = null;
		PrintWriter pw = null;
		Rapporto rapporto = new Rapporto();

		try {
			for (File m : messaggi) {
				fw = new FileWriter("rapporto.txt", true);
				pw = new PrintWriter(fw);
				System.out.println(
						"________________________________________________________________________________________________");
				System.out.println("\nMessaggio: " + m);
				rapporto = fr.analisi(m);
				System.out.println(rapporto.toString());
				pw.write("\nMessaggio: " + m);
				pw.write(rapporto.toString());
			}
		} catch (IOException e) {
			System.out.println("IOExcpetion()");
		} finally {
			try {
				if (pw != null) {
					pw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				System.out.println("IOExcpetion()");
			} finally{
				System.out.println();
			}
		}

	}

}
