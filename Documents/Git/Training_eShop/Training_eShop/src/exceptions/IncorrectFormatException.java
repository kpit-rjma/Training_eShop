package exceptions;

/**
 * Class for IncorrectFormatException
 * Thrown when the date is in the past
 * @author Rachel
 *
 */
@SuppressWarnings("serial")
public class IncorrectFormatException extends Exception {
	
	/**
	 * Empty/Parameterless Constructor
	 */
	public IncorrectFormatException() {}
	
	/**
	 * Constructor with message
	 * @param message
	 */
	public IncorrectFormatException(String message) {
		super(message);
	}
	
	/**
	 * Constructor with cause
	 * @param cause
	 */
	public IncorrectFormatException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Constructor with message and cause
	 * @param message
	 * @param cause
	 */
	public IncorrectFormatException(String message, Throwable cause) {
		super(message, cause);
	}
	
}