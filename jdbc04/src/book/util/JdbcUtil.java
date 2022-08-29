package book.util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcUtil {
	
	public static JdbcTemplate getTemplate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("khacademy");
		dataSource.setPassword("khacademy");
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		return template;
	}
}
