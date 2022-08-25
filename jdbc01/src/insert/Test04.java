package insert;

import javax.xml.transform.Templates;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test04 {

	public static void main(String[] args) {
		
		int no = 5;
		String name = "꼬부기";
		String type = "물";
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("khacademy");
		dataSource.setPassword("khacademy");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		String sql = "insert into pocket_monster(no,name,type) values(?,?,?)";
//		Object [] param = new Object[] {no, name, type};
		Object [] param = {no, name, type};
		
		template.update(sql,param);
		System.out.println("완료");
	}
}
