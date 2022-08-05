package oop.getter3_1;

public class Test01 {

	public static void main(String[] args) {
		Leap a = new Leap("마리오", 1, 90, 80, 70);
		Leap b = new Leap("루이지", 1, 85, 85, 83);
		Leap c = new Leap("쿠파", 3, 70, 60, 55);

		a.vet();
		b.vet();
		c.vet();
	}

}
