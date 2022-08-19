package api.util.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test01 {
	public static void main(String[] args) {
		//Map<K,V> k: key 이름 v: value 값 
		//K(key)와 V(value)를 세트로 저장하는 저장소 
		// - K는 중복 불가, V는 중복 가능
		// - K만 보면 Set<K>와 같다. (Set에 value가 하나씩 붙어있는 형태)
		
		// ex, 이름과 나이를 저장하는 저장소 
		// k = 이름 v = 나이 
//		Map<String, Integer> people = new TreeMap<>(); 보통 해쉬를 많이 쓴다. 
		Map<String, Integer> people = new HashMap<>();
		
		// 추가 - .add() 데이터 1개 추가하는 명령 ,, 2개는 .put() 명령으로 추가하도록 설계 
		people.put("유재석", 50);
		people.put("박명수", 51);
		people.put("정준하", 51);
		people.put("정형돈", 44);
		people.put("하하", 42);
		
		people.put("하하", 44); // 중복된 key가 들어가면 value가 수정됨 
		
		// 검색 - .contains() 가 아니라 key,value 각각 존재 
		System.out.println(people.containsKey("노홍철"));
		System.out.println(people.containsValue(50));
		
		//삭제 - remove(k)
		people.remove("정준하");
		
		//추출 - 박명수 몇살인가?
		System.out.println(people.get("박명수"));
		System.out.println(people.get("노홍철"));
		
		//주의 = null이 나올 수 있는 상황이라면 원시형을 사용할 수 없다. 
		String name = "길";
//		int age = people.get(name);
		Integer age = people.get(name);
		System.out.println("나이: " + name);
		
		System.out.println(people);
		System.out.println(people.size());
		System.out.println(people.isEmpty());
				
		
		
		
		
	}
}
