-- ##################  변환 함수 실습 ######################

-- 1) 모든 직원의 이름과 입사일을 ‘1996-5-14’의 형태로 출력 하라.
select ename, date_format(hiredate, ' %Y-%c-%d') hiredate
from emp;

-- 2) 모든 직원의 이름과 입사년과 입사월만 '1981.05' 형식으로 출력하라
select ename, date_format(hiredate, '%Y.%d') 입사년월
from emp;

-- 3) 모든 직원의 번호, 이름, 급여를 출력하라. 단, 급여앞에 화폐표시($), 그리고 천단위(,)표시, 소수점이하 2자리가 표시되도록 하라.
-- format(데이터, 표시할 자릿수)
select empno, ename, concat( '$', format(sal,2)) sal
from emp;

select empno, ename, format(sal, '$99,999.99') sal
from emp;

select empno, ename, format(sal, '99,999.99') sal
from emp;

select sal
from emp;

-- ##################  일반 함수 실습 ######################

-- 1)  모든 직원의 이름, 급여, 커미션을 출력하라. 단, comm이 null이면 '없음'으로 출력하라.



-- 2) 모든 직원의 이름, 직무, 급여, 커미션, 보너스를 출력하라. 
-- 보너스는 직무가  MANAGER이면 급여의 150%, 그외 직원은 급여의 130% 이다.(case ~ else 사용)



-- 3) mgr2 컬럼을 하나 더 만들어서
-- mgr이 null이면 상위담당자/ null이면 mgr값을 가지도록 한다.(case ~ else 사용))



