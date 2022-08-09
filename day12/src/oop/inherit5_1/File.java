package oop.inherit5_1;

public class File {
	
	//공용 필드 - 접근제한 
	protected String filename;
	protected long filesize;
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		if(filesize <0L) {
			return;
		}
		this.filesize = filesize;
	}

	//생성자 - 필수항목: 파일명은 무조건 있어야 한다. 
	public File(String fileName) {
		this.setFilename(fileName);
	}
	
	//공용 메소드 - 재정의 
	public void execute() {
		System.out.println(this.filename + "실행!");
	}
	
}
