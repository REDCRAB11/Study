package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		//예외(exception)의 종류가 너무 많은데 통합하여 처리할수는 없나?
		
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
//		catch(RuntimeException e)
//		catch(Throwable e)
//		catch(Object e) 에러떠서 못 씀 
		catch(Exception e) {//캐치 네개에 대한 에 대한 플랜 비 
			System.err.println("에러발생");
		}
	
	}
			}
