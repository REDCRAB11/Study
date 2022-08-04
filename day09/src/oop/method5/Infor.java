package oop.method5;

public class Infor {	
	
	String name; 
	String telephone; 
	int price; 
	String month;
	
	void set(String name, String telephone, int price, String month) {
		
		this.name = name;
		this.telephone = telephone;
		this.price = price;
		this.month = month;	
	}
	
	void vet() {
		
		System.out.println("기종명: " + name);
		System.out.println("통신사: " + telephone);
		System.out.println("가격: " + price+ "만원");
		System.out.println("약정: " + month);
		System.out.println();
	}
	
	
	
}
