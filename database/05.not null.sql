/*
    테이블 제약조건(table constraint)
    - 데이터 저장, 수정 등에 반영할 특이사항에 대한 조건
    - Not Null: 필수 데이터를 지정하는 조건 
    - unique: 중복을 금지하는 조건 
    - check: 원하는 값의 형태를 지정하는 조건 
    
*/

drop table menu;

create table menu(
    name varchar(60) not null unique,
    type varchar2(9) not null check(type in('음료','디저트')),    
    price number not null  check(price >=0),
    event char(1) check(event = 'Y') -- (주의) 오라클에서는 =로 같음을 비교한다.
    );
    
insert into menu(name, type, price, event) values('아메리카노','음료',2500,'Y');
-- insert into menu(name, type, price, event) values('모카라떼', '음료', 3500, null);
insert into menu(name, type, price) values('모카라떼', '음료', 3500);

commit;
