-- 조회(Select)
-- 저장된 데이터를 가져오도록 지시하는 명령 
-- SELECT 항목 FROM 테이블 [WHERE 조건]

create table product(
no number primary key,
name varchar2(30) not null,
type varchar2(15) check(type in ('과자','아이스크림','주류','사탕')),
price number,
made date,
expire date
);

insert into product values(1, '스크류바', '아이스크림', 1200, '2020-05-01', '2020-10-01');
insert into product values(2, '마이쮸', '사탕', 900, '2020-01-01', '2021-01-01');
insert into product values(3, '초코파이', '과자', 3000, '2020-01-01', '2021-01-01');
insert into product values(4, '맛동산', '과자', 2200, '2020-02-01', '2020-10-20');
insert into product values(5, '참이슬', '주류', 1000, '2020-01-05', '2020-04-05');
insert into product values(6, '처음처럼', '주류', 1000, '2020-03-15', '2020-08-15');
insert into product values(7, '바나나킥', '과자', 1500, '2020-05-03', '2020-06-03');
insert into product values(8, '빠삐코', '아이스크림', 1000, '2019-12-01', '2020-06-01');
insert into product values(9, '멘토스', '사탕', 1200, '2020-03-20', '2020-12-31');
insert into product values(10, '오레오', '과자', 2100, '2019-06-01', '2020-06-01');

commit;


-- 전체조회 
select * from product;

-- 와일드카드(*)는 모든 항목을 의미
-- 항목을 선택해서 가져올 수 있다. 
select no, name, type, price, made, expire from product;
select name, price from product;

-- 데이터 필터링 조건 설정 

-- 숫자 조건 설정 

-- Q. 2000원 이하의 상품만 조회 
select * from product where price <=2000;

-- Q. 1000원 이상 2000원 이하인 상품만 조회 
select * from product where  price >= 1000 and price <=2000;
select * from product where price between 1000 and 2000;

-- Q. 1000원인 상품 
select * from product where price = 1000;

-- Q. 1000원이 아닌 상품 위에꺼 쓰는거 추천
select * from product where price != 1000; 
select * from product where price <> 1000;

-- 문자열 조건 설정 

-- Q. 과자만 조회 in보다 =의 속도가 더 빠르다 . 하나 쓸 때 if문을 써서 찾는거랑 똑같... 같다와 다르다가 제일 빠름 찾는거는 
select * from product where type in '과자';
select * from product where type = '과자';

-- Q. 아이스크림과 과자만 조회 

select * from product where type in ('과자','아이스크림');
select * from product where type = '아이스크림' or type = '과자';

-- Q. '바'로 시작하는 상품 조회 
-- like는 %를 있어도 되고 없어도 되는 값으로 인식한다.
select * from product where name like '바%';

-- instr은 저장한 글자가 항목의 몇번쨰에 위치하는지 반환(1부터 시작)
select * from product where instr(name, '바') = 1;

-- Q. '바'가 포함된 상품 조회 
select * from product where name like '%바%';
select * from product where instr(name, '바') > 0;

-- Q. '바'로 끝나는 상품 조회 
select * from product where name like '바%';
select * from product where instr(name, '바') = length(name);


-- 문자열 유사검색에서는 시작검사는 like가 좋고 나머지는 instr()이 좋다. 


-- 날짜 조건 설정 
-- 문자열 처럼 사용할 수 있고, 계산도 가능, 범위 표현도 가능. 

-- Q. 제조년도가 2020년인 상품을 조회 
select * from product where extract(year from made) = 2020;

-- Q. 여름에 생산한 제품을 조회 
select * from product where extract(month from made) in (6,7,8);

select * from product 
where
extract(month from made) = 6
or
extract(month from made) = 7
or
extract(month from made) = 8;

select * from product where made like '%/06/%' or made like '%/07/%' or made like '%/08/%'; -- 추천하지 않음

select * from product where to_char(nade, 'min')in('06','07','08');

select * from product where regexp_like(to_char(made,'mm'),'(06|07|08)');


-- 2019년 6월 1일 ~ 2019년 8월 31일까지 조회 
-- (주의) 시간을 입력하지 않으면 00시 00분 00초로 설정됨
select * from product where made >= to_date('2019-06-01 00:00:00','yyyy-mm-dd hh24:mi:ss') and made <= to_date('2019-08-31 23:59:59','yyyy-mm-dd hh24:mi:ss');

select *from product
where made between to_date('2019-06-01 00:00:00','yyyy-mm-dd hh24:mi:ss')and to_date('2019-08-31 23:59:59','yyyy-mm-dd hh24:mi:ss'); 



-----------------------------------------------------------------------------------------

-- 정렬(order)
-- 데이터를 원하는 기준에 맞게 재배치 하는 것 
-- 오름차순(asc) 내림차순(desc) 
-- 오라클은 키워드로 정렬을 수행 
-- 데이터를 조회할 때 여러개가 나오면 반드시 정렬을 해야한다. 

select * from product order by no asc;

-- Q. 가격이 저렴한/비싼 상품 순으로 출력 
select * from product order by price asc;

select * from product order by price desc;
select * from product order by price desc, no asc; -- 같은 가격일 경우.. 
-- Q. 이름순으로 출력 
select * from product order by name asc;
select * from product order by name asc, no asc; -- 같은 이름일 경우 

select * from product order by name desc;

-- Q. 제조일 순/최신제조순 으로 출력 
select * from product order by made asc;

select * from product order by made desc;



-- Q. 유통기한이 짧은 순으로 출력 
select * from product order by (expire - made) asc;
select no, name, type, pride, made, expire from product; -- 이거나 
select product.*,expire-made from product; -- 이렇게 쓰는게 좋다 
select product .*, expire-made from product order by expire-made asc; 
select product.*,expire-made "유통기한" from product order by expire-made asc;
select product.*,expire-made "유통기한" from product order by "유통기한" asc;

select * from product order by expire-made asc;


-- (주의) 정렬은 항상 제일 마지막에 와야한다.(데이터가 정해져야 가능하기 때문) 


-- Q. 2000원 이하인 상품들을 이름순으로 정렬 
select * from product where price <= 2000 order by name asc;2