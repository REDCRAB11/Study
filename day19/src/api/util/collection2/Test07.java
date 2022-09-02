package api.util.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test07 {
	public static void main(String[] args) {
	
		Set<String> c = new TreeSet<>();
		c.add("이상한 나라의 수학자");
		c.add("더 배트맨");
		c.add("인민을 위해 복무하라");
		c.add("블랙라이트");
		
		Set<String> h = new TreeSet<>();
		h.add("더 배트맨");
		h.add("스파이더맨: 노웨이 홈");
		h.add("블랙라이트");
		h.add("우리가 사랑이라고 믿는 것");
		
		// 철수와 영희가 둘다 본 영화 
		Set<String> both = new TreeSet<>();
		both.addAll(c);
		both.retainAll(h);
		System.out.println(both);
		
		//철수와 영희 중 한명만 본 영화 
		Set<String> one = new TreeSet<>();
		one.addAll(c);
		one.removeAll(h);
		System.out.println(one);
	}
}
