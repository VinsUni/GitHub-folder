/**
 * 
 * @author Vincenzo Plantone - 639371
 * 
 */

package exception;

/**
 * 
 * @class EmptyListException
 *
 */
public class EmptyListException extends Exception {

	/**
	 * default Exception serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor with no parameters
	 */
	public EmptyListException() {
		super();
	}

	/**
	 * 
	 * @param message
	 */
	public EmptyListException(String message) {
		super(message);
	}

}
