package oop.multi2;

public class Kickboard extends Mos implements Electronic, Transportation {

	@Override
	public void move() {
		System.out.println("전동 킥보드가 이동합니다.");		
	}

	@Override
	public void on() {
		System.out.println("전동 킥보드 전원을 켭니다.");		
	}

	@Override
	public void off() {
		System.out.println("전동 킥보드를 끕니다.");
	}

	@Override
	public String drone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String airplane() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String train() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String bus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String kickboard() {
		// TODO Auto-generated method stub
		return null;
	}

}
