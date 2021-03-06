SELECT * FROM EMPLOYEES;

-- EXTRACT FUNCTION IS A SINGLE ROW FUNCTION
-- THAT CAN EXTRACT ANY PART OF DATE TIME COLUMN
-- LIKE YEAR , MONTH , DAY , HOUR , MINUTE, SECOND
-- AND RETURN THE NUMBER
-- EXTRACT THE YEAR FROM THE HIRE_DATE
SELECT HIRE_DATE ,EXTRACT(YEAR FROM HIRE_DATE) AS HIRED_YEAR
FROM EMPLOYEES
ORDER BY HIRE_DATE;


-- SELECT THE MONTH FROM THE HIRE_DATE
SELECT HIRE_DATE, EXTRACT(MONTH FROM HIRE_DATE) AS HIRED_MONTH
FROM EMPLOYEES;


-- FIND OUT ALL EMPLOYEES HIRED IN YEAR 2008
SELECT FIRST_NAME , HIRE_DATE  , EXTRACT(YEAR FROM HIRE_DATE)
FROM EMPLOYEES
WHERE EXTRACT(YEAR FROM HIRE_DATE) =2008;

-- FIND OUT ALL EMPLOYEES HIRED IN YEAR 2001 TILL 2003
SELECT FIRST_NAME , HIRE_DATE  , EXTRACT(YEAR FROM HIRE_DATE)
FROM EMPLOYEES
WHERE EXTRACT(YEAR FROM HIRE_DATE) BETWEEN 2001 AND 2003;





-- FIND OUT HOW MANY PEOPLE ARE HIRED IN EACH YEAR
-- OPTIONALLY FILTER THE RESULT IF THE COUNT IS MORE THAN 15
SELECT  EXTRACT(YEAR FROM HIRE_DATE) AS HIRED_YEAR,COUNT(*) AS EMPLOYEE_COUNT
FROM EMPLOYEES
GROUP BY EXTRACT(YEAR FROM HIRE_DATE)
HAVING COUNT(*) > 15
ORDER BY 1;--- ORDER BY FIRST COLUMN IN SELECT STATEMENT





--Interview question:
--assuming there is a table to log the entrance and exit of the people into the building
--The LOGS table has a column called EnteredDateTime.
--Return everyone who entered the building between 2 am and 5 am on any date, what's your approach?

SELECT FIRST_NAME||' '||LAST_NAME AS FULL_NAME , EnteredDateTime
FROM LOGS
where EXTRACT(hours from EnteredDateTime) BETWEEN 2 AND 5;





