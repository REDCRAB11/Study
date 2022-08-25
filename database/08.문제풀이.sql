/* (참고)
    -char의 크기는 200byte, varchar2의 크기는 4000byte
    - default는 미입력시 자동 설정될 값을 지정하는 조건 
    - date는 시간을 저장하는 자료형(연/월/일/시/분/초.0까지 저장)
    - 시간은 직접작성해도 되지만 현재시각(sysdate) 키워드가 존재한다. 
*/

create sequence board_seq;

drop table board;

create table board(
    board_no number not null unique,
    board_title varchar2(300) not null,
    board_content varchar2(4000) not null,
    board_writer varchar2(20) not null check(regexp_like(board_writer, '^[a-z][a-z0-9]{7,19}$')),
    board_read number default 0 null check(board_read >= 0), -- default는 미입력시 적용 
     board_time char(10) not null
   -- board_time date not null 이것도 써도 되지만 아직 안배웠으니 ㅋ  
    );
    
insert into board(board_no, board_title, board_content,board_writer,board_time) 
values(board_seq.nextval,'테스트제목','테스트내용','asdf1234','2022-08-22');

commit;

select * from board;
    
    