package oop.inherit8_1;

public class Elf  extends Player {

	public Elf(String id, int level) {
		super(id, level);

	}

	public Elf(String id) {
		super(id);
	}

	@Override
	public void attack() {
		System.out.println("엘프가 공격합니다.");
		
	}

	@Override
	public void move() {
	System.out.println("엘프가 이동합니다.");
	}

}
