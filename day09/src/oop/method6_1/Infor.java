package oop.method6_1;

public class Infor {
	
	
	String name; 
	String type; 
	int price; 
	boolean early;
	boolean event;
	
	//주의사항** 메소드 오버로딩은 형태까지 같은 경우는 불가능하다. 
	void set (String name, String type, int price) {
		this.set(name, type, price, false, false);
	}
	
	void set (String name, String type, int price, boolean early) {
		this.set(name, type, price, early, false);
	}
	
	
	void set (String name, String type, int price, boolean early, boolean event) {
		
		this.name = name;
		this.type = type;
		this.price = price;
		this.early = early; 
		this.event = event; 
		
	}
	
	void vet() {
		//새벽배송과 행사여부는 상품 정보 옆에 추가로 출력 
		System.out.println("<상품 정보>");
		if(this.early == true){ // ==true는 안써도 됨! )
			System.out.println("새벽배송");
		}
		if(this.event) {
			System.out.println("행사상품");
		}
		System.out.println();
		
		System.out.println("상품명: " + name);
		System.out.println("상품 분류: " + type);
		
		if(this.event) {
			int discountPrice = this.price * 90/100;
			System.out.println("할인 판매가: " + discountPrice + "원, 원래가격: "+ price);
		}
		else {
			System.out.println("판매가: " + price);
		}
		if(this.early) {
			System.out.println("(배송비 +2500원");
		}
		System.out.println();
		
//		System.out.println("새벽 배송: " + early);
//		System.out.println("행사 여부: " + event);
//		System.out.println();
		
	}
	
	
}
