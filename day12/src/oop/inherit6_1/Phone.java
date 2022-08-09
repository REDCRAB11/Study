package oop.inherit6_1;

public class Phone {
	
	protected String number;
	protected String color;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Phone(String number, String color) {
		this.number = number;
		this.color = color;
	}
	
	public void call() {
		System.out.println("?? 통화 기능 실행");
	}
	
	public void sms() {
		System.out.println("?? 의 문제 기능 실행");
	}
	

}
