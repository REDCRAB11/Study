package api.util.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test07_2 {

	public static void main(String[] args) {
		Set<String> a = Set.of("이상한 나라의 수학자","더 배트맨", "인민을 위해 복무하라", "블랙라이트");
		Set<String> b = Set.of("더 배트맨", "스파이더맨: 노웨이 홈","블랙라이트","우리가 사랑이라고 믿는 것");
		
		System.out.println("철수: " + a);
		System.out.println("영희: " + b);
		
		//Q. 둘다 본 영화 
		Set<String> c = new TreeSet<>();
		c.addAll(a);
		c.retainAll(b);
		System.out.println("둘 다 본 영화");
		for(String name : c ) {
			System.out.println("->" +name);
		}
		
		//Q. 한명만 본 영화 (철수 or 영희)
		// 1.(A U B) - (A N B) N은 교집합임;;
		Set<String> d = new TreeSet<>();
		d.addAll(a);
		d.addAll(b);
		d.removeAll(c);
		System.out.println("한 명만 본 영화 ");
		for(String name : d) {
			System.out.println("->" + name);
		}
		
		// 2.(A-B) U (B-A)
		Set<String> e = new TreeSet<>();
		e.addAll(a);
		e.removeAll(b);
		
		Set<String> f = new TreeSet<>();
		f.addAll(b);
		f.removeAll(a);
		
		Set<String> g = new TreeSet<>();
		g.addAll(e);
		g.addAll(f);
		System.out.println("한 명만 본 영화");
		for(String name : g) {
			System.out.println("->" + name);
		}
	}
}
