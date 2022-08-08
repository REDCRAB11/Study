package oop.keyword5;

public class Galaxy22 {	
	//field:: 제조사, 색상, 번호, 용량 
	private String company; 
	private String color;
	private String number;
	private int memory;
	
	//메소드
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	
	//생성자 
	public Galaxy22(String color, String number, int memory) {
		this.company = "삼성";
		this.color = color;
		this.number = number;
		this.memory = memory;
	}
	
	public void print() {
		System.out.println(this.company);
		System.out.println(this.color);
		System.out.println(this.number);
		System.out.println(this.memory);
		System.out.println();
	}
}
