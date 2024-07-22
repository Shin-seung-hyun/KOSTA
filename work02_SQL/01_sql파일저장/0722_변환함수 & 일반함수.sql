/*
 07.22 변환함수
 
str_to_date 보다  convert 나 cast를 써보자

변환함수 
1) cast
2) convert (값, 변환할 데이터 타입)
	convert(값, date)
	convert(값, char)
	convert(값, signed) -- 숫자로 변경
이 둘은 형식만 다를뿐 기능은 동일하다.
둘 중에 하나만 사용하면 된다.

convert를 사용하면 str_to_date의 별도 기능을 사용할 필요가 없다.

*/

-- 살아온 일생, 날짜 - 날짜 ( curdate() - '2024-07-21' ) 당시 에러 발생 이때 변환함수를 써보자
-- str_to_date() 함수를 사용했지만 convert()를 사용하면 편리하다.
select (curdate() - '2024-07-21') 어제;
select (curdate() - str_to_date('2024-07-21', '%Y-%m-%d')) 어제;
select (curdate() - convert('2024-07-21', date)) 어제;

-- emp 테이블에서 사원이름과 상사 번호를 검색
select ename, mgr 
from emp;

-- mgr의 값이 null이면 '없음'이 출력되도록
select ename, ifnull(mgr, '없음')
from emp;

select ename, ifnull(convert(mgr,char), '없음') -- oracle에서는 와 같이 '없음'과 같은 char 형으로의 형변환이 필요하다.
from emp;


/*
일반함수

case 
	when 조건1 then '반환값'
    when 조건2 then '반환값'
    ELSE 'WHEN 조건에 해당 안되는 경우 반환 값'
end

when 과 then 은 한쌍으로 나와야 한다.
when 과 then 은 여러 개 나올 수 있다.

else문에는 위 조건에 해당하지 않는 모든 경우가 반환된다.
else가 존재하지 않고 when 조건에 부합하는 경우가 아닐 때는 null이 반환된다.

*/

-- 이름, 업무, 급여, 커미션을 검색
-- manager 라면 comm이 sal의 150%를 받는다.
-- analysist라면 comm이 sal의 ~%를 받는다.
-- 그외 직원은 sal 130%받는다.

select ename, job, sal, comm,
	case job
		when 'manager' then sal * 1.5
        else sal * 1.3
	end as bonus
from emp;

-- 이름,업무,상사번호 검색
-- mgr이 null이라면, 최고위 상사
--      null이 아니라면, 일반직원
select ename, job, mgr,
	case
		when mgr is null then '최고위상사'
		else '일반직원'
	end '직위'
from emp;


