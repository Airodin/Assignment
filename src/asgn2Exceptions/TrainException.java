package asgn2Exceptions;

/**
 * A simple class for exceptions thrown by railway shunting and boarding operations.
 * 
 * @version 1.0
 * @author INB370
 */
@SuppressWarnings("serial")
public class TrainException extends Exception {
	/**
	 * Constructs a new TrainException object.
	 * 
	 * @param message - an informative message describing the cause of the problem
	 */
	
	public TrainException() {
		super();
	}
	
	public TrainException(String message) {
		super("Train Exception: " + message);
	}


}