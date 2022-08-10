 package oop.inherit8;

public class Warrior extends Game {

	public Warrior(String id) {
		super(id);
	}

	@Override
	public void attack() {
		System.out.println("전사가 칼로 공격합니다.");
	}

	@Override
	public void move() {
		System.out.println("전사가 뛰어서 이동합니다.");
		
	}
	
	public void vet() {
		System.out.println("id: " + super.id);
		System.out.println("lv: " + super.lv);
	}

	
}
