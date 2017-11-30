package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import exceptions.SupportoException;

public class Album implements Comparable<Album>, Serializable{

	/**
	 * 
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

	public Supporto getSupporto() {
		return supporto;
	}

	public void setSupporto(Supporto supporto) {
		this.supporto = supporto;
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
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getId() {
		return id;
	}
	
	public void addTraccia(Traccia[] tracce){
		for(Traccia t: tracce){
			if(listaTracce.contains(t)){
				continue;
			}else{
				listaTracce.add(t);
			}
		}
	}
	
	public boolean isPresente(Traccia traccia){
		boolean res = false;
		for(Traccia t: listaTracce){
			if(t.equals(traccia)){
				res = true;
			}
		}
		return res;
	}
	
	public int getDurataTraccia(Traccia traccia){
		int durata = 0;
		for(Traccia t: listaTracce){
			if(t.equals(traccia)){
				durata = t.getDurata();
			}
		}
		return durata;
	}
	
	public int getDurataAlbum(){
		int durataTot = 0;
		for(Traccia t: listaTracce){
			durataTot += t.getDurata();
		}
		return durataTot;
	}

	@Override
	public String toString() {
		return "Album [getId()=" + getId() + ", getData()=" + getData() + ", getDurataAlbum()=" + getDurataAlbum()
				+ "]";
	}
	
	public Iterator<Traccia> iteratoreTracce(){
		Collections.sort(listaTracce);
		return listaTracce.listIterator();
	}

	@Override
	public int compareTo(Album arg0) {
		return this.getId()-arg0.getId();
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
		Album other = (Album) obj;
		if (id != other.id){
			return false;
		}
		return true;
	}
	
	
}
