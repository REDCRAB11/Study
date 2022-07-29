package loop;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		Scanner a = new Scanner(System.in);
		
		//Scanner를 안에 다 넣으면 에러난다.  도구는 반복문 에다 만들지 않는다. 
		System.out.println("5개의 숫자를 입력하세요");
		for(int i=0; i<5 ; i++) {
			int b = a.nextInt();
			a.close();
		}
		//클로즈 밖으로 뺴지말고 안에다 넣자. 에러는 안뜨지만 비추~
		
	//펄풱한 문제풀이 
		
		
	}

}
