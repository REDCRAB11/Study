 drop table fifa;

create table fifa(
    rank number(1),
    state varchar2(30),
    score number(6, 2) -- 6대신 와일드카드 * 넣어도 됨 0000
    );

insert into fifa(rank, state, score)values(1,'브라질',1828.45);
insert into fifa(rank, state, score)values(2,'벨기에',1823.42);
insert into fifa(rank, state, score)values(3,'프랑스',1786.15);

commit;


-- 한글이나 한자만 2바이트 영어는 1바이트 
-- (참고) 문자열은 char(고정) 와 varchar2(가변) 이 존재한다. 
-- char: 무고전 지정된 크기를 꽉 채워서 저장(무조건) 속도가 빠름 
-- vachar2: 최대 크기만 지키고 내부에서 자유롭게 사용 효율성이 좋음 

-- 테이블에 들어갈 값의 형태를 check 조건을 설정하여 지정할 수 있다. 
-- in 이라는 기호가 있으면 우측에 있는 값 중 하나란 뜻 

drop table telephone;

create table telephone(
    phone char(2)check(phone in('SK','KT','LG')),
    product varchar2(60),
    charge number(10) check(charge >= 0),
    gb number(10) check(gb >= 0), 
    call number(10)check(call >= 0),
    text number(10) check(text >= 0)
    );
    
    insert into telephone(phone, product, charge, gb, call, text) values('SK', '5G언택트 52', 52000, 300, 1000, 2000);
    insert into telephone(phone, product, charge, gb, call, text) values('KT', '5G세이브', 45000, 100, 900, 1500);
    insert into telephone(phone, product, charge, gb, call, text) values('LG', '5G시그니처', 130000, 500, 2000, 2500);

    commit;
    
    
-- (참고) 오라클은 && 대신 and, || 대신 or 을 사용한다.
-- 구간을 처리할 수 있는 between 연상을 따로 지원한다. ~이상 ~이하만 처리 가능 
-- unique 키워드를 추가하면 중복 데이터 추가 불가능     
    
drop table exam;
    
create table exam(
    name varchar2(21) unique check(regexp_like(name,'^[가-힣]{2,7}$')),
    kor number(3) check(kor >= 0 and kor <= 100),
    eng number(3) check(eng between 0 and 100),
    mat number(3) check(mat between 0 and 100)
    );
    
    insert into exam(name, kor, eng, mat) values('피카츄', 90, 90, 85);
    insert into exam(name, kor, eng, mat) values('라이츄', 80, 90, 85);
    insert into exam(name, kor, eng, mat) values('꼬부기', 100, 90, 90);
    
    commit;
    
    
    
    
    