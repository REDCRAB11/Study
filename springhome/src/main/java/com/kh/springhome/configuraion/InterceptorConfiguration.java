package com.kh.springhome.configuraion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kh.springhome.interceptor.AdminInterceptor;
import com.kh.springhome.interceptor.MemberInterceptor;
import com.kh.springhome.interceptor.TestInterceptor;

//스프링 설정 파일
// - application.properties에서 설정하기 어려운 복잡한 설정을 구현 
// - 프로그램 동작 방식과 관련된 걸정일 경우 특정 인터페이스를 상속 받아야 함
// - interface WebMvcConfigurer
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer{
	
	// Autowired 무조건 한번헤 하나씩 
	
	@Autowired
	private MemberInterceptor memberInterceptor;
	@Autowired
	private AdminInterceptor adminInterceptor;
	@Autowired
	private TestInterceptor testInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		//(참고) 등록 코드 작성 순으로 실행됨 
		
		registry.addInterceptor(testInterceptor).addPathPatterns("/**");
		
		
		//registry에 추가하여 인터셉터가 작동하도록 설정.  먼저 제외는 불가 ~ !! 제외는 마지막에 ~!  
		registry.addInterceptor(memberInterceptor)
						.addPathPatterns( //* : 와일드 카드는 여러개 ~ 할때만  // 인터셉터가 감시할 주소 
								"/pocketmon/**", // 포켓몬스터 전부 
								"/music/detail", //음원 상세 
								"/member/**"//회원 전체 
								)
						.excludePathPatterns(// 위의 주소에서 제외할 주소 
								"/member/join", //회원 가입
								"/member/login"// 로그인 
								);
		
		registry.addInterceptor(adminInterceptor)
					.addPathPatterns("/guestbook/edit*", // edit으로 시작하는 주소 ,, 방명록 수정 
							"/guestbook/delete", // 방명록 삭제 
							"/music/**", //음원 전체 
							"/member/list", // 회원 목록
							"/member/detail", //회원 상세
							"/member/change*", //회원 수정
							"/member/exit" // 회원 삭제 
							)
					.excludePathPatterns("/music/list",  // 음원 목록
							"/music/detail" // 음원 상세
							);
					
	}
	
	
}
