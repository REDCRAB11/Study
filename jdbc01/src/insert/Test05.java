package insert;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test05 {
	public static void main(String[] args) {

		
		String name = "루이지짱";
		String memo = "맛있네요";
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("khacademy");
		dataSource.setPassword("khacademy");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		String sql = "insert into guest_book(no,name,memo) "
						+ "values(guest_book_seq.nextval,?,?)";
		Object[] param = new Object[] {name, memo};
		
		template.update(sql,param);
		System.out.println("완료");
		
	}

}
