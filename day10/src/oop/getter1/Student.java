package oop.getter1;

public class Student {
	
	//field
	String name; 
	int score; 
	
	//method
	void vet() {
		System.out.println(this.name);
		System.out.println(this.score);
		System.out.println(this.getResult());
	}
	
	// setter method
	void setName(String name) {
		this.name = name;
	}
	
	//void : 결과 없음 
	void setScore(int score) {
		if(score >=0 && score <= 100) {
		this.score = score; 
		}
	}
	
	//getter method: 값을 반환하는 메소드 
	// - 메소드는 실행 후 남겨지는 값을 이름 옆에 명시 
	// - 없으면 void로 작성해야함 
	String getName() {
//		return; 그냥 중지 
//		return  ??;   값을 반환하면서 중지 
		return this.name;
	}
	
	int getScore() {
		return this.score;
	}
	
	// - 가상의 항목에 대한 getter

	String getResult() {
		if(this.score >= 60) {
			return "합격";
		}
		else{
			return "불합격";
		}
	}
	
	
	
	//constructor
	Student(String name, int score){
		this.setName(name);
		this.setScore(score);
	}

}
