/*  
    생성된 테이블에 데이터를 추가하는 방법 
    - 데이터는 객체가 아니다. 
    - 데이터는 객체와 명령이 다르다.
    - 추가 완료 후에 commit을 통해 확정 저장을 해야한다.     
    - 추가 완료 후에 rollback을 사용하면 련재까지의 작업 내용이 무효화된다. 
*/

-- no, name, type에 1, 이상해씨, 풀을 넣으세요 
-- insert into pocket_monster(형식) values(값); 사용할때는 이게 좋다 
insert into pocket_monster(no, name, type) values(1, '이상해씨', '풀');


-- 1, 이상해씨, 풀을 넣으세요
-- insert into pocket_monster valuser(값);
insert into pocket_monster values(1, '이상해씨','풀');

-- 명령을 통한 조회 (SQL Command Line 에서도 사용함) 
select * from pocket_monster;

-- 최종 저장 
commit;


insert into pocket_monster(no, name, type)values(2,'이상해풀','풀');
rollback; -- 최종 취소 