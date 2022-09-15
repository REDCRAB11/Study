package com.kh.spring12;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Setter @Getter @ToString(exclude = "score") 을 데이터로 한번에
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 클래스의 객체를 만들어주는 내부 클래스를 정의 
public class Student {
private String name;
private int score;
}
