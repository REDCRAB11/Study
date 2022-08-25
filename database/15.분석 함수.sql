-- 분석 함수 
-- 단일 행 함수와 집계 함수의 합성 형태 
-- 순위와 같이 전체를 보긴 하지만 표시는 행마다 하는 경우
-- 함수 뒤에 over()를 붙이고 기준(분류,정렬)을 제시 
-- 분류는 partiotion by 항목으로 작성
-- 정렬은 order by 항목 asd/desc로 작성 


-- Q. product 상품 정보를 가격 순서로 순위를 매겨 출력
select 
    product.*,
    rank()over(order by price desc)"순위"
    from product;
    

-- Q. 상품 종류별 가격순위를 구하여 출력 
select 
     product.*,
     rank() over(partition by type order by price desc)"순위"
     from product;
    