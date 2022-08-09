package oop.inherit6_1;

public class IPhone13 extends IPhone {

	public IPhone13(String number, String color) {
		super(number, color);
	}
	
	public void faceTime() {
		System.out.println("아이폰13의 페이스타임 기능 실행");
	}
	
	@Override
	public void call() {
		System.out.println("아이폰13의 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("아이폰13의 문자 기능 실행");
	}
	
	@Override
	public void siri() {
		System.out.println("아이폰13의 음성인식 기능 실행");
	}

}
