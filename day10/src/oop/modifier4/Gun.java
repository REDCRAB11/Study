package oop.modifier4;
import oop.modifier4.Leap;

public class Gun {

	public int bullet;

	public int getBullet() {
		return this.bullet;
	}

	public void setBullet(int bullet) {
		this.bullet = bullet;
	}

	public Gun(int bullet) {
		this.bullet = bullet;
	} 
	
	
	public void shoot() { 
		if(bullet == 0) {
			System.out.println("딸깍");
		}else {
			System.out.println("빵야");
			bullet--;
		}
		
	}
	

	public void num() {
		System.out.println("총알 개수: " + bullet + "개");
	}
	
}
