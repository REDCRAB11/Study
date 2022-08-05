package oop.method7_1;

public class Test01 {

	public static void main(String[] args) {
		
		melon a = new melon();
		melon b = new melon();
		melon c = new melon();
		melon d = new melon();

		
		a.set("그떄 그 순간 그대로(그그그)", "WSG워너비", "WSG워너비 1집", 104250, 91835);
		b.set("보고싶었어", "WSG워너비", "WSG워너비 1집", 83127, 90805);
		c.set("LOVE DIVE", "IVE(아이브)", "LOVE DIVE", 64590, 174519);
		d.set("POP!", "나연(TWICE)", "IMNAYEON", 58826, 70313);

		a.vet();
		b.vet();
		c.vet();
		d.vet();

		
	}

}
