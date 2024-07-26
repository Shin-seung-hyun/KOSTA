/*
workshop_7
*/

-- 1. 위의 MY_DEPT의 구조와 같은 테이블을 생성하는 SQL 구문을 작성하세요.
CREATE TABLE MY_DEPT(
	dept_no TINYINT,
    dept_name varchar(10),
    dept_loc varchar(10),
    dept_telno varchar(20)
);

-- 2. MY_DEPT 테이블의 PK를 설정하는 구문을 추가하여 작성하세요. (단, PK 명은 MY_DEPT_PK ) 
alter table my_dept ADD CONSTRAINT  my_dept_pk PRIMARY KEY(dept_no);
desc my_dept;

-- 3. MY_DEPT 테이블에 위 표의 제공된 데이터를 입력하는 SQL 구문을 작성하세요.
INSERT INTO MY_DEPT values(10, 'SALES', 'SEOUL ', '02-671-1111');
INSERT INTO MY_DEPT values(20, 'FINANCE', 'SEOUL ', '02-862-2222');
INSERT INTO MY_DEPT values(30, 'HR', 'BUSAN ', '051-111-1111');
INSERT INTO MY_DEPT values(40, 'PURCHASE', 'BUSAN ', '051-222-2222');
INSERT INTO MY_DEPT values(50, 'MANAGEMENT', 'SEOUL ', '02-383-3333');

select * from my_dept;


-- 4. 위 MY_EMP 테이블을 생성하는 SQL 구문을 작성하세요.
CREATE TABLE MY_EMP(
	emp_no int(4),
    emp_name varchar(10),
    emp_mgr int(4),
    hiredate date,
    sal double,
    dept_no TINYINT
);

-- 5. MY_EMP 의 constraint PK, FK 를 추가하는 SQL 구문을 작성하세요.(PK : my_emp_ pk ,FK : my_emp_fk)
alter table my_emp ADD CONSTRAINT my_emp_pk PRIMARY KEY(emp_no);
ALTER TABLE my_emp ADD CONSTRAINT my_emp_fk FOREIGN KEY(dept_no) REFERENCES my_dept(dept_no) ON DELETE CASCADE;
desc my_emp;
desc my_dept;

-- 6. MY_EMP 테이블에 제공된 데이터를 입력하는 SQL 구문을 작성하세요.
INSERT INTO my_emp VALUES(1001, 'KIM', '1003', '2019-01-15', 4750, 20 );
INSERT INTO my_emp VALUES(1002, 'LEE', '1003', '2021-06-05', 3000, 30 );
INSERT INTO my_emp VALUES(1003, 'PARK', '1001', '2023-11-28', 3500, 10 );

select * from my_emp;

-- 7. 위 MY_EMP 테이블에 ‘HR’ 부서 직원의  소속 부서를 ‘MANAGEMENT’ 부서로 변경하는 SQL 구문을 작성하세요.
UPDATE my_emp 
set dept_no = (select dept_no from my_dept where dept_name ='MANAGEMENT')
where dept_no = (select dept_no from my_dept where dept_name ='HR');

select * from my_emp;


-- 8. 위 MY_DEPT 테이블에 ‘HR’ 부서를 삭제하는 SQL 구문을 작성하세요.
INSERT INTO my_emp VALUES(1004, 'LEE', '1003', '2021-06-05', 3000, 30 );
delete from my_dept where dept_name = 'HR';

select * from my_emp;
select * from my_dept;

-- 9. 아래의 데이터를 MY_EMP 테이블에 추가하세요. 
-- 추가 시에 입사일은 시스템의 현재일자를 자동으로 가져와서 부여하도록 SQL 구문을 작성하세요.

INSERT INTO my_emp VALUES (2001, 'chung', 1001, date_format(now(), '%Y-%m-%d'), 3000, 50);
select * from my_emp;

-- 10. MY_EMP , MY_DEPT  테이블을 부서코드로 JOIN해서 view 생성하는 SQL 구문을 작성하세요.
-- (emp_no, emp_name, emp_mgr, hiredate, sal, dept_no, dept_name, dept_loc 를 보여주는 view 생성)
--  Naming Rule > emp_dept_view

CREATE VIEW emp_dept_view 
AS(select e.emp_no, e.emp_name, e.emp_mgr, e.hiredate, e.sal, d.dept_no, d.dept_name, d.dept_loc
	from my_emp e join my_dept d on e.dept_no = d.dept_no);

-- 11. 생성된 view를 실행하여 보자.
select * from emp_dept_view;

drop table my_emp;
drop table my_dept;
drop view emp_dept_view;

