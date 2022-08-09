package oop.inherit5_1;

public class Ppt extends File {
	
	private int pageSize;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if(pageSize < 0 ) {
			return;
		}
		this.pageSize = pageSize;
	}
	
	//고유 메소드 
	public void information() {
		System.out.println("<파일 정보>");
		System.out.println("이름 : " + this.filename);
		System.out.println("크기: " + this.filesize + "Bytes");
		System.out.println("장수: " + this.pageSize);
	}

	//생성자 
	public Ppt(String fileName, long fileSize) {
		this(fileName, fileSize, 1);
	}
	public Ppt(String fileName, long fileSize, int pageSize) {
		super(fileName);
		this.setFilesize(fileSize);
		this.setPageSize(pageSize);
	}
}
