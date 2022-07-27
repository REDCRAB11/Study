package data;

public class Test18 {

	public static void main(String[] args) {
	
		int a = 2000;
		int a1 = 2022-2000 +1;
		System.out.println(a1);
		
		int a2 = 20;
		a2 +=1;
		
		String b = "20세 이상이면 담배 구매가 가능합니다.";
		System.out.println(b);
		
		boolean c = a1 >= a2;
		System.out.println(c);
		
		System.out.println("//////////");
		
		
		// 풀이 ~~ 
		
		//한국식 나이는 태어난 해부터 현재까지의 숫자 개수 (= 두개의 숫자 사이의 개수 
		
		//준비 
		int year = 2000;
		int now= 2022;
		
		//계산 
		int age = now - year +1;
		System.out.println(age);
		
		boolean adult = age >=20;
		
		//출력 
		System.out.println(adult);
	
		
		//이름은 너무 간단하게 짓지 맙시다 ~~ 
		
		

	}

}
;