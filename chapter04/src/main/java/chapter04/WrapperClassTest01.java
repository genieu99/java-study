package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		// 직접 생성하면 힙상에 객체가 존재하게 된다.
		// 리터럴(literal)을 사용하면 JVM 안의 Constant Pool에서 관리하게 된다.
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		// Auto Boxing
		Integer j1 = 10;
		Integer j2 = 20;
		
		System.out.println(j1 == j2);
		System.out.println(j1.equals(j2));
		
		// Auto Unboxing
		int m = j1 + 10;
		// int m = j1.intValue() + 10;  // 위의 코드와 같음
	}

}
