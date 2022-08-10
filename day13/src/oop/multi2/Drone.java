package oop.multi2;

public class Drone extends Mos implements Electronic, Transportation, Flyable {

	@Override
	public void on() {
		System.out.println("드론의 전원을 켭니다.");
	}

	@Override
	public void off() {
		System.out.println("드론의 전원을 끕니다.");
	}

	@Override
	public void move() {
		System.out.println("드론이 이동합니다.");
	}

	@Override
	public void fly() {
		System.out.println("드론이 비행합니다.");
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
