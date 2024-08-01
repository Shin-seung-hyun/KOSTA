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