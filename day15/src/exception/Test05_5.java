package exception;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test05_5 {

	public static void main(String[] args) {
		try { // Plan A  -- > 실패! --> Plan B로 강제예외 시켜 ~ (throw new E...()) 강제예외: 프로그램이 잡아내지 못하기에 내가 잡는것.. (특히 음수잡는거.. 왜 ? 인트에 음수가 나오면 잡기힘듬)

			Scanner sc = new Scanner(System.in);
			
			System.out.println("이름: ");
			String name = sc.next();
			if(!Pattern.matches("^[가-힣]{2,7}$", name)){
				// catch로 강제 이동하는 코드 
//				throw new Exception();
				throw new Exception("이름은 한글 2~7 글자로 작성해야 합니다.");

			}
			
			System.out.println("국어: ");
			int kor = sc.nextInt();
			if(kor < 0 || kor > 100) {
//				throw new Exception();
				throw new Exception("국어 점수는 0~100점으로만 설정 가능합니다. ");

			}
			
			System.out.println("영어: ");
			int eng = sc.nextInt();
			if(eng < 0 || eng > 100) {
//				throw new Exception();
				throw new Exception("영어 점수는 0~100점으로만 설정 가능합니다. ");
			}
			System.out.println("수학: ");
			int mat = sc.nextInt();
			if(mat < 0 || mat > 100) {
//				throw new Exception();
				throw new Exception("수학 점수는 0~100점으로만 설정 가능합니다. ");
			}
			
			sc.close();
			
			int total = kor + eng + mat;
			float avg = total/3f;
			
			System.out.println("이름: " + name + "점");
			System.out.println("총점: " + total + "점");
			System.out.println("평균: " + avg +"점");
		}
		
		catch(Exception e) { // Plan B
			if(e.getMessage() == null) {
				System.err.println("입력이 잘못되었습니다.");
			}else {
				System.err.println("오류: " + e.getMessage()); // 겟 메세지는 오류가 날때 오류가 나는 원인의 이름을 알려주는 것 ..
			}
			
		}
	}
}
