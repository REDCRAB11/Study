package oop.method5_1;

public class Infor {	
	
	//필드
	String name; 
	String telephone; 
	int price; 
	int month;
	
	//메소드  몰아주기 일이적은곳에서 많은곳으로 
	void set(String name, String telephon, int price) {
		this.set(name, telephon, price, 0);
	}

	void set(String name, String telephone, int price, int month) {
		
		this.name = name;
		this.telephone = telephone;
		if(price >=0) {
			this.price = price;	
		}	
		
		switch(month) {
		case 0:
		case 24:
		case 30:
		case 36:
		this.month = month;
		}
	}
	
	void vet() {
		
		if(this.month > 0) {//약정기간이 있는 경우
			
			int priceperMonth = this.price/this.month;
			
			System.out.println("<휴대폰 정보>");
			System.out.println("기종명: " + name);
			System.out.println("통신사: " + telephone);
			System.out.println("가격: " + price+ "만원"+"(월" + priceperMonth + "만원)");
			System.out.println();
		}
		else {// 약정기간이 없는 경우
			
			int discountPrice = this.price * 95 /100;
			
			System.out.println("<휴대폰 정보>");
			System.out.println("기종명: " + name);
			System.out.println("통신사: " + telephone);
			System.out.println("가격: " + discountPrice + "만원" + "(원래 가격: " + price + "만원)");
			System.out.println("약정없음");
			System.out.println();
		}
	

	}
	
	
	
}
