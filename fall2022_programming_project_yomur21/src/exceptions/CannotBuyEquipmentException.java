package exceptions;

public class CannotBuyEquipmentException extends Exception{

private String errorMessage;
	
/**
 * I will throw this exception when a student either already has an equipment,
 * or when a student cannot afford the equipment. It will print out an error
 * message that I specified in the Student class methods.
 */
	public CannotBuyEquipmentException(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	@Override
	public String getMessage() {
		return errorMessage;
	}
	
}
