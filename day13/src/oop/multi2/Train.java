package oop.multi2;

public class Train extends Mos implements Transportation, Reserve {

	@Override
	public void reservation() {
		System.out.println("기차를 예약합니다.");		
	}

	@Override
	public void move() {
		System.out.println("기차가 이동합니다.");
		
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
