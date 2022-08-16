package exception;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test05 {

	public static void main(String[] args) {
//		사용자에게 이름, 국어점수, 수학점수, 영어점수를 입력받아 총점과 평균을 구하는 프로그램을 만듭니다.
//		사용자가 입력을 잘못한 경우 잘못된 입력입니다. 처음부터 다시 진행해주세요. 라는 메세지를 출력하고 진행중인 프로그램을 종료합니다.
//		다음 상황에 해당하지 않으면 입력을 잘못한 것으로 간주합니다.
//		이름은 한글로 2글자 이상 7글자 이하로 작성해야 합니다.
//		점수는 모두 0점이상 100점 이하의 정수인 경우만 가능합니다.
//		입력이 정상적으로 진행된 경우에는 이름, 총점, 평균을 출력해주세요.
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("이름:");
			String name = sc.next();
			System.out.println("국어점수:");
			int kor = sc.nextInt();
			System.out.println("수학점수:");
			int mat = sc.nextInt();
			System.out.println("영어점수:");
			int eng = sc.nextInt();
			sc.close();
			int total = kor + mat + eng;
			double avg = total / 3.0; 
			
			String regex="^[가-힣]{2,7}$";
			boolean test = Pattern.matches(regex, name);
			
			boolean note = 0 <= kor && 100 <= kor;
			note &=  0 <= mat && 100 <= mat;
			note &=  0 <= eng && 100 <= eng;
			
			if(test&&note) {

					System.out.println("이름: " + name);
					System.out.println("총점: " + total);
					System.out.println("평균: " + avg);
					
			}else {
				System.out.println("잘못된 입력입니다. 처음부터 다시 진행해주세요.");
			}
		}
		catch(Exception e) {		
			System.out.println("잘못된 입력입니다. 처음부터 다시 진행해주세요.");
			System.exit(0);
		
		}
	}
}
