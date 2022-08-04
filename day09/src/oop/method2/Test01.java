package oop.method2;

public class Test01 {

	public static void main(String[] args) {
		
		System.out.println("역대 한국인 올림픽 메달 보유 선수");
		System.out.println();
		
		Infor a = new Infor();
		
		a.set("진종오", "사격", "하계", 4, 2, 0);
		a.print();
		
		System.out.println();
		
		Infor b = new Infor();
		
		b.set("김수녕", "양궁", "하계", 4, 1, 1);
		b.print();
		
		System.out.println();
		
		Infor c = new Infor();
		
		c.set("전이경", "쇼트트랙", "동계", 4, 0, 1);
		c.print();
		
	}

}
