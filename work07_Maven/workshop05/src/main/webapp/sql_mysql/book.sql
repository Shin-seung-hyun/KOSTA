DROP TABLE book;

create table book(
isbn char(12) primary key,
title varchar(50) not null,
catalogue varchar(30) not null,
nation varchar(30),
publish_date date,
publisher varchar(50),
author varchar(50) not null,
price decimal(6,0) not null,
currency char(6),
description varchar(2000));

INSERT INTO book VALUES('1233-111-111','Java �ϼ�','���α׷���','��������',
         '2019.01.01','�繫��','�繫��',3000,'��','java�� ������');
INSERT INTO book VALUES('1233-111-222','�������� ��뷮 ����Ÿ�м�','���α׷���','���ܵ���',
         '2023.01.02','�繫��','�繫��',4000,'��','��뷮 ����Ÿ');
INSERT INTO book VALUES('1233-111-333','AI����','���α׷���','��������',
         '2024.08.22','�繫��','�繫��',6000,'��','AI�� ����');
		 
commit;