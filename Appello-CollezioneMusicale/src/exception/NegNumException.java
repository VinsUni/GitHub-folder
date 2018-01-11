/**
 * 
 * @author Vincenzo Plantone - 639371
 * 
 */

package exception;

/**
 * 
 * @class NegNumException
 *
 */
public class NegNumException extends Exception {

	/**
	 * default exception serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor with no parameters
	 */
	public NegNumException() {
		super();
	}

	/**
	 * 
	 * @param arg0
	 */
	public NegNumException(String arg0) {
		super(arg0);
	}

}
