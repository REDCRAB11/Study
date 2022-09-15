package com.kh.springhome.vo;

//VO(Value Object) - 값을 편하게 처리하기 위한 클래스
public class PocketMonsterCountVO {
	private String type;
	private int cnt;
	
	@Override
	public String toString() {
		return "PocketMonsterCountVO [type=" + type + ", cnt=" + cnt + "]";
	}
	public PocketMonsterCountVO() {
		super();
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}