package api.util.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Test04 {
	public static void main(String[] args) {
		//Map 전체 출력 
		// 1. Map의 Key만 보면 Set과 같다. 따라서 Map의 Key를 Set으로 변환한 뒤 출력 
		// 2. Map 내부에 Entry라는 중첩클래스가 존재하며 이 형태로 출력 
		//(참고) 전체 출력할 일은 흔지 않다. 
		
		Map<String, Integer> people = new HashMap<>();
		
		people.put("유재석", 50);
		people.put("박명수", 51);
		people.put("정형돈", 44);
		people.put("하하", 42);
		people.put("노홍철", 43);
		
		// 1
		Set<String> set = people.keySet(); // Map<K,V> -> Set<k>
		for(String name : set) {
			int age = people.get(name);
			System.out.println("이름: " + name + "|| 나이: " + age);
		}
		
		System.out.println();
		
		//2
		for(Map.Entry<String, Integer> entry : people.entrySet()) {
			String name = entry.getKey();
			int age = entry.getValue();
			System.out.println("이름: " + name + ", 나이: " + age);
		};
		
		
	}
}
