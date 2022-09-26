package com.kh.springhome.configuraion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kh.springhome.interceptor.AdminInterceptor;
import com.kh.springhome.interceptor.MemberBoardOwnerCheckInterceptor;
import com.kh.springhome.interceptor.MemberBoardPermissionCheckInterceptor;
import com.kh.springhome.interceptor.MemberInterceptor;
import com.kh.springhome.interceptor.ReplyOwnerCheckInterceptor;
import com.kh.springhome.interceptor.TestInterceptor;

//스프링 설정파일
//- application.properties에서 설정하기 어려운 복잡한 설정을 구현
//- 프로그램 동작 방식과 관련된 설정일 경우 특정 인터페이스를 상속 받아야 함
//- interface WebMvcConfigurer
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer{
	
	@Autowired
	private MemberInterceptor memberInterceptor;
	
	@Autowired
	private AdminInterceptor adminInterceptor;
	
	@Autowired
	private TestInterceptor testInterceptor;
	
	@Autowired
	private MemberBoardPermissionCheckInterceptor permissionCheckInterceptor;
	
	@Autowired
	private MemberBoardOwnerCheckInterceptor ownerCheckInterceptor;
	
	@Autowired
	private ReplyOwnerCheckInterceptor replyOwnerCheckInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry에 추가하여 인터셉터가 작동하도록 설정
		//(참고) 등록 코드 작성 순으로 실행됨
		
		//테스트 확인용 인터셉터
		registry.addInterceptor(testInterceptor)
					.addPathPatterns("/**");
		
		//회원용 인터셉터
		registry.addInterceptor(memberInterceptor)
					.addPathPatterns(//인터셉터가 감시할 주소
							"/pocketmon/**",//포켓몬스터 전부
							"/music/detail",//음원 상세
							"/member/**",//회원 전체
							"/board/**"//게시판 전체
					)
					.excludePathPatterns(//위의 주소에서 제외할 주소
							"/member/join*",//회원가입
							"/member/login",//로그인
							"/member/goodbye_result",//탈퇴완료
							"/board/list",//게시판 목록
							"/board/detail"//게시판 상세보기
					);
		
		//관리자용 인터셉터
		registry.addInterceptor(adminInterceptor)
					.addPathPatterns(//인터셉터가 감시할 주소
						"/guestbook/edit*",//방명록 수정페이지
						"/guestbook/delete",//방명록 삭제페이지
						"/music/**",//음원 전체
						"/member/list",//회원목록
						"/member/detail",//회원상세
						"/member/change*",//회원수정
						"/member/exit",//회원삭제
						"/admin/**", //관리자 기능
						"/board/reply/blind"//블라인드 기능
					)
					.excludePathPatterns(//위의 주소에서 제외할 주소
						"/music/list",//음원 목록
						"/music/detail"//음원 상세
					);
		
		//관리자만 공지사항을 등록할 수 있도록 검사하는 인터셉터
		registry.addInterceptor(permissionCheckInterceptor)
					.addPathPatterns(
							"/board/edit", 
							"/board/write"
					);
		
		//소유자 또는 관리자만 수정/삭제를 할 수 있도록 검사하는 인터셉터
		registry.addInterceptor(ownerCheckInterceptor)
						.addPathPatterns(
								"/board/edit",
								"/board/delete"
								);
		
		// 소유자 또는 관리자만 수정/삭제를 할 수 있도록 검사하는 인터셉터 
		registry.addInterceptor(replyOwnerCheckInterceptor)
													.addPathPatterns("/board/edit"
															+ "/board/delete"
															);

		// 소유자만 댓글 수정/삭제 가능하도록 검사하는 인터셉터
		registry.addInterceptor(replyOwnerCheckInterceptor)
													.addPathPatterns("/board/reply/edit"
															+ "/board/reply/delete");
		
	}
}
 

