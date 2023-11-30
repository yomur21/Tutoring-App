package exceptions;

public class InvalidPrereqException extends Exception{
	
	/**
	 * This exception will be thrown when an administrator tries to add
	 * an advanced course to the prerequisite list of a beginner course.
	 */
	
	
	@Override
	public String getMessage() {
		return "Invalid prerequisite! A beginner course cannot have an advanced course as a prerequisite.";
	}
}
