CREATE TABLE employee (
  `num` int  AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(10) ,
  `salary` decimal(7,2) ,
  `address` varchar(10)
);

create index employee_name_idx on employee(name);

select * from employee;
desc employee;