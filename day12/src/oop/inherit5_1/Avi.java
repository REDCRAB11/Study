package oop.inherit5_1;

public class Avi extends MediaFile {

	//생성자 - fileName뿐만 아니라 다른 항목들도 반드시 설정하게 구현하겠다.
	// - 배속을 설정하지 않으면 기본배속(x1)로 구현 
	public Avi(String fileName, long fileSize) {
		super(fileName);
		this.setFilesize(fileSize);
		this.setSpeed(1);
	}
	
	public Avi(String fileName, long fileSize, double speed) {
		super(fileName);
		this.setFilesize(fileSize);
		this.setSpeed(speed);
	}
	
	//고유 필드 , 메소드 
	private double speed;

	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		if(speed > 0) {
			this.speed = speed;			
		}
	}
	
	
}
