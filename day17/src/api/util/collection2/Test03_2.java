package api.util.collection2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test03_2 {

	public static void main(String[] args) {

//		사용자에게 글 번호를 입력받아 해당하는 번호의 게시물에 좋아요를 설정/해제하는 프로그램을 구현하세요
//
//		요구사항
//		사용자에게 글 번호를 입력받는다
//		글 번호를 Set을 이용하여 저장하거나 삭제하도록 구현한다
//		좋아요를 누른 적이 없는 글 번호가 입력된 경우 ?번 글에 좋아요를 눌렀습니다 출력 후 저장소에 번호를 저장한다
//		좋아요를 누른 적이 있는 글 번호가 입력된 경우 ?번 글에 좋아요를 취소했습니다 출력 후 저장소에서 번호를 제거한다
//		0을 입력하면 프로그램을 종료하고 종료 직전까지 좋아요를 누른 모든 게시글의 번호를 오름차순으로 출력한다.
		
		Scanner sc = new Scanner(System.in);
		Set<Integer> sns = new TreeSet<>();
		
		System.out.print("글 번호: ");
		int number = sc.nextInt(); 
		System.out.print("좋아요는 0번 해제는 1번");
		int like = sc.nextInt(); // 0: 좋아요 설정 1: 좋아요 해제 
		

		for(int i=0; i<number; i++) {
			// 글 번호 저장
			sns.add(number);
			// 글 번호 삭제 
			sns.remove(number);
			
			if(like == 0) {
				sns.add(like);
				System.out.println(number + "번 글에 좋아요를 눌렀습니다.");
			} else if(like == 1) {
				sns.add(like);
				System.out.println(number + "번 글에 좋아요를 취소했습니다.");
				sns.remove(number);
			}
			sc.close();
			System.exit(0);
		}
		
		
	}

}
