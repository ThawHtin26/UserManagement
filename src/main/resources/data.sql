insert into m_user(
	user_id, password ,
	user_name , birthday , 
	age , gender , 
	department_id , role ) 
	values ('system@co.jp' , 'password' , 'system administrator' , '2000-01-01' , 21, 1, 1, 'role_admin' ) , ('user@co.jp' , 'password' , 'user1' , '2000-01-01' , 21, 2, 2, 'role_general' ) ;

/* Department master */
INSERT INTO m_department (department_id, department_name)
VALUES(1, 'System Management' ), 
(2, 'Sales' );

/* Salary table */
INSERT INTO t_salary (user_id, year_month, salary) 
VALUES('user@co.jp' , '11/2020' , 2800), 
('user@co.jp' , '12/2020' , 2900), 
('user@co.jp' , '01/2021' , 3000);