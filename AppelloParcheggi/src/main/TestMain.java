package main;

import java.util.Random;

import classes.Automobile;
import classes.Motocicletta;
import classes.Parco;
import classes.Veicolo;
import exceptions.IsFullException;
import exceptions.PostoException;

/**
 * 
 * @class TestMain
 *
 */
public class TestMain {

	/**
	 * @constructor private
	 */
	private TestMain() {
	}

	/**
	 * @variable
	 */
	static final Random rnd = new Random();

	/**
	 * 
	 * @param l
	 * @return
	 */
	static String genRandString(int l) {
		String a = "qwertyuioplkjhgfdsazxcvbnm";
		char[] c = new char[l];
		for (int i = 0; i < c.length; i++) {
			c[i] = a.charAt(rnd.nextInt(a.length()));
		}
		return new String(c);
	}

	/**
	 * 
	 * @param veicoli
	 */
	static void metodoForA(Veicolo[] veicoli) {
		int in = 7;
		for (int i = 0; i < 80; i++) {
			if (i < 40) {
				String sq = genRandString(in);
				veicoli[i] = new Automobile(sq);
			} else if (i >= 40 && i < 80) {
				String sq = genRandString(in);
				veicoli[i] = new Motocicletta(sq);
			}
		}
	}

	/**
	 * 
	 * @param parco
	 * @param veicoli
	 */
	static void metodoForB(Parco parco, Veicolo[] veicoli) {
		for (int i = 0; i < 99; i++) {
			int c = 2;
			int n = rnd.nextInt(c);
			switch (n) {
			case 0:
				int na = 10;
				int a = rnd.nextInt(na) / na;
				double p = a;
				int n1 = rnd.nextInt(c);
				metodoForBInner(n1, p, parco, veicoli);
				break;
			case 1:
				break;
			default:
				break;
			}
		}
	}

	/**
	 * 
	 * @param n1
	 * @param p
	 * @param parco
	 * @param veicoli
	 */
	static void metodoForBInner(int n1, double p, Parco parco, Veicolo[] veicoli) {
		int c = 40;
		int c1 = 10;
		int c2 = 1;
		switch (n1) {
		case 0:
			int num = (rnd.nextInt(c) + c);
			int num2 = (rnd.nextInt(c1) + c2);
			metodoForBInnerA(parco, veicoli, num, num2, p);
			break;
		case 1:
			int numero = (rnd.nextInt(c) + c);
			metodoForBInnerB(numero, veicoli, parco, p);
			break;
		default:
			break;
		}
	}

	/**
	 * 
	 * @param parco
	 * @param veicoli
	 * @param num
	 * @param num2
	 * @param p
	 */
	static void metodoForBInnerA(Parco parco, Veicolo[] veicoli, int num, int num2, double p) {
		try {
			if (p < 0.6) {
				parco.entrata(veicoli[num], num2);
			} else {
				parco.entrata(veicoli[num], num2);
			}
		} catch (IsFullException | PostoException e) {
			System.out.println("ERRORE");
		}
	}

	/**
	 * 
	 * @param numero
	 * @param veicoli
	 * @param parco
	 * @param p
	 */
	static void metodoForBInnerB(int numero, Veicolo[] veicoli, Parco parco, double p) {
		try {
			if (p < 0.6) {
				Motocicletta m = (Motocicletta) veicoli[numero];
				if (parco.isPresente(m)) {
					parco.uscita(m);
				}
			} else {
				int c = 40;
				int rn = rnd.nextInt(c);
				parco.uscita(veicoli[rn]);
				Automobile a = (Automobile) veicoli[numero];
				if (parco.isPresente(a)) {
					parco.uscita(a);
				}
			}
		} catch (PostoException e) {
			System.out.println("ERRORE");
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int orologio = 99;
		int postiaut = 40;
		int postimo = 40;
		int c = 20;
		int c1 = 1;
		int c3 = 2;
		Parco parco = new Parco(orologio, postiaut, postimo);
		Veicolo[] veicoli = new Veicolo[80];
		metodoForA(veicoli);
		metodoForB(parco, veicoli);
		int sconto1 = (rnd.nextInt(c) + c1);
		int sconto2 = (rnd.nextInt(c) + c1);
		parco.promo("Moto", sconto1, genRandString(c3));
		parco.promo("Auto", sconto2, genRandString(c3));

	}

}
