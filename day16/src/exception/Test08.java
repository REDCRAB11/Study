package exception;

import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("이름: "); String name = sc.next();
			System.out.println("국어:"); int kor = sc.nextInt();
			System.out.println("영어: "); int eng = sc.nextInt();
			System.out.println("수학: ");  int mat = sc.nextInt();
			
			Student s = new Student(name, kor, eng, mat);
			System.out.println(s.toString());
		}
		catch(Exception e) {
//			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
