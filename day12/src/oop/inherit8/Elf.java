package oop.inherit8;

public class Elf extends Game{

	public Elf(String id) {
		super(id);
	}

	@Override
	public void attack() {
		System.out.println("엘프가 활로 공격합니다.");
		
	}

	@Override
	public void move() {
		System.out.println("엘프가 이동합니다.");
		
	}
	
	public void vet() {
		System.out.println("id: " + super.id);
		System.out.println("lv: " + super.lv);
	}

}
