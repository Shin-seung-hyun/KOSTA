/*
[데이터 베이스 객체]
1. table
2. index
3. view

*/

-- ================================================== 인덱스 ====================================================
-- 인덱스
-- emp 테이블의 데이터가 100만 개로 가정할 때, ename = 'SCOTT' 인 사원을 검색해보자
-- 이때, DB는 100만 row를 모두 검색하는 full scan 방식으로 검색한다. (성능이 매우 안 좋다.)
-- ename 에 인덱스가 걸려 있다면, 동일한 쿼리지만 성능이 엄청 올라간다. (인덱스는 컬럼 레벨이 지정하는 것이다.)
select * from emp where ename = 'SCOTT';

/*
인덱스의 정의
DB에서 인덱스를 사용하는 이유는
검색 조건을 만족하는 레코드를 빠르게 조회하기 위함이다.
대용량 데이터에서 인덱스 지정은 필수 조건이다.

인덱스의 종류
1. 클러스터드 인덱스 (Clustered Index) (= primary key 인덱스)
   기본키 지정하는 순간 클러스터드 인덱스가 만들어 진다. (즉, primarkey 는  인덱스이다.)
   
2. 논클러스터드 인덱스 (Non-Clustered Index) (= 세컨더리, 보조 인덱스)

*/

-- 1) tb1 테이블 생성 시, pk 제약 조건을 지정
-- pk 제약 조건을 지정하면 인덱스가 자동으로 생성된다. (= 클러스터드 인덱스)
CREATE TABLE tb1(
	a int primary key,
	b int,
    c int
);
show index from tb1;

-- 2) tb2 테이블 생성 시, pk + unique 제약조건 지정
CREATE TABLE tb2(
	a int PRIMARY KEY,
    b int UNIQUE,
    c int UNIQUE,
    d int
);
show INDEX from tb2;

DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;

CREATE TABLE employee AS SELECT * FROM emp;
CREATE TABLE department AS SELECT * FROM dept;

ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);
ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk FOREIGN KEY(deptno) REFERENCES department(deptno);

desc employee;
desc department;


-- ----------------------------------- 인덱스 걸기 ----------------------------------------
/*
1),2) 은 데이블 생성 시 인덱스에 문제가 있다.
1),2) 은 테이블 생성 시 컬럼에 제약 조건을 부여 --> 자동으로 인덱스가 만들어지도록

3) 테이블은 이미 만들어져 있고 데이터까지 다 들어가 있다.
이 상황에서 인덱스를 걸어보자 

select * from empolyee where ename = 'SCOTT';
ename은 인덱스가 안 걸림 컬럼이다. 데이터가 대용량일 때는 성능이 안 좋다.
ename은 이름이 동일한 사원이 존재할 수 있기에 중복이 허용된다. 따라서 중복을 허용하는 인덱스를 만들어야 한다. ( Non-Uniuqe 가 1)

*/

-- 보조 인덱스를 직접 만들어 보자
-- 이름 컨벤션
-- 어떤 테이블에_어떤 컬럼의_이름
-- 3)
-- 생성된 테이블에서 index를 지정하기
CREATE INDEX employee_ename_idx on employee(ename);
show index from employee;

/*
두 개의 컬럼을 합쳐서 인덱스를 걸어줄 수 있다.!!

아래와 같은 경우가 있다.
job		  		 jobNumber
salesman  	-      123
clerk		-      123

3강의장의 7번학생을 알고 싶다.
2깅의장의 7번학생을 알고 싶다.

*/
-- job의 jnumber는 하나밖에 없다. 
-- 그러나 아래와 같이 idx를 만들면 중복되는 인덱스가 만들어져 문제가 생긴다.
CREATE INDEX employee_job_junmber_idx on employee(job, jnumber);

-- unique 를 써야 한다.
CREATE UNIQUE INDEX employee_job_junmber_idx on employee(job, jnumber);

-- 4) 
-- 데이블을 생성하면서 인덱스를 걸어주는 방법
-- 2개의 컬럼을 결합해서 unique한 인덱스를 생성해보자
create table player(
	id int PRIMARY key,	 -- 클러스터드 인덱스 생성
    name varchar(10) not null,
    team_id int, 
    backnumber int,
    INDEX (name), -- 중복되는 보조인덱스 생성
    UNIQUE INDEX(team_id, backnumber) -- team_id 별로 quniqe한 backnumber 보조 인덱스 지정
);
show index from player;



-- ================================================== 뷰 ====================================================
/*
뷰 View
사용자에게 접근이 허용된 자료만을 제한적으로 보여주기 위해
하나 이상의 기본 테이블로부터 유도된, 이름을 가지는 가상의 테이블이다.
테이블이지만 실질적으로 DB 내에 물리적인 저장 장치를 가지지 않는다.

읽기 전용의 테이블이라고 생각하면 된다.

뷰는 기본적으로 읽기 전용이다.
권장사항은 아니지만 데이터의 삭제/수정을 할 수는 있다.
*/

-- 뷰 생성 1)
-- CREATE VIEW empView(
-- ~~~
-- );

-- 뷰 생성 2)
-- 이미 있는 테이블 중 민감정정보를 가리고 보여주는 것으로 catas로 생성하는 것이 개념적으로 맞다.
CREATE VIEW empView AS select empno, ename from emp;

-- 뷰 확인
select * from empView;

-- 뷰 삭제
delete from empView where empno= 7369;
drop view empView;








