
-- -------------------------------- workshop01 ------------------------
CREATE TABLE employee (
  `num` int  AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(10) ,
  `salary` double  ,
  `address` varchar(10)
);

create index employee_name_idx on employee(name);

select * from employee;

desc employee;

-- -------------------------------- workshop02 03 ------------------------
create table book(
	isbn char(8) PRIMARY KEY,
	title varchar(50) not null,
    author varchar(10) not null,
    publisher varchar(10) not null,
    price int not null,
    description varchar(200)
);

select * from book;

select isbn, title, author, publisher, price, description from book where isbn='a1101';

select count(isbn) from book;

drop table book;

select isbn, title, author, publisher, price, description from book where title like '%JAVA%';
                
update book b, (select isbn, price from book where publisher = '한빛 출판사') b2 set b.price = b2.price * 0.2 where b.isbn = b2.isbn;
select * from book;


-- -------------------------------- jdbc 29일차 : DB 정규화 ------------------------

-- ------------------ 정규화 전 
create table companysawon (
company varchar(20),
address varchar(50),
phone varchar(35),
sawon_name varchar(30),
position varchar(30),
email varchar(50),
hp varchar(20)
);
insert into companysawon values ('LG','서울강남구','02-123-1234', '홍길동','사원','aaa@naver.com','010-222-1111');
insert into companysawon values ('KT','분당','02-222-2323','이영자','과장','bbb@naver.com','010-2222-3434');
insert into companysawon values ('SK','부산','02-555-1234', '강호동','부장','ccc@naver.com','010-7777-8888');

select * from companysawon;

-- ------------------ 정규화 진행 후
create table company (
company_id int primary key,
company varchar(20),
address varchar(50),
phone varchar(35)
);
INSERT INTO company(company_id, company, address,phone) VALUES(10,'LG','서울강남','02-111-2323');
INSERT INTO company(company_id, company, address,phone) VALUES(20,'KT','분당','031-455-6666');
INSERT INTO company(company_id, company, address,phone) VALUES(30,'SK','정자','031-323-2342');

select * from company;

create table sawon (company_id int ,
 sawon_name varchar(20),
 position varchar(20),
 email varchar(40),
 hp varchar(40), foreign key(company_id) references company(company_id) on delete cascade);
INSERT INTO sawon VALUES (10, '피준범','과장','junbumpi@kosta.com','010-2345-1122');
INSERT INTO sawon VALUES (10, '이새봄','대리','bom@daum.net','010-4329-3355');
INSERT INTO sawon VALUES (30, '김아름','대리','beauty@google.com','010-9901-8232');
INSERT INTO sawon VALUES (20, '박이리','대리','beauty@google.com','010-9901-8232');

select * from companysawon;
select * from company;
select * from sawon;


-- KT 회사의 주소를 나주시로 변경, 전화번호도 변경
-- KT의 소속된 사원의 이름, 직급, 회사명, 회사번호을 검색 (이때, 변경된 회사 주소가 출력된다)

update company set address = '나주시' where company = 'KT';

select s.sawon_name, s.position, c.company, c.company_id, c.address
from company c join sawon s on c.company_id = s.company_id
where c.company = 'KT';


-- ------------------------------------------- Workshop04 --------------------------------------

create table book(
	isbn char(8) PRIMARY KEY,
	title varchar(50) not null,
    author varchar(10) not null,
    publisher varchar(10) not null,
    price int not null,
    description varchar(200)
);

-- 1.
create table author(
	authorno int(2) primary key,
    name varchar(50),
    phone varchar(30)
);

-- 2.
desc book;
desc author;
alter table book modify author int(2);
alter table book add FOREIGN KEY(author) REFERENCES author(authorno);

-- author 데이터 입력
insert into author VALUES(10,"김작가", "010-1111-1111");
insert into author VALUES(20,"박작가", "010-1111-1111");
insert into author VALUES(30,"오작가", "010-1111-1111");
insert into author VALUES(40,"김작가2", "010-1111-1111");
select * from author;

-- book 데이터 입력
insert into book VALUES("a1101", "JAVA 기본", 10, "자앤 출판사", 23000, "기본");
insert into book VALUES("a1105", "JAVA 기본", 10, "자앤 출판사", 23000, "기본");
insert into book VALUES("a1106", "JAVA 기본", 10, "자앤 출판사", 23000, "기본");
insert into book VALUES("a1107", "JAVA 기본", 10, "자앤 출판사", 23000, "기본");
insert into book VALUES("a1102", "JAVA 기본", 20, "자앤1 출판사", 23000, "기본");
insert into book VALUES("a1103", "JAVA 기본", 30, "자앤2 출판사", 23000, "기본");
insert into book VALUES("a1104", "JAVA 기본", 40, "자앤3 출판사", 23000, "기본");

select * from book;

-- 3. book, author join해서 도서명,가격,저자명 검색
select b.title, b.price, a.name
from book b join author a on b.author = a.authorno;

-- 4. 이름이 ‘ 김XX ’인 저자의 도서명, isbn, 출판사를 출력하는 기능
select b.title, b.isbn, b.publisher
from book b join author a on b.author = a.authorno
where a.name like '김%';

-- 5. 저자명 별로 출간된 도서들을 도서명, 출판사, 가격, 저자명을 출력
select * from author;
select * from book;

select title, publisher, price, a.name
from book b join author a on b.author = a.authorno
where a.name = "김작가";

-- 6. Book 테이블에 concat( ‘IoT세상은 미래닷컴에서 출판했다’)
select concat(title, "세상은 ", publisher, "에서 출판했다") as print
from book;










