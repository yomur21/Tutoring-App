package exceptions;


public class InvalidTutorException extends Exception{
	/*
	 * This exception is either thrown when a given course already has 5 tutors, or 
	 * when a B Level Tutor is trying to teach an advanced class.
	 */
	private String errorMessage;
	
	
	public InvalidTutorException(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	@Override
	public String getMessage() {
		return errorMessage;
	}
}
