-- 1. get me first 10 result of first_name and job_id.
SELECT FIRST_NAME ,JOB_ID
FROM EMPLOYEES
WHERE ROWNUM <= (10);

-- 2. get me all employees whose salary is lower than average
SELECT AVG(SALARY)
FROM EMPLOYEES;

SELECT FIRST_NAME,SALARY
FROM EMPLOYEES
WHERE SALARY < (SELECT AVG(SALARY)
                FROM EMPLOYEES);


-- 3. get me those departments whose employees more than department 80
SELECT COUNT(DEPARTMENT_ID)
FROM EMPLOYEES
    WHERE DEPARTMENT_ID =80;


SELECT DEPARTMENT_ID
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING COUNT(DEPARTMENT_ID) > (SELECT COUNT(DEPARTMENT_ID)
                               FROM EMPLOYEES
                               WHERE DEPARTMENT_ID =80);


-- 4. get me those employees who is older than any IT programmer in the company
SELECT MIN(HIRE_DATE)
FROM EMPLOYEES
WHERE JOB_ID = 'IT_PROG';

SELECT FIRST_NAME,HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE < (SELECT MIN(HIRE_DATE)
                   FROM EMPLOYEES
                   WHERE JOB_ID = 'IT_PROG');


-- 5. get me first name and department name in same table
SELECT FIRST_NAME,DEPARTMENT_NAME
FROM EMPLOYEES
INNER JOIN DEPARTMENTS ON  EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID;


-- 6. get me job id and manager id in one table
SELECT JOB_ID, DEPARTMENTS.MANAGER_ID
FROM EMPLOYEES
INNER JOIN DEPARTMENTS
ON EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID;



-- 7. get me department names and end date( if any employee quit)
SELECT DEPARTMENT_NAME, END_DATE
FROM DEPARTMENTS
INNER JOIN JOB_HISTORY
ON DEPARTMENTS.DEPARTMENT_ID = JOB_HISTORY.DEPARTMENT_ID;



-- 8. get me job id and job title together
SELECT EMPLOYEES.JOB_ID,JOB_TITLE
FROM EMPLOYEES
LEFT OUTER JOIN JOBS
ON EMPLOYEES.JOB_ID = JOBS.JOB_ID;


-- 9. get me first name who left the company
SELECT FIRST_NAME,END_DATE
FROM EMPLOYEES
RIGHT OUTER JOIN JOB_HISTORY
ON EMPLOYEES.EMPLOYEE_ID = JOB_HISTORY.EMPLOYEE_ID;


-- 10. get me first name and job title for those whose salary is equal to max salary of that job  title
SELECT FIRST_NAME,SALARY,JOB_TITLE,MAX_SALARY
FROM EMPLOYEES
RIGHT OUTER JOIN JOBS
ON EMPLOYEES.JOB_ID = JOBS.JOB_ID;


-- 11.get me department name, city in same table
SELECT DEPARTMENT_NAME,CITY
FROM DEPARTMENTS
FULL OUTER JOIN LOCATIONS
ON DEPARTMENTS.LOCATION_ID = LOCATIONS.LOCATION_ID;




-- 12. get me first name , start date, end date in same table
SELECT FIRST_NAME,START_DATE,END_DATE
FROM EMPLOYEES
FULL OUTER JOIN JOB_HISTORY
ON EMPLOYEES.EMPLOYEE_ID = JOB_HISTORY.EMPLOYEE_ID;




--13. create a table name laptops, with id, brand, color, price
CREATE TABLE laptops (
                         Id_number integer primary key ,
                         brand varchar(25),
                         color varchar(25),
                         price integer
);

select * from laptops;

-- 15. insert laptops table belwo values
-- 1. (1, 'hp' , 'black', 1500)
-- 2. (2, 'msi', 'grey', 1300)
-- 3. (3, 'dell', 'black', 1600)
-- 4. (4, 'hp', 'white', 1300)
-- 5. (5, 'macbook', 'white', 1800)

insert into laptops values (1, 'hp', 'black', 1500);
insert into laptops values (2, 'msi', 'grey', 1300);
insert into laptops values (3, 'dell', 'red', 1600);
insert into laptops values (4, 'hp', 'white', 1300);
insert into laptops values (5, 'macbook', 'white', 1800);

--14. create table phones with id, brand, color, price

CREATE TABLE phones (

                        Id_number integer primary key ,
                        brand varchar(25),
                        color varchar(25),
                        price integer

);


INSERT INTO phones values (1, 'samsung' , 'black', 700);
INSERT INTO phones values (1, 'samsung' , 'black', 700);
INSERT INTO phones values (2, 'dell', 'grey', 1000);
INSERT INTO phones values (3, 'msi', 'black', 800);
INSERT INTO phones values (4, 'iphone', 'white', 1100);

SELECT * FROM phones;







-- 16. insert phones table belwo values
-- -- 1. (1, 'samsung' , 'black', 700)
-- -- 2. (2, 'dell', 'grey', 1000)
-- -- 3. (3, 'msi', 'black', 800)
-- -- 4. (4, 'iphone', 'white', 1100)



--17. update dell price to 1500
update laptops
set price = 1500
where ID_NUMBER = 3;

select * from laptops;

-- 18. delete macbook from laptops table
delete  from laptops
where ID_NUMBER = 5;

-- 19. combine all brand names in one table( from laptops and phones)
select brand from laptops
union all
select brand from phones;

-- 20. combine unique brand names in one table
select brand from laptops
union
select brand from phones;

--21. get me unique prices and sort them
select price from laptops
union
select price from phones;

--22. get me common colors for phones and laptops
select color from laptops
intersect
select color from phones;

--23. get me the colors only laptops have
select color from laptops
minus
select  color from phones;

select color from laptops;
select color from phones;


--24. get me the brands only phones have
select brand from phones
minus
select brand from laptops;




-- GIVE THE TOP 10 SALARY
SELECT *
FROM EMPLOYEES
ORDER BY SALARY DESC ;


SELECT *
FROM (SELECT *
      FROM EMPLOYEES
      ORDER BY SALARY DESC)
WHERE ROWNUM <11;



-- SELECT INFO. FOR SECOND MAX SALARY
SELECT MAX(SALARY)
FROM EMPLOYEES;


SELECT MAX(SALARY)
FROM EMPLOYEES
WHERE SALARY < (SELECT MAX(SALARY)
                FROM EMPLOYEES);


SELECT *
FROM EMPLOYEES
WHERE SALARY = (SELECT MAX(SALARY)
               FROM EMPLOYEES
               WHERE SALARY < (SELECT MAX(SALARY)
                               FROM EMPLOYEES));




SELECT SUBSTR(FIRST_NAME,0,1)||' '|| SUBSTR(LAST_NAME,0,1) AS "INITIAL",
FIRST_NAME ||' '|| EMPLOYEES.LAST_NAME AS "FULL_NAME",
     LOWER(EMAIL ||'@GMAIL.COM') AS "EMAIL"
FROM EMPLOYEES;




--FIND THE HIGHEST 14TH SALARY
SELECT DISTINCT SALARY
FROM EMPLOYEES
ORDER BY  SALARY DESC ;


SELECT *
FROM (SELECT DISTINCT SALARY
      FROM EMPLOYEES
      ORDER BY  SALARY DESC )
WHERE ROWNUM < 15 ;


SELECT MIN(SALARY)
FROM (SELECT DISTINCT SALARY
      FROM EMPLOYEES
      ORDER BY  SALARY DESC )
WHERE ROWNUM < 15 ;

-- THE INFO. OF THE HIGHEST 14TH SALARY
SELECT *
FROM EMPLOYEES
WHERE SALARY = (SELECT MIN(SALARY)
                FROM (SELECT DISTINCT SALARY
                      FROM EMPLOYEES
                      ORDER BY  SALARY DESC )
                WHERE ROWNUM < 15);




CREATE TABLE MOhammed (
 Emp_Id INTEGER PRIMARY KEY ,
 FirstName varchar(30) not null,
 LastName varchar(30),
 JobTitle varchar(20)

);



SELECT *
FROM MOhammed;

INSERT INTO MOhammed(emp_id, firstname, lastname, jobtitle)
VALUES (1,'Mohammed','Alshalchi','Tester');

SELECT *
FROM MOhammed;


INSERT INTO  MOhammed(emp_id, firstname, lastname, jobtitle)
VALUES (2,'Dalya','Ibrahim','NHA');


SELECT *
FROM MOhammed;


UPDATE MOhammed
SET JobTitle = 'Tester'
WHERE  Emp_Id =2;

SELECT *
FROM MOhammed;

UPDATE MOhammed
SET  JobTitle = 'sdet'
WHERE Emp_Id = 2;

SELECT *
FROM MOhammed;


INSERT INTO MOhammed
values (3,'Mariam','Mohammed','Dentist');


SELECT *
FROM MOhammed;



DELETE FROM MOhammed
WHERE Emp_Id =3;


SELECT *
FROM MOhammed;


ALTER TABLE MOhammed
ADD SALARY INTEGER;


SELECT *
FROM MOhammed;






ALTER TABLE MOhammed
    RENAME COLUMN SALARY
        TO ANNUAL_SALARY;

SELECT *
FROM MOhammed;




ALTER TABLE MOhammed RENAME TO MohammedAlasalchi;

SELECT * FROM MohammedAlasalchi;



TRUNCATE TABLE MohammedAlasalchi;


DROP TABLE MohammedAlasalchi;






-- get me, firstName ,lastName , department_name ,city fo all employee
SELECT FIRST_NAME, LAST_NAME , DEPARTMENT_NAME , CITY
FROM EMPLOYEES e
    INNER JOIN DEPARTMENTS d
ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
INNER JOIN LOCATIONS l
on d.LOCATION_ID = l.LOCATION_ID;




-- HOW TO FIND DUPLICATE NAMES IN EMPLOYEES TABLE
SELECT FIRST_NAME ,COUNT(*)
FROM EMPLOYEES
GROUP BY FIRST_NAME
HAVING COUNT(*) >1;


SELECT JOB_TITLE
FROM JOBS;










