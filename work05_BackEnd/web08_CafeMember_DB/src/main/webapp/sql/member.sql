create table Member(
	id varchar(20) primary key,
    password varchar(20) not null,
    name varchar(20),
    address varchar(100)
);

desc member;

insert into Member VALUES("kosta", "1234", "홍종각", "종각");

select * from member;