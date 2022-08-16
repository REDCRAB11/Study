package api.lang.etc;

public class Test02 {

	public static void main(String[] args) {
		//System 클래스 
		// - 외부 시스템 환경에 대한 도구 및 정보를 가진 클래스 
		// - 객체를 생성할 수 없으며 모든 필드, 메소드ㅏ static이다. 
		
		
		//필드 
		System.out.println("Hello"); // 표준 출력 통로 	
		System.err.println("Hello"); // 표준 에러 출력 통로 
		
		System.out.println(System.currentTimeMillis()); // 현재 시각 (기준시 이후의 ms) 
		
		//ex,, 1부터 1000까지 더하는데 얼마나 걸려요?
		
		//시간측정(a) 
		long A = System.currentTimeMillis();
		
		//--> 1부터 1000까지 더하는 코드 
		int total=0;
		for(int i=1; i<=100000000; i++) {
			total += 1;
		}
		
		//----> 시간측정(b)
		long B = System.currentTimeMillis();
		
		// 소요 시간 b-a
		System.out.println(B-A);
		
		//프로그램 강제종료 
		// - 종료하면서 시스템에게 종료 상태를 번호로 알려준다. 
		// - 0이면 아주 잘 종료되었다. 는 뜻 0을 제외한 나머지는 비정상적인 종료라는 뜻.. 
//		System.exit(0); 
//		System.out.println("이 메세지는 안나와요 ");
		
		//시스템 환경 정보 읽기 
		System.out.println(System.getProperties()); // 모든 정보
		System.out.println(System.getProperty("os.name")); //os.name 정보
		System.out.println(System.getProperty("java.specification.version")); // java 버전 확인
	}

}
