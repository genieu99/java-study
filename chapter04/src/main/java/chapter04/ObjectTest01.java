package chapter04;

public class ObjectTest01 {
	
	public static void main(String[] args) {
		Point point = new Point();
		
		Class klass = point.getClass();  //refrelection
		System.out.println(klass);
		
		System.out.println(point.hashCode());  // address 기반의 해싱
											   // address x
											   // reference x
		System.out.println(point.toString());  // getClass() + "@" + hashCode()
		System.out.println(point);
	}
}
