/*
2027.07.25

Join
여러 개의 테이블로부터 데이터를 가져오는 경우에 사용되는 기법
"하나 이상의 테이블에서 질의를 던지는 경우에 필요하다" 

일반적인 경우 2개의 테이블을 연결시키는 즉, RDBMS(관계형 데이터베이스)를 가능하게 하는 핵심 키워드는 PK, FK의 관계이다.
하지만 PK, FK 관계 없이, 논리적인 값들의 연결만으로도 join 작업이 가능하다. (아직, 제약 조건을 배우지 않았기에 오늘은 이렇게 실습을 진행하자)

조인의 종류
	1) EQui Join -> 가장 대표적인 조인
	2) Self Join
	3) Outer Join 

*/

-- description의 약어
desc emp;
desc dept;

select * from dept; -- 10 20 30 40번 부서 존재
select distinct deptno from emp; -- 10 20 30번 부서 존재

-- -------------------------------------- [ 1. EQui join ]------------------------------------------------------
-- 모든 사원이 어떤 부서에서 일하는지를 검색해보자 (사원이름, 업무, 부서번호, 부서 이름, 부서 위치)
select * from emp;  --  14
select * from dept; -- 4

/*
Cartesian Product
emp와 dept 테이블이 단순히 수평적으로 결합했다.
14 * 4 =  56

Cartesian Product가 나오는 경우는
1)조인 조건을 생략했을 때 (논리적인 결합을 지정하면 cartesian product가 안나온다)
2)조인 조건을 잘못줬을 때
*/

-- 1 step 
select * from emp, dept; -- 관계가 없기에 56행이 나온다.

-- 2 step 
-- 논리적인 결합이란 무엇일까?
-- 두 테이블 간의 공통적인 컬럼이 있다. 이 컬럼으로 결합하는 것은 말한다.
-- deptno 가 공통된다.
select *
from emp, dept
where emp.deptno = dept.deptno;

/*
	EQui Join
	1. where 절 뒤에 = 연산자를 사용하는 조인이다.
	2. 두 테이블의 공통적인 컬럼을 연결하는 방식이다.
    
    그러나, 해당 조인은 Projection이 없어서 기밀한 정보까지 노출되고 있다.
    또한, deptno 칼럼이 중복된다.
*/

-- 3 step 
select empno, ename, deptno, dname, loc
from emp, dept
where emp.deptno = dept.deptno; -- ERROR : Column 'deptno' in field list is ambiguous  두 테이블에 모두 deptno가 있다.
								-- 또한, alias를 사용하지 않아 두 테이블을 모두 뒤져서 최악의 성능이다.

-- 4 step                                 
select e.empno, e.ename, e.deptno, d.dname, d.loc
from emp e, dept d 
where e.deptno = d.deptno;

-- 사원의 이름, 급여, 부서 번호, 부서 위치를 검색
-- 단, 급여가 2000달러 이상이고 30번 부서에 한해서만 조회
select e.ename, e.sal, d.deptno, d.loc
from emp e, dept d
where e.sal > 2000    -- 비조인조건
and e.deptno =30      -- 비조인조건
and e.deptno = d.deptno;	-- 조인조건

-- NEW YORK에서 근무하는 사원의 이름과 급여를 검색
select e.ename, e.sal, d.deptno
from emp e , dept d
where e.deptno = d.deptno
and d.loc = 'NEW YORK';

/*
EQiu Join의 한 유형

JOIN으로 결합할 때 많이 사용되는 키워드
1) JOIN ~ ON
	- 조인할 컬럼명이 다른 경우에도 사용할 수 있다. e.ssn == e.rrn
    - on 뒤에 and 절이 올 수 있다. on 뒤에 비조인 조건을 넣는다.
2) JOIN ~ USING
	- 조인할 두 컬럼의 이름이 같은 경우에만 쓸 수 있다. e.deptno = d.deptno
    - 컬럼의 이름이 같은 경우에 using() 안에 공통된 컬럼을 명시한다.
    - using()을 사용한다면 조인 시 양쪽 테이블의 컬럼값을 모두 조회할 필요가 없어서 성능이 좋아진다.
    - 두 테이블에 있는 deptno 값을 두번 부르지 않는 장점이 있다.
    - and 조건절을 사용 못함

*/

-- 1) JOIN ~ ON
select e.empno, e.ename, e.sal, d.deptno, d.dname
from emp e JOIN dept d
ON e.deptno = d.deptno; 

select e.empno, e.ename, e.sal, d.deptno, d.dname
from emp e JOIN dept d
ON e.deptno = d.deptno
and e.sal >= 3000; -- 비조인 조건

select e.empno, e.ename, e.sal, d.deptno, d.dname
from emp e JOIN dept d
ON e.deptno = d.deptno
where e.sal >= 3000; -- 비조인 조건

-- 2) JOIN ~ USING
select e.empno, e.ename, e.sal, deptno, d.dname -- using에 공통적인 컬럼을 넣었기에 그냥 한 테이블만 검색해서 deptno을 찾음. ambiguous X
from emp e join dept d 
using (deptno); -- using 뒤에 공통적인 컬럼을 넣는다.

select e.empno, e.ename, e.sal, deptno, d.dname 
from emp e join dept d 
using (deptno)
and e.sal >=3000; -- ERROR : error in your SQL syntax; 

select e.empno, e.ename, e.sal, deptno, d.dname 
from emp e join dept d 
using (deptno)
where e.sal >=3000;

-- -------------------------------------- [ 2. Self join ] ------------------------------------------------------

-- 특정 사원의 상사 이름을 검색
	-- 1) smith의 mgr을 확인하고
    -- 2) smith의 mgr =  empno인 것을 확인
select empno, ename, mgr from emp;

-- 1) 특정 사원의 ename을 조회 : BLAKE를 찾는다.
-- 2) BLAKE의 상사번호 MGR을 찾는다.
-- -- 
-- 1) 다시 EMP테이블의 empno 가 7839 번인 사람의 이름을 검색

-- step 1)
select empno, ename, mgr from emp e ; -- 사원 테이블 : BLAKE의 mgr이 7839
select empno, ename from emp m; -- 상사의 정보를 찾음

select * 
from (select empno, ename, mgr from emp) e , (select empno, ename from emp ) m ; -- cartesian product : 조인 조건이 없음.

-- step 2) 조인조건 추가
select * 
from (select empno, ename, mgr from emp) e , (select empno, ename from emp ) m 
where e.mgr = m.empno;

-- step 3)
select e.ename 사원이름, m.ename 상사이름
from emp e, emp m
where e.mgr = m.empno;

-- step 4)
select e.ename 사원이름, m.ename 상사이름
from emp e, emp m
where e.mgr = m.empno
and e.ename = 'BLAKE';


-- -------------------------------------- [3. Outer join ] ------------------------------------------------------

/*
Outer join 개념
A, B 두 테이블을 조인할 경우, 
조건에 맞지 않는 데이터도 표시하고 싶을 때 사용하는 조인이다.

Outer join 유형
	1. right outer join
	2. left outer join
	3. full outer join
데이터가 있는 쪽을 기준으로 한다.
*/

-- 조건에 맞는 않는 데이터도 표시된다는 뜻은 무엇일까?
-- 지금까지의 조인 기법은 Inner 조인으로 두 테이블에서 공통적인 부분만 검색했다.
-- deptno = 40인 것은 나타나지 않는다. outter join을 해야한다.
select e.empno, e.ename, e.sal, d.deptno, d.dname
from emp e JOIN dept d
ON e.deptno = d.deptno;

select * from emp;
select * from dept;


-- 1) RIGHT JOIN
-- 조인 수행 시 우측 테이블이 기준이 되어 결과를 출력( 데이터가 있는 쪽을 의미)
select e.ename, e.deptno, d.dname, d.loc
from emp e  right join dept d on e.deptno = d.deptno;

select e.ename, d.deptno, d.dname, d.loc
from emp e  right join dept d on e.deptno = d.deptno;

select e.ename, d.deptno, d.dname, d.loc
from emp e  left join dept d on e.deptno = d.deptno; -- 안보임

-- 특정 사원의 상사의 이름을 검색 (self join -> )
select concat(e.ename, '의 상사는  ', m.ename, '입니다.') info
from emp e, emp m
where e.mgr = m.empno; 	--  13/14 줄이 나왔다.
						-- m.mgr에 null이 있기에 left join을 해야 한다.
                        
select concat(e.ename, '의 상사는  ', m.ename, '입니다.') info
from emp e left join emp m
on e.mgr = m.empno;

select concat(e.ename, '의 상사는  ', m.ename, '입니다.') info
from emp e right join emp m
on e.mgr = m.empno;


-- Full outer join
-- mysql에서는 full join을 지원하지 않는다. 따라서 union을 사용해야 한다.
-- 양쪽 테이블 모두 공통적이지 않는 데이터가 있는 경우 모두 보여준다.
-- emp, dept 테이블은 right join이 적합하다.
-- 따라서 다른 예시를 만들어보자
-- union | union all

create table outera( sawonid int);
create table outerb( sawonid int);

insert into outera values(10);
insert into outera values(20);
insert into outera values(30);
select * from outera;

insert into outerb values(10);
insert into outerb values(20);
insert into outerb values(40);
select * from outerb;

select sawonid from outera
union
select sawonid from outerb;


/*
set(집합) 연산자 
CTAS  (Create Table as select)

*/

select * from emp;

create table emp1 as (select * from emp); -- CTAS로 emp1 생성
select * from emp1;
desc emp1; -- 제약 조건은 못 가져온다. 지정해야 한다.
desc emp;


create table emp2 as (select ename, job, sal, deptno from emp where deptno = 20);
select * from emp2; -- 이렇게 해서는 union을 할 수 없다. 

create table newemp as (select * from emp);
-- 데이터 추가
insert into newemp values(111, '전현무', 'MANAGER', 7566, '2000-01-01', 5000.0, null, 20);
insert into newemp values(222, '박나래', 'MANAGER', 111, '2003-11-21', 4000.0, null, 20);

select * from newemp;

select * from emp
union
select * from newemp; -- 16명 : 14명이 중복되는 것을 distinct로 벗겨낸다.

select * from emp
union all
select * from newemp; -- 16 + 14 = 30명



