drop table customer;
drop sequence customer_seq;

create sequence customer_seq;

-- default가 먼저 나와야 한다 ~~ 

create table customer(
    no number not null unique,
    id varchar2(20) not null unique check(regexp_like(id, '^[a-z0-9]{8,20}$')),
    num char(13) not null unique check(regexp_like(num, '^[010]-[0-9]{4}-[0-9]{4}$')), -- \d = [0-9]
    date char(10) not null,
    buy char(10) not null,
    mile number default 0 check(mile >=0),
    grade varchar2(12) default '일반' not null check(grade in('일반', 'VIP' , 'VVIP', '플래티넘'))
    );
    
insert into customer(no, id, num, date, buy, mile, grade)
    values(customer_seq.nextval, 'testuser1', '010-1212-3434', '2022-01-01', '2022-03-11', 5500, 'VIP'); 
insert into customer(no, id, num, date, buy, mile, grade)
    values(customer_seq.nextval, 'testuser2', '010-2323-4545', '2020-05-11', '2022-01-30', 7200, 'VVIP'); 
insert into customer(no, id, num, date, buy, mile, grade)
    values(customer_seq.nextval, 'testuser3', '010-3434-5656', '2021-11-26', '2021-12-25', 30000, '플래티넘'); 
insert into customer(no, id, num, date, buy, mile, grade)
    values(customer_seq.nextval, 'testuser4', '010-4545-6767', '2022-02-03', '2022-03-15', 500, '일반'); 
insert into customer(no, id, num, date, buy, mile, grade)
    values(customer_seq.nextval, 'testuser5', '010-5656-7878', '2021-12-31', '2022-01-31', 800, '일반'); 
    
    commit; 
