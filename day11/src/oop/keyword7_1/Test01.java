package oop.keyword7_1;

public class Test01 {

	public static void main(String[] args) {
		Leap.setRate(1.2);  //방법 1..  외부에서 직접 설정 
		
		Leap a = new Leap("유재석", 0.3, 5000000);
		Leap b = new Leap("강호동", 0.5, 3500000);
		Leap c = new Leap("신동엽", 0.2, 8000000);
		
		
		a.vet();
		b.vet();
		c.vet();
		
	}

}
