package oop.inherit6;

public class Iphone13 extends Phone3i {
	
	public Iphone13(String number, String color) {
		super(number, color);
	}

	public void faceTime() {
		System.out.println("IPhone13 영상통화 기능 실행");
	}
	public void call() {
		System.out.println("IPhone13 전화 기능 실행");
	}
	public void sms() {
		System.out.println("IPhone13 문자 기능 실행");
	}

}
