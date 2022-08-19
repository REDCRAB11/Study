package api.util.collection2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test07_1 {
	public static void main(String[] args) {
	
		List<String> c = new ArrayList<>();
		c.add("이상한 나라의 수학자");
		c.add("더 배트맨");
		c.add("인민을 위해 복무하라");
		c.add("블랙라이트");
		
		List<String> h = new ArrayList<>();
		h.add("더 배트맨");
		h.add("스파이더맨: 노웨이 홈");
		h.add("블랙라이트");
		h.add("우리가 사랑이라고 믿는 것");

		// 철수와 영희 둘다 다 본 영화 
		List<String> all = new ArrayList<>();
		all.addAll(c);
		all.addAll(h);
		System.out.println(all);
		
		// 철수와 영희가 둘다 본 영화 
		List<String> both = new ArrayList<>();
		both.addAll(c);
		both.retainAll(h);
		System.out.println(both);
		
		//철수와 영희 중 한명만 본 영화 
		List<String> one = new ArrayList<>();
		one.addAll(c);
		one.removeAll(h);
		System.out.println(one);
	}
}
