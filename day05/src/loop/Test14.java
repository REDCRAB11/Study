package loop;

import java.util.Scanner;
import java.lang.*;
public class Test14 {

	public static void main(String[] args) {
//		사용자에게 숫자를 하나 입력받아 해당하는 숫자의 구구단을 출력합니다(ex : 5 입력시 구구단 5단 출력)
//
//		사용자는 출력된 구구단을 보고 정답을 입력하며 프로그램에서는 정답 여부를 판정하여 카운트를 합니다.
//
//		모든 문제가 출력되고 난 후 정답 개수와 오답 개수를 구하여 화면에 출력하세요
//
//		단 입력 : 5
//
//		5단 시작!
//		5 x 1 = ?
//		5 x 2 = ?
//		5 x 3 = ?
//		5 x 4 = ?
//		5 x 5 = ?
//		5 x 6 = ?
//		5 x 7 = ?
//		5 x 8 = ?
//		5 x 9 = ?

		

	
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력: ");
		int A = sc.nextInt(); 
		System.out.println(A + "단 시작!");
		
		int correct = 0;
		int incorrect = 0;		
		
		for(int i=1; i<=9; i++) {
		System.out.println(A + "X" + i);
		int B = sc.nextInt();
		System.out.println("는: " + B);

		
		if(A*i == B) {
			System.out.println("정답");
			correct++;
		}else{
			System.out.println("오답");
			incorrect++;

		}
		
		}
		
		System.out.println("정답 개수: " + correct);
	    System.out.println("오답 개수: " + incorrect);
	    sc.close();
	    
	    
	    
	}

}
