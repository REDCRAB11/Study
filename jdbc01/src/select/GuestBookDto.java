package select;

// DTO(Data Transfer Object)
// - 데이터베이스의 테이블 안에 있는 한 줄의 데이터를 저장하기 위한 클래스
// - 앞으로 만날 모든 테이블은 DTO가 있어야 한다.
// - 테이블과 동일한 형태를 가짐 
// POJO 클래스(Plain Old Java Object)
public class GuestBookDto {
	
	private int no;
	private String name;
	private String memo;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "GuestBookDto [no=" + no + ", name=" + name + ", memo=" + memo + "]";
	}
	
	

}
