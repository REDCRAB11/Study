/* 문제 풀이

-- upper: 대문자 소문자 구분 안함 
*/


drop table onlinee;

create table onlinee(
    name varchar2(30) not null unique ,
    type char(6) not null check(type in('주류','과자')),
    price number not null check(price >= 0),
    deliver char(1) check(upper(deliver) = 'Y'),
    event char(1) check(upper(event) = 'Y')
    );
    
insert into onlinee(name, type, price, deliver, event) values('참이슬후레쉬', '주류', 1200, 'Y','Y');
-- insert into onlinee(name, type, price, deliver, event) values('클라우드맥주', '주류', 3000, null,'Y');
insert into onlinee(name, type, price, event) values('클라우드맥주', '주류', 3000,'Y');
insert into onlinee(name, type, price, deliver, event) values('바나나킥', '과자', 1500, null,'Y');
insert into onlinee(name, type, price, deliver, event) values('허니버터칩', '과자', 2000, 'Y',null);