package oop.method4_1;

public class Infor {
	
	String name;
	String list; 
	int price;
	boolean event;
	
	void set(String name, String list, int price) {
		
//		method overlodaing: 같은 이름으로 메소드를 여러개 준비하는 것 
		this.set(name, list, price, false);
		
//		this.name = name;
//		this.list = list;
//		this.price = price;
//		this.event = false;
	}
	
	void set(String name, String list, int price, boolean event) {		
		this.name = name;
		this.list = list;
		this.price = price;
		this.event = event;
	}
	
	void vet() {
		System.out.println("<메 뉴 정 보>");
		System.out.println("메뉴: " + name);
		System.out.println("분류: " + list);
		System.out.println("가격: " + price+ "원");
		if(this.event == true){
			System.out.println("(***행사상품***)");
		}
		System.out.println();
		
	}
	
	

}
