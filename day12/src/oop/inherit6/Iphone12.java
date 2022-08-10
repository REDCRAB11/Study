package oop.inherit6;

public class Iphone12 extends Phone3i {
	
	public Iphone12(String number, String color) {
		super(number, color);
	}

	public void itunes() {
		System.out.println("IPhone12 아이튠즈 기능 실행");
	}
	public void call() {
		System.out.println("IPhone12  전화 기능 실행");
	}
	
	public void sms() {
		System.out.println("IPhone12  문자 기능 실행");
	}

}
