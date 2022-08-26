package select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import util.JdbcUtil;

public class Test06 {
	public static void main(String[] args) {
	
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "select * from customer order by customer_no asc";
		
		RowMapper<CustomerDto> mapper = (rs, idx) -> {
			CustomerDto c = new CustomerDto();
			c.setCustomer_no(rs.getInt("customer_no"));
			c.setCustomer_id(rs.getString("customer_id"));
			c.setCustomer_phone(rs.getString("customer_phone"));
			c.setCustomer_regist(rs.getString("customer_regist"));
			c.setCustomer_purchase(rs.getString("customer_purchase"));
			c.setCustomer_mileage(rs.getInt("customer_mileage"));
			c.setCustomer_grade(rs.getString("customer_grade"));
			return c; 
			
		};
		
		List<CustomerDto> list = template.query(sql, mapper);
		for(CustomerDto c : list) {
			System.out.println(c.getCustomer_no());
			System.out.println(c.getCustomer_id());
			System.out.println(c.getCustomer_phone());
			System.out.println(c.getCustomer_regist());
			System.out.println(c.getCustomer_purchase());
			System.out.println(c.getCustomer_mileage());
			System.out.println(c.getCustomer_grade());
		}
		
	}

}
