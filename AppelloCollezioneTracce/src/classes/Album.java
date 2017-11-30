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
	
	private transient int id;
	
	/**
	 * static variable
	 */
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
		this(supporto, data, "", "");
		if(supporto.equals(Supporto.CD) || supporto.equals(Supporto.VINILE ) || supporto.equals(Supporto.USB)){
			id = ++cont;
			listaTracce = new ArrayList<>();
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
	 * 
	 * @return listaTracce
	 */
	public List<Traccia> getListaTracce() {
		return listaTracce;
	}

	/**
	 * 
	 * @param listaTracce
	 */
	public void setListaTracce(List<Traccia> listaTracce) {
		this.listaTracce = listaTracce;
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
		Album other = (Album) obj;
		if (id != other.id){
			res = false;
		}
		return res;
	}
	
}
