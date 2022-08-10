package oop.inner1;

//중첩 클래스(nested class)
// - 클래스 간의 소유관계를 표현 
// - 클래스 내부에서 사용할 객체 설계 


//종류 
// - 일반 중첩 클래스 중요 
// - static 중첩 클래스  중요 
// - 지역 중첩 클래스 xx 영원히 평생 안나옴 ㅋ;;
// - 익명 중첩 클래스 가장중요**** 
public class Police {
	private Gun gun;
	
	public Police() {
		this.gun = new Gun();
	}
	
	// private class Gun{} // 일반 중첩 클래스
	public static class Gun{} // static 중첩 클래스 
	

	public void print() {
		class Gun{} // 지역 중첩 클래스 몰라도됨 ~ ( 메소드 내부에서만 사용 가능)
	}
}
