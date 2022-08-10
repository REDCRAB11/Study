package oop.inherit8;

public class Magician extends Game {

	public Magician(String id) {
		super(id);
	}

	@Override
	public void attack() {
		System.out.println("마법사가 마법으로 공격합니다.");
		
	}

	@Override
	public void move() {
		System.out.println("마법사가 날아서 이동합니다.");
		
	}
	
	public void vet() {
		System.out.println("id: " + super.id);
		System.out.println("lv: " + super.lv);
	}
	
	

}
