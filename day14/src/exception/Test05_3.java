package exception;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test05_3 {

	public static void main(String[] args) {
		try { // Plan A --> 실패 ---> Plan B 로 강제 예외 시켜 

			Scanner sc = new Scanner(System.in);
			
			System.out.println("이름: ");
			String name = sc.next();
//			if(name.length() <2 || name.length() > 7)  주석친거 두개는 글자수만일떄..! 
//			if(!(name.length() <2 && name.length() <=7))
			if(Pattern.matches("^[가-힣]{2,7}$", name)){
				System.err.println("잘못된 입력입니다. ");
				return; // system.exit(1); 이거도 됨 
			}
			
			System.out.println("국어: ");
			int kor = sc.nextInt();
			if(kor < 0 || kor > 100) {
				System.err.println("잘못된 입력입니다. ");
				return;
			}
			
			System.out.println("영어: ");
			int eng = sc.nextInt();
			if(eng < 0 || eng > 100) {
				System.err.println("잘못된 입력입니다. ");
				return;
			}
			System.out.println("수학: ");
			int mat = sc.nextInt();
			if(mat < 0 || mat > 100) {
				System.err.println("잘못된 입력입니다. ");
				return;
			}
			
			sc.close();
			
			int total = kor + eng + mat;
			float avg = total/3f;
			
			System.out.println("이름: " + name + "점");
			System.out.println("총점: " + total + "점");
			System.out.println("평균: " + avg +"점");
		}
		
		catch(Exception e) { // Plan B
			System.err.println("입력이 잘못 되었습니다.");
			
		}
	}
}
