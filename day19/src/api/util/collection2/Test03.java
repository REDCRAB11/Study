package api.util.collection2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test03 {
	public static void main(String[] args) {
		// day17 test03 풀이 ~ 
		
		Set<Integer> like = new TreeSet<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("번호: ");
		int number = sc.nextInt();
		
		sc.close();
		
		if(like.contains(number)) {
			like.remove(number);
			System.out.println(number + "번호 게시글에 좋아요를 취소했습니다.");
		}else {
			like.add(number);
			System.out.println(number + "번호 게시글에 좋아요를 눌렀습니다.");
		}
		
		
	}
}
