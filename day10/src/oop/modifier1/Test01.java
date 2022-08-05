package oop.modifier1;

public class Test01 {

	public static void main(String[] args) {
	
		Student a = new Student("홍길동", 50);
		
//		a.score = 50;  접근 불가 ! 
		a.setScore(-18); // 접근 가능 ! (사용 가능 ~)
		
		a.vet();

	}

}
