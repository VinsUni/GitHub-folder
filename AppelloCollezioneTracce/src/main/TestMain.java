package main;

/**
 * 
 * @author Vincenzo Plantone 639371
 * 
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Random;

import classes.Album;
import classes.Traccia;
import classes.Album.Supporto;
import exceptions.NumberException;
import exceptions.SupportoException;

/**
 * 
 * @class TestMain
 *
 */
public class TestMain {

	/**
	 * default private constructor
	 */
	private TestMain(){}
	
	/**
	 * static Random variable
	 */
	static final Random rnd = new Random();
	
	/**
	 * 
	 * @return random String
	 */
	static String genRandString(){
		int l = (rnd.nextInt(5)+5);
		char[] c = new char[l];
		String a = "qwertyuioplkjhgfdsazxcvbnm";
		for(int i = 0; i < c.length; i++){
			c[i] = a.charAt(rnd.nextInt(a.length()));
		}
		return new String(c);
	}
	
	/**
	 * 
	 * @return data
	 */
	static String genRandData(){
		return (rnd.nextInt(29)+1) + "/" + (rnd.nextInt(12)+1) + "/" + (rnd.nextInt(60)+1950);
	}
	
	/**
	 * 
	 * @param titoli
	 * @param esecutori
	 * @param durate
	 */
	static void popolamentoArrays(String[] titoli, String[] esecutori, int[] durate){
		for(int i = 0; i < 100; i++){
			titoli[i] = genRandString();
			esecutori[i] = genRandString();
			durate[i] = (rnd.nextInt(120)+60);
		}
	}
	
	/**
	 * 
	 * @param tracce
	 * @param titoli
	 * @param esecutori
	 * @param durate
	 */
	static void popolamentoTracce(Traccia[] tracce, String[] titoli, String[] esecutori, int[] durate){
		try {
			for(int i = 0; i < 100; i++){
				tracce[i] = new Traccia(titoli[rnd.nextInt(titoli.length)], esecutori[rnd.nextInt(esecutori.length)], durate[rnd.nextInt(durate.length)]); 
			}
		} catch (NumberException e) {
			System.out.println("NumberException()");
		}
	}
	
	/**
	 * 
	 * @param albums
	 * @param titoli
	 * @param esecutori
	 * @param durate
	 */
	static void popolamentoAlbums(Album[] albums, String[] titoli, String[] esecutori, int[] durate){
		try {
			for(int i = 0; i < 12; i++){
				switch(rnd.nextInt(3)){
				case 0:
					albums[i] = new Album(Supporto.CD, genRandData(), titoli[rnd.nextInt(titoli.length)], esecutori[rnd.nextInt(esecutori.length)]);
					break;
				case 1:
					albums[i] = new Album(Supporto.USB, genRandData(), titoli[rnd.nextInt(titoli.length)], esecutori[rnd.nextInt(esecutori.length)]);
					break;
				case 2: 
					albums[i] = new Album(Supporto.VINILE, genRandData(), titoli[rnd.nextInt(titoli.length)], esecutori[rnd.nextInt(esecutori.length)]);
					break;
				default:
					break;	
				}
			}
		} catch (SupportoException e) {
			System.out.println("SupportException()");
		}
	}
	
	/**
	 * 
	 * @param albums
	 * @param tracce
	 */
	static void addTracceAlbums(Album[] albums, Traccia[] tracce){
		Traccia[] tracks = null;
		for(Album a: albums){
			tracks = new Traccia[rnd.nextInt(5)+5];
			for(int i = 0; i < tracks.length; i++){
				tracks[i] = tracce[rnd.nextInt(tracce.length)];
			}
			a.addTraccia(tracks);
		}
	}
	
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		
		String[] titoli = new String[100];
		String[] esecutori = new String[100];
		int[] durate = new int[100];		
		popolamentoArrays(titoli, esecutori, durate);
		
		Traccia[] tracce = new Traccia[100];
		popolamentoTracce(tracce, titoli, esecutori, durate);
		
		Album[] albums = new Album[12];
		popolamentoAlbums(albums, titoli, esecutori, durate);

		addTracceAlbums(albums, tracce);
		
		System.out.println(albums[0]);
		
		Iterator<Traccia> it = albums[0].iteratoreTracce();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null; 
		try {
			fos = new FileOutputStream(new File("collezione.txt"));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(albums[0]);
		} catch (IOException e) {
			System.out.println("IOException()");
		} finally {
			oos.close();
			fos.close();
		}
	}

}
