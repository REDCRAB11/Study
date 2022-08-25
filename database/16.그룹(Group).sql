-- 그룹(Group)
-- 통계에서 많이 사용되는 기법 
-- ㅇㅇ별 이라는 단어가 들어가는 작업을 처리할 때 사용 

-- Q. 상품 분류별 개수 
-- (참고) count(type)는 type이 null이 아닌 경우만 세고, count(*)은 전부 센다.
select * from product; 
select type,count(*)from product group by type;
select type, count(*)"개수" from product group by type order by count(*) desc;
select type, count(*)"개수" from product group by type order by 개수 desc;

-- Q. 상품군별 가격 평균 , 최대값, 최소값 출력

select type, 
    avg(price)"평균",
    max(price)"최대",
    min(price)"최소"
from product group by type;

-- 그룹의 성립 조건은 having 키워드를 붙여서 설정한다. 
-- (참고) where은 개별 데이터 필터링 조건이다. 
-- order by는 마지막에 읽는다.

select type, 
    avg(price)"평균",
    max(price)"최대",
    min(price)"최소"
from product group by type having min(price) >= 1000;
