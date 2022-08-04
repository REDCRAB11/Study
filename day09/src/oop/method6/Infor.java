package oop.method6;

public class Infor {
	
	
	String name; 
	String list; 
	double price; 
	String deliver;
	String event;
	
	void set (String name, String list, double price, String deliver, String event) {
		
		this.name = name;
		this.list = list;
		this.price = price;
		this.deliver = deliver; 
		this.event = event; 
		
	}
	
	void vet() {
		
		System.out.println("상품명: " + name);
		System.out.println("상품 분류: " + list);
		System.out.println("판매가: " + price);
		System.out.println("새벽 배송: " + deliver);
		System.out.println("행사 여부: " + event);
		System.out.println();
		
	}
	
	
}
