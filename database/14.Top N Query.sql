-- Top N Query
-- 데이터를 원하는 개수만큼 끊어서 조회하는 개념 
-- 페이지별로 데이터를 나누어서 보여줄 때 사용(1P = 1~10번까지) 
-- rowunm이라는 내장도구를 사용할 줄 알아야 한다. 
--    - rownum은 정렬하면 원하는 결과가 나오지 않는다. 
--    - 즉, rownum은 가장 마지막에 부여해야 한다. 
--    - rowunm은 반드시 1번부터 부여되야한다. 

-- Q. 상품을 가격순으로 3개만 보여주세요 
select product.*,rownum from product;
select product.*,rownum from product where rownum <=3;

select product.*,rownum from product where rownum <=3 order by price desc;

-- 서브쿼리를 이용해서 다음과 같이 구문 순서를 변경
-- 1. 가격이 비싼 순으로 정렬을 실행 
-- 2. rownum을 부여 

select TMP.*,rownum from (
select * from product order by price desc --1
)TMP where rownum <=3 --2

-- 2차 문제점 
select TMP.*,rownum from (
select * from product order by price desc
)TMP where rownum between 3 and 5;

-- 2차 문제 해결하려면 rownum을 먼저 부여하고 조건으로 필터링 
select * from (
select TMP.*,rownum rn from (
select * from product order by price desc
)TMP
) where rn rownum between 3 and 5;


/* 공식 
select * from (
    select TMP.*, rownum rn from(
        원하는 데이터 조회, 필터 및 정렬 구문
        )TMP
        )where rn beteen 시작행번호 and 종료행번호;
        */