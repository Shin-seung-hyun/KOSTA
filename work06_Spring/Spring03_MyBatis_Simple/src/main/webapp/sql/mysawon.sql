create table mysawon(
	num int(10) auto_increment primary key,
	id varchar(10) not null,
	pwd varchar(20),
	name varchar(20),
	age int(3),
	hiredate date,
	constraint mysawon_id_uq unique(id)
);


INSERT INTO users VALUES('user01','홍길동','user01',10,1,'2019-10-11'); 
INSERT INTO users VALUES('user02','이순신','user02',20,2, '2019-10-12');
INSERT INTO users VALUES('user03','김유신','user03',30,3, '2019-10-09'); 
INSERT INTO users VALUES('mybatis01','홍길동iba','mybatis01',10,1,'2019-10-08');
INSERT INTO users VALUES('mybatis02','이순신iba','mybatis02',20,2, '2019-10-07');
INSERT INTO users VALUES('mybatis03','김유신iba','mybatis03',30,3,'2019-10-02');