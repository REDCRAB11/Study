-- 집합연산
-- 결과 집합 간의 계산
-- 자바에서는 Set으로 집합연산을 했었다. 
-- 오라클에서는 결과 집합(Result Set)으로 한다. 
-- 합집합, 교집합, 차집합 

-- (참고) distinct 는 중복제거 

-- 차이를 만들기 위한 insert 구문 추가 
insert into exam_a values(17,'피카츄','데이터베이스구현','서술형',85);
insert into exam_a values(18,'라이츄','sql활용','서술형',76);

commit;

-- 피카츄가 응시한 과목 (A)
select distinct subject from exam_a where student = '피카츄';

-- 라이츄가 응시한 과목 (B)
select distinct subject from exam_a where student = '라이츄';


-- 합집합 : AUB (union, unio all) 
select distinct subject from exam_a where student = '피카츄'
union 
select distinct subject from exam_a where student = '라이츄';


-- 교집합 : ANB (intersect)
select distinct subject from exam_a where student = '피카츄'
intersect
select distinct subject from exam_a where student = '라이츄';


-- 차집합 : A-B or B-A
select distinct subject from exam_a where student = '피카츄'
minus
select distinct subject from exam_a where student = '라이츄';

