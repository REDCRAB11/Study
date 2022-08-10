package oop.inherit8_1;

public class Test01 {
	public static void main(String[] args) {
		Warrior a = new Warrior("테스트1");
		a.attack();
		a.move();
		a.print();
		
		Magician b = new Magician("테스트2");
		b.attack();
		b.move();
		b.print();
		
		Elf c = new Elf("테스트3");
		c.attack();
		c.move();
		c.print();
		
	}

}
