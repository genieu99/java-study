package exception;

@SuppressWarnings("serial")
public class MyException extends Exception {
	public void MyExcepiton(String message) {
		super(message);
	}
	
	public MyException() {
		super("MyException Thrown");
	}
}
