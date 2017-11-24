package classes;

import java.io.Serializable;

import exceptions.PostoException;

/**
 * 
 * @class Posto
 *
 */
public class Posto implements Comparable<Posto>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum Stato {
		LIBERO, OCCUPATO
	}

	private Veicolo veicolo;
	private Stato stato;
	private int oraIngresso;
	private int durata;
	private double costoTotale;

	/**
	 * @constructor
	 */
	public Posto(Veicolo veicolo, Stato stato, int oraIngresso, int durata, double costoTotale) {
		this.veicolo = veicolo;
		this.stato = stato;
		this.oraIngresso = oraIngresso;
		this.durata = durata;
		this.costoTotale = costoTotale;
	}

	/**
	 * @constructor
	 */
	public Posto() {
		stato = Stato.LIBERO;
		veicolo = null;
		oraIngresso = 0;
		durata = 0;
		costoTotale = 0;
	}

	/**
	 * 
	 * @return veicolo
	 */
	public Veicolo getVeicolo() {
		return veicolo;
	}

	/**
	 * 
	 * @param veicolo
	 */
	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}

	/**
	 * 
	 * @return stato
	 */
	public Stato getStato() {
		return stato;
	}

	/**
	 * 
	 * @param stato
	 */
	public void setStato(Stato stato) {
		this.stato = stato;
	}

	/**
	 * 
	 * @return oraIngresso
	 */
	public int getOraIngresso() {
		return oraIngresso;
	}

	/**
	 * 
	 * @param oraIngresso
	 */
	public void setOraIngresso(int oraIngresso) {
		this.oraIngresso = oraIngresso;
	}

	/**
	 * 
	 * @return durata
	 */
	public int getDurata() {
		return durata;
	}

	/**
	 * 
	 * @param durata
	 */
	public void setDurata(int durata) {
		this.durata = durata;
	}

	/**
	 * 
	 * @return costoTotale
	 */
	public double getCostoTotale() {
		return costoTotale;
	}

	/**
	 * 
	 * @param costoTotale
	 */
	public void setCostoTotale(double costoTotale) {
		this.costoTotale = costoTotale;
	}

	/**
	 * @override
	 */
	@Override
	public String toString() {
		return "Posto [getVeicolo()=" + getVeicolo() + ", getStato()=" + getStato() + ", getOraIngresso()="
				+ getOraIngresso() + ", getDurata()=" + getDurata() + ", getCostoTotale()=" + getCostoTotale() + "]";
	}

	/**
	 * 
	 * @param newV
	 * @param orarioIngresso
	 * @throws PostoException
	 */
	public void occupa(Veicolo newV, int orarioIngresso) throws PostoException {
		if (getStato().equals(Stato.LIBERO)) {
			this.setVeicolo(newV);
			this.setOraIngresso(orarioIngresso);
			this.setStato(Stato.OCCUPATO);
		} else {
			throw new PostoException();
		}
	}

	/**
	 * 
	 * @throws PostoException
	 */
	public void libera() throws PostoException {
		if (getStato().equals(Stato.OCCUPATO)) {
			this.setVeicolo(null);
			this.setOraIngresso(0);
			this.setStato(Stato.LIBERO);
		} else {
			throw new PostoException();
		}
	}

	/**
	 * @override
	 */
	@Override
	public int compareTo(Posto arg0) {
		return this.getDurata() - arg0.getDurata();
	}

	/**
	 * @override
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((veicolo == null) ? 0 : veicolo.hashCode());
		return result;
	}

	/**
	 * @override
	 */
	@Override
	public boolean equals(Object obj) {
		boolean res = true;
		if (this == obj) {
			res = true;
		} else if (obj == null) {
			res = false;
		} else if (getClass() != obj.getClass()) {
			res = false;
		}
		Posto other = (Posto) obj;
		if (veicolo == null) {
			if (other.veicolo != null) {
				res = false;
			}
		} else if (!veicolo.equals(other.veicolo)) {
			res = false;
		}
		return res;
	}

}
