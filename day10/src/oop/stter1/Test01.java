package oop.stter1;

public class Test01 {

	public static void main(String[] args) {
		
		Car a = new Car();
		
//		(문제점) 변수는 이상데이터 지가 불가
//		a.name= "아반떼";
//		a.speed = 200;
//		a.passenger = 4; 
//		a.price = 150000000; 
		
//		(해결책) 메소드는 필터링이 가능 
		a.setName("아반떼");
		a.setSpeed(200);
		a.setPassenger(4);
		a.setPrice(15000000);
		
		a.vet();

		
	}

}
