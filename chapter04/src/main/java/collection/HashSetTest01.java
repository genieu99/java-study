package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest01 {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		
		String s1 = new String("둘리");
		
		s.add("둘리");
		s.add("마이콜");
		s.add("도우너");
		s.add(s1);
		
		System.out.println(s.size());
		System.out.println(s.contains(s1));  // 자료구조는 무조건 내용으로 확인 not 동질성
		
		// 순회
		for (String str : s) {
			System.out.println(str);
		}
		
		
	}

}
