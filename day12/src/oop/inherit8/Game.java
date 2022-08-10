package oop.inherit8;

public abstract class Game {
	
	//f
	protected String id;
	protected int lv;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		if(lv < 0) {
			return;
		}
		this.lv = lv;
	}

	public Game(String id) {
		this.id = id;
		this.lv = 1;
	}
	//m
	public abstract void attack();
	public abstract void move();
	

}
