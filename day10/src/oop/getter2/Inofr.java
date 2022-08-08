package oop.getter2;


public class Inofr {
	//필드
	String name;
	String list;
	int socre1;
	int score2;
	
	//메소드
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getList() {
		return list;
	}
	void setList(String list) {
		this.list = list;
	}
	int getSocre1() {
		return socre1;
	}
	void setSocre1(int socre1) {
		this.socre1 = socre1;
	}
	int getScore2() {
		return score2;
	}
	void setScore2(int score2) {
		this.score2 = score2;
	}
	
	void vet() {
		System.out.println(this.name);
		System.out.println(this.list);
		System.out.println(this.socre1);
		System.out.println(this.score2);
		System.out.println(this.getTotal());
		System.out.println(this.getAvg());
	}
	
	int getTotal() {
		return this.socre1 + this.score2;
	}
	
	double getAvg() {
		return this.getTotal()/2.0;
	}
	
	String getPass() {
		if(this.socre1 >= 40 && this.score2 >= 40 && this.getAvg() >= 60) {
			return "통과";
		}
		else { 
			return "재평가";
		}
	}
	
	
	// 생성자
	Inofr(String name, String list, int socre1, int score2) {
		this.setName(name);
		this.setList(list);
		this.setSocre1(socre1);
		this.setScore2(score2);
		
	}

}
