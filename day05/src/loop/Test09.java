package loop;

import java.util.Scanner;

public class Test09 {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	int num = sc.nextInt(); 
	int count = 0;
	
	for(int i=1; i<=num; i++) {
		if(num % i ==1 ) {
			count++;
		
		}
		
	}
	
	if(count ==2 ) {
		System.out.println("소수 입니다");
	}else {
		System.out.println("소수가 아닙니다.");
	}

	}

}
