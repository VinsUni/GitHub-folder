package classes;

/**
 * 
 * @author Vincenzo Plantone 639371
 * 
 */

public class Rapporto {

	private int lunghezza;
	private int numStringhe;
	private int punteggioTot;
	private double punteggioMedio;
	
	/**
	 * Class constructor
	 */
	public Rapporto(){
		lunghezza = 0;
		numStringhe = 0;
		punteggioMedio = 0;
		punteggioTot = 0;
	}

	/**
	 * 
	 * @return lunghezza
	 */
	public int getLunghezza() {
		return lunghezza;
	}

	/**
	 * 
	 * @param lunghezza
	 */
	public void setLunghezza(int lunghezza) {
		this.lunghezza = lunghezza;
	}

	/**
	 * 
	 * @return numStringhe
	 */
	public int getNumStringhe() {
		return numStringhe;
	}

	/**
	 * 
	 * @param numStringhe
	 */
	public void setNumStringhe(int numStringhe) {
		this.numStringhe = numStringhe;
	}

	/**
	 * 
	 * @return punteggioTot
	 */
	public int getPunteggioTot() {
		return punteggioTot;
	}

	/**
	 * 
	 * @param punteggioTot
	 */
	public void setPunteggioTot(int punteggioTot) {
		this.punteggioTot = punteggioTot;
	}

	/**
	 * 
	 * @return punteggioMedio
	 */
	public double getPunteggioMedio() {
		return punteggioMedio;
	}

	/**
	 * 
	 * @param punteggioMedio
	 */
	public void setPunteggioMedio(int punteggioMedio) {
		this.punteggioMedio = punteggioMedio;
	}

	/**
	 * Overrided toString() method
	 */
	@Override
	public String toString() {
		return "Rapporto messaggio: Lunghezza messaggio = " + getLunghezza() + ", Numero stringhe sospette = " + getNumStringhe()
				+ ", Punteggio totale = " + getPunteggioTot() + ", Punteggio Medio = " + getPunteggioMedio();
	}
	
	
	
}
