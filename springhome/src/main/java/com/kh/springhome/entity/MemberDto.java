package com.kh.springhome.entity;

import java.sql.Date;

public class MemberDto {
	private String memberId, memberPw;
	private String memberNick, memberTel, memberEmail;
	private String memberPost, memberBaseAddress, memberDetailAddress;
	private int memberPoint;
	private String memberGrade;
	private Date memberBirth, memberJoin, memberLogin;
	private String memberChangePw;
	
	
	public String getMemberChangePw() {
		return memberChangePw;
	}
	public void setMemberChangePw(String memberChangePw) {
		this.memberChangePw = memberChangePw;
	}
	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", memberNick=" + memberNick + ", memberTel=" + memberTel
				+ ", memberEmail=" + memberEmail + ", memberPost=" + memberPost + ", memberBaseAddress="
				+ memberBaseAddress + ", memberDetailAddress=" + memberDetailAddress + ", memberPoint=" + memberPoint
				+ ", memberGrade=" + memberGrade + ", memberBirth=" + memberBirth + ", memberJoin=" + memberJoin
				+ ", memberLogin=" + memberLogin + "]";
	}
	public MemberDto() {
		super();
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public Date getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPost() {
		return memberPost;
	}
	public void setMemberPost(String memberPost) {
		this.memberPost = memberPost;
	}
	public String getMemberBaseAddress() {
		return memberBaseAddress;
	}
	public void setMemberBaseAddress(String memberBaseAddress) {
		this.memberBaseAddress = memberBaseAddress;
	}
	public String getMemberDetailAddress() {
		return memberDetailAddress;
	}
	public void setMemberDetailAddress(String memberDetailAddress) {
		this.memberDetailAddress = memberDetailAddress;
	}
	public int getMemberPoint() {
		return memberPoint;
	}
	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	public Date getMemberJoin() {
		return memberJoin;
	}
	public void setMemberJoin(Date memberJoin) {
		this.memberJoin = memberJoin;
	}
	public Date getMemberLogin() {
		return memberLogin;
	}
	public void setMemberLogin(Date memberLogin) {
		this.memberLogin = memberLogin;
	}
}
