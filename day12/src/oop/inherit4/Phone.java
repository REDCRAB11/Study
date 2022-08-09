package oop.inherit4;


//상위 클래스의 필드, 메소드, 생성자 구현 시 주의해야할 점
public class Phone {
	//필드 - 접근제한 
	// - private로 설정하면 자식 클래스에서도 접근이 불가! = (통제 가능) 
	// - protected로 설정하면 자식 클래스는 자유롭게 접근 가능. = (통제 불가)
//	private String number;   ---> 자식 클래스는 오류 !
	protected String number; 
	
	
	//메소드 - 재정의(Override) 여부
	// - 메소드에 final 키워드를 붙이면 재정의가 앞으로 영원히 불가능 
	public void test() {
		System.out.println("테스트");
	}
	
	//생성자 - 반드시 설정해야 할 필숙밧을 지정(상속받는 클래스에 제약이 생김)
	public Phone(String number) {
		this.number = number;
	}
	

}
