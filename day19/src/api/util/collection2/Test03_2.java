package api.util.collection2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test03_2 {
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
	}
}
