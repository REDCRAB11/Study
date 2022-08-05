package oop.modifier2;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
	Leap a = new Leap();
		
	Scanner sc = new Scanner(System.in);
	
	System.out.println("이름: ");
	a.setName(sc.next());
//	String name = sc.next();
	
	System.out.println("학년: ");
	a.setNum(sc.nextInt());
//	int num = sc.nextInt();
	
	System.out.println("국어: ");
	a.setKor(sc.nextInt());		
//	int kor = sc.nextInt();
	
	System.out.println("영어: ");
	a.setEng(sc.nextInt());
//	int eng = sc.nextInt();
	
	System.out.println("수학: ");
	a.setMat(sc.nextInt());
//	int mat = sc.nextInt();
	sc.close();
	
//	Leap a = new Leap(name, num, kor, eng, mat);
	a.vet();
	
	}

}