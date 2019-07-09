package matrixcustomhandlers;

public class InvalidInputException extends Exception {
	public InvalidInputException(String wrongInput) {
		super (wrongInput);
	}
}
