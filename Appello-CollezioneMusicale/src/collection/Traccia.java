/**
 * 
 * @author Vincenzo Plantone - 639371
 * 
 */

package collection;

import java.io.Serializable;

import exception.NegNumException;

/**
 * 
 * @class Traccia
 *
 */
public class Traccia implements Comparable<Traccia>, Serializable {

	/**
	 * default static serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id's counter
	 */
	static int cont = 0;

	private transient int id;
	private String titolo;
	private String esecutore;
	private int durata;

	/**
	 * 
	 * @param titolo
	 * @param esecutore
	 * @param durata
	 * @throws NegNumException
	 */
	public Traccia(String titolo, String esecutore, int durata) throws NegNumException {
		id = ++cont;
		this.titolo = titolo;
		this.esecutore = esecutore;
		if (durata > 0) {
			this.durata = durata;
		} else {
			throw new NegNumException();
		}

	}

	/**
	 * 
	 * @return titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * 
	 * @param titolo
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * 
	 * @return esecutore
	 */
	public String getEsecutore() {
		return esecutore;
	}

	/**
	 * 
	 * @param esecutore
	 */
	public void setEsecutore(String esecutore) {
		this.esecutore = esecutore;
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
	 * @override hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * @override equals()
	 */
	@Override
	public boolean equals(Object obj) {
		boolean res = true;
		Traccia other = null;
		if (this == obj) {
			res = true;
		} else if (obj == null) {
			res = false;
		} else if (getClass() != obj.getClass()) {
			res = false;
		} else if (obj instanceof Traccia) {
			other = (Traccia) obj;
			if (id != other.id) {
				res = false;
			}
		}
		return res;
	}

	/**
	 * @override equals()
	 */
	@Override
	public String toString() {
		return "Traccia [getTitolo()=" + getTitolo() + ", getEsecutore()=" + getEsecutore() + ", getDurata()="
				+ getDurata() + "]";
	}

	/**
	 * 
	 * @param arg0
	 * @return
	 */
	@Override
	public int compareTo(Traccia arg0) {
		return -(this.getDurata() - arg0.getDurata());
	}

}
