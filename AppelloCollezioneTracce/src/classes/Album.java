package classes;

/**
 * 
 * @author Vincenzo Plantone 639371
 * 
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import exceptions.SupportoException;

/**
 * 
 * @class Album
 *
 */
public class Album implements Comparable<Album>, Serializable{

	/**
	 * static variable
	 */
	private static final long serialVersionUID = 1L;

	public enum Supporto{ CD, VINILE, USB}
	
	private int id;
	static int cont = 0;
	private List<Traccia> listaTracce;
	private String data;
	private Supporto supporto;
	private String titolo;
	private String esecutore;
	
	/**
	 * 
	 * @param supporto
	 * @param data
	 * @throws SupportoException
	 */
	public Album(Supporto supporto, String data) throws SupportoException {
		if(supporto.equals(Supporto.CD) || supporto.equals(Supporto.VINILE ) || supporto.equals(Supporto.USB)){
			id = ++cont;
			listaTracce = new ArrayList<>();
			this.data = data;
			this.supporto = supporto;
		}else{
			throw new SupportoException();
		}
	}
	
	/**
	 * 
	 * @param supporto
	 * @param data
	 * @param titolo
	 * @param esecutore
	 * @throws SupportoException
	 */
	public Album(Supporto supporto, String data, String titolo, String esecutore) throws SupportoException {
		if(supporto.equals(Supporto.CD) || supporto.equals(Supporto.VINILE ) || supporto.equals(Supporto.USB)){
			id = ++cont;
			listaTracce = new ArrayList<>();
			this.data = data;
			this.supporto = supporto;
			this.titolo = titolo;
			this.esecutore = esecutore;
		}else{
			throw new SupportoException();
		}
		
	}

	/**
	 * 
	 * @return supporto
	 */
	public Supporto getSupporto() {
		return supporto;
	}

	/**
	 * 
	 * @param supporto
	 */
	public void setSupporto(Supporto supporto) {
		this.supporto = supporto;
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
	 * @return data
	 */
	public String getData() {
		return data;
	}

	/**
	 * 
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param tracce
	 */
	public void addTraccia(Traccia[] tracce){
		for(Traccia t: tracce){
			if(listaTracce.contains(t)){
				continue;
			}else{
				listaTracce.add(t);
			}
		}
	}
	
	/**
	 * 
	 * @param traccia
	 * @return res
	 */
	public boolean isPresente(Traccia traccia){
		boolean res = false;
		for(Traccia t: listaTracce){
			if(t.equals(traccia)){
				res = true;
			}
		}
		return res;
	}
	
	/**
	 * 
	 * @param traccia
	 * @return durata
	 */
	public int getDurataTraccia(Traccia traccia){
		int durata = 0;
		for(Traccia t: listaTracce){
			if(t.equals(traccia)){
				durata = t.getDurata();
			}
		}
		return durata;
	}
	
	/**
	 * 
	 * @return durata
	 */
	public int getDurataAlbum(){
		int durataTot = 0;
		for(Traccia t: listaTracce){
			durataTot += t.getDurata();
		}
		return durataTot;
	}

	/**
	 * @override toString() method
	 */
	@Override
	public String toString() {
		return "Album [getId()=" + getId() + ", getData()=" + getData() + ", getDurataAlbum()=" + getDurataAlbum()
				+ "]";
	}
	
	/**
	 * 
	 * @return it
	 */
	public Iterator<Traccia> iteratoreTracce(){
		Collections.sort(listaTracce);
		return listaTracce.listIterator();
	}

	/**
	 * @override compareTo() method
	 */
	@Override
	public int compareTo(Album arg0) {
		return this.getId()-arg0.getId();
	}

	/**
	 * @override hashCode() method
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
		if (this == obj){
			return true;
		}else if (obj == null){
			return false;
		}else if (getClass() != obj.getClass()){
			return false;
		}
		Album other = (Album) obj;
		if (id != other.id){
			return false;
		}
		return true;
	}
	
	
}
