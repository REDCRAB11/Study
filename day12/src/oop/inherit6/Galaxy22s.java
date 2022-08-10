package oop.inherit6;

public class Galaxy22s extends Phone2s{

	public Galaxy22s(String number, String color) {
		super(number, color);
	}

	public void bixby() {
		System.out.println("갤럭시22s 음성인식 기능 실행");
	}

	public void call() {
		System.out.println("갤럭시22s 전화 기능 실행");
	}
	
	public void sms() {
		System.out.println("갤럭시22s 문자 기능 실행");
	}
	
}
