package oop.basic2;

public class Test01 {

	public static void main(String[] args) {

		System.out.println("FIFA 세계 축구 랭킹");
		System.out.println();
		
		Information a = new Information();

		a.rank = 1;
		a.state = "브라질";
		a.score = 1828.45;
		
		System.out.println(a.rank + "등");
		System.out.println(a.state);
		System.out.println(a.score + "점");
	
		System.out.println("--------------");
		
		Information b = new Information();
		
		b.rank = 2;
		b.state = "벨기에";
		b.score = 1823.42;
		
		System.out.println(b.rank + "등");
		System.out.println(b.state);
		System.out.println(b.score + "점");
		
		System.out.println("--------------");
		
		Information c = new Information();
		
		c.rank = 3;
		c.state = "프랑스";
		c.score = 1786.15;
		
		System.out.println(c.rank + "등");
		System.out.println(c.state);
		System.out.println(c.score + "점");
	
	
	}
}

