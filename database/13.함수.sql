-- 함수(Function)
-- 자바 메소드처럼 input과 output이 존재하는 도구 
-- 함수의 처리 방식에 따라 여러 가지로 구분된다. 

-- 듀얼 테이블: 임시 계산 결과를 보관 및 출력할 수 있도록 구성된 내장 테이블 
select 1234+5678 from dual;


-- 단일 행 함수: 행별로 작업을 처리하는 함수 
-- 테이블 조회 시 추가하여 사용이 가능 
select chr(65) from dual;
select ascii('A') from dual;

select lower('Hello')"결과" from dual; 

select prodct.*,lower(name)"소문자" from product;

select product.*,substr(name,1,1)"첫글자" from product;


-- 집계함수: 여러 데이터를 종합하여 결과를 만들어 내는 함수 
-- (대표)합계, 평균, 최대, 최소, 개수 
-- 집계 함수는 항목이나 단일행 함수와 같이 사용할 수 없다. 
select sum(price)from product;
select product.*,sum(price)from product;

select avg(price)"평균"from product;
select max(price)"최대"from product;
select min(price)"최소"from product;
select count(price)"개수"from product;

-- Q. 가장 비싼 상품의 이름을 출력 
select max(price)"비싼" , max(name)"이름" from product;

-- 서브쿼리(Sub Query): 구문 여러개를 순차적으로 실행하도록 구성한 것 
select name from product where price = (select max(price) from product);

-- Q. 가장 최근에 만들어진 상품정보
select * from product where made =(select max(made) from product);

-- Q. 가장 포인트가 적은 고객의 아이디 
select id from customer where mile =(select max(mile) from customer);