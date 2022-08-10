package oop.multi1;

//interface - 다중 상속 전용 클래스 
// 	- 다중 상속에서 문제가 발생할 수 있는 요소들을 모두 제거한 클래스 
public interface Singer {
	// 필드 - 변수 생성 금지  상수만 가능(public static final이 자동 추가됨)
//	/*public static final이 자동으로 붙음*/ int a; 
	
	// 생성자  - 생성 금지(절대 만들면 안됨 ~~  어떠한 경우라도 ) 
//	public Singer() {}
	
	
	
	// 메소드 - 추상메소드만 가능(public abstract를 자동으로 생성)
	/*public abstract*/ void sing();
}
