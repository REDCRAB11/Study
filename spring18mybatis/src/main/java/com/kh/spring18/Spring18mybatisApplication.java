package com.kh.spring18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling //스케쥴러 추가 
@SpringBootApplication
public class Spring18mybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring18mybatisApplication.class, args);
	}

}
