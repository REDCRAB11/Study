package oop.multi2;

public class Airplane extends Mos implements Transportation, Flyable, Reserve {

	@Override
	public void reservation() {
		System.out.println("비행기를 예약합니다.");
	}

	@Override
	public void fly() {
		System.out.println("비행기가 비행합니다.");
	}

	@Override
	public void move() {
		System.out.println("비행기가 이동합니다.");
		
	


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