package oop.setter2;

public class Infor {
	
	String name; 
	int time; 
	int price; 
	String division; // boolean 은 두가지일때만 가능 얘는 3개 써야해서 불가능 
	
	void vet() {
		
		System.out.println("과정명:  " + this.name);
		System.out.println(this.time + "(총"+ time*30 + "시간)");
		System.out.println("수강료: " + this.price);
		System.out.println("방식: " + this.division);
		System.out.println();
	}
	
	
	void setName(String name) {
		this.name = name;
	}
	
	void setTime(int time) {// 30의 배수이거나 ,, 음수나 0이될 수는 없다. 
//		if(time > 0 && time % 30 ==0)
		if(time <=0) {
			return;
		}
		if(time % 30 != 0) {
			return;
		}
		this.time = time; 
	}
	
	void setPrice(int price) {
//		if(price >= 0) {
//			this.price=price;
//		}
		
		if(price < 0) {
			return;
		}
		this.price = price; 
		
	}
	
	//근데 이러면 스위치 문을쓰는 의미가 있을까?  ---> 옆에 어차피 온 오프 쓴다면?
	//if로는 문자열은  비교연산이  힘들다. (안될 경우 존재) 
	void setDivision(String division) {
		this.division = division;
		switch(division) {
		case "온라인":
		case "오프라인":
		case "혼합":
		}
	}
	
	Infor(String name, int time, int price, String division){
		this.setName(name);
		this.setTime(time);
		this.setPrice(price);
		this.setDivision(division);
	}
	
	
}
