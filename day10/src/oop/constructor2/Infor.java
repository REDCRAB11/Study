package oop.constructor2;

public class Infor {
	
	
	//field
	String id; 
	String job;
	int level;
	
	//기본 생성자 
	// - 클래스는 객체를 만들기 위해 존재한다.
	// - 생성자를 안만들어도 하나는 만들어준다. 
	// - 마음에 안들면 다른 생성자를 만든다.
	// - 생성자끼리는 서로 몰아줄 수 있다. 
	// Infor(){}
	
	Infor(String id, String job){
		this(id, job, 1);
//		this.id = id;
//		this.job = job;
//		this.level = 1; 
		// 이거를 한쪽으로 몰아준다. 
	}
	
	// OR 
	
	
	Infor(String id, String job, int level) {
		this.id = id;
		this.job = job; 
		this.level = level;
	}

	void levelUp() {
		this.level++; 
		// 그외 추가 작업.. ~~ 
	}
	
	
	
	void vet() {
		
		System.out.println("아이디: " + this.id);
		System.out.println("직업: " + this.job);
		System.out.println("레벨: " + this.level);
		
//		if(this.level == 0) {
//			System.out.println("레벨: " + this.level + 1);
//		}else {		System.out.println("레벨: " + this.level);
//
//		} 이렇게 안해도 맨위처럼 만들면 된다. ! ! ! 
		
		System.out.println();
		
		
		
	}
}
