/**
 * 
 * @author Vincenzo Plantone - 639371
 *
 */

package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import collection.Album;
import collection.Traccia;
import exception.NegNumException;

/**
 * 
 * @class TestMain
 *
 */
public class TestMain {

	/**
	 * private default Class
	 */
	private TestMain() {
	}

	/**
	 * static random variable
	 */
	static Random rnd = new Random();

	/**
	 * 
	 * @return random string
	 */
	static String genRandString() {
		String alph = "qwertyuiopasdfghjklzxcvbnm";
		int len = rnd.nextInt(10);
		char[] seq = new char[len];
		for (int i = 0; i < seq.length; i++) {
			seq[i] = alph.charAt(rnd.nextInt(alph.length()));
		}
		return new String(seq);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		final int T = 100;

		Traccia[] tracce = new Traccia[T];
		String[] titoli = new String[T];
		String[] esecutori = new String[T];
		int[] durate = new int[T];

		for (int i = 0; i < T; i++) {
			titoli[i] = genRandString();
			esecutori[i] = genRandString();
			durate[i] = rnd.nextInt(T);
		}
		try {
			for (int i = 0; i < T; i++) {
				tracce[i] = new Traccia(titoli[rnd.nextInt(titoli.length)], esecutori[rnd.nextInt(esecutori.length)],
						durate[rnd.nextInt(durate.length)]);
			}
		} catch (NegNumException e) {
			System.out.println("Exception " + e);
		} finally {
			System.out.println();
		}

		final int A = 12;
		final int C = 5;
		
		Album[] albums = new Album[A];
		for(Album a: albums) {
			List<Traccia> coll = new ArrayList<>(C);
			for(int i = 0; i < C; i++) {
				Traccia t = tracce[rnd.nextInt(tracce.length)];
				if(coll.contains(t)) {
					continue;
				}else {
					coll.add(t);
				}
			}
			a.addTraccia(coll);
		}
		
		System.out.println(albums[0].toString() );
		
		Iterator<Traccia> it = albums[0].iteraTracce();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		File collezione = new File("collezione_album.txt");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(collezione);
			oos = new ObjectOutputStream(fos);
		} catch (FileNotFoundException f) {
			System.out.println("Exception " + f);
		} catch (IOException ie) {
			System.out.println("Exception " + ie );
		} finally {
			if(fos != null || oos != null) {
				try {
					oos.close();
					fos.close();
				} catch (IOException e) {
					System.out.println("Exception " + e);
				} finally {
					System.out.println();
				}
			}
		
			
		}
		
	}

}
