package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		//예외(exception)
		// - 예상치 못한 돌발상황 
		// - java.util.InputMismatchException
		// - java.lang.ArithmeticException
		
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
		catch(InputMismatchException e) {//InputMismatchException에 대한 플랜 비 
			System.err.println("똑바로 입력해라");
		}
		catch(ArithmeticException e) {//ArithmeticException에 대한 플랜 비 
			System.out.println("사람이 왜 없어?");
		}
	}
			}
