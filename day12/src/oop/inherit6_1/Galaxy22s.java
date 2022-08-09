package oop.inherit6_1;

public class Galaxy22s extends Galaxy {

	public Galaxy22s(String number, String color) {
		super(number, color);
	}
	
	public void bicby() {
		System.out.println("갤럭시22s의 음성 기능 실행");
	}

	@Override//annotation, 명찰 역할(바로 아래 있는 대상의 역할을 정의)
	public void samsungPay() {
		System.out.println("갤럭시22s의 삼성페이 기능 실행");
	}

	@Override
	public void call() {
		System.out.println("갤럭시22s의 통화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("갤럭시22s의 문자 기능 실행");
	}

	
}
