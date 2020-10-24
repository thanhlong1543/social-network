package tp.kits3.ambi.exception;

@SuppressWarnings("serial")
public class EmailExistsException extends Throwable {
	
	public EmailExistsException(String message) {
		super(message);
	}
}
