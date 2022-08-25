
drop table exam_a;
create table exam_a (
id number,
student varchar2(9),
subject varchar2(33),
type varchar2(24),
score number(3)
);

insert into exam_a(id,student,subject,type,score) values(1,'피카츄','프로그래밍언어활용','서술형',55);
insert into exam_a(id,student,subject,type,score) values(2,'피카츄','프로그래밍언어활용','문제해결시나리오',95);
insert into exam_a(id,student,subject,type,score) values(3,'피카츄','네트워크프로그래밍구현','서술형',60);
insert into exam_a(id,student,subject,type,score) values(4,'피카츄','네트워크프로그래밍구현','평가자체크리스트',51);
insert into exam_a(id,student,subject,type,score) values(5,'라이츄','프로그래밍언어활용','서술형',80);
insert into exam_a(id,student,subject,type,score) values(6,'라이츄','프로그래밍언어활용','문제해결시나리오',52);
insert into exam_a(id,student,subject,type,score) values(7,'라이츄','네트워크프로그래밍구현','서술형',58);
insert into exam_a(id,student,subject,type,score) values(8,'라이츄','네트워크프로그래밍구현','평가자체크리스트',80);
insert into exam_a(id,student,subject,type,score) values(9,'파이리','프로그래밍언어활용','서술형',54);
insert into exam_a(id,student,subject,type,score) values(10,'파이리','프로그래밍언어활용','문제해결시나리오',81);
insert into exam_a(id,student,subject,type,score) values(11,'파이리','네트워크프로그래밍구현','서술형',44);
insert into exam_a(id,student,subject,type,score) values(12,'파이리','네트워크프로그래밍구현','평가자체크리스트',76);
insert into exam_a(id,student,subject,type,score) values(13,'꼬부기','프로그래밍언어활용','서술형',100);
insert into exam_a(id,student,subject,type,score) values(14,'꼬부기','프로그래밍언어활용','문제해결시나리오',60);
insert into exam_a(id,student,subject,type,score) values(15,'꼬부기','네트워크프로그래밍구현','서술형',51);
insert into exam_a(id,student,subject,type,score) values(16,'꼬부기','네트워크프로그래밍구현','평가자체크리스트',72);

commit;

/*
1. 학생별 평균점수를 구하여 출력				
2. 과목별 평균점수를 구하여 출력				
3. 평가유형별 평균점수를 구하여 출력				
4. 학생별 최고, 최저점을 구하여 출력				
5. 과목별 최고, 최저점을 구하여 출력				
6. 유형별 최고, 최저점을 구하여 출력				
7. 과목별 평균 60점 미만 학생의 수를 구하여 출력				
8. 과목별 평균 90점 이상 학생의 수를 구하여 출력				
9. 평균이 높은 학생을 3등까지만 출력				
*/

-- 1. 학생별 평균 점수 
select student, 
    avg(score)"평균"
from exam_a group by student order by 평균 desc;


-- 2. 과목별 평균 점수 
select subject, 
    avg(score)평균
from exam_a group by subject order by 평균 asc;


-- 3 평가유형별 평균점수 
select type,
    avg(score)"평균"
from exam_a group by type order by 평균 desc;
    
    
-- 4. 학생별 최고 최저 구하기 
select student, 
    max(score)"최대",
    min(score)"최소"
from exam_a group by student order by student asc;


-- 5. 과목별 최고 최저 구하기 
select subject, 
     max(score)"최대",
     min(score)"최소"
from exam_a group by subject order by subject asc;


-- 6. 유형별 최고 최저 
select type, 
    max(score)"최대",
    min(score)"최소"
from exam_a group by type;



---------------------- 위에거 처럼 풀면 안나옴 ~~ 밑에거 처럼 풀어야함 ~~ -------------------

-- 7. 과목별 60점 평균 미만 학생수 출력 
/*
select subject, 
    avg(score)평균,
    count(*)인원수
from exam_a group by subject having avg(score) < 60;
*/

select subject, count(*)"인원수" from(
    select * from exam_a where score < 60
    )
group by subject;

-- 이게 정답 위에는 잘못된 질문의 이해의 이한 정답 
select student, subject, avg(score)평균 from exam_a
group by student, subject having avg(score) < 60;

select subject, count(*)인원수 from(
    select student, subject, avg(score)평균 from exam_a
    group by student, subject having avg(score) < 60
    ) group by subject;

-- 8. 과목별 평균 70점 이상인 학생수 출력 
/*
select subject, 
    avg(score)"평균",
    count(*)"개수"
from exam_a group by subject having avg(score) >= 90;
*/

select subject, count(*)"인원수" from(
    select * from exam_a where score >= 70
    )
group by subject;

select subject, count(*)인원수 from(
    select student, subject, avg(score)평균 from exam_a
    group by student, subject having avg(score) >= 60
    ) group by subject;


-- 9. 평균이 높은 학생 3명만 출력 
/*
select student,
    avg(score)"평균",
    max(score)"최대"
from exam_a group by student having avg(score), max(score) =3;
*/

select * from(
    select TMP.*, rownum rn from(
    select student, avg(score) 평균 from exam_a
    group by student order by 평균 desc
    )TMP
) where rn between 1 and 3;



