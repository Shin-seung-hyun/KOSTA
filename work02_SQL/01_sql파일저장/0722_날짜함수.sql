-- SHOW VARIABLES WHERE Variable_name LIKE 'character\_set\_%' OR Variable_name LIKE 'collation%';

/*
07.22 날짜 함수
https://oneul-losnue.tistory.com/123

[ 날짜 함수 ]
date_format(hiredate, '%Y-%m-%d') - date를 format 형식에 맟춰 문자열로 반환한다.
dayofweek() - 주어진 date의 요일을 반환한다. (일요일 : 1, 월요일 :2, 토요일 :7)
year(date) - 년도 반환
month(date) - 월 반홚
day(date) - 날짜 반환
last_day(date) - 주어진 date에서 해당 월의 마지막 날짜 정보 반환 (30일, 31일, 28일인지)

[ 시간을 반환하는 함수 ]
curdate() - 현재 날짜 반환 (YYYY-MM-DD 형식으로 출력)

NOW(), CURRENT_TIMESTAMP() - 현재 날짜와 시간 반환 (YYYY-MM-DD HH:MM:SS)
CURTIME() - 현재 시각 반환 (HH:MM:SS)

@@@@@@ 중요 @@@@@@@
[ 특정 날짜와 시간 연산 ]
date_add
adddate(date, INTERVAL value addunit) - date에 value addunit 만큼 시간/날짜를 추가한 date를 반환
										(INTERVAL value addunit 대신 days도 가능)
datediff(date1, date2) - 두 날짜 사이의 일수를 숫자로 반환 (date1 - date2)

날짜 + 숫자 = 날짜
날짜 - 숫자 = 날짜
날짜 - 날짜 = 숫자 (기간)

*/

select curdate() - 1 어제;
select curdate() + 1 내일;
select curdate() + 200 '만난지 200일'; -- 그러나 계산법이 잘못됐다.

-- 오늘로부터 100일 이후의 날짜를 알고 싶어
select adddate( curdate(), interval 200 day) '200일 기념일' ;
select adddate( curdate(), interval 1 year) '1주년' ;
select adddate( curdate(), interval 1 week) '1주일 후' ;
-- select adddate( curdate(), interval 1 hour) '1주년' ; -- curdate가 날짜만 출력해서 안됨
select adddate( now(), interval 1 hour);

-- (날짜 -날짜) 인 경우
-- 1 
-- 오늘 날짜에서 어제 날짜를 빼면 1이 나와야 한다.
select (curdate() - '2024-07-21') difference; -- 잘못된 결과가 출력됨 ' '안을 문자로 생각해서 오류 발생
											  -- 문자 - > 날짜로 변환하자
-- 2 str_to_date() 변환 함수를 사용
select (curdate() - str_to_date('2024-07-21', '%Y-%m-%d') ) difference; -- str -> date							

-- 3. 
select datediff(curdate() , '2024-07-21' ) difference;
-- 여러분들이 태어난 날로부터 오늘까지 살아온 일생의 기간은 몇일일가요?
select datediff( curdate(), '1999-10-28') difference;

-- emp 테이블에서 manager 업무에 대해서 입사한 날로부터 오늘까지의 근무일수를 출력 
select empno, ename, job, datediff( curdate(), hiredate) as '연속 근무일'
from emp
where job = 'manager';

select empno, ename, job, abs( datediff( hiredate, curdate())) as '연속 근무일' -- 함수안에 함수를 쓴다. 메소드 중첩	abs(datediff())
from emp
where job = 'manager';

-- emp 테이블에서 manager 업무에 대해서 입사한 날로부터 오늘까지의 근주수를 출력
 select empno, ename, job, ceil(datediff( curdate(), hiredate ) /7 ) Weekends
from emp
where job = 'manager';

-- emp 테이블에서 사원들이 입사한 월만 검색 단, 날짜 함수를 써서 검색
select empno, ename, month(hiredate) as '입사 월'
from emp;

-- substr 로 5월에 입사한 사람 뽑기
select empno, ename, hiredate, substr(hiredate, 6, 2) as '입사 월'
from emp
where month(hiredate) = 5;


