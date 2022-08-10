package oop.inherit5;

public class File {

	protected String fileName; 
	protected String fileSize;
	protected String execute;
	
	
	//공용 메소드 
	
	public void fileName() {
		System.out.println("파일 이름 실행");
	}
	
	public void fileSize() {
		System.out.println("파일 크기 실행");
	}
	
	public void execute() {
		System.out.println("실행 기능 실행");
	}
}
