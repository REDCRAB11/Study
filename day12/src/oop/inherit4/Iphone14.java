package oop.inherit4;

public class Iphone14 extends Phone{

	public void print() {//3개다 사용 가능 ~ 
		System.out.println("번호: " + number);
		System.out.println("번호: " + this.number);
		System.out.println("번호: " + super.number); // super는 정확히 부모 클래스라는 것을 알려주는 것 
	}
	
	//Phone의 test메소드를 재정의 하겠다. 
	// - 재정의는 원본과 동일하게 구현해야 한다. (원본은 사라진게 아니고 위로 덮어서 안보이는 것일 뿐) 
	// - 재정의가 가능하다는 것은 = 원한다면 내용을 고쳐서 사용할 수 있다. 
	public void test() {
		System.out.println("재정의한 테스트");
	}
	
	//부모 클래스에 생성자가 있다면 반드시 자식 클래스는 해당 생성자를 고려하여 생성자를 구현해야 한다. 
	public Iphone14(String number) {
		super(number); // 부모 클래스의 생성자로 number 를 전달 
	}
	
}
