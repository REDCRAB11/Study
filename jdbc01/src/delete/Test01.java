package delete;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test01 {
	public static void main(String[] args) {
		// 삭제(delete)
		// delete fifa where state = ?
		
		// 데이터 준비 
		String state = "잉글랜드";
		
		//DB 처리 
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "delete fifa where state =?";
		Object [] param = {state};
		
		int result = template.update(sql,param);
		
		System.out.println("result: " + result);
		if(result > 0) {
			System.out.println("삭제가 완료되었습니다.");
		}else {
			System.out.println("존재하지 않는 나라 이름입니다. ");
		}
		
	}
}
