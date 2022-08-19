package api.util.collection2;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test03_3 {
	public static void main(String[] args) {
		// day17 test03 풀이 ~ 
		
		Set<Integer> like = new TreeSet<>();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("번호: ");
			int number = sc.nextInt();
			if(number == 0) { //0을 어디에 넣는지 순서가 중요 // 0이 입력되면 종료  
				break;
			}
			
			if(like.contains(number)) {
				like.remove(number);
				System.out.println(number + "번호 게시글에 좋아요를 취소했습니다.");
			}else {
				like.add(number);
				System.out.println(number + "번호 게시글에 좋아요를 눌렀습니다.");
			}
			
		}
		sc.close();
		
		// 목록 출력
		System.out.println(like);
		
		// 개별 접근은 불가능하지만 전체를 다 추출하는 것은 가능하다. 
		// 1. Iterator이라는 별개의 저장소로 이동
			Iterator<Integer> iter = like.iterator(); 
			while(iter.hasNext()) {
				int number = iter.next(); // 저장하려면 ~ int로 바꿔서 저장 ㅋ 
				System.out.println(number);
			}
			
			
		// 2. 확장형 for 구문 사용 
			for(int number : like) { // 오른쪽 저장소 왼쪽이 저장할 변수 
				System.out.println(number);
			}
			
			
		// 3. 배열로 복사하거나 List로 복사  ## 비추천 메모리 낭비 심함 ~ 
		
	}
}
