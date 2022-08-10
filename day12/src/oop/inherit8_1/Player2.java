package oop.inherit8_1;

public abstract class  Player2 {
	
	//필드  -- 레벨이 무조건 오를떄 (내려가지 않는다면..)
	
	protected String id;
	private int level;
	
	
	
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
	public void levelUp() {
		this.level++;
	}
	
	
	
	//생성자
	public Player2(String id) {
		this(id, 1);
	}
	public Player2(String id, int level) {
		this.setId(id);
		this.level=level;
	}

}
