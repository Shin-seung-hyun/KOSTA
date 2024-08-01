CREATE TABLE book(
isbn char(8) PRIMARY KEY,
title varchar(50) not null,
author varchar(10) not null,
publisher varchar(15) not null,
price int not null,
description varchar(200)
);

DESC book;

select * from book;

-- workshop 4 --
-- 1. 작가 컬럼이 있는 행 삭제, 작가 컬럼의 속성, 명칭 변경 
DELETE FROM book where author is not null;
ALTER TABLE book MODIFY author int(2);
ALTER TABLE book CHANGE author authorno int(2);

-- 2. 작가 테이블 생성, 책 테이블의 작가번호 컬럼에 외래키 설정
CREATE TABLE author(
authorno int(2) PRIMARY KEY,
name varchar(50),
phone varchar(30)
);
ALTER TABLE book ADD CONSTRAINT  book_authorno_fk FOREIGN KEY (authorno) REFERENCES author(authorno);

DESC author;

select * from author;

-- 3. 테이블에 데이터 추가
INSERT INTO author VALUES (01, '김민규', '010-1111-1111');
INSERT INTO author VALUES (02, '차은우', '010-2222-2222');
INSERT INTO author VALUES (03, '이찬', '010-3333-3333');

INSERT INTO book VALUES ('a1101', 'JAVA 기본', 01, '자앤 출판사', 23000, '기본');
INSERT INTO book VALUES ('a1102', 'JAVA 중급', 02, '자앤 출판사', 25000, '중급');
INSERT INTO book VALUES ('a1103', 'JAVA 실전', 03, '자앤 출판사', 30000, '실전');
INSERT INTO book VALUES ('a1104', 'JDBC 기본', 01, '자앤 출판사', 23000, '기본');
INSERT INTO book VALUES ('a1105', 'Python 중급', 02, '자앤 출판사', 25000, '중급');
INSERT INTO book VALUES ('a1106', 'LAMBDA 실전', 03, '자앤 출판사', 30000, '실전');

-- JDBC 쿼리문 테스트 
select isbn, title, authorno, publisher, price, description from book;

select concat(b.isbn, ' ', b.title, ' ', b.authorno, ' ', a.name, ' ', a.phone, ' ', b.publisher, ' ', b.price, ' ', b.description) '책과 작가'
from book b JOIN author a USING (authorno);

select concat(b.isbn, ' ', b.title, ' ', b.authorno, ' ', a.name, ' ', a.phone, ' ', b.publisher, ' ', b.price, ' ', b.description)
from book b, author a;

select a.name, b.title, b.isbn, b.publisher
from book b JOIN author a ON b.authorno=a.authorno
where a.name like '김%';

select concat(a.name, b.title, b.isbn, b.publisher)
from book b JOIN author a ON b.authorno=a.authorno where a.name like '김%';

select a.name, b.title, b.publisher, b.price, count(a.name)
from book b JOIN author a USING (authorno)
GROUP BY a.name, b.title, b.publisher, b.price;

select concat(title, '은 ', publisher, '에서 출판했다')
from book;

