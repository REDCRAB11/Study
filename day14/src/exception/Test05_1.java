package exception;

import java.util.Scanner;

public class Test05_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름: ");
		String name = sc.next();
		System.out.println("국어: ");
		int kor = sc.nextInt();
		System.out.println("영어: ");
		int eng = sc.nextInt();
		System.out.println("수학: ");
		int mat = sc.nextInt();
		
		sc.close();
		
		int total = kor + eng + mat;
		float avg = total/3f;
		
		System.out.println("이름: " + name + "점");
		System.out.println("총점: " + total + "점");
		System.out.println("평균: " + avg +"점");
	}
}
