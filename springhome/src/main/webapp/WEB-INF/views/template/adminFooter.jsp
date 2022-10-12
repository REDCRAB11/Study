<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

			</section>
		</div>
	
		<hr>
		
		<!-- 하단 푸터 -->
		<footer>
			<div class="float-container">
				<div class="float-left w-33">
					<div class="row">
						<h2>회사소개</h2>	
					</div>
					<div class="row">
						이용약관
					</div>
					<div class="row">
						인재상
					</div>
					<div class="row">
						강사소개
					</div>
					<div class="row">
						구인현황
					</div>
					<div class="row">
						조직도
					</div>
				</div>
			
				<div class="float-left w-33">
					<div class="row">
						<h2>지점 연락처</h2>	
					</div>
					<div class="row">
						종로지원 : 000-0000-0000
					</div>
					<div class="row">
						강남지원 : 000-0000-0000
					</div>
					<div class="row">
						당산지원 : 000-0000-0000
					</div>
					<div class="row">
						울릉도지원 : 000-0000-0000
					</div>
					<div class="row">
						하와이지원 : 000-0000-0000
					</div>
				</div>
				
				<%-- 
					사용자 세션과 관련된 정보 출력
					- 세션 ID : 세션에 부여되는 고유번호(16진수 32자리)
					- 신규 세션은 세션이 생성될 경우(신규 접속)만 true로 출력
					
					(참고) pageContext는 페이지 내에서 사용 가능한 도구를 제공
	
					세션ID : ${pageContext.session.getId()} <br>
					신규세션 : ${pageContext.session.isNew()} <br>
				--%>
				<div class="float-left w-33">
					<div class="row">
						<h2>상태창</h2>	
					</div>
					<div class="row">
						loginId : ${sessionScope.loginId}
					</div>
					<div class="row">
						로그인 : ${sessionScope.loginId != null}
					</div>
					<div class="row">
						mg : ${sessionScope.mg}
					</div>
					<div class="row">
						관리자 : ${sessionScope.mg == '관리자'}
					</div>
				</div>
			</div>
		</footer>
	
	</main>
    
    </body>
</html>