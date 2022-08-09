package oop.inherit5_1;

public class Test01 {

	public static void main(String[] args) {
		
		Mp3 a = new Mp3("test.mp3", 1L*1024L*1024L, 180);
		
		a.execute();
		a.forward();
		a.rewind();
		
		
		Avi b = new Avi("test.avi", 100L*1024L*1024L);
		
		b.execute();
		b.forward();
		b.rewind();
		System.out.println(b.getSpeed());
		
		Ppt c = new Ppt("test.pptx", 5L*1024*1024, 25);
		
		c.execute();
		c.information();
		
		
		
		
	}

}
