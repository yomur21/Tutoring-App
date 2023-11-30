package exceptions;

public class InvalidTutoringCostException extends Exception{
	private String errorMessage;
	
	
	
	/**
	 * I will throw this exception when an A Level Tutor tries to set a tutoring
	 * cost less than 700 TL, and when a B Level Tutor tries to set a tutoring cost
	 * more than 1000 TL.
	 * 
	 */
	
	public InvalidTutoringCostException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	@Override
	public String getMessage() {
		return errorMessage;
	}
	
}
