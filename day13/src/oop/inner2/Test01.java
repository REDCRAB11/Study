package oop.inner2;

public class Test01 {
	public static void main(String[] args) {
		Button bt1 = new Button();
		bt1.push();
		
		//익명 중첩 클래스 (anonymous nested class)
		// - 객체를 만들면서 즉석에서 클래스를 구성하여 특정 기능을 재정의한다. 
		// - 일회용 상속 효과가 발생ㅎㄴ다. 
		Button menu = new Button() {
			public void push() {
				System.out.println("메뉴 버튼 클릭");
		}
		
		};
	menu.push();

		Button exit = new Button() {
		public void push() {
			System.out.println("종료 버튼 클릭");
		}
		}; 
		exit.push();
	}
}

