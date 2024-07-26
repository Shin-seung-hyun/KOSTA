/*
2024.07.25 DDL/DML

DDL
테이블 생성하기 -- create table
테이블 삭제하기 -- drop table
테이블 칼럼, 데이터 타입 변경하기 -- alter table

DML
데이터 추가하기 -- insert into
데이터 수정하기 -- update
데이터 삭제하기 -- delete

*/

-- 1. 테이블 생성
drop table custom;

create table custom(
num int auto_increment,   -- client에서 입력될 때 DB가 자동으로 입력하는 값 
name varchar(10) not null, -- client에서 입력하는 값
addr varchar(100),
birthday date,
primary key(num)); -- 테이블 레벨에서 제약 조건 추가하기

desc custom;

--  2. 데이터 추가하기
-- insert into 테이블명 ( 컬럼,컬럼) values(값,값);
insert into custom (name, addr, birthday) values('전현무', '창신동', '1980-02-12');
insert into custom (name, addr, birthday) values('박나래', '여의도', '1983-01-11');
insert into custom (name, addr, birthday) values('이장우', '방배동', '1985-03-12');

select * from custom where num = 1;
select * from custom;

-- 3. 데이터 수정하기
-- update 테이블명 set 수정할 컬럼 = '수정값', 수정컬럼 = '수정값' where pk값
-- 박나래 고객의 주소를 신사동으로 변경, 생년월일 1982년도 생으로 변경

update custom set addr='신사동', birthday='1982-01-11' where num=2;
select * from custom;

-- 4. 삭제 하기
/*

삭제 관련된 SQL 3가지
어떻게 다른지 아는 것이 중요하다!!!!!

1. drop : 구조를 남긴다.
2. truncate : drop + create
3. delete : where 절과 함께 사용한다. 부분삭제이다. 값이 다 삭제되도 테이블의 구조COMM는 남는다.

*/

-- CTAS를 이용해서 custom과 동일한 테이블 mycustomer을 생성
create table mycustom as (select * from custom);
desc mycustom;

delete from mycustom; -- mycustom의 모든 데이터가 삭제됨
					  -- 그러나, 이런 용도가 아님 조건에 해당하는 것만 삭제하는 것이다.
delete from mycustom where num = 3; -- Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.
desc mycustom;

select * from mycustom;
select * from custom;

truncate table custom;  -- where 절을 못 씀. 구조는 남기고 전체 삭제한다.
desc custom;

drop table mycustom; -- 구조 삭제
desc mycustom;


drop table outerb;

