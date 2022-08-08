package oop.keyword3;

public class Carculator {
	//메소드를 1회성 계산이 가능한 구조로 변경하여 사용 
	
	// 스태틱 키워드를 붙이면 객체가 없어도 접근이 가능(탈객체 키워드)
	public static int getAnswer(int left, int right) {
		return left * right;
	}

}
