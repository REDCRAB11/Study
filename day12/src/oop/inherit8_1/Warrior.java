package oop.inherit8_1;

public class Warrior extends Player {

	public Warrior(String id) {
		super(id);
		}
	public Warrior(String id, int level) {
		super(id,level);
	}

	@Override
	public void attack() {
		System.out.println("전가사 공격합니다.");		
	}

	@Override
	public void move() {
		System.out.println("전사가 이동합니다.");		
	}

}
