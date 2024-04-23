package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("숫자를 입력하시오: ");
		int number = scanner.nextInt();
		
		int sum = 0;
		
		if (number % 2 == 0) {
			for (int i = 0; i <= number; i++) {
				if (i % 2 == 0) {
					sum += i;
				}
			}
		}
		else {
			for (int i = 0; i <= number; i++) {
				if (i % 2 != 0) {
					sum += i;
				}
			}
		}
		
		System.out.print("결과 값 : ");
		System.out.print(sum);
		
		scanner.close();
	}
}
