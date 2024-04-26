package exception;

@SuppressWarnings("serial")
public class MyException extends Exception {
	public MyExcepiton(String message) {
		super(message);
	}
	
	public MyException() {
		super("MyException Thrown");
	}
}
