/*
과제
    
    다음 정보를 저장할 수 있도록 테이블을 생성하고 데이터 추가 구문을 만들어보세요.
    
    <테이블 요구사항>
    - 고객 테이블 생성(customer)
    - 컬럼 정보
        - 고객번호 : 숫자로 구성되어 있으며 반드시 입력되어야 하고 중복이 불가능. 시퀀스로 자동 부여되도록 구현
        - 고객아이디 : 영문+숫자로 구성된 8~20자 데이터이며, 반드시 입력되어야 하고 중복이 불가능
        - 고객전화번호 : 010-XXXX-XXXX으로 구성된 데이터이며, 반드시 입력되어야 하고 중복이 불가능
        - 등록일 : 첫 구매일자를 저장하기 위한 컬럼이며, 날짜 형식(YYYY-MM-DD)으로 저장됨. 반드시 입력되어야 함
        - 최종 구매일 : 마지막 구매일자를 저장하기 위한 컬럼이며 등록일과 형식이 같다.
        - 마일리지 : 회원이 물건을 구매하면 적립금을 표시하기 위한 컬럼이며, 0이상으로 설정하며, 없을 수도 있다.
        - 고객 등급 : 고객의 구매수준에 따라 변경 가능한 등급이며 다음과 같이 설정한다.
            - 일반, VIP, VVIP, 플래티넘 중 한 가지로 설정 가능하다.
    <시퀀스 요구사항>
    - 시퀀스 생성(customer_seq)
    - 기본 옵션으로 생성
    
    <회원 정보>
        - 아이디 : testuser1 , 전화번호 : 010-1212-3434, 등록일 : 2022-01-01, 최종구매일 : 2022-03-11, 마일리지 : 5500, 등급 : VIP
        - 아이디 : testuser2 , 전화번호 : 010-2323-4545, 등록일 : 2020-05-11, 최종구매일 : 2022-01-30, 마일리지 : 7200, 등급 : VVIP
        - 아이디 : testuser3 , 전화번호 : 010-3434-5656, 등록일 : 2021-11-26, 최종구매일 : 2021-12-25, 마일리지 : 30000, 등급 : 플래티넘
        - 아이디 : testuser4 , 전화번호 : 010-4545-6767, 등록일 : 2022-02-03, 최종구매일 : 2022-03-15, 마일리지 : 500, 등급 : 일반
        - 아이디 : testuser5 , 전화번호 : 010-5656-7878, 등록일 : 2021-12-31, 최종구매일 : 2022-01-31, 마일리지 : 800, 등급 : 일반
*/

DROP TABLE CUSTOMER;
DROP SEQUENCE CUSTOMER_SEQ;
CREATE TABLE CUSTOMER  (
CUSTOMER_NO NUMBER NOT NULL UNIQUE,
CUSTOMER_ID VARCHAR2(20) NOT NULL UNIQUE
    CHECK(REGEXP_LIKE(CUSTOMER_ID, '^[a-z0-9]{8,20}$')),
CUSTOMER_PHONE CHAR(13) NOT NULL UNIQUE
    CHECK(REGEXP_LIKE(CUSTOMER_PHONE, '^010-\d{4}-\d{4}$')),
CUSTOMER_REGIST CHAR(10) NOT NULL
    CHECK(REGEXP_LIKE(CUSTOMER_REGIST, '^(19|20)\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$')),
CUSTOMER_PURCHASE CHAR(10) NOT NULL
    CHECK(REGEXP_LIKE(CUSTOMER_PURCHASE, '^(19|20)\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$')),
CUSTOMER_MILEAGE NUMBER DEFAULT 0
    CHECK(CUSTOMER_MILEAGE >= 0),
CUSTOMER_GRADE VARCHAR2(12) DEFAULT '일반' NOT NULL
    CHECK(CUSTOMER_GRADE IN ('일반', 'VIP', 'VVIP', '플래티넘'))
);

CREATE SEQUENCE CUSTOMER_SEQ;

INSERT INTO CUSTOMER(
    CUSTOMER_NO, CUSTOMER_ID, CUSTOMER_PHONE,
    CUSTOMER_REGIST, CUSTOMER_PURCHASE, CUSTOMER_MILEAGE,
    CUSTOMER_GRADE
)
VALUES(
    CUSTOMER_SEQ.NEXTVAL, 'testuser1', '010-1212-3434', 
    '2022-01-01', '2022-03-11', 5500, 'VIP'
);

INSERT INTO CUSTOMER(
    CUSTOMER_NO, CUSTOMER_ID, CUSTOMER_PHONE,
    CUSTOMER_REGIST, CUSTOMER_PURCHASE, CUSTOMER_MILEAGE,
    CUSTOMER_GRADE
)
VALUES(
    CUSTOMER_SEQ.NEXTVAL, 'testuser2', '010-2323-4545', 
    '2020-05-11', '2022-01-30', 7200, 'VVIP'
);

INSERT INTO CUSTOMER(
    CUSTOMER_NO, CUSTOMER_ID, CUSTOMER_PHONE,
    CUSTOMER_REGIST, CUSTOMER_PURCHASE, CUSTOMER_MILEAGE,
    CUSTOMER_GRADE
)
VALUES(
    CUSTOMER_SEQ.NEXTVAL, 'testuser3', '010-3434-5656', 
    '2021-11-26', '2021-12-25', 30000, '플래티넘'
);

INSERT INTO CUSTOMER(
    CUSTOMER_NO, CUSTOMER_ID, CUSTOMER_PHONE,
    CUSTOMER_REGIST, CUSTOMER_PURCHASE, CUSTOMER_MILEAGE,
    CUSTOMER_GRADE
)
VALUES(
    CUSTOMER_SEQ.NEXTVAL, 'testuser4', '010-4545-6767', 
    '2022-02-03', '2022-03-15', 500, '일반'
);

INSERT INTO CUSTOMER(
    CUSTOMER_NO, CUSTOMER_ID, CUSTOMER_PHONE,
    CUSTOMER_REGIST, CUSTOMER_PURCHASE, CUSTOMER_MILEAGE,
    CUSTOMER_GRADE
)
VALUES(
    CUSTOMER_SEQ.NEXTVAL, 'testuser5', '010-5656-7878', 
    '2021-12-31', '2022-01-31', 800, '일반'
);

commit;

select * from customer;


