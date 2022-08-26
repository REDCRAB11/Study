package util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

// 매번 반복되는 도구 생성 코드를 간소화 시키기 위한 클래스 
public class JdbcUtil {
	
	public static JdbcTemplate getTemplate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("khacademy");
		dataSource.setPassword("khacademy");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		return template;
	}
	
}
