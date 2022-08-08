package oop.keyword8;

// 목표: 한번 정해지면 절대로 크기가 변하지 않는 창(window) 만들기 
public class WIndow {
	// 객체가 생성되면 값이 무조건 들어가므로 final 항목의 오류가 발생한다. 
	
	// 1. 필드에 값을 직접 대입한다. 
//		private final int width = 640;
//		private final int height = 480;
	
	// 2. 모든 생성자에서 값을 초기화한다. 
        private final int width;
		private final int height;
		public WIndow(int width, int height) {
			this.width = width;
			this.height = height; 
			
		}
		
		//(주의) final 필드는 절대로 setter 메소드를 만들 수 없다. 
//		public void setWIdow(int width) {
//			this.width = width;
//		}
}
