package oop.stter1;

public class Car {
	
	//field
	String name; 
	int speed; 
	int passenger;
	int price; 

	//setter method
	// - 이름을 지을 때 set + 변수명으로 작성 
	
	void setName(String name) {
		this.name = name; 
	}
	
	void setSpeed(int speed) {
		if(speed >0) { 
		this.speed = speed; 
	   }		
	}
	
	void setPassenger(int passenger) {
		// 1. passenger 0보다 클 경우에만 설정하세요.
//		if(passenger > 0) {
//			this.passenger = passenger;
//		}
		// 2. 만약에 passenger 0 이하라면..? 
		// - retrun은 메소드를 종료하는 명령 
		// - 조건이 많아지면 좋다 ~ 
		if(passenger <= 0 ) {
			return;
		}
	}
	
	void setPrice(int price) {
		if(price > 0 ) {
			return;
		}
		
//		if(price > 0) {
//			this.price = price; 
//		}
//		
		
	}
	
	void vet() {
		System.out.println(this.name);
		System.out.println(this.speed);
		System.out.println(this.passenger);
		System.out.println(this.price);
		
	}
	
	Car(String name, int speed, int passenger, int price){
		this.setName(name);
		this.setSpeed(speed);
		this.setPassenger(passenger);
		this.setPrice(price);
	}
}
