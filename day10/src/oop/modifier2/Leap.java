package oop.modifier2;

public class Leap {

	//foeld(private)
	private String name;
	private int num;
	private int kor, eng, mat;

	void vet() {
		
		System.out.println(this.name);
		System.out.println("학년: " + this.num);
		System.out.println(this.kor + "점");
		System.out.println(this.eng + "점");
		System.out.println(this.mat + "점");
		System.out.println("총점: " + this.getTotal());
		System.out.println("평균: " + this.getAvg());
		System.out.println("등급: " + this.getGrade());
		System.out.println();
	}
	
	
	//method (public)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	public int getTotal() {
		return this.kor + this.eng + this.mat;
	}
	
	public double getAvg() {
		return this.getTotal()/3;
	}
	
	public String getGrade() {
		double avg = this.getAvg();
		if(avg >= 90) return "A";
		else if(avg >= 80) return "B";
		else if(avg >= 70) return "C";
		else return "F";
	}
	
	// constructor(public)
	public Leap(String name, int num, int kor, int eng, int mat) {
		super();
		this.setName(name);
		this.setNum(num);
		this.setKor(kor);
		this.setEng(eng);
		this.setMat(mat);
	}
	
	//기본생성자 
	public Leap() {}
	
	
}