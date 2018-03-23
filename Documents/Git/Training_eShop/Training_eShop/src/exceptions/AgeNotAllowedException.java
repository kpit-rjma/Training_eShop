package exceptions;

/**
 * Class for AgeNotAllowedException
 * Thrown when the date is in the past
 * @author Rachel
 *
 */
@SuppressWarnings("serial")
public class AgeNotAllowedException extends Exception {
	
	/**
	 * Empty/Parameterless Constructor
	 */
	public AgeNotAllowedException() {}
	
	/**
	 * Constructor with message
	 * @param message
	 */
	public AgeNotAllowedException(String message) {
		super(message);
	}
	
	/**
	 * Constructor with cause
	 * @param cause
	 */
	public AgeNotAllowedException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Constructor with message and cause
	 * @param message
	 * @param cause
	 */
	public AgeNotAllowedException(String message, Throwable cause) {
		super(message, cause);
	}
	
}