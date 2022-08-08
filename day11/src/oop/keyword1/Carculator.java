package oop.keyword1;

public class Carculator {
	//필드
	private int left;
	private int right;
	
	//메소드
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	public int getAnswer() {
		return this.left * this.right;
	}

	//생성자
	public Carculator(int left, int right) {
		this.setLeft(left);
		this.setRight(right);
	}

}
