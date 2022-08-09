package oop.inherit1;

public class Galaxy22s {
	//field - 정보 
	private String color;
	private String number;

	
	//method(setter, getter 당연히 있어야함 근데 우선은 생략) - 기능
	public void call() {
		System.out.println("통화 기능");
	}
	
	public void camera() {
		System.out.println("카메라 기능");
	}

	public void samsungPay() {
		System.out.println("삼성 페이");
	}
}
// 핸드폰 만들기 공통부분을 따로 빼서 만들자 -- 클래스로 만들어서  -- 