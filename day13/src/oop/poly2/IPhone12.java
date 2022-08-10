package oop.poly2;

public class IPhone12 extends Phone {

	@Override
	public void camera() {
		System.out.println("아이폰12 사진촬영 기능 실행");
		
	}

	@Override
	public void gallery() {
		System.out.println("아이폰12 사진첩 기능 실행");
		
	}

	@Override
	public void call() {
		System.out.println("아이폰12 전화 기능 실행");
		
	}

	@Override
	public void sms() {
		System.out.println("아이폰12 문자 기능 실행");
		
	}

}
