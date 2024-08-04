/*
2024.07.24
서브 쿼리 개념
	- 서브 쿼리는 하나의 sql 문 안에 호환돼있는 또다른 sql문을 말한다.
		(성능을 높이기 위해 db에 2번의 질의를 하지 않기 위해 만들어졌다.)
	- ?에 해당하는 부분을 먼저 검색하는데 사용된다.
	- 서브 쿼리의 결과값을 메인 쿼리에서 사용해서 전체 쿼리가 완성된다.
	- 서브 쿼리에서 order by 절을 사용해도 되나?
		개념적으로는 되지만, Main 절에서 정렬하면 됨으로 의미 없다.

서브 쿼리의 3가지 유형
1. where 절에서 사용되는 서브쿼리
2. from 절에서 사용되는 서브 쿼리
3. having 절에서 사용되는 서브 쿼리    
    
*/

/*
	1. where 절에서 사용되는 서브쿼리
	단일행 서브 쿼리
*/
-- clark 의 급여보다 더 맣은 급여를 받는 사원을 검색
-- 1. clark의 급여를 알아보자
select sal
from emp
where ename = 'clark'; -- 2450

-- 2. 2450보다 급여가 높은 사람 (5명 출력)
select ename
from emp
where sal > 2450;

-- > 두번의 질의를 서버에 던지는 쿼리가 발생한다. 효율적이지 않고, 성능 저하를 이끈다.
-- > 하나의 쿼리문으로 만들기 위해서는 ?에 해당하는 부분을 먼저 수행하고 전체 쿼리에 넣는다.
select ename
from emp
where sal > (select sal
			from emp
			where ename = 'clark');

-- ename이 king인 사원과 같은 부서에서 근무하는 사원을 검색
-- ? : ename이 king인 사원의 부서
select *
from emp
where deptno = ( select deptno
				 from emp
				 where ename = 'king');

-- 10번 부서에서 근무하는 사원 중, 사원 전체의 평균 급여보다 더 많은 급여를 받는 사원을 검색
-- ? : 사원 전체의 평균 급여
select *
from emp
where deptno = 10 
and sal >(select round(avg(sal))
		  from emp);
select round(avg(sal)) from emp; -- 2073

-- job 별 평균 급여 중 가장 적은 평균 급여 검색
-- ? : 평균 급여
select job, round(avg(sal))
from emp
group by job
having avg(sal) = (select min(avg(sal)) from emp group by job); -- error 발생
																-- mysql은 그룹함수 중첩이 안된다. 단, 위의 코드는 orcale에서는 가능하다.
-- 1) limit 사용
select job, round(avg(sal))
from emp
group by job
order by 2
limit 1;

-- 2) 테이블 alias : mysql의 권고 사항이다.
-- 테이블을 리턴하는 서브쿼리에는 반드시 테이블 alias를 지정한다.
select t.job, t.avgSal
from (	select job, round(avg(sal)) avgSal
		from emp
		group by job
	 )  t
order by t.avgSal
limit 1;

select job, round(avg(sal)) avgSal
from emp
group by job;

-- error 발생
select t.job, min(t.avgSal)
from (	select job, round(avg(sal)) avgSal
		from emp
		group by job
	 )  t;


/*
	2. from 절에서 사용되는 서브 쿼리
    테이블 alias 지정하기
*/
-- scott의 급여보다 더 많은 급여를 받는 사원을 검색
select ename, sal
from emp
where sal > (select sal from emp where ename = 'scott');

-- 테이블 alias 지정하는 법
-- 전체 테이블을 a, 서브쿼리 테이블을 b :: a와 b를 비교하는 방식

-- 1)
select a.ename, a.sal
from (select sal from emp where ename = 'scott') b, emp a 
where a.sal > b.sal;

-- 2)
select * 
from emp a , (select sal from emp where ename = 'SCOTT') b
where a.sal > b.sal;

-- 3)
select ename, sal  -- error : Column 'sal' in field list is ambiguous
from emp a, (select sal from emp where ename = 'scott') b 
where a.sal > b.sal;

-- 직속 상관이 king인 사원의 사원번호와 이름을 검색
-- ? : king.사번 = 사원.사번
select *
from emp
where mgr = (select empno from emp where ename = 'KING'); -- 7839

-- job이 사원번호 7369와 같고, 급여가 사원 7876번호의 사원보다 많은 사원을 검색
-- 7369의 사원번호, 7879의 급여
select *
from emp e,
	(select job from emp where empno = 7369) a,
    (select sal from emp where empno = 7876) b
where e.job = a.job and e.sal > b.sal;

select *
from emp e
where e.job = (select job from emp where empno = 7369)
	  and e.sal > (select sal from emp where empno = 7876);


/*
	3. having 절에서 사용되는 서브 쿼리 
	단일행 서브 쿼리
*/
-- 부서별 최소 급여 중에서 20번 부서의 최소 급여 보다 더 큰 최소 급여를 검색
-- 그룹핑한 후 조건 : Having
-- ? : 20번 부서의 최소 급여
select deptno, min(sal)
from emp
group by deptno; -- 1300 800 950

select deptno, min(sal)
from emp
group by deptno
having min(sal) > (	select min(sal)
					from emp
					where deptno = 20)
order by 1;


-- ----------------------------------- 다중행 서브 쿼리 ----------------------------------

/*
 다중행 서브 쿼리는 단일행 연산자를 사용할 수 없다.
 단일행 비교 연산자 : <, >, = , !=
 
 다중행 서브 쿼리는 다중행 연산자를 사용해야 한다.
 다중행 연산자 : in, any, all
 
 in(여러 값 중에서 하나라도 참이면 수행됨)
 
*/
-- 부서별 최소급여 보다 더 큰 급여를 받는 사원을 검색
-- - 이제까지는 스칼라 서브 쿼리(= 단일행 서브 쿼리)로 결과가 하나만 나왔다.
-- - 비교 연산자는 단일행 연산이다. 비교 대상이 하나여야 한다.

-- 1)
select ename, job
from emp
where sal > ( 	select min(sal) -- 다중행을 반환하기에 Error 발생
				from emp
				group by deptno);
                
-- 2) 다중행 연산자 사용(다중행 서브 쿼리 반환)
select ename, job
from emp
where sal in ( 	select min(sal) 
				from emp
				group by deptno);            
                
-- 급여를 3000 달러 이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원을 검색
select distinct deptno
from emp
where sal >= 3000; -- 다중행 서브 쿼리

select ename, sal, deptno
from emp
where deptno in (select distinct deptno
				from emp
				where sal >= 3000);

/*
다중행 연산자 any, all
  sal < Any : clerk 급여중에서 최대값보다 작은 sal
  sal > ALL : clerk 급여중에서 최소값보다 작은 sal
  
  sal < Any : clerk 급여중에서 최소값보다 작은 sal
  sal > Any : clerk 급여중에서 최대값보다 작은 sal
  
*/
-- 급여가 어떤 clerk(점원 job)의 급여보다도 작으면서 Clerk은 아닌 사원을 검색
-- ? : clerk(점원 job)의 급여
-- 어떤(Acertain) <-> 모든(All)
-- clerk 의 급여 800 950 1100 1300
-- 모든일 때는 800 보다 작아야 한다.
-- 어떤일 때는 1300보다 작아야 한다.

select sal
from emp
where job = 'CLERK'; -- 800 950 1100 1300

-- 1)과 2)는 차이가 없다.
-- 그룹 연산자와 단일행 연산자를 사용할 수 있다. (all-min, any-max)

-- 1) 다중행 연산자
select empno, ename, sal, job
from emp 
where sal < any ( select sal from emp where job = 'CLERK')
and job <> 'CLERK';

-- 2) 그룹 함수를 사용 ( 단일행 연산자)
select empno, ename, sal, job
from emp 
where sal < ( select max(sal) from emp where job = 'CLERK')
and job <> 'CLERK';

-- Error 발생
select empno, ename, sal, job
from emp 
where sal < max( select sal from emp where job = 'CLERK')
and job <> 'CLERK';

-- 급여가 모든 부서의 평균 급여보다 더 많은 사원을 검색
-- ? : 모든 부서의 평균 급여
-- 1) 다중행 서브 쿼리
select *
from emp
where sal > all(select avg(sal)
				from emp
				group by deptno);

-- 2) 그룹함수
select *
from emp
where sal > (select avg(sal)
			from emp
			group by deptno
			order by 1 desc
			limit 1);

select empno, ename, deptno,sal
from emp
where sal > (select max(a.sal)
			 from (select avg(sal) sal from emp group by deptno) a);

-- 급여가 30번 부서의 속한 그 어떤(All) 사원의 급여보다도 많은 급여를 받는 사원을 검색
-- 이때 30부서에 속한 사원은 일단 제외하고, 
-- 정렬은 사원번호 순으로 정렬한다.

-- 1) 다중행 서브 쿼리
select empno, ename, sal, deptno
from emp
where sal > all(select sal from emp where deptno = 30)
and deptno <> 30
order by 1;

-- 2) 단일 연산자
select empno, ename, sal, deptno
from emp
where sal > (select max(sal) from emp where deptno = 30)
and deptno <> 30
order by 1;

 -- 20번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사원을 검색
 -- = 20번 소속의 그 어떤 사원의 급여보다 더 많은 급여를 받는 사원을 검색 
 
 -- 1) 다중행 연산자
 select empno, ename, deptno, sal
 from emp
 where sal > ( select max(sal) from emp where deptno = 20);
 
 -- 2) 단일행 연산자
 select empno, ename, deptno, sal
 from emp
 where sal > all( select sal from emp where deptno = 20);
 
 
 -- 부서번호가 30번인 사원들의 급여 중 가장 낮은 급여(950)보다 더 높은 급여를 받는 사원을 검색
  -- 1) 다중행 연산자
 select empno, ename, deptno, sal
 from emp
 where sal > any(select sal
			  from emp
			  where deptno = 30);
 
  -- 2) 단일행 연산자
select empno, ename, deptno, sal
 from emp
 where sal > (select min(sal)
			  from emp
			  where deptno = 30);
              
              

