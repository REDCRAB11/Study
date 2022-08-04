package oop.method4;

public class Infor {
	
	String name;
	String list; 
	int price;
	String event;
	
	void set(String name, String list, int price, String event) {
		this.name = name;
		this.list = list;
		this.price = price; 
		this.event = event;
	}
	
	void vet() {
		
		System.out.println("메뉴: " + name);
		System.out.println("분류: " + list);
		System.out.println("가격: " + price+ "원");
		System.out.println("행사여부: " + event);
		System.out.println();
		
	}
	
	

}
