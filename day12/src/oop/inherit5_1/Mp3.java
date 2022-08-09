package oop.inherit5_1;

public class Mp3 extends MediaFile {
	
	//생성자
	public Mp3(String fileName) {
		super(fileName);
	}
	
	public Mp3(String fileName, long fileSize, int duration) {// 슈퍼를 쓰든 셋을 쓰든 맘데로 하세용 
		super(fileName);
		this.setFilesize(fileSize);
		this.setDuration(duration);
	}
	
	//고유 필드, 메소드(는 없어서 패수)  
	private int duration;

	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		if(duration < 0) {
			return;
		}
		this.duration = duration;
	}
	
	

}
