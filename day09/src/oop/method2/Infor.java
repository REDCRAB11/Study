package oop.method2;

public class Infor {

	String name;
	String list;
	String season;
	int gold;
	int silver;
	int bronze;
	
	void set(String name, String list, String season, int gold, int silver, int bronze) {
		this.name = name;
		this.list = list;
		this.season = season;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
	
	void print() {
		System.out.println("<선수정보>"+ "\n" +"이름: "  + this.name);
		System.out.println("종목: " + this.list);
		System.out.println("구분: " + this.season);
		System.out.println("금/은/동: " + gold + "/" + silver + "/" + bronze);
//		위에 처럼 써도 되고 밑에 처럼 써도 되지만 효율성은 위가 낫다. 
//		System.out.println("금메달: " + this.gold);
//		System.out.println("은메달: " + this.silver);
//		System.out.println("동메달: " + this.bronze);
	}
	
	
}
