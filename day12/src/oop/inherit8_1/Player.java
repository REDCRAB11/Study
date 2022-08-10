package oop.inherit8_1;

public abstract class  Player {
	
	//필드 
	protected String id;
	protected int level;
	
	
	
	//메소드(+추상메소드
	public abstract void attack();
	public abstract void move();
	public final void print() {
		System.out.println("<플레이어 정보>");
		System.out.println("id: " + this.id);
		System.out.println("lv: " + this.level);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
	//생성자
	public Player(String id) {
		this.setId(id);
		this.setLevel(1);
	}
	public Player(String id, int level) {
		this.setId(id);
		this.setLevel(level);
	}

}
