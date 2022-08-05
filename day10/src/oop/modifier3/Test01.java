package oop.modifier3;

import oop.modifier2.Leap;

public class Test01 {
	public static void main(String[] args) {

		// Q: 다른 패키기에 있는 내용을 사용할 수 있는가?
		// A: 그냥은 안된다. 자바는 기본 인식 범위가 패키지 이다. 
		// - import를 통해 외부 요소를 준비시켜 사용할 수 있다. 
		
		//(주의)
		// 1. public이 아니면 impor가 불가하다. 
		// 2. 구성요소들도 public이 아니면 접근이 불가 
		// 나중에 상속을 배우면 protected는 가능 
		Leap a = new Leap();
		
		a.vet();
		
		
		
	}

}
