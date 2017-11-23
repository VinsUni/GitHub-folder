package exceptions;

/**
 * 
 * @class Exception's class
 *
 */
public class IsFullException extends Exception {

	/**
	 * 
	 */
	private static final long SERIALVERSIONUID = 1L;

	/**
	 * @constructor
	 */
	public IsFullException() {
		super();
	}

	public IsFullException(String message) {
		super(message);
	}

}
