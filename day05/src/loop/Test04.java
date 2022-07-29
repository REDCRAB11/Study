package loop;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		
//		Scanner a = new Scanner(System.in);
//		
//		System.out.println("분을 입력하세요.");
//		int m = a.nextInt();
//		System.out.println("초를 입력하세요");
//		int s = a.nextInt();
//		
//		int mins = m * 60;
//		
//		int b = mins + s;
//		
//		
//		for(int i=130 ; i >=0 ; i--) {
//		
//			System.out.println(mins + "분");
//			System.out.println(s + "초");
//			
//		}
				
		
		System.out.println("//////////");
		
		
		
		
		//풀이 ~ 
		
		//준비 
		int min = 2; 
		int sec = 10; 
		
		//계산 
		int total = min * 60 + sec; 
		System.out.println("total =" + total);
		
		//출력 
		
		for(int i =total; i >=0; i--) {
			
		//	System.out.println("?분 ?초 남았습니다.");
			System.out.println(i/60 + "분 남았습니다." + i%60 + "초 남았습니다.");
		}
		
		
		
		
		
		
		
		
	
		
	}

}
