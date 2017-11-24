package classes;

/**
 * 
 * @class Auto
 *
 */
public class Automobile extends Veicolo {

	/**
	 * @constructor
	 */
	public Automobile(String targa) {
		super(targa);
	}

	/**
	 * 
	 * @return costo
	 */
	@Override
	public double getCosto() {
		double costo = 0.10;
		return costo;
	}

	@Override
	public String toString() {
		return "Auto " + super.toString();
	}

}
