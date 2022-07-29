package loop;

import java.util.Scanner;

public class Test12 {

	public static void main(String[] args) {

		//일자를 기준으로 반복문을 구현
		
		int total=0; // 합계나 카운트나 둘다 0으로 시작한다. 
		int pushup = 3;
		for(int day=1; day<=30; day++) {
//			System.out.println(day +"일"+ day*3 +"-개"); 규칙이 쉬울때는 간단하고 좋음. 
			System.out.println(day +"일"+ pushup +"-개");
			total += pushup; //토달을 푸쉬업 개수만큼 증가시키세요. 순서가 중요하다.  
			pushup +=3;
			
		}
	
		System.out.println("총 개수:" + total);
		
		
	}

}
