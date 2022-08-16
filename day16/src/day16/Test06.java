package day16;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Test06 {
	public static void main(String[] args) {
	
		// try ! with 구문 (java 8+)
		// - 자동 close를 수행하는 try구문 
		// - 기존의 try구문에 resource를 선언하는 구역이 하나 더 추가되었다.  
		// - close()가 가능한 객체를 선언하면 자동으로 try 종료 시 close를 수행
		// - AutoClosable의 자식 클래스만 선언 가능 
		// - (주의) try 종료 후에도 사용하고 싶을 경우(close를 하기 싫은 경우) 사용하면 안됨..
		
	try	(//resource : 아무거나 안들어감;;; 
			Scanner sc = new Scanner(System.in);
//			Random r = new Random(); // 얘는 안됨; 
		){ 
		System.out.println("이름: ");
		String name = sc.next();
		if(!Pattern.matches("^[가-힣]{2,7}$", name)){
			throw new Exception("이름은 한글 2~7 글자로 작성해야 합니다.");
		}
		
		System.out.println("국어: ");
		int kor = sc.nextInt();
		if(kor < 0 || kor > 100) {
			throw new Exception("국어 점수는 0~100점으로만 설정 가능합니다. ");
		}
		
		System.out.println("영어: ");
		int eng = sc.nextInt();
		if(eng < 0 || eng > 100) {
			throw new Exception("영어 점수는 0~100점으로만 설정 가능합니다. ");
		}
		
		System.out.println("수학: ");
		int mat = sc.nextInt();
		if(mat < 0 || mat > 100) {
			throw new Exception("수학 점수는 0~100점으로만 설정 가능합니다. ");
		}
		
		int total = kor + eng + mat;
		float avg = total/3f;
		
		System.out.println("이름: " + name + "점");
		System.out.println("총점: " + total + "점");
		System.out.println("평균: " + avg +"점");
	}
	
	catch(Exception e) {
		if(e.getMessage() == null) {
			System.err.println("입력이 잘못되었습니다.");
		}else {
			System.err.println("오류: " + e.getMessage()); 
		}
		}
	}
}