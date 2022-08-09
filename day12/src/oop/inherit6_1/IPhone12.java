package oop.inherit6_1;

public class IPhone12 extends IPhone {

	public IPhone12(String number, String color) {
		super(number, color);
	}
	
	public void itunes() {
		System.out.println("아이폰12의 아이튠즈 기능 실행");
	}

	@Override
	public void call() {
		System.out.println("아이폰12의 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("아이폰12의 문자 기능 실행");
	}
	
	@Override
	public void siri() {
		System.out.println("아이폰12의 음성인식 기능 실행");
	}
	

}
