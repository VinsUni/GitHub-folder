package classes;

import java.util.ArrayList;
import java.util.List;

import classes.Posto.Stato;
import exceptions.IsFullException;
import exceptions.PostoException;

/**
 * 
 * @class Parco
 *
 */
public class Parco {

	private List<Posto> postiAuto;
	private List<Posto> postiMoto;
	private int orologio;

	/**
	 * @constructor
	 */
	public Parco(int orologio, int maxAuto, int maxMoto) {
		this.orologio = orologio;
		postiAuto = new ArrayList<>();
		for (int i = 0; i < maxAuto; i++) {
			postiAuto.add(new Posto());
		}
		postiMoto = new ArrayList<>();
		for (int i = 0; i < maxMoto; i++) {
			postiMoto.add(new Posto());
		}
	}

	/**
	 * 
	 * @return orologio
	 */
	public int getOrologio() {
		return orologio;
	}

	/**
	 * 
	 * @param lista
	 * @return
	 */
	static Posto getPostoLibero(List<Posto> lista) {
		Posto posto = new Posto();
		for (Posto p : lista) {
			if (p.getStato().equals(Stato.LIBERO)) {
				posto = p;
			}
		}
		return posto;
	}

	/**
	 * 
	 * @param lista
	 * @return
	 */
	static boolean isFull(List<Posto> lista) {
		boolean res = true;
		for (Posto p : lista) {
			if (p.getStato().equals(Stato.LIBERO)) {
				res = false;
			}
		}
		return res;
	}

	/**
	 * 
	 * @param v
	 * @param durata
	 * @throws IsFullException
	 */
	public void entrataA(Veicolo v, int durata) throws IsFullException {
		if (isFull(postiMoto)) {
			throw new IsFullException();
		} else {
			Posto p = new Posto();
			p = getPostoLibero(postiMoto);
			try {
				p.occupa(v, orologio);
			} catch (PostoException e) {
				System.out.println("ERRORE");
			}
			p.setDurata(durata);
			System.out.println("OCCUPATO" + p.toString());
			tic();
		}
	}

	/**
	 * 
	 * @param v
	 * @param durata
	 * @throws IsFullException
	 */
	public void entrataB(Veicolo v, int durata) throws IsFullException {
		if (isFull(postiAuto)) {
			throw new IsFullException();
		} else {
			Posto p = new Posto();
			p = getPostoLibero(postiAuto);
			try {
				p.occupa(v, orologio);
			} catch (PostoException e) {
				System.out.println("ERRORE");
			}
			p.setDurata(durata);
			System.out.println("OCCUPATO! " + p.toString());
			tic();
		}
	}

	/**
	 * 
	 * @param v
	 * @param durata
	 * @throws IsFullException
	 * @throws PostoException
	 */
	public void entrata(Veicolo v, int durata) throws IsFullException, PostoException {
		if (durata < orologio) {
			if (v != null || v instanceof Motocicletta) {
				entrataA(v, durata);
			} else if (v != null || v instanceof Automobile) {
				entrataB(v, durata);
			}
		}

	}

	/**
	 * 
	 * @param v
	 * @throws PostoException
	 */
	public void uscita(Veicolo v) throws PostoException {
		Posto posto = new Posto();
		if (v instanceof Automobile) {
			Automobile a = (Automobile) v;
			for (Posto p : postiAuto) {
				if (p.getVeicolo().equals(a)) {
					p.setCostoTotale((p.getDurata() * p.getVeicolo().getCosto()));
					posto = p;
					p.libera();
				}
			}
			System.out.println("Scontrino: ");
			System.out.println(posto.getVeicolo());
			System.out.println("Ora ingresso: ");
			System.out.println(posto.getOraIngresso());
			System.out.println("Ora uscita: ");
			System.out.println(orologio);
			System.out.println("Costo totale: ");
			System.out.println((posto.getDurata() * a.getCosto()));
			tic();
		} else if (v instanceof Motocicletta) {
			Motocicletta m = (Motocicletta) v;
			for (Posto p : postiMoto) {
				if (p.getVeicolo().equals(m)) {
					p.setCostoTotale((p.getDurata() * p.getVeicolo().getCosto()));
					posto = p;
					p.libera();
				}
			}
			System.out.println("Scontrino: ");
			System.out.println(posto.getVeicolo());
			System.out.print("Ora ingresso: ");
			System.out.println(posto.getOraIngresso());
			System.out.print("Ora uscita: ");
			System.out.println(orologio);
			System.out.print("Costo totale: ");
			System.out.println((posto.getDurata() * m.getCosto()));
			tic();
		}
	}

	/**
	 * pass to next unit
	 */
	public void tic() {
		orologio -= 1;
	}

	/**
	 * 
	 * @param v
	 * @return
	 */
	public boolean isPresente(Veicolo v) {
		boolean res = false;
		if (v instanceof Motocicletta) {
			Motocicletta m = (Motocicletta) v;
			for (Posto p : postiMoto) {
				if (p.getVeicolo().equals(m)) {
					res = true;
				} else {
					continue;
				}
			}
		} else if (v instanceof Automobile) {
			Automobile a = (Automobile) v;
			for (Posto p : postiAuto) {
				if (p.getVeicolo().equals(a)) {
					res = true;
				}
			}
		}
		return res;
	}

	/**
	 * 
	 * @param codice
	 * @param sconto
	 */
	public void promoSubA(String codice, int sconto) {
		for (Posto p : postiAuto) {
			if (p.getStato().equals(Stato.OCCUPATO)) {
				if (codice.charAt(0) == p.getVeicolo().getTarga().charAt((p.getVeicolo().getTarga().length() - 1))
						&& codice.charAt(1) == p.getVeicolo().getTarga()
								.charAt((p.getVeicolo().getTarga().length() - 2))) {
					double costo = 0;
					costo = p.getCostoTotale();
					p.setCostoTotale(costo - (costo * sconto / 100));
				}
			}
		}
	}

	/**
	 * 
	 * @param string
	 * @param sconto
	 * @param codice
	 */
	public void promo(String string, int sconto, String codice) {
		if ("Moto".equals(string)) {
			for (Posto p : postiMoto) {
				if (p.getStato().equals(Stato.OCCUPATO)) {
					if (codice.charAt(0) == p.getVeicolo().getTarga().charAt((p.getVeicolo().getTarga().length() - 1))
							&& codice.charAt(1) == p.getVeicolo().getTarga()
									.charAt((p.getVeicolo().getTarga().length() - 2))) {
						double costo = 0;
						costo = p.getCostoTotale();
						p.setCostoTotale(costo - (costo * sconto / 100));
					}
				}
			}
		} else if ("Auto".equals(string)) {
			promoSubA(codice, sconto);
		}
	}

	/**
	 * print state
	 */
	public void stato() {
		System.out.println("Elenco posti Auto:");
		for (Posto p : postiAuto) {
			System.out.println(p.toString());
		}

		System.out.println("Elenco posti Moto:");
		for (Posto p : postiMoto) {
			System.out.println(p.toString());
		}
	}
}
