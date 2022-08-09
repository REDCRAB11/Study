package oop.inherit3;

public class Test01 {

	public static void main(String[] args) {
		//상위 클래스는 객체 생성을 하지 않는다(추상적인 형태)
		// ex.. Internte a = new Internet(); 안됨 ^^ 
		
		Chrome a = new Chrome();
		
		System.out.println("<Chrome>");
		a.setUrl("www.Chrome.com");
		a.refresh();
		a.move();
		a.develop();
		a.chromeStroe();
		System.out.println();
		
		Edge b = new Edge();
		
		System.out.println("<Edge>");
		b.setUrl("www.Edge.com");
		b.refresh();
		b.move();
		b.fullScreen();
		System.out.println();

		
		Whale c = new Whale();
		
		System.out.println("<Whale>");
		c.setUrl("www.Whale.com");
		c.refresh();
		c.move();
		c.papago();
		c.naverSearch();
		System.out.println();

		
	
		
		
	}

}
