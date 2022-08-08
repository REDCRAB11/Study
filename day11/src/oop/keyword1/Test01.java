package oop.keyword1;

public class Test01 {
	public static void main(String[] args) {
		
		System.out.println((3*5));
		
		//간단한 계산에서는 객체지향으로 풀면 이렇게 많은 코드들이...
		Carculator c  = new Carculator(3,5);
		System.out.println(c.getAnswer());
	}

}
