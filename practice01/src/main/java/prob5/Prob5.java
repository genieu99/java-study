package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		for (int i = 1; i < 100; i++) {
			int a = i / 10;
			int b = i % 10;
			int clap = 0;
			
			if (a == 3 || a == 6 || a == 9) {
				clap++;
			}
			if (b == 3 || b == 6 || b == 9) {
				clap++;
			}
			
			if (clap > 0) {
				System.out.print(i);
			}
			
			if (clap == 2) {
				System.out.println(" 짝짝");
			}
			else if (clap == 1) {
				System.out.println(" 짝");
			}
		}
	}
}
