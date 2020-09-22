-- Top Earners

-- 문제 : [https://www.hackerrank.com/challenges/earnings-of-employees/problem?h_r=internal-search](https://www.hackerrank.com/challenges/earnings-of-employees/problem?h_r=internal-search)
    -- 요약하면 EMPLOYEE 테이블에서 제일 높은 연봉을 구하고. 해당 연봉을 받는 사람을 구하라.
    -- 연봉은 months * salary

-- 풀이

# oracle
select maxEarning, num
from (
    select
        months * salary as maxEarning
        ,count(*) as num
    from Employee
    group by months * salary
    order by months * salary desc
    )
where rownum = 1
;

# mysql
select
    months * salary as maxEarning
    ,count(*) as num
from Employee
group by months * salary
order by months * salary desc
limit 1
;
```
