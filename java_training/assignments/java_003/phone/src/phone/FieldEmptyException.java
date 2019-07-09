package phone;

public class FieldEmptyException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FieldEmptyException (String errorMessage) {
		super(errorMessage);
	}
}
