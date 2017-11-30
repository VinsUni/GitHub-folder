package classes;

import java.io.Serializable;

import exceptions.NumberException;

public class Traccia implements Comparable<Traccia>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	static int cont = 0;
	private String titolo;
	private String esecutore;
	private int durata;
	
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

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getEsecutore() {
		return esecutore;
	}

	public void setEsecutore(String esecutore) {
		this.esecutore = esecutore;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}else if (obj == null){
			return false;
		}else if (getClass() != obj.getClass()){
			return false;
		}
		Traccia other = (Traccia) obj;
		if (id != other.id){
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Traccia [getTitolo()=" + getTitolo() + ", getEsecutore()=" + getEsecutore() + ", getDurata()="
				+ getDurata() + "]";
	}

	@Override
	public int compareTo(Traccia arg0) {
		return -(this.getDurata()-arg0.getDurata());
	}
	
	
	
	
}
