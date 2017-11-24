package classes;

/**
 * 
 * @class Moto
 *
 */
public class Motocicletta extends Veicolo {

	/**
	 * @constructor
	 */
	public Motocicletta(String targa) {
		super(targa);
	}

	/**
	 * 
	 * @return costo
	 */
	@Override
	public double getCosto() {
		double costo = 0.25;
		return costo;
	}

	@Override
	public String toString() {
		return "Moto " + super.toString();
	}

}
