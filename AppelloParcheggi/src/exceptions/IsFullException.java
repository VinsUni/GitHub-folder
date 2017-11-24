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
	private static final long serialVersionUID = 1L;

	/**
	 * @constructor
	 */
	public IsFullException() {
		super();
	}

	/**
	 * 
	 * @param message
	 */
	public IsFullException(String message) {
		super(message);
	}

}
