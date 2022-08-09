package oop.inherit3;

public class Internet {
	
	//공용 필드 = 세터 게터는 무조건 만드시오 !! 
	private String url; 

	
	//공용 메소드 
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void refresh() {
		System.out.println("새로고침 기능");
	}
	public void move() {
		System.out.println("페이지 이동 기능 실행");
	}

}
