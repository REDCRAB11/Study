package oop.modifier4;
import oop.modifier4.Gun_1;

public class Police {
	
	//field 
	private String name;
	private String rank;
	private String area;
	private Gun_1 gun; //!!
	
	
	//setter, getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}	
	public void print() {
		System.out.println("<경찰 정보>");
		System.out.println("이름: " + this.name);
		System.out.println("직급: " + this.rank);
		System.out.println("근무지: " + this.area);
		this.gun.print();
	}
	
	public void shoot() {
		System.out.println(this.name + "이 총을 발사합니다!");
		this.gun.fire();
	}
	
	
	//constructor
	public Police(String name, String rank, String area) {
		this.name = name;
		this.rank = rank;
		this.area = area;
		this.gun = new Gun_1(0);
		
	}

}
