package oop.inherit5;

public class Mp3 extends File {

	public void duration() {
		System.out.println("재생시간 초단위 실행");
	}
	public void forward() {
		System.out.println("빨리 감기 기능 실행");
	}
	public void rewind() {
		System.out.println("되감기 기능 실행");
	}
	
	public void fileName() {
		System.out.println("Mp3 파일 이름 실행");
	}
	public void fileSize() {
		System.out.println("Mp3 파일 크기 실행");
	}
	public void execute() {
		System.out.println("Mp3 실행 기능 실행");
	}
}
