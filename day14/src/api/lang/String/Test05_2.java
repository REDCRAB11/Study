package api.lang.String;

import java.util.Scanner;

public class Test05_2 {
	public static void main(String[] args) {
		// 준비
		String given ="바나나";
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println(given + " !쿵쿵따! ->");
			
			String input = sc.next();
			
			boolean good = given.charAt(given.length()-1) == input.charAt(0);
			// good good && input.lenght() == 3  이게 밑에랑 똑같은거 줄여서 그럼 
			good &= input.length() ==3;
			
			
			if(good) {
				given = input; // 제시어 교체 
				
			}else {	
				
				break;
			}
		}
		
		sc.close();	
		System.out.println("게임오버!");
		
	}

}
