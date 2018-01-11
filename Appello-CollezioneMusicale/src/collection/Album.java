/**
 * 
 * @author Vincenzo Plantone - 639371
 *
 */

package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import exception.EmptyListException;

/**
 * 
 * @author Album
 *
 */
public class Album {

	/**
	 * id's counter 
	 */
	static int cont = 0;
	
	private int id;
	private Set<Traccia> lista;

	public enum Supporto {
		VINILE, USB, CD
	}

	private Supporto supporto;
	private String esecutore;
	private String titolo;
	private String data;

	/**
	 * 
	 * @param supporto
	 * @param data
	 */
	public Album(Supporto supporto, String data) {
		this(supporto, null, null, data);
	}

	/**
	 * 
	 * @param supporto
	 * @param esecutore
	 * @param titolo
	 * @param data
	 */
	public Album(Supporto supporto, String esecutore, String titolo, String data) {
		lista = new HashSet<>();
		this.id = ++cont;
		this.supporto = supporto;
		this.esecutore = esecutore;
		this.titolo = titolo;
		this.data = data;
	}

	/**
	 * 
	 * @param tracce
	 */
	public void addTraccia(List<Traccia> tracce) {
		for (Traccia t : tracce) {
			if (!lista.contains(t)) {
				lista.add(t);
			}
		}
	}

	/**
	 * 
	 * @param traccia
	 * @return
	 */
	public boolean isPresente(Traccia traccia) {
		boolean res = false;
		if (lista.contains(traccia)) {
			res = true;
		} else {
			res = false;
		}
		return res;
	}

	/**
	 * 
	 * @param traccia
	 * @return
	 * @throws EmptyListException
	 */
	public int getDurataTraccia(Traccia traccia) throws EmptyListException {
		int tmp = 0;
		if (lista.isEmpty()) {
			throw new EmptyListException();
		} else {
			if (lista.contains(traccia)) {
				tmp = traccia.getDurata();
			}
		}
		return tmp;
	}

	/**
	 * 
	 * @return
	 * @throws EmptyListException
	 */
	public int getDurataAlbum() {
		int tmp = 0;
		if (!lista.isEmpty()) {
			for (Traccia t : lista) {
				tmp += t.getDurata();
			}
		} else {
			return tmp;
		}
		return tmp;
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
	 * @return data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @override toString()
	 */
	@Override
	public String toString() {
		return "Album [getId()=" + getId() + ", getData()=" + getData() + ", getDurataAlbum()= " + getDurataAlbum()
				+ "]";
	}

	/**
	 * 
	 * @return iterator
	 */
	public Iterator<Traccia> iteraTracce() {
		Iterator<Traccia> iterator = lista.iterator();
		while (iterator.hasNext()) {
			iterator.next();
		}
		return iterator;
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

}
