package oop.inherit5_1;

public class MediaFile extends File {
	
	//생성자 - 부모 클래스(File)에서 파일명을 반드시 필요로 하므로 맞춰준다. 
	public MediaFile(String fileName) {
		super(fileName);		
	}

	//공용 필드 
	
	//공용 메소드
	public void forward() {
		System.out.println("빨리 감기 실행!");
	}
	public void rewind() {
		System.out.println("되감기 실행!");
	}
	
}
