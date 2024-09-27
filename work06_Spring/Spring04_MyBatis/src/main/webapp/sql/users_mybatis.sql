DROP TABLE users;

CREATE TABLE users ( 
user_id      VARCHAR(10)   PRIMARY KEY,
user_name   VARCHAR(10)   NOT NULL,
password    VARCHAR(10)    NOT NULL,
age         int(3),
grade       int(3),
reg_date     DATE 
);

INSERT INTO users VALUES('user01','홍길동','user01',10,1,'2019-10-11'); 
INSERT INTO users VALUES('user02','이순신','user02',20,2, '2019-10-12');
INSERT INTO users VALUES('user03','김유신','user03',30,3, '2019-10-09'); 
INSERT INTO users VALUES('mybatis01','홍길동iba','mybatis01',10,1,'2019-10-08');
INSERT INTO users VALUES('mybatis02','이순신iba','mybatis02',20,2, '2019-10-07');
INSERT INTO users VALUES('mybatis03','김유신iba','mybatis03',30,3,'2019-10-02');

COMMIT;