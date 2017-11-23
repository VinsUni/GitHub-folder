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

	@Override
	public double getCosto() {
		return 0.25;
	}

	@Override
	public String toString() {
		return "Moto " + super.toString();
	}

}
