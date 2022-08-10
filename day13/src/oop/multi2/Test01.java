package oop.multi2;

public class Test01 {

	public static void main(String[] args) {
		Drone a = new Drone();
		a.on();
		a.off();
		a.move();
		a.fly();
		
		
		Airplane b = new Airplane();
		b.move();
		b.fly();
		b.reservation();
		
		Train c = new Train();
		c.move();
		c.reservation();
		
		Bus d = new Bus();
		d.move();
		
		Kickboard e = new Kickboard();
		e.on();
		e.off();
		e.move();
	}

}
