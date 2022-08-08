package oop.keyword8;

public class Test01 {
	//final - "마지막"임을 의미하는 키워드 
	// - 변수에 붙든, 메소드에 붙든, 클래스에 붙든 아무튼 더이상은 없다는 뜻 
	public static void main(String [] args) {
		
		final int a;
		
		a = 10;
//		a = 20; // error 두번 이상의 초기화 금지 
		
		System.out.println(a);
		
	}
}
