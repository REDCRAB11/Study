package array;

import java.util.Scanner;

public class Test09 {

	public static void main(String[] args) {
//		사용자에게 숫자 5개를 입력받아 배열에 저장합니다
//		입력받은 모든 숫자를 출력합니다
//		입력받은 모든 숫자의 합계와 평균을 구하여 출력합니다

		
	Scanner sc = new Scanner(System.in);
	
	int[] user = new int[5];


	for(int i=0; i<user.length; i++) {
		
		user[i] = sc.nextInt();
		System.out.println("입력한 숫자: " + user[i]);
	}

	sc.close();
	
	int total = 0;
	for(int i=0; i<user.length; i++) {
		total += user[i];
	}
	
	System.out.println("total: " + total);
	
	double avg =(double)total/user.length;
	System.out.println("average: " + avg);
	
	}

}
