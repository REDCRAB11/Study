package oop.inherit8;

public class Test01 {

	public static void main(String[] args) {
		Warrior a = new Warrior("짜장면");
		a.attack();
		a.move();
		a.vet();
		
		System.out.println();
		
		Magician b = new Magician("짬뽕");
		b.attack();
		b.move();
		b.vet();
		
		System.out.println();

		Elf c = new Elf("울면");
		c.attack();
		c.move();
		c.vet();
		

	}

}
