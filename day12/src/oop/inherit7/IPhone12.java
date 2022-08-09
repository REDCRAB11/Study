package oop.inherit7;

public class IPhone12 extends IPhone{

	public IPhone12(String name, String color) {
		super(name, color);
	}

	
	// 상속받은 추상 메소드는 반드시 재정의를 해야한다. 
	@Override
	public void siri() {
		System.out.println("아이폰12 음성인식 실행");
	}

	@Override
	public void call() {
		System.out.println("아이폰12 전화 실행");
	}

	@Override
	public void sms() {
		System.out.println("아이폰12 문자 실행");
	}
	
	public void itunes() {
		System.out.println("아이폰12 아이튠즈 실행");
	}

}
