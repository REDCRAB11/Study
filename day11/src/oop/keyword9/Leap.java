package oop.keyword9;

import java.util.Scanner;

public class Leap {	
	//필드 
	private final String id;
	private String pass; 
	private String nick;

	//메소드
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getId() {
		return id;
	}

	public void vet() {
		System.out.println("<회원 정보>");
		System.out.println("아이디: " + this.id);
		System.out.println("닉네임: " + this.nick);
	}


	// id를 반드시 설정하는 생성자 
	public Leap(String id, String pass, String nick) {
		this.id = id;
		this.pass = pass;
		this.nick = nick;
	}
}
