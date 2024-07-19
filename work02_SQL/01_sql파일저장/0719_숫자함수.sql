/*
2024.07.19
<어제 리뷰>
	1. 연산자 
		- Like 연산자( 와일드 카드 %, _)
			특정 패턴에 속하는 값을 조회할 때 사용하는 연산자
			% : 0 혹은 1개 이상의 문자와 대응
			_ : 반드시 한개의 문자와 대응
       
        - 비교 연산자 ( =, !=(<>와 같음), >, < )
        
        - IN  연산자
			여러값 중에서 어느 하나와 일치하는지를 비교하는 연산자
			
            
        - 논리 연산자 ( ADN, OR, NOT)	
			> 우선순위가 존재함 NOT > AND > OR 순으로 작동함
            > ( )는 모든 우선순위 규칙보다 우선된다.
 
 <오늘 할 일>
	2. 단일행 함수

*/

/* IN 연산자 */
-- 사원번호가 7369 or 7521 or 7782인 사원을 검색
-- 1) 최악의 성능 (DB에 3번 요청)
select * from emp where empno = 7369; -- Smith
select * from emp where empno = 7521; -- ward
select * from emp where empno = 7782; -- clark

-- 2) IN 연산자는 OR 연산자의 원리이다.
select * from emp where empno = 7369 or empno=7521 or empno=7782;

-- 3) IN 연산자
select * from emp where empno in (7369, 7521, 7782);
select * from emp where empno in (7369, 7521, null); -- 원래는 null이 있어서 안되지만 OR연산이기에 해당 코드는 돌아간다. 

-- 사원번호가 7369 아니고 7521 아니고 7782도 아닌 사원을 검색 (AND 연산자와 연결됨)
-- 1) 
select * from emp where empno != 7369 and empno != 7521 and empno != 7782;
select * from emp where empno<> 7369 and empno<> 7521 and empno<> 7782;

-- 2) 
select * from emp where empno not in (7369, 7521, 7782);
select * from emp where empno not in (7369, 7521, null); -- null 값은 비교가 안되기에 AND에서는 사용할 수 없음. NOT IN일 경우 null 값을 처리해줘야 한다.
select * from emp where mgr not in (7369, 7521, 0);

select * from emp;
-- 부하직원을 거느리고 있는 사원을 검색(empno에 해당하는 사람이 mgr번호에 있는 사람이다.)
select empno, ename, mgr from emp where empno in(select distinct mgr from emp); 

-- 부하직원을 거느리고 있지 않는 사원을 검색(empno에 해당하는 사람이 mgr번호에 없는 사람이다.)
select empno, ename, mgr from emp where empno not in(select distinct mgr from emp); -- (x) 문법적 오류가 아닌 symentic error이다.

select empno, ename, mgr 
from emp where empno 
not in(select distinct ifnull(mgr,0) from emp); -- (O)

select * from emp;
select distinct mgr from emp;



-- !!! 논리연사자 우선순위 관련한 문제 !!!
-- 사원들 중에서 업무가 영업사원이거나 혹은 사장인 경우의 사원중에서 급여가 1500 달러 이상인 사원을 검색
-- 사원이름, 업무, 급여가 디스플레이되도록 한다.

select empno, job, sal
from emp
where job = 'salesman' or job = 'president' and sal > 1500;  -- (x) 우선순위에 따라서 job = 'salesman' or (job = 'president' and sal > 1500); 로 돌아감

select empno, job, sal
from emp
where (job = 'salesman' or job = 'president') and sal > 1500; -- (O)

select empno, job, sal
from emp
where job in ('salesman' ,'president') and sal > 1500; -- (O)



/*
단일행 연산자
	1) 문자함수 2) 숫자함수 3) 날짜함수 4) 변환함수가 있다.
    
    1) 문자함수
		concat('문자열', '문자열') : 문자열 혹은 컬럼을 연결
		upper(), lower() : 대소문자 변환
        *substring(문자열, 시작위치, 길이) : 문자열 추출
        *substr()
        pad/lpad/rpad : 문자열을 채우는 기능
        length : 문자열의 길이를 추출
        left/right/mid : 문자열 중에서 왼쪽/오른쪽/시작위치에서 갯수만큼 추출
			MID(문자, 시작 위치, 가져올 갯수);
			또는 SUBSTR(문자, 시작 위치, 가져올 갯수);
			또는 SUBSTRING(문자, 시작 위치, 가져올 갯수);
		*ltrim/rtrim/trim : 문자열 중에서 왼쪽/오른쪽/양쪽 공백을 제거
    
*/
-- 1) 문자열 함수
--  concat() : 문자열 연결
select concat('Good', 'Morning') from emp;
select concat('Good', 'Morning') as msg from dual;
select concat('Good', 'Morning') as msg; -- MySQL은 알아서 Dummy Table이 생성된다. (Oracle은 안됨)

-- concat() : 문자열, 컬럼 연결
select concat( ename, ', Good', ' Morning~~') as msg from emp;

-- concat() : 컬럼, 문자열, 컬럼 연결
select ename 사원이름, job 업무, concat( ename, ' is a ', job) as msg from emp;


-- substr() 문자열 추출
select substr('HelloWorld', 6); -- World
select substr('HelloWorld', 6, 3); -- Wor
select substr('HelloWorld', -4, 3); -- orl : 업무 중에서 m으로 끝나느 업무를 p로 고쳐라 등등에 쓰임

-- 사원의 업무 중에서 salesman인 업무를 하는 사원 중에서 사원이름이 r로 끝나느 사원의 정보를 출력
select *
from emp
where (job like 'salesman') and (substr(ename, -1,1) = 'r');

-- 업무에서 salesman인 업무부서의 이름이 sales로만 검색되도록
select empno, ename, substr(job, 1,5) as '축약형 job'
from emp
where job = 'salesman';

-- 입사일 중에서 년도만 검색되도록 조회하고 별칭을 입사년도로 지정
-- 1
select empno, ename, substr(hiredate, 1, 4) as '입사년도' from emp; -- 1981
select empno, ename, substr(hiredate, 3, 2) as '입사년도' from emp; -- 81
select empno, ename, substr(hiredate, -8, 2) as '입사년도' from emp; 

-- 2 1981 sbstr 말고 다른 기능
select empno, ename, left(hiredate, 4) as '입사년도' from emp;

-- MID(문자, 시작 위치, 가져올 갯수);
-- 또는 SUBSTR(문자, 시작 위치, 가져올 갯수);
-- 또는 SUBSTRING(문자, 시작 위치, 가져올 갯수);

-- pad 채운다 (lpad, rpad)
select lpad('abc', 6, '*');
select rpad('abc', 6, '*');
select rpad('abc', 6, ' '); -- 공백으로 채움 (채움 문자를 지정하지 않으면 에러 발생), oracle은 공백으로 채움

select ename, lpad(deptno, 20, ' ' ) as deptno from emp;
 
-- 사원중에서 이름이 n으로 끝나는 사원에 대한 이름과 job, 부서 번호를 출력 (3가지 방법으로 출력)
-- 1)
select ename, job, deptno
from emp
where ename like '%n';

-- 2)
select ename, job, deptno
from emp
where substr(ename, -1, 1) = 'n';

-- 3)
select ename, job, deptno
from emp
where instr(ename, 'n') = length(ename);

-- 공백을 제거하는 함수 trim()
select rtrim('James Gosling is Good            ') msg;
select ltrim('            James Gosling is Good') msg;
select trim('            James Gosling is Good            ') msg;

-- 가운데 공백은 어떻게 제거할까요? replace 대체!
-- replace(문자열, 기존문자열, 대체문자열)
select replace('James Gosling           is Good', '  ', '') msg;

/*
숫자 함수
abs(숫자) 절대값
mod(분자,분모) 분자를 분모로 나눴을 때의 나머지 (%연산자와 동일)
greatest(숫자1, 숫자2, 숫자3) 주어진 숫자 중에서 가장 큰 수 반환
least(숫자1, 숫자2, 숫자3) 주어진 숫자 중에서 가장 작은 수 반홯ㄴ

ceiling(숫자)
floor(숫자)
trurncate(숫자, 자릿수)
round(숫자, 자릿수)


ceiling --- floor (자릿수 표시 불가능)
			truncate (자릿수 표시 가능)

*/

-- 1. 반올림
select round(45.923,2); -- 45.92 (소수점 이하 2자리까지 표시, 소수점 3째자리에서 반올림!!!!)
select round(45.923,0); -- 46 정수출력 (소수접 이하 첫째자리에서 반올림)
select round(45.923); -- 46 (0 이 생략됨, 무조건 정수값 출력)

-- 2. 내림
-- 소수점 이하는 버림 ( 실수값은 내림)
-- 실수값을 내림과 동시에 자릿수를 지정하려면 --> truncate()을 사용
select floor(12.11); -- 12 
select floor(19.0); -- 19
select floor(19.99); -- 19
select floor(19.99, 2); -- 자릿수를 지정할 수 없다. 실수값은 무조건 내린다.

-- 3. 올림 (정수값에 해당하는 부분의 값을 대상)
select ceiling(12.11); -- 13
select ceiling(12.61); -- 13
select ceiling(12.0); -- 12
select ceiling(12.61, 2); -- 자릿수를 지정할 수 없다.
 
-- 4. 자릿수를 지정하고 버림
select truncate(19.4123,1) a ; -- 19.4
select truncate(19.4123,2) b ; -- 19.41






