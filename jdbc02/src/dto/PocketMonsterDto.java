package dto;

public class PocketMonsterDto {
	private int no;
	private String name; 
	private String type;
	
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public PocketMonsterDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PocketMonsterDto [no=" + no + ", name=" + name + ", type=" + type + "]";
	}
}
