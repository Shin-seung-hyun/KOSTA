-- 1. emp 테이블에서 ename 'R'로 끝나는 사원을 검색 
select  *
from emp
where ename like '%R';
  
-- 2. emp 테이블에서 ename 에서 두번째 글자가 'L' 인 사원을 검색
select *
from emp
where ename like '_L%';

-- 3. emp 테이블과 dept 테이블을 조인해서 ename,job,dname,loc 출력
select e.ename, e.job, d.dname, d.loc
from emp e join dept d on e.deptno = d.deptno;

-- 4. emp 테이블에서 입사일이  1981 인 사람중에 mgr 이 7698 인사람을 검색
select *
from (select * from emp where year(hiredate) = '1981') as e
where e.mgr = 7698;
 
-- 5. emp 테이블에서 empno 사원번호가 7566, 7698, 7782 인 사원의 업무를 'MARKETING' 으로 변경하시오
select * from emp where empno in ( 7566, 7698, 7782) ;
update emp set job = 'MARKETING' where empno in ( 7566, 7698, 7782) ;
 
-- 6. emp 테이블에서 업무(job) 별로 각각의 인원수를 구하라
  select count(empno) cntByJob
  from emp
  group by job;
  

-- 7. emp 테이블에서 부서(deptno)별로 급여(sal) 의 평균을 구하시오
--   (평균은 소숫점이하 한자릿수로)
select truncate(avg(sal),1)
from emp
group by deptno;

select round(avg(sal),1)
from emp
group by deptno;


-- 8. emp 테이블에서 ename 이 'TURNER' 인 사람의 sal 을 1900 으로 comm 을 400으로 수정하시오
select * from emp where ename = 'TURNER';
update emp set sal = 1900, comm = 400 where ename = 'TURNER';
  
-- 9. emp 테이블에서 입사년도가 81년도인 사원중 급여가 1400 미만인 사원의 인원수를 검색 
  select count(empno)
  from (select * from emp where right(year(hiredate),2) = '81') e 
  where e.sal < 1400;

-- 10. 9번에서 조회된 사원들을 삭제합니다.
 delete from emp where right(year(hiredate),2) = '81' and sal <1400;
 select * from emp;

-- 11. emp 테이블에서 업무가 clerk(점원) 인 사원의 급여를 전체적으로 15% 인상합니다. 
select * from emp where job = 'CLERK';
update emp set sal = sal * 0.15 where job = 'CLERK';

select * from emp;

-- 12.  emp 테이블에서 comm이 null 이 아닌 모든 사원을 삭제합니다.
--     단 comm이 0인 사원은 제외합니다.

drop table emp;
select * from emp;
 delete from emp where (comm is not null) and (comm != 0);
 
--  ----------------- 구글 검색으로 나머지 쿼리를 완성합니다. ---------------
-- 13. emp 테이블에서 ename--> name, sal--> salary로 컬럼명을 변경합니다.
desc emp;
alter table emp change ename name varchar(10);
alter table emp change sal salary double;

-- 14. emp 테이블에서  job의 데이타 타입을 varchar(30)으로 수정합니다.
alter table emp modify job varchar(30);

drop table emp;
select * from emp;
