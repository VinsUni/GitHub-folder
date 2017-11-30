package classes;

/**
 * 
 * @author Vincenzo Plantone 639371
 * 
 */

import java.io.Serializable;

import exceptions.NumberException;

/**
 * 
 * @class Traccia
 *
 */
public class Traccia implements Comparable<Traccia>, Serializable {

	/**
	 * static variable
	 */
	private static final long serialVersionUID = 1L;
	private transient int id;
	
	/**
	 * static variable
	 */
	static int cont = 0;
	
	private String titolo;
	private String esecutore;
	private int durata;
	
	/**
	 * 
	 * @param titolo
	 * @param esecutore
	 * @param durata
	 * @throws NumberException
	 */
	public Traccia(String titolo, String esecutore, int durata) throws NumberException {
		if(durata > 0){
			id = ++cont;
			this.titolo = titolo;
			this.esecutore = esecutore;
			this.durata = durata;
		}else{
			throw new NumberException();
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
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @override hashcode() method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * @override equals() method
	 */
	@Override
	public boolean equals(Object obj) {
		boolean res = true;
		if (this == obj){
			res = true;
		}else if (obj == null){
			res = false;
		}else if (getClass() != obj.getClass()){
			res = false;
		}
		 res = inEquals(res, obj);
		return res;
	}

	/**
	 * 
	 * @param res
	 * @param obj
	 * @return
	 */
	public boolean inEquals(boolean res, Object obj){
		Traccia other = (Traccia) obj;
		if (id != other.id){
			res = false;
		}
		return res;
	}
	
	/**
	 * @override toString() method
	 */
	@Override
	public String toString() {
		return "Traccia [getTitolo()=" + getTitolo() + ", getEsecutore()=" + getEsecutore() + ", getDurata()="
				+ getDurata() + "]";
	}

	/**
	 * @override compareTo() method
	 */
	@Override
	public int compareTo(Traccia arg0) {
		return -(this.getDurata()-arg0.getDurata());
	}
	
	
	
	
}
