package oop.keyword6;

public class Galaxy22 {	
	//field:: 제조사, 색상, 번호, 용량 
	// - 객체별로 관리되지 말아야 할 데이터에 스태틱 키워드를 붙인다. 
	// - 해당 스태틱 필드의 getter,setter도 스태틱 키워드를 붙인다. 
	// - this. 를 통한 스태틱 필드의 접근은 권장하지 않는다.(경고)
	private static String company;  // static이 붙으면 내것이 아니다 .. 전체의 것이 되어버려 ~ 
	private String color;
	private String number;
	private int memory;
	
	//메소드
	public static String getCompany() { // 나도 스태틱 
		return company;
	}
	public static void setCompany(String company) { // 나도 스태틱 
		Galaxy22.company = company;
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
		Galaxy22.company = "삼성";
		this.color = color;
		this.number = number;
		this.memory = memory;
	}
	
	public void print() {
		System.out.println(Galaxy22.company);
		System.out.println(this.color);
		System.out.println(this.number);
		System.out.println(this.memory);
		System.out.println();
	}
}
