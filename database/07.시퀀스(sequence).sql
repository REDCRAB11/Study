/* 
    시퀀스(sequence)
    - 겹치지 않는 번호 생성기
    - 데이터베이스 객체의 한 종류 
*/    


-- 시퀀스 생성
create sequence test_seq;

-- 방명록 테이블 생성 
drop table guest_book;

create table guest_book(
no number not null unique,
name varchar2(21) not null,
memo varchar2(300)
);

-- 시퀀스 번호를 발급할 때는 .nextval 명령을 사용.
insert into guest_book(no, name, memo) values(test_seq.nextval,'마리오', '잘 먹고 갑니다.');

select * from guest_book;

commit;


-- 시퀀스 속성(옵션) 확인
select * from user_sequences;

-- 옵션을 부여하여 시퀀스 생성
-- 1부터 100까지 1씩 늘어나며 번호를 다 쓰면 순환하고 캐시는 없음

create sequence guest_book_seq
minvalue 1 
maxvalue 1000
cycle --nocycle
