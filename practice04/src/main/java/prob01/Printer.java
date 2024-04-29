package prob01;

public class Printer {
//	public void println(int value) {
//        System.out.println(value);
//    }
//
//    public void println(boolean value) {
//        System.out.println(value);
//    }
//
//    public void println(double value) {
//        System.out.println(value);
//    }
//
//    public void println(String value) {
//        System.out.println(value);
//    }
	
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	public int sum(Integer... nums) {
		int s = 0;
		
		for (Integer n : nums) {
			s += n;
		}
		
		return s;
	}
	
	public <T> void println(T... ts) {
		for (T t : ts) {
			System.out.println(t);
		}
	}
}
