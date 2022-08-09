package oop.inherit6_1;

public class IPhone extends Phone {

	public IPhone(String number, String color) {
		super(number, color);
	}
	
	public void siri() {
		System.out.println("?? 의 음성인식 기능 실행");
	}

}
