/*
2024. 07.18
1. 기본 SELECT 구문 
	1) Projection과 Selection
    Projection : 원하는 컬럼을 지정해서 가져오는 쿼리문 
    Selection : 전체 or 원하는 행만 가져오는 쿼리문
*/

-- Selection handing
select * 
from emp;

-- Projection handing
select ename, job, sal, deptno 
from emp;

-- Selection +  Projection
select ename, job, sal, deptno 
from emp 
where deptno = 10;

select ename, job, sal, deptno 
from emp 
where job = 'salesman'
order by sal;
-- order by sal asc; -- 기본은 오름차순
-- order by sal desc;

/*
emp 테이블에서 이름,업무,급여,부서번호 출력
부서번호가 20인 사원만 급여순으로 정렬
*/
select ename, job, sal, deptno
from emp
where deptno = 20
order by sal;
-- order by 4; -- display 되어 있는 4번째 컬럼을 의미한다.

/*
사원중에서 입사일이 가장 빠른 사원순으로 출력
*/
select empno, ename, hiredate
from emp
order by hiredate;

/*
emp 테이블에서 직원들이 속한 부서 번호를 알고 싶다.
사원들이 속해 있는 부서 번호만을 출력
*/
select distinct DEPTNO
from emp
order by 1;

/*
모든 사원의 급여를 (기준 급여 + 100) * 1.5배를 출력
*/
select ename, sal, (sal+100) *1.5 as 인상급여
from emp;

select ename, sal, (sal+100) *1.5 인상급여
from emp;

-- ver1. 
select ename, sal, (sal+100) *1.5 '인상 급여'
from emp
order by '인상 급여'; -- semetic error(정렬이 안됨)

-- ver2.
select ename, sal, (sal+100) *1.5 '인상 급여'
from emp
order by (sal+100) *1.5;

-- ver3.
select ename, sal, (sal+100) *1.5 '인상 급여'
from emp
order by 3;


/*
사원의 급여에서 세금을 제외한 실제 수령한 급여를 출력
세금은 급여의 10%로 간주한다.
정렬은 실수령액으로 
*/
select ename 직원, sal, (sal *0.9) as 실수령액
from emp
order by 3;


/*
null 값에 대한 정리
*/

-- emp 테이블에서 모든 사원들의 각각 연봉을 출력, 정렬
select ename, deptno, job, sal as Salary, sal * 12 + comm as AnnualSalary 
from emp
order by 5 desc; -- comm이 null인 사원의 연봉은 구할 수 없다.

select ename, deptno, job, sal as Salary, sal * 12 + ifnull(comm,0) as AnnualSalary 
from emp
order by 5 desc;

-- comm을 가장 많이 받는 사원 순으로 정렬
select ename, deptno, job, sal as Salary, ifnull(comm,0) as comm
from emp
order by 5 desc;

-- 단, comm이 null인 사원은 제외하고 
select ename, deptno, job, sal as Salary, comm
from emp
where comm is not null
order by 5 desc;



/*
limit
*/

-- 사원중에서 급여를 가장 많이 받는 사원이 먼저 출력되도록

select ename, deptno, job, sal
from emp
order by sal desc
limit 3;
-- limit 0,3;

select ename, deptno, job, sal
from emp
order by sal desc
limit 12,2;

-- Full scan으로 동작한다. .. 나중에 index 설명
select * 
from emp
limit 0,10;

select * from emp where empno = 7902; --  PK이기에 Full Scan (X)
select * from emp where ename = 'FORD'; -- PK가 아니긱에 Full Scan을 한다.

/*
Like 연산자
특정 단어가 포함돼있는 데이터를 검색할 때 많이 사용
*/

-- 1.
-- sal가 2500 ~  3500 사이에 들어있는 sal를 받는 사원을 검색
select ename, sal
from emp
where sal >= 2500 and sal <=3500;

-- 2.
select ename, sal
from emp
where sal between 2500 and 3500; -- 값이 포함됨

select ename, sal
from emp
where sal between 3500 and 2500; -- sementic error

-- S로 시작하는 이름을 가진 사원을 검색
select ename, sal
from emp
where ename like 'S%';

-- S를 포함하는 이름을 가진 사원을 검색
select ename, sal
from emp
where ename like '%S%';

-- 2번째 문제에 A가 들어가는 사원 이름을 검색
select ename, sal
from emp
where ename like '_A%';

-- 81년도에 입사한 사원을 검색, 사원의 이름과 입사일이 함께 출력되도록
select ename, hiredate
from emp
where hiredate like '__81%';