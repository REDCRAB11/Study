package api.lang.etc;

public class Test01 {

	public static void main(String[] args) {
		// Math 클래스 
		// - 생성자가 없는(private) 클래스 
		//   1. 객체 생성을 아예 못하게 하려고 하는 경우 
		//     - 모든 필드 메소드가 static이다. 
		//   2. 객체를 내가 원하는 만큼만 만들려고 하는 경우(singleton 패턴)
		//     - 필드, 메소드 중에 static이 아닌 것이 있는 경우 
		
		//필드 
		System.out.println(Math.PI);
		System.out.println(Math.E); // exp 
		
		//메소드 
		System.out.println(Math.abs(10 - 20)); //절대값
		System.out.println(Math.max(10, 20)); //최대값
		System.out.println(Math.min(10, 20)); //최소값
		
		System.out.println(Math.pow(2, 10)); //2의 10승 

		double a = 1.5;
		System.out.println(Math.floor(a)); //버림 
		System.out.println(Math.round(a)); //반올림
		System.out.println(Math.ceil(a)); //올림 
		
		
	}

}
