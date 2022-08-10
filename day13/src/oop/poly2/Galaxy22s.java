package oop.poly2;

public class Galaxy22s extends Phone{

	@Override
	public void camera() {
		System.out.println("갤럭시22s 사진촬영 기능 실행");
		
	}

	@Override
	public void gallery() {
		System.out.println("갤럭시22s 사진첩 기능 실행");
		
	}

	@Override
	public void call() {
		System.out.println("갤럭시22s 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("갤럭시22s 문자 기능 실행");
		
	}

}
