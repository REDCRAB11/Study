package app;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("번호: ");
		int music_no = sc.nextInt();
		System.out.println("타이틀: ");
		String music_title = sc.next(); 
		System.out.println("아티스트: ");
		String music_artist = sc.next();
		System.out.println("앨범: ");
		String music_album = sc.next();
		System.out.println("재생수: ");
		int music_play = sc.nextInt();
		System.out.println("발매일: ");
		String release_time = sc.next();
		sc.close();
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("khacademy");
		dataSource.setPassword("khacademy");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		String sql ="insert into music(music_no, music_title, music_artist, music_album, music_play, release_time) "
						+ "values(?,?,?,?,?,?)";
		Object[] param = {music_no, music_title, music_artist, music_album, music_play, release_time};
		
		template.update(sql, param);
		System.out.println("완료!");
		
	}
}
