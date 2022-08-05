package oop.setter2;

public class Test01 {

	public static void main(String[] args) {
		Infor a = new Infor("자바 마스터과정", 90, 1000000, "온라인");
		Infor b = new Infor("파이썬 기초", 60, 600000, "온라인");
		Infor c = new Infor("웹 개발자 단기완성", 120, 12000000,"오프라인");
		
		
		a.vet();
		b.vet();
		c.vet();
		
	}

}
