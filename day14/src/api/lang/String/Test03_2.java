package api.lang.String;

import java.util.Scanner;

public class Test03_2 {
	public static void main(String[] args) {
		//준비
		Scanner sc = new Scanner(System.in);
		System.out.print("닉네임: " );
		String nickname = sc.next();
		
		//계산
		// 1. 글자수 - .length()
		boolean first = nickname.length() >= 2 && nickname.length() <= 10;
		
		//2. 운영자의포함 여부  - .indexOf()
//		System.out.println("indexOf= " + nickname.indexOf("운영자"));
//		System.out.println("lastindexOf= " + nickname.lastIndexOf("운영자"));
		boolean second = nickname.indexOf("운영자") ==-1;
		
		
		//출력
		if(first && second) {
			System.out.println("닉네임 설정 완료");
		}else {
			System.out.println("잘못된 닉네임 입니다.");			
		}
	}

}
