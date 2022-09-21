package com.kh.springhome.error;

import lombok.NoArgsConstructor;

//사용자 지정 예외 클래스
//- JVM이 인지하지 못하지만 문제가 되는 상황을 알려주기 위한 클래스
//- 상속을 통한 자격 획득
//- 상속을 받을 때 Exception이 아니라 RuntimeException을 상속받으면 추가 예외처리 생략 가능(Checking Exception)
@NoArgsConstructor
//public class TargetNotFoundException extends Exception{
public class TargetNotFoundException extends RuntimeException{
	public TargetNotFoundException(String message) {
		super(message);
	}
}