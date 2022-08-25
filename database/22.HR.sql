-- 오라클 학습용 계정인 HR 계정을 활성화 

-- 관리자로 진행하는 내용 
select username from dba_users;

alter user hr identified by hr; 
alter user hr account unlock;


-- hr 계정으로 진행하는 내용 

select * from tab; 

select * from regions; 
select * from countries;



--- 관련 문제 풀이 

-- country_id 별 지역 개수를 구하여 출력하세요 
select country_id, count(*)"지역개수" from locations group by country_id order by 지역개수 desc, country_id asc;

-- 작업자 중에서 급여를 가장 많이 받는 사람 5명을 출력하세요 
select * from employees;
select * from(
    select TMP.*, rownum rn from(
    select employee_id, max(salary)"임금" from employees
    group by employee_id order by 임금 desc
    )TMP
) where rn between 1 and 5;

-- 작업자 중에서 가장 오래 근무한 사람 3명을 출력하세요 
select * from employees;
select * from(
    select TMP.*, rownum rn from(
    select employee_id, max(hire_date)"근무기간" from employees
    group by employee_id order by 근무기간 desc
    )TMP
) where rn between 1 and 3;

select * from (
    select TMP.*, rownum rn from(
        select * from employees order by hire_date asc, employee_id asc
        )TMP
) where rn between 1 and 3;

-- 작업 이력 중에서 가장 오랜 기간 작업한 사람의 ID를 출력
select * from job_history;
select * from (
select TMP.*, rownum rn from(
select job_id, max(end_date - start_date)
from job_history group by job_id order by max(end_date - start_date) desc
)TMP
);

-- JBOB_ID별 평균 최대 최소 급여 출력 
select job_id,
avg(salary)평균,
max(salary)최대, 
min(salary)최소 
from employees group by job_id;  

-- 작업자를 급여순서대로 순위를 매겨서 출력 (전체/ 부서별)
select employees.*, rank() over(partition by job_id order by salary desc)"순위" from employees; 

select E.first_name, E.last_name, E.department_id, e.salary, 
rank() over(partition by department_id order by salary desc) 순위 from employees E;