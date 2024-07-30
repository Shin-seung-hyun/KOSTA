
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
