package loop;

import java.util.Scanner;

public class Test09_1 {

	public static void main(String[] args) {
	 
		//준비
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요:");
		int num = sc.nextInt(); 
		sc.close();
		
		int count = 0;
		
		
		
		//계산- 1부터 num까지의 숫자로 나누기를 시도. 
		for(int i=1; i<=num; i++) {
//	    System.out.println(num + "%" + i + " = " + num % i);
	    if(num%i == 0) {//num가 i로 나누어 떨어진다면
//	    	System.out.println("찾았다!");
	    	count++;
	    }
		}
		
//		System.out.println("count= " +  count);
		
		
		//출력

		if(count == 2) {
		System.out.println(num + " 소수입니다.");}
		else {
		System.out.println(num + "소수가 아닙니다.");}
		
		

	}

}
