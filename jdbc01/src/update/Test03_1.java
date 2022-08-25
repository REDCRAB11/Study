package update;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test03_1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("고객번호: ");
		long customer_no = sc.nextLong();
		System.out.println("증정 포인트: ");
		int customer_mileage = sc.nextInt();
		sc.close();
		
		
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "update customer set customer_mileage = customer_mileage + ? where customer_no =? ";
		Object[] param = {customer_mileage, customer_no};
		
		int result = template.update(sql, param);
		
		System.out.println(result);
		
		if(result > 0) {
			System.out.println("포인트 증정 완료");
		}else {
			System.out.println("해당하는 고객이 없습니다.");
		}
	}

}
