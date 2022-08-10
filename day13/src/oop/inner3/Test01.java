package oop.inner3;

public class Test01 {

	public static void main(String[] args) {
		// 추상 클래스는 객체 생성이 안된다. 
//		Button bt = new Button();
		
		//하지만, 추상 메소드만 익명 중첩 클래스로 해결해주면 객체 생성을 할 수 있다. 
		Button bt = new Button() {
			public void push() {
				System.out.println("버튼 클릭!");
			}
		};
		bt.push();
	}

}
