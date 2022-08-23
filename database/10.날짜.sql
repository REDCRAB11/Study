/*
    날짜(Date)
    - 데이터에 시간을 설정할 떄 사용하는 형태 
    - 연,월,일,시,분,초,0 까지 저장 가능
    - 더 자세한 형태로는 timestamprk 있다.
    - 장점: 문자열과 변환이 가능(to_char(), to_date()함수)
    -      현재 시각을 자동 계산해주는 객체가 존재한다.(sysdate)
    - date는 계산이 가능하다 
*/

create table time_test(
    no number not null unique,
    when date not null 
);

-- 시간 표시 방식이 맞으면 문자열을 바로 추가할 수 있지만 비추천 
insert into time_test(no,when)values(1,'2022-08-23');

-- to_date('문자열','형식정보')를 통해 문자열을 날짜 데이터로 변환할 수 있다. 
insert into time_test(no,when)values(2,to_date('2022-08-23','YYYY-MM-DD'));
insert into time_test(no,when)values(3,to_date('2022-08-23','yyyy-mm-dd'));

-- 현재 시각은 sysdate로 확인
insert into time_test(no,when)values(4,sysdate);

select * from time_test;
select no, to_char(when, 'yyyy-mm-dd hh24:mi:ss')from time_test; 