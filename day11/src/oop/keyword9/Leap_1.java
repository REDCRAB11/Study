package oop.keyword9;

import java.util.Scanner;

public class Leap_1 {	
	//필드 
	private String id;
	private String pass; 
	private String nick;

	//메소드
	public Leap_1(String id, String pass, String nick) {
		this.id = id;
		this.pass = pass;
		this.nick = nick;
	}
	private void setid(String id) { // final 처럼 .. 쓸수는 있으나.. 파이널인줄 모르니깐... 
		this.id = id;
	}
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
}
