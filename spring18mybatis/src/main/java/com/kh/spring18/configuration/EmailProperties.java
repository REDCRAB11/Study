package com.kh.spring18.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data //세터&게터 
@Component//등록해라!
@ConfigurationProperties(prefix = "custom.email")//properties에서 불러와라!
public class EmailProperties {
	//접두사를 제외한 나머지 이름으로 field를 생성하면 자동으로 채워진다. 
	private String host, username,password;
	private int port;
}
