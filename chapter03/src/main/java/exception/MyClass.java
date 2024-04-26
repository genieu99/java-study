package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException, MyException {
		System.out.println("some code1...");
		System.out.println("some code1...");
		
		if (2 - 2 == 0) {
			throw new MyException();
		}
		
		if (1 - 1 == 0) {
			throw new IOException();
		}
		
		System.out.println("some code3...");
		System.out.println("some code4...");
	}
	
}
