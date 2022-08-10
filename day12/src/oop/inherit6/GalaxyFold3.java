package oop.inherit6;

public class GalaxyFold3 extends Phone2s {
	
	public GalaxyFold3(String number, String color) {
		super(number, color);
	}

	public void iris() {
		System.out.println("갤럭시폴드3 홍채인식 기능 실행");
	}
	
	public void call() {
		System.out.println("갤럭시폴드3 전화 기능 실행");
	}
	
	public void sms() {
		System.out.println("갤럭시폴드3 문자 기능 실행");
	}

}
