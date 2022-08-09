package oop.inherit2;

// 상위(슈퍼, 부모) 클래스 
// - 여러 클래스에서 공통적으로 발생하는 코드(필드, 메소드 등)들을 보관하는 클래스 
// - 객체를 만드는 것이 목적이 아님 
public class Phone {

	//공용 필드 
	private String color; 
	private String number; 
	
	//공용 메소드 
	public void call() {
		System.out.println("통화 기능");
	}
	
	public void camera() {
		System.out.println("카메라 기능");
	}
}
