package oop.method3;

public class Infor {
	
	String name;
	int kor;
	int eng;
	int mat;
	double total; // int로 해도됩니덩 .
	double avg;
	
	void set(String name, int kor, int eng, int mat) {//토탈과 평균은 넣을 필요 없다. 가지고 있는 정보로 만들 수 있기 떄문. 
		
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.total = kor + eng + mat;
		this.avg = this.total/3.0; 
	}
	
	void vet() {
		System.out.println("<학생정보>" + " \n" + "이름: " + name);
		System.out.println("국어: " + kor + " 영어: " + eng + " 수학: " + mat);
		System.out.println("총점: " + total + "점");
		System.out.println("평균: " + avg + "점");
	}
	
	

}
