package oop.inherit6_1;

public class GalaxyFold3 extends Galaxy {

	public GalaxyFold3(String number, String color) {
		super(number, color);
	}
	
	public void iris() {
		System.out.println("갤럭시폴드3 홍채 인식 기능 실행");
	}
	@Override//annotation, 명찰 역할(바로 아래 있는 대상의 역할을 정의)
	public void samsungPay() {
		System.out.println("갤럭시폴드3의 삼성페이 기능 실행");
	}

	@Override
	public void call() {
		System.out.println("갤럭시폴드3의 통화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("갤럭시폴드3의 문자 기능 실행");
	}


}
