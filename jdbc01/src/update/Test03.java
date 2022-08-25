package update;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test03 {
	public static void main(String[] args) {
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "update customer set customer_id =? , customer_mileage =? where customer_no =? ";
		Object[] param = {"방방구", 300, 3};
		
		int result = template.update(sql, param);
		
		System.out.println(result);
		
		if(result > 0) {
			System.out.println("변경 완료");
		}else {
			System.out.println("해당하는 고객이 없습니다.");
		}
	}

}
