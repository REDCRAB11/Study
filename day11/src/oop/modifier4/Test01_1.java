package oop.modifier4;

public class Test01_1 {

	public static void main(String[] args) {
		Police a = new Police("포돌이", "순경", "영등포경찰서");
		Police b = new Police("포순이", "경장", "당산파출소");
		Police c = new Police("포그리" , "순경", "마포경찰서");
		
		a.shoot();
		a.shoot();
		
		b.shoot();
		
		c.shoot();
		c.shoot();
		c.shoot();
		
		
		a.print();
		b.print();
		c.print();
	}

}
