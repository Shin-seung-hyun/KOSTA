-- 1. emp 테이블에서 ename 'R'로 끝나는 사원을 검색 
SELECT empno , ename, job 
FROM emp 
WHERE ename LIKE '%R';
  
-- 2. emp 테이블에서 ename 에서 두번째 글자가 'L' 인 사원을 검색
SELECT empno , ename, job 
FROM emp 
WHERE ename LIKE '_L%';
-- or
SELECT empno , ename, job  
FROM emp 
WHERE substr(ename, 2, 1) = 'L';
   
-- 3. emp 테이블과 dept 테이블을 조인해서 ename,job,dname,loc 출력
SELECT ename 사원명, job 업무, dname 부서명, loc 지역 
FROM emp e JOIN dept d 
ON e.deptno = d.deptno;

-- or
SELECT ename, job, dname, loc
FROM emp e, dept d
WHERE e.deptno = d.deptno;
  
-- 4. emp 테이블에서 입사일이  1981 인 사람중에 mgr 이 7698 인사람을 검색
SELECT ename, hiredate, mgr
FROM emp
WHERE year(hiredate)=1981 AND mgr=7698;

 
​
-- 5. emp 테이블에서 empno 사원번호가 7566, 7698, 7782 인 사원의 업무를 'MARKETING' 으로 변경하시오
 UPDATE emp SET job='MARKETING' WHERE empno IN (7566, 7698, 7782);
  
​
-- 6. emp 테이블에서 업무(job) 별로 각각의 인원수를 구하라
SELECT job 업무, count(job) '업무별 인원수' FROM emp GROUP BY job;
  
​
-- 7. emp 테이블에서 부서(deptno)별로 급여(sal) 의 평균을 구하시오
--   (평균은 소숫점이하 한자릿수로)
SELECT deptno 부서, round(avg(sal),1) 급여평균 
FROM emp 
GROUP BY deptno;
​
​
-- 8. emp 테이블에서 ename 이 'TURNER' 인 사람의 sal 을 1900 으로 comm 을 400 수정
SELECT * FROM emp WHERE ename = 'TURNER';
UPDATE emp SET sal = 1900, comm = 400 WHERE ename = 'TURNER';
  
  
-- 9. emp 테이블에서 입사년도가 81년도인 사원중 급여가 1400 미만인 사원의 인원수를 검색 
SELECT count(ename) 인원수
FROM emp
WHERE year(hiredate)=1981 AND sal<1400;
  
  
SELECT concat(count(*), '명') 인원수 
FROM emp 
WHERE year(hiredate) = 1981 
AND sal < 1400;
  
​
-- 10. 9번에서 조회된 사원들을 삭제합니다.
DELETE FROM emp 
WHERE year(hiredate) = 1981 
AND sal < 1400;

-- or
DELETE FROM emp WHERE ename 
IN (SELECT 인원수 FROM (SELECT ename 인원수 FROM emp WHERE year(hiredate)=1981 AND sal<1400) e);
 ​
-- 11. emp 테이블에서 업무가 clerk(점원) 인 사원의 급여를 전체적으로 15% 인상합니다. 
UPDATE emp SET sal = sal * 1.15 
WHERE job = 'clerk';


​
-- 12.  emp 테이블에서 comm이 null 이 아닌 모든 사원을 삭제합니다.
--     단 comm이 0인 사원은 제외합니다.
DELETE FROM emp WHERE comm IS NOT NULL;

-- or  
DELETE FROM emp WHERE NOT isnull(comm) AND comm != 0;
​
--  ----------------- 구글 검색으로 나머지 쿼리를 완성합니다. ---------------
​
-- 13. emp 테이블에서 ename--> name, sal--> salary로 컬럼명을 변경합니다.
desc emp;
ALTER TABLE emp CHANGE ename name varchar(10), CHANGE sal salary double;

-- or  

ALTER TABLE emp CHANGE ename name VARCHAR(10);
ALTER TABLE emp CHANGE sal salary double;
   ​
​
-- 14. emp 테이블에서  job의 데이타 타입을 varchar(30)으로 수정합니다.
ALTER TABLE emp MODIFY job varchar(30);