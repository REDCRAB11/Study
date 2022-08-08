package oop.getter3;

public class Leap {

	//필드 
	String name; 
	int grade; 
	int kor;
	int eng;
	int mat;
	
	//메소드 
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getGrade() {
		return grade;
	}
	void setGrade(int grade) {
		this.grade = grade;
	}
	int getKor() {
		return kor;
	}
	void setKor(int kor) {
		this.kor = kor;
	}
	int getEng() {
		return eng;
	}
	void setEng(int eng) {
		this.eng = eng;
	}
	int getMat() {
		return mat;
	}
	void setMat(int mat) {
		this.mat = mat;
	}
	
	int getTotal() {
		return this.kor + this.eng +this.mat;
	}
	
	double getAvg() {
		return this.getTotal()/3;
	}
	
	String getPass() {
		if(this.getAvg() >= 90) {
			return "A";
		}
		else if(this.getAvg() >= 80) {
			return "B";
		}
		else if(this.getAvg() >= 70) {
			return "C";
		}
		else {
			return "F";
		}
	}
	
	void vet() {
		System.out.println(this.name);
		System.out.println("학년: " + this.grade);
		System.out.println("국어: " + this.kor);
		System.out.println("영어: " + this.eng);
		System.out.println("수학: " + this.mat);
		System.out.println("총점: " + this.getTotal());
		System.out.println("평균: " + this.getAvg());
		System.out.println("등급: " + this.getPass());
		System.out.println();
	}
	
	//생성자
	Leap(String name, int grade, int kor, int eng, int mat) {
		this.setName(name);
		this.setGrade(grade);
		this.setKor(kor);
		this.setEng(eng);
		this.setMat(mat);
	}
	
	
	
	
}