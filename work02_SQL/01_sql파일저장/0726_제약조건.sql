/*
24.07.26

1. 제약조건 추가하기
	컬럼에 부여 - not null, unique(null 허용), pk(not null + unique)
	
	emp(직원 d.deptno(fk) -- RDBMS -- dept(부서 deptno(pk))
	다른 테입르의 기본키를 가져옴으로 인해서 제약 조건이 생성됨(fk)


*/

desc emp;
desc dept;

-- 대용량 샘플 데이터 생성하기 CTAS 로 
-- employee , department 테이블을 생성해보자

create TABLE employee as (select * from emp);
create TABLE department as (select * from dept);

-- ctas로 테이블의 테이터는 그대로 사용할 수 있지만 제약 조건은 적용돼있지 않다.
-- 기본키 제약 조건부터 다시 설정해야 한다.
desc employee;
desc department;

-- 1. 제약 조건 추가하기(기본키 제약 조건)
ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);
ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);

desc employee;
desc department;

-- 20번 부서의 직원이 아직 남아 있다.
-- 테이블의 관계를 지정하지 않아서 이다. FK 설정이 안돼있다.
select * from department;
DELETE from department where deptno = 20;
select * from employee;

-- 2. 제약 조건 추가(외래키 fk)
-- 자식 테이블에만 fk를 지정한다.
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk FOREIGN KEY(deptno) REFERENCES department(deptno);

-- 2-1 제약조건 추가(외래키 fk) + casecade 옵션 지정
-- - 2-1-1. 자식을 먼저 삭제하고, 부모를 삭제 (기본 삭제 방법)
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk FOREIGN KEY(deptno) REFERENCES department(deptno)
ON DELETE CASCADE;

-- - 2-1-2. 자식의 모든 값을 null로 채우고 부모가 삭제 
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk FOREIGN KEY(deptno) REFERENCES department(deptno)
ON DELETE SET NULL;

-- 3. 데이터 삭제하기
-- 10번 부서의 직원이 모두 삭제 됨
delete from employee where deptno = 10;
select * from employee;

delete from department where deptno = 20; -- ERROR 발생 : 자식을 가진 부모는 죽일 수 없다.
select * from employee;

-- 자식을 갖는 부모가 죽는 방법
-- 1) 자식을 먼저 죽이고 부모가 죽는 방법
-- 2) 자식 컬럼의 데이터 값을 null로 채우고 부모가 죽는 방법
-- - FK를 지정할 때는 1),2)가 되도록 조건을 추가해야 한다.
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk FOREIGN KEY(deptno) REFERENCES department(deptno)
ON DELETE CASCADE;
delete from department where deptno = 20; 
select * from employee; -- 삭제가 잘 된 것을 확인!
						-- on delete cascade 옵션을 지정해서 deptno = 20인 employee 사원도 함께 삭제 됨
                        
                        
desc employee;
desc department;
select * from department;
select * from employee;
drop table department;
drop table employee;










