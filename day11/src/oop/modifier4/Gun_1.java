package oop.modifier4;

public class Gun_1 { // 권총의 정보를 경찰에 넣지 말길! 역할 구분 명확하게 ~~ 
	//field 
	private int bullet; // 여기에 2를 써도 되지만,, setBullet과 2쓰는것에 대한 ㅊ ㅏ이를 알고 쓰셔 공부를 위히나..
	
	//setter, getter
	public void setBullet(int bullet) {
		if(bullet >0) {
			this.bullet = bullet;
		}
	}
	
	public int getBullet() {
		return this.bullet;
	}
	
	public void print() {
		System.out.println("권총에 남은 총알 수 " + this.bullet + "발");
	}
	
	public void fire() {
		if(bullet > 0) {
			this.bullet--;
			System.out.println("빵야!");
		} else {
			System.out.println("딸각!");
		}
	}
	
	//constructor
	public Gun_1(int bullet) {
		this.setBullet(2);
	}
	
}
