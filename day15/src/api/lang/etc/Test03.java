package api.lang.etc;

import java.io.IOException;

public class Test03 {

	public static void main(String[] args) throws IOException {
		// Runtime 클래스 
		// - 객체를 하나만 만들어서 공유하는 방식(singleton 방식)
		// - 객체의 일관성을 유지할 수 있다. 
		// - 외부 환경에 명령을 전송할 수 있다. 
		
		if(System.getProperty("os.name").startsWith("맥 이름 쓰면됨")) {
//		Runtime run = new Runtime(); // 생성코드
			Runtime run = Runtime.getRuntime(); // 렌탈코드
//		run.exec("notepad"); // 외부환경에 노트패드라는 명령을 전송해라 근데 맥에서는 노트패드가 안열림ㅋ;; 
			run.exec("open -a TextEdit.app"); // 맥용			
		}
	}

}
