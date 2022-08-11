package api.lang.objects;

public class Test01 {

	public static void main(String[] args) {
		//Object 
		
		//객체 생성
		Object a = new Object();
		Object b = new Object();
		
		//필드 & 메소드 
		System.out.println(a.toString()); // a의 요약정보(16진수의 값 일련번호) 
		System.out.println(b.toString()); // b의 요약정보 
		
		System.out.println(a.hashCode()); // a의 일련번호(10진수의 값 일련번호 ,, 위의 a와 똑같음 ㅋ.. )
		System.out.println(b.hashCode()); // b의 일련번호
	}

}
