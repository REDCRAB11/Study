package loop;

import java.util.Scanner;

public class Test04_1 {

	public static void main(String[] args) {
		
		
		//풀이 ~ 
		
		//준비 
		Scanner sc = new Scanner(System.in);
		System.out.println("분: ");
		int min = sc.nextInt(); 
		System.out.println("초: ");
		int sec = sc.nextInt(); 
		
		//계산 
		int total = min * 60 + sec; 
//  	System.out.println("total =" + total);
		
		//출력 
		
		for(int i =total; i >=0; i--) {
			
		//	System.out.println("?분 ?초 남았습니다.");
			System.out.println(i/60 + "분 남았습니다." + i%60 + "초 남았습니다.");
		}
		
		
		
		
		
		
		
		
	
		
	}

}
