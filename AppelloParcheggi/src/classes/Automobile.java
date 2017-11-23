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

	@Override
	public double getCosto() {
		return 0.10;
	}

	@Override
	public String toString() {
		return "Auto " + super.toString();
	}

}
