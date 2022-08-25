-- 삭제(Delete)
-- 기존에 등록한 데이터를 없에는 명령(commit, rollback 필요) 
-- 대부분 PK를 이용한 단일삭제로 처리한다. 

-- delete (from) 테이블 (조건)
delete product;
delete product where no=1;

-- Q. 2022년 상반기에 제조된 상품 정보를 삭제하시오
delete product 
where extract(year from made)=2020 
and extract(month from made) between 1 and 6;

delete product where regexp_like(to_char(made, 'yyyymm'), '20200[1-6]');

delete product where made between 
    to_date('20200101000000', 'yyyymmddhh24miss') 
        and 
        to_date('20200630235959', 'yyyymmddhh24miss');

rollback;


