package oop.modifier4;

public class Test01 {

	public static void main(String[] args) {

		Leap a = new Leap("포돌이", "순경", "영등포경찰서");
		Leap b = new Leap("포순이", "경장", "당산파출소");
		Leap c = new Leap("포그리", "순경", "마포경찰서");

		
		a.shoot();
		a.shoot();
		
		b.shoot();
		
		c.shoot();
		c.shoot();
		c.shoot();

		
		a.vet();
		b.vet();
		c.vet();
	   
		
		
		
		
	}

}
