package oop.multi1;

//(접근제한자) (final) class (이름) (extends 클래스) (implements 인터페이스1, 인터페이스2) 
public class Kim/*exstends*/ implements Singer, Magician{// 여러개 상속 받고 싶으면 ,(콤마) 찍으세요 

	@Override
	public void sing() {
		System.out.println("죽을만큼 보고싶다~");
	}
	public void show() {
		System.out.println("나와라 비둘기~ ");
	}

}
