package exceptions;

public class CannotRegisterToCourseException extends Exception{

private String errorMessage;
	
	
/** I will throw this exception if the student cannot register to a course,
 * and I will give the reason as an errorMessage, which is specified in the Student
 * class methods.
 */
	public CannotRegisterToCourseException(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	@Override
	public String getMessage() {
		return errorMessage;
	}
}
