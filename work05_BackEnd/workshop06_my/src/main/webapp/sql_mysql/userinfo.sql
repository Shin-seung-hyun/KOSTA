DROP TABLE USERINFO;

CREATE TABLE USERINFO ( 
	userId varchar(12) primary key, 
	password varchar(12) NOT NULL,
	name varchar(20) NOT NULL,
	email varchar(50));

INSERT INTO USERINFO VALUES('admin', 'admin', '������', 'admin@google.com');
INSERT INTO USERINFO VALUES('java', 'java', '�ڹ�����', 'java@jaen.com');
INSERT INTO USERINFO VALUES('kosta', '1234', '������', 'hsh@kosta.com');
commit;