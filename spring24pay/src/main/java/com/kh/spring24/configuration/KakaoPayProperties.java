package com.kh.spring24.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "custom.pay")
public class KakaoPayProperties {
	private String key;
	private String cid;
}
