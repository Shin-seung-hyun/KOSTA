-- ### SubQuery 리뷰 ###
-- 1.  ‘SMITH'의 직무와 같은 사람의 이름, 부서명, 급여, 직무를  출력하라.
select e.ename, d.dname, e.sal, e.job
from emp e join dept d on  d.deptno= e.deptno
where e.job = (select job from emp where ename='SMITH');

-- 2. 10번 부서와 같은 일을 하는 사원의 사원번호, 이름, 부서명,지역, 급여를 급여가 많은 순으로 출력하라.
select e.empno, e.ename, d.dname, d.loc, e.sal
from emp e join dept d on e.deptno = d.deptno
where e.job in(select job from emp where emp.deptno= 10 )
order by sal desc; 

select job from emp where emp.deptno= 10;
select * from emp;
select * from dept;

-- ### equi join ###
-- 1.  emp와 dept Table을 JOIN하여 부서번호, 부서명, 이름, 급여를  출력하라.
select e.deptno, d.dname, e.ename, e.sal
from emp e join dept d on e.deptno = d.deptno;

-- 2.  이름이 ‘SMITH’인 사원의 부서명을 출력하라.
select d.dname
from emp e join dept d on e.deptno = d.deptno
where e.ename = 'SMITH';

 
-- ### outer join ###
-- 1.  dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여 
-- 모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.
select e.ename, e.deptno, d.dname, e.sal
from emp e left join dept d on e.deptno = d.deptno;


-- ###self join###
-- 2.  emp Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력하라. ‘SMTH의 매니저는 FORD이다’
select concat(e.ename, '의 매니저는 ', m.ename, '이다') info
from emp e , emp m
where e.mgr = m.empno;


-- ### join 실습 ###

-- 1. 관리자가 7698인 사원의 이름, 사원번호, 관리자번호, 관리자명을 출력하라.
select e.ename, e.empno, m.empno, m.ename
from emp e , emp m
where e.mgr = m.empno and e.mgr = 7698;


-- 2. 업무가 MANAGER이거나 CLERK인 사원의 사원번호, 이름, 급여, 업무, 부서명
select e.empno, e.ename, e.sal, e.job, d.dname
from emp e join dept d on e.deptno = d.deptno
where e.job in('MANAGER', 'CLERK');


-- ### set 연산자 ### --
-- 1. dept와 동일한 테이블(단 dept테이블의 10, 20부서의 데이터를 입력)을 하나 생성한다.
-- 테이블명은 newdept로 하자  
create table newdept as (select * from dept where deptno in (10,20));

select * from newdept;
drop table newdept;

-- 2. 추가 데이터를 입력한다. 2행입력
insert into newdept values(50, 'IT', 'AA');
insert into newdept values(60, 'IT2', 'BB');

-- 3. dept테이블과 newdept 테이블의 모든 행을 출력하라.(단, 중복되는 행은 한번만 출력한다)
select * from dept
union
select * from newdept;

-- 4. dept테이블과 newdept 테이블의 모든 행을 출력하라.
select * from dept
union all
select * from newdept;


