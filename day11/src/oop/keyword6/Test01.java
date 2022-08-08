package oop.keyword6;

public class Test01 {

	public static void main(String[] args) {
		// 휴대폰 생성
		Galaxy22 a = new Galaxy22("아쿠아블루", "010-1234-1234", 256);
		Galaxy22 b = new Galaxy22("실버", "010-5678-5678", 512);
		
		a.setMemory(512); //a의 메모리를 512 교체
		a.setNumber("010-1234-4321"); // a의 번호 교체 
		a.setColor("블랙"); // a의 색상 변경 // 위의 세개는 개별 관리 항목 ~! 
//		a.setCompany("애플"); // a의 제조사를 교체?? 교체될거면 다같이 하거나 아예 안하거나 ! ! 그래서 일괄 관리 항목의 경우에 static을 붙인다. 
		Galaxy22.setCompany("애플");
		
		a.print();
		b.print();
	}

}
