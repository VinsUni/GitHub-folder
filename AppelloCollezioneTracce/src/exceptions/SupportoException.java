package exceptions;

/**
 * 
 * @author Vincenzo Plantone 639371
 * 
 */

/**
 * 
 * @class SupportoException
 *
 */
public class SupportoException extends Exception {
	
	/**
	 * static variable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public SupportoException() {
		super();
	}

	/**
	 * 
	 * @param message
	 */
	public SupportoException(String message) {
		super(message);
	}

}
