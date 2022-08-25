package update;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test02 {
	public static void main(String[] args) {
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "update guest_book set name = ?, memo = ? where no = ?";
		Object[] param = {"꼬부기", "꼬북꼬북", 5};
		
		int result = template.update(sql,param);
		
		System.out.println(result);
		
		if(result > 0) {
			System.out.println("변경 완료");
		}else {
			System.out.println("해당하는 번호가 없습니다.");
		}
				
	}

}
