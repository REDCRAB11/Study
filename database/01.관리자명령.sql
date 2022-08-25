-- 다음 요구사항에 맞게 SQL 구문을 작성 

--  1. 아이디가 khacademy, 비밀번호가 student인 계정을 생성
create user khacademy identified by student; 

-- 2. khacademy 계정에 연결(connect) 와 지원관리(resource)권한 부여 
grant connect, resource to khacademy;

-- 3. khacademy 계정의 비밀번호를 khacademy 로 변경
alter user khacademy identified by khacademy;
