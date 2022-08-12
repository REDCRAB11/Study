package api.lang.etc;

public class Test04 {

	public static void main(String[] args) {
		//String 합성(StringBuffer, StringBuilder)
		// - 문자열 덧셈이 성능이 좋지 않은 이유는 문자열이 불변이기 때문 
		
		//별 생성 코드 
		
		//10개 
		long a = System.currentTimeMillis();
		String star = "*";
		for(int i=0; i<100; i++) {
			star +="*";
		}
		long b = System.currentTimeMillis();
		System.out.println(b-a);
		
	}

}
