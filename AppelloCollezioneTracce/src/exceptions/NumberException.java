package exceptions;

/**
 * 
 * @author Vincenzo Plantone 639371
 *
 */

/**
 * 
 * @class NumberException
 *
 */
public class NumberException extends Exception {

	/**
	 * static variable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public NumberException() {
		super();
	}

	/**
	 * 
	 * @param arg0
	 */
	public NumberException(String arg0) {
		super(arg0);
	}

}
