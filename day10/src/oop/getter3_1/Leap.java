package oop.getter3_1;

public class Leap {

	String name;
	int num;
	int kor, eng, mat;
	
	void vet() {
		System.out.println("<성적 정보>");
		System.out.println("이름: " + this.name);
		System.out.println(this.num + "학년");
		System.out.println("국어: " + this.kor + "점");
		System.out.println("영어: " + this.eng + "점");
		System.out.println("수학: " + this.mat + "점");
		System.out.println("총점: " + this.getTotal() + "점");
		System.out.println("평균: " + this.getAvg() + "점");
		System.out.println("등급: " + this.getGrade() + "점");
		System.out.println();
	}
	
	void setName(String name) {
		this.name=name;
	}
	
	void setNum(int num) {
		this.num = num;
	}

	void setKor(int kor) {
		if(kor <0 || kor >100) return; //이렇게 써도 되는데 엥간하면 가로 치쇼 
		this.kor = kor;
	}
	
	void setEng(int eng) {
		if(eng < 0 || eng > 100 )return;
		{
		this.eng= eng;
		}
	}
	
	void setMat(int mat) {
		if(mat <= 100){
		this.mat = mat;
		}
	}
	
	String getName() {
		return this.name;
	}
	
	int getNum() {
		return this.num;
	}
	
	int getKor() {
		return this.kor;
	}
	int getEng() {
		return this.eng;
	}
	int getMat() {
		return this.mat;
	}
	
	int getTotal() {
		return this.kor+this.eng+this.mat;
	}
	float getAvg() {
		return this.getTotal()/3f;
	}
	
	String getGrade() {
		if(this.getAvg() >= 90) return "A"; // 가로가하나밖에 없을떄 리턴 옆에 붙이기 가능 
		else if(this.getAvg() >= 80) return "B";
		else if(this.getAvg() >= 70) return  "C";
		else return "F";
		
		//float average = this.getAvg();
		
		
	}
	
	
	Leap(String name, int num, int kor, int eng, int mat){
		this.setName(name);
		this.setNum(num);
		this.setKor(kor);
		this.setEng(eng);
		this.setMat(mat);
	}
	
}