package oop.method3_1;

public class Test01 {

	public static void main(String[] args) {
		//수정에 강하다 ! 값이 달라도 괜찮음 
		
		Infor a = new Infor();
		Infor b = new Infor();
		Infor c = new Infor();
		
		a.set("피카츄", 90, 90, 85);
		b.set("라이츄", 80, 90, 85);
		c.set("꼬부기", 100, 90, 90);
		
		
		
		a.kor = 0; 
		
		
		a.vet();
		b.vet();
		c.vet();
	}

}
