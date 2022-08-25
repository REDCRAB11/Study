-- 포켓몬스터 테이블 생성 
create table pocket_monster(
    no number(3),
    name varchar2(21),
    type varchar2(9)
);

-- 테이블변경 
alter table pocket_monster modify(type varchar2(12));

-- 테이블 삭제 
drop table pocket_monster;


