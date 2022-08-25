-- 오라클 학습용 계정인 HR 계정을 활성화 

-- 관리자로 진행하는 내용 
select username from dba_users;

alter user hr identified by hr; 
alter user hr account unlock;


-- hr 계정으로 진행하는 내용 

select * from tab; 