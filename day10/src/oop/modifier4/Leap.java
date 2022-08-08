package oop.modifier4;
import oop.modifier4.Gun;

public class Leap {

	 String name;
	 String position;
	 String space;
	 Gun g = new Gun(2);
	 
	 
	 
	 String getName() {
		 return name;
	 }
	 
	 void setName(String name) {
		 this.name = name;
	 }
	 
	 String getPosition() {
		 return position;
	 }
	 
	 void setPosition(String position) {
		 this.position = position;
	 }
	 
	 String getSpace() {
		 return space;
	 }
	 
	 void setSpace(String space) {
		 this.space = space;
	 }
	 
	 public void vet() {
		 
		 System.out.println("<경찰 근무 정보>");
		 System.out.println("이름: " + this.name);
		 System.out.println("직급: " + this.position);
		 System.out.println("근무지역: " + this.space);	
		 System.out.print("총 발사! ");
		 g.num();
		 System.out.println();
		 
	 }
	 
	public void shoot() {
		g.shoot();
	}
	


	
	 Leap(String name, String position, String space) {
		 
		 this.setName(name);
		 this.setPosition(position);
		 this.setSpace(space);
	 }
	 
	
}
