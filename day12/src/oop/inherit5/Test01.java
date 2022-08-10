package oop.inherit5;

public class Test01 {

	public static void main(String[] args) {
		Mp3 a = new Mp3();
		System.out.println("<MP3>");
		a.fileName();
		a.fileSize();
		a.execute();
		a.duration();
		a.forward();
		a.rewind();
		System.out.println();
		
		Avi b = new Avi();
		System.out.println("<AVI>");
		b.fileName();
		b.fileSize();
		b.execute();
		b.speed();
		b.forward();
		b.rewind();
		System.out.println();
		
		Ppt c = new Ppt();
		System.out.println("<PPT>");
		c.fileName();
		c.fileSize();
		c.execute();
		c.pageSize();
		c.information();
		System.out.println();
		
	}

}
