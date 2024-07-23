/*
2024.07.23 그룹함수

그룹함수  - 그룹 전체를 집계한 결과로 값이 도출되는 함수
	count() : null 값을 포함한 행의 수를 반환
	count(컬럼명) :  컬럼에 해당하는 행의 수를 반환 (null값은 제외한다.)
	sum(컬럼명) : 컬럼값의 총합
	avg(컬럼명) : 컬럼값의 평균
	max(컬럼명) : 최대값
	min(컬럼명) : 최소값
그룹함수는 null 값을 제외한다. (단, * 는 null값을 포함)

*/

-- count 
-- 전체 사원수를 조회 ( * : 모든행임으로 null값도 포함된다.)
select count(*) from emp;  
select count(-1) from emp; -- 마지막 행의 수를 반환 (조금 더 효율적이다)
select count(empno) from emp; -- 기본키는 null값이 없다.

-- 특정한 컬럼의 갯수
select count(mgr) from emp; -- mgr 컬럼값 내 null 값은 빼고 갯수 반환 

select round(avg(sal),3), sum(sal), min(sal), max(sal), count(sal) from emp;

-- emp 테이블에서 입사한지 가장 오래된 사원과 가장 최근에 입사한 사원의 입사일을 검색
-- avg/sum은 숫자 데이터에만 적용되지만, min/max/count는 모든 데이터에 다 적용된다.
select min(hiredate) '근속일이 가장 오래된 사원', max(hiredate) 
from emp;

-- 부서번호가 10이거나 20번인 사원의 수를 검색 (or 조건보다 in 연산을 쓸 것)
select count(empno)
from emp
where deptno in (10, 20);

-- 모든 사원의 보너스 평균을 검색 avg 소수점 둘째자리까지 출력
-- 그룹함수는 null을 건너뛴다.  14로 나눠야하는데 잘못 나뉜다.
-- comm이 null인 사람이 있기에 ifnull이 있어야 한다.

-- 1) 잘못된 연산
select round(avg(comm),2) '보너스 평균'
from emp;

-- 2) 올바른 계산
select round(avg(ifnull(comm,0)), 2) '보너스 평균'
from emp;

-- emp 테이블에서 존재하는 부서의 갯수를 출력
select deptno from emp;
select count(distinct(deptno)) 부서수 from emp; -- 중복을 벗기고 count를 적용

-- ------------------------------------------------------------------

-- 평균 급여를 조회
-- avg(sal) 은 결과가 하나가 나오지만, deptno은 14개가 나옴. 따라서 에러 발생
-- 그룹함수는 전체 결과를 집계해 하나의 결과가 나온다. 따라서 deptno은 집계함수가 아니라서 에러가 발생하는 것이다.
-- 1)
select deptno, round(avg(sal)) 				-- error
from emp; 									-- Error Code: In aggregated query without GROUP BY, expression #1 of SELECT list contains nonaggregated column 'kosta.emp.DEPTNO'; 
											-- this is incompatible with sql_mode=only_full_group_by
											-- 그룹함수에 적용되지 않는 컬럼(deptno)이 select 절에 나열되면 안된다.
											-- 만약 select 절에 나열되기 위해서는 group by 절에 명시돼야 한다.
-- 2)
select deptno, round(avg(sal))				
from emp
group by deptno;

-- 3)
select deptno DNumber, round(avg(sal)) AugSalary				
from emp
group by DNumber;

/*
실행순서 from -> where -> group by -> select -> order by 순으로 실행이 된다.
select 절의 컬럼명에 대한 alias는 group by 절에서는 인식이 불가능하다.
원론적으로는 안된다.
그러나, mysql에서는 group by절 뒤에 alias 사용이 가능하다.
orcale에서는 절대 안된다.
*/

-- 4)
select deptno DNumber, round(avg(sal)) AugSalary				
from emp
group by deptno
order by DNumber;

-- group by의 목적은 세분화, grouping이다.

-- 5) where 절 실행 후 group by가 실행된다.
select deptno DNumber, round(avg(sal)) AugSalary				
from emp
where deptno != 10
group by deptno
order by DNumber;

-- 6) where절에서는 alias 사용 불가함
select deptno DNumber, round(avg(sal)) AugSalary				
from emp
where DNumber != 10
group by deptno
order by DNumber;

-- 입사년도별 사원의 인원수를 출력 alias 사원수
select year(hiredate), count(empno) 사원수
from emp
group by year(hiredate);

select date_format(hiredate, '%Y') 입사년도, count(*)
from emp
group by 1 -- orcale에서는 안됨
order by 1;

-- 부서별 평균 급여가 2000달러 이상인 부서번호와 평균 급여를 검색
-- where절에서는 group 함수를 사용할 수 없다.
-- having절이 필요하다.
select a.deptno, round(a.avgSal)
from (	select deptno, avg(sal) avgSal
		from emp
		group by deptno
	 ) as a
where a.avgSal > 2000;

-- error
select deptno, avg(sal)
from emp
where avg(sal)>=2000
group by deptno;

-- 1) 그룹 별 평균급여를 구한 후, 거기서 다시 추릴 때 having절을 사용한다.
select deptno, avg(sal)
from emp
group by deptno
having avg(sal) >=2000;

select deptno, avg(sal) AvgSalary
from emp
where deptno <> 10
group by deptno
having avg(sal) >=2000
order by AvgSalary;

/*
실행순서 
from(테이블) -> where(행을 제한) -> group by -> having -> select(컬럼 추출) -> order by

where 절에 못오는 것
1) 그룹함수
2) alias
*/

-- 최대 급여가 2900달러가 넘는 부서들의 최대 급여를 검색
-- 1 step)
select deptno, max(sal)
from emp
group by deptno;

-- 2 step)
select deptno, max(sal)
from emp
group by deptno
having max(sal) > 2900;

-- 3 step)
select deptno, max(sal)
from emp
group by deptno
having max(sal) > 2900
order by max(sal) desc
limit 1;


-- --------------------------------------------------------------
/*
rollup
- group by 절의 확장이다.
- (그룹 항목 중 총합)이나 (각 그룹 별 중간 합계)가 필요한 경우 사용된다.

rollup의 인수는 계층구조이므로 인수의 순서가 바뀌면 수행결과도 달라진다.
따라서 인수의 순서에 주의를 해야 한다.

*/

-- 1. 부서별 인원수, 급여의 합
select deptno, count(empno) 사원수, sum(sal) '급여의 합'
from emp
group by deptno
order by 3;

-- 1-1. 그룹 항목의 총합
select deptno, count(empno) 사원수, sum(sal) '급여의 합'
from emp
group by deptno WITH ROLLUP; -- 모든 사원수의 총합, 모든 급여의 합


-- 2. 부서 별, 업무 별 급여의 합
select deptno, job, sum(sal) '급여 총합'
from emp
group by deptno, job
order by 1;

-- 2-1. 그룹 별 중간 합계 가 필요한 경우
select deptno, job, sum(sal) '급여 총합'
from emp
group by deptno, job with rollup
order by 1;

-- 2-2. rollup은 계층구조이다. 인수의 순서가 바뀌면 수행결과도 달라진다.
select job, deptno, sum(sal) '급여 총합'
from emp
group by job, deptno with rollup
order by 1;


/*
[실행순서 정리]
from -> where -> group by -> having -> select -> order by -> limit 절 순서로 실행된다.

[문법순서 정리]
select distinct
from
where
group by
having
order by
limit
*/
