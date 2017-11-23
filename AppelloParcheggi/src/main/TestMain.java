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

	private TestMain(){}
	
	/**
	 * @variable
	 */
	static final Random rnd = new Random();

	static String genRandString(int l) {
		String a = "qwertyuioplkjhgfdsazxcvbnm";
		char[] c = new char[l];
		for (int i = 0; i < c.length; i++) {
			c[i] = a.charAt(rnd.nextInt(a.length()));
		}
		return new String(c);
	}

	static void metodoForA(Veicolo[] veicoli) {
		for (int i = 0; i < 80; i++) {
			if (i < 40) {
				veicoli[i] = new Automobile(genRandString(7));
			} else if (i >= 40 && i < 80) {
				veicoli[i] = new Motocicletta(genRandString(7));
			}
		}
	}

	static void metodoForB(Parco parco, Veicolo[] veicoli) {
		for (int i = 0; i < 99; i++) {
			int n = rnd.nextInt(2);
			switch (n) {
			case 0:
				double p = rnd.nextDouble();
				int n1 = rnd.nextInt(2);
				metodoForBInner(n1, p, parco, veicoli);
				break;
			case 1:
				break;
			default:
				break;
			}
		}
	}

	static void metodoForBInner(int n1, double p, Parco parco, Veicolo[] veicoli) {
		switch (n1) {
		case 0:
			int num = (rnd.nextInt(40) + 40);
			int num2 = (rnd.nextInt(10) + 1);
			metodoForBInnerA(parco, veicoli, num, num2, p);

			break;
		case 1:
			int numero = (rnd.nextInt(40) + 40);
			metodoForBInnerB(numero, veicoli, parco, p);
			break;
		default:
			break;
		}
	}

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

	static void metodoForBInnerB(int numero, Veicolo[] veicoli, Parco parco, double p) {
		try {
			if (p < 0.6) {
				Motocicletta m = (Motocicletta) veicoli[numero];
				if (parco.isPresente(m)) {
					parco.uscita(m);
				}
			} else {
				int rn = rnd.nextInt(40);
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

	public static void main(String[] args) {

		int orologio = 99;
		int postiaut = 40;
		int postimo = 40;
		Parco parco = new Parco(orologio, postiaut, postimo);
		Veicolo[] veicoli = new Veicolo[80];
		metodoForA(veicoli);
		metodoForB(parco, veicoli);
		int sconto1 = (rnd.nextInt(20) + 1);
		int sconto2 = (rnd.nextInt(20) + 1);
		parco.promo("Moto", sconto1, genRandString(2));
		parco.promo("Auto", sconto2, genRandString(2));

	}

}
