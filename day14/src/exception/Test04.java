package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		//예외(exception)를 통합 처리 했을 때 무슨 작업을 해야하는가? 
		
		try { // 아무 문제 없을 떄 실행될 코드 (plan b)
			Scanner sc = new Scanner(System.in);
			System.out.println("술값: ");
			int total = sc.nextInt();
			
			System.out.println("인원: ");
			int people = sc.nextInt();
			
			sc.close();
			
			int price = total / people;
			int etc = total % people;
			
			System.out.println("1인당 " + price + "원");
			System.out.println("자투리 " + etc + "원");			
		}
		catch(Exception e) {
//			System.err.println("에러발생");
//			System.err.println(e); // 예외 정보가 담긴 객체 
//			System.err.println(e.getClass()); // 예외 클래스 정보 
//			System.out.println(e.getMessage()); // 예외 메세지 정보 (사용자에게 보여줄만한 정보 ,, 없을 수도 있음)
//			구분을 원한다면 인스턴스오브 대신 캐치를 하나 더 만드는 것이 좋다 
			if(e.getMessage() == null) {
				System.out.println("오류 발생");
			}
			else {
				System.out.println("오류 발생: " + e.getMessage());
			}
			//예외 처리를 하지 않은 것처럼 stack trace를 출력하고 싶을 수도 있다. 
			// -> 개발이 끝나면 삭제 
			e.printStackTrace(); //원상복귀 ! 
		}
	
	}
			}
