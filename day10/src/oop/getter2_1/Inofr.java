package oop.getter2_1;

public class Inofr {

	//field
	String name;
	String list;
	int score;
	int check;
	
	
	void vet() {
		System.out.println("<시험 결과>");
		System.out.println("이름: " + this.name);
		System.out.println("과목: " + this.list);
		System.out.println("서술형 점수: " + this.score + "점");
		System.out.println("평가자 체크 리스트 점수: " + this.check + "점");
		System.out.println("결과: " + this.getPass());
		System.out.println();
		
	}
	
	
	void setName(String name) {
		this.name = name;
	}
	
	void setList(String list) {
		this.list = list;
	}
	
	void setScore(int score) {
		if(score >= 0 && score <=100) {
			this.score = score;			
		}
	}
	
	void setCheck(int check) {
//		if(check < 0 || check > 100) 0점 미만 또는 100점 초과 
		if(!(check >= 0 && check <= 100)) { //0점 이상 100점 이하가 아니면 
		return;
	}
		this.check = check;
	}
	
	
	//get 안쓰더라도 만들어라 ~  무조건 있어야 한다. 
	String getName() {
		return this.name;
	}
	
	String getList() {
		return this.list;
	}
	
	int getScore() {
		return this.score;
	}
	
	int getCheck() {
		return this.check;
	}

	
	//가상의 getter 
	
	int getTotal() {
		return this.score + this.check;
	}
	
	double getAvg() {
//		return( this.score + this.check )/2.0;
		return this.getTotal()/2.0;
	}

	String getPass() {
		if(this.score >= 40 && this.check >=40 && this.getAvg() >=60) {
			return "통과";
		}
		else{
			return "재평가";
		}
	}

	
	//constructor 위치는 상관 없 위에 있든 가운데 있든 .. 
	Inofr(String name, String list, int score, int check){
		this.setName(name);
		this.setList(list);
		this.setScore(score);
		this.setCheck(check);	
	}
	
	
}
