package exception;

@SuppressWarnings("serial")
public class MyException extends Exception {
	public MyException(String message) {
		super(message);
	}
	
	public MyException() {
		super("MyException Thrown");
	}
}
