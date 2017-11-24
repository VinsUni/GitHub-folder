package classes;

/**
 * 
 * @author vince
 *
 */

/**
 * 
 * @class Veicolo
 *
 */
public abstract class Veicolo {

	private String targa;

	/**
	 * @constructor
	 */
	protected Veicolo(String targa) {
		this.targa = targa;
	}

	/**
	 * 
	 * @return costo
	 */
	public abstract double getCosto();

	public String getTarga() {
		return targa;
	}

	@Override
	public String toString() {
		return "[targa=" + targa + ", getTarga()=" + getTarga() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((targa == null) ? 0 : targa.hashCode());
		return result;
	}

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
		Veicolo other = (Veicolo) obj;
		if (targa == null) {
			if (other.targa != null){
				res = false;
			}
		} else if (!targa.equals(other.targa)){
			res = false;
		}
		return res;
	}

	
}
