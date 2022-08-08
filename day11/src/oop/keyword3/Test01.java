package oop.keyword3;

public class Test01 {
	public static void main(String[] args) {
		
		//static 메소드는 아무데서나 클래스명만 알면 객체 없이 사용이 가능하다. 
		System.out.println(Carculator.getAnswer(3, 5));
		System.out.println(Carculator.getAnswer(4, 5));
	}
}
