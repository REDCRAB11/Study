package exception;

import java.util.regex.Pattern;

public class Student {
	//필드 
	private String name; 
	private int kor, eng, mat;
	
	//set 에만 ... !!!!!
	// throw : 예외를 발생시키는 코드 
	// throws
	// - 예외가 발생할 것이라고 셩고하는 코드 , 예외 전가 
	// - 예외 처리가 되어있지 않으면 호출이 불가한 메소드가 된다. 
	
	public String getName(){
		return name;
	}
	public void setName(String name) throws Exception {
		if(Pattern.matches("^[가-힣]{2,7}$", name)) {
			this.name = name;
		}else {
			throw new Exception("이름은 한글 2~7자로 작성하세요.");}
		}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) throws Exception {
		if(kor < 0 || kor > 100) {
			//return;
			throw new Exception("국어점수는 0~100점으로만 설정 가능합니다.");
		}
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) throws Exception {
		if(eng < 0 || eng > 100) {
			//return;
			throw new Exception("영어점수는 0~100점으로만 설정 가능합니다.");
		}
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) throws Exception {
		if(mat < 0 || mat > 100) {
			//return;
			throw new Exception("수학점수는 0~100점으로만 설정 가능합니다.");
		}
		this.mat = mat;
	}
	public Student () {}
	public Student(String name, int kor, int eng, int mat) throws Exception {
		this.setName(name);
		this.setKor(kor);
		this.setEng(eng);
		this.setMat(mat);
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + "]";
	}

}
